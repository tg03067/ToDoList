package com.green.todolist1.user;

import com.green.todolist1.user.model.SignInUserReq;
import com.green.todolist1.user.model.SignInUserRes;
import com.green.todolist1.user.model.UserInfo;
import com.green.todolist1.user.model.UserPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserPostReq p);
    UserInfo signInUser(String userId);
    int countUserId(String userId);
    int countUserName(String userName);
}
