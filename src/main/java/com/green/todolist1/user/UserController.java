package com.green.todolist1.user;

import com.green.todolist1.common.model.CustomException;
import com.green.todolist1.common.model.ResultDto;
import com.green.todolist1.email.EmailService;
import com.green.todolist1.user.model.SignInUserReq;
import com.green.todolist1.user.model.SignInUserRes;
import com.green.todolist1.user.model.UserPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "회원정보", description = "사용자관련 CRUD")
public class UserController {
    private final UserService service;
    private final EmailService emailService;

    @PostMapping("sign-up")
    @Operation(summary = "사용자 회원가입", description = "회원정보 Post")
    public ResultDto<Integer> signUpUser(@RequestBody UserPostReq p){
        try {
            int result = service.signUpUser(p);
            return ResultDto.<Integer>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (DuplicateKeyException e){
            return ResultDto.<Integer>builder().
                    code(-2).
                    msg("아이디중복").
                    build();
        } catch (CustomException e){
            return ResultDto.<Integer>builder().
                    code(-3).
                    msg("닉네임중복").
                    build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDto.<Integer>builder().
                    code(-1).
                    msg("검증되지않은 오류").
                    build();
        }
    }

    @PostMapping("send-verification")
    @Operation(summary = "Email 인증코드 ")
    public String sendEmail(@RequestParam String email){
        try{
            emailService.sendVerificationCode(email);
            return "인증코드를 보냈습니다.";
        }catch (MessagingException e){
            e.printStackTrace();
            return "인증코드를 해당 이메일에 보내지 못했습니다.";
        }
    }

    @PostMapping("register")
    @Operation(summary = "Email 인증코드 인증을 활용한 회원가입", description = "Email인증이 포함되어있음.")
    public String registerUser(@RequestBody UserPostReq p, @RequestParam String code) {
        try {
            service.registerUser(p, code);
            signUpUser(p);
            return "인증에 성공했습니다.";
        } catch (CustomException | DuplicateKeyException e) {
            return e.getMessage();
        }
    }

    @PostMapping("sign-in")
    @Operation(summary = "사용자 로그인", description = "로그인 Post")
    public ResultDto<SignInUserRes> signInUser(@RequestBody SignInUserReq p){
        try {
            SignInUserRes res = service.signInUser(p);
            return ResultDto.<SignInUserRes>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(res).
                    build();
        } catch (DuplicateKeyException e){
            return ResultDto.<SignInUserRes>builder().
                    code(-2).
                    msg("비밀번호 틀림.").
                    build();
        } catch (CustomException e){
            return ResultDto.<SignInUserRes>builder().
                    code(-2).
                    msg("아이디 틀림.").
                    build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDto.<SignInUserRes>builder().
                    code(-1).
                    msg("알수없는 오류").
                    build();
        }
    }
}
