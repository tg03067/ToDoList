package com.green.todolist1.user;

import com.green.todolist1.common.model.CustomException;
import com.green.todolist1.common.model.ResultDto;
import com.green.todolist1.user.model.SignInUserReq;
import com.green.todolist1.user.model.SignInUserRes;
import com.green.todolist1.user.model.UserPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "회원정보", description = "사용자관련 CRUD")
public class UserController {
    public final UserService service;

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
