package com.green.todolist1.user;

import com.green.todolist1.common.model.CustomException;
import com.green.todolist1.email.EmailService;
import com.green.todolist1.user.model.SignInUserReq;
import com.green.todolist1.user.model.SignInUserRes;
import com.green.todolist1.user.model.UserInfo;
import com.green.todolist1.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final EmailService emailService;
    @Transactional
    public int signUpUser(UserPostReq p) {
        String hashPw = BCrypt.hashpw(p.getUserPw(), BCrypt.gensalt());
        p.setUserPw(hashPw);

        int userIdCheck = mapper.countUserId(p.getUserId());
        int userNameCheck = mapper.countUserName(p.getUserName());
        if (userIdCheck == 1) {
            throw new DuplicateKeyException("아이디중복");
        } else if (userNameCheck == 1) {
            throw new CustomException("닉네임중복");
        }
        return mapper.insUser(p);
    }

    public SignInUserRes signInUser(SignInUserReq p){
        UserInfo user = mapper.signInUser(p.getUserId());

         if(user == null){
            throw new CustomException("아이디가 일치하지 않습니다.");
        } else if(!BCrypt.checkpw(p.getUserPw(), user.getUserPw())){
            throw new DuplicateKeyException("비밀번호가 일치하지 않습니다");
        }

        return SignInUserRes.builder().
                userId(user.getUserId()).
                userName(user.getUserName()).
                userEmail(user.getUserEmail()).
                userSeq(user.getUserSeq()).
                build();
    }

    public void registerUser(UserPostReq p, String code) {
        boolean isValid = emailService.verifyCode(p.getUserEmail(), code);
        if(isValid){
            signUpUser(p);
            emailService.clearVerificationCode(p.getUserEmail());
        } else {
            throw new CustomException("유효하지않는 인증번호입니다.");
        }
    }
}