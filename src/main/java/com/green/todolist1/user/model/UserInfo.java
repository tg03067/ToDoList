package com.green.todolist1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private long userSeq;
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private int userLoginGb;
    private int userGb;
    private String inputDt;
    private String updateDt;
}
