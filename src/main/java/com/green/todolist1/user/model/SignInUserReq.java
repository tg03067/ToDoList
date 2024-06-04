package com.green.todolist1.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignInUserReq {
    @Schema(defaultValue = "mic12", description = "유저 아이디", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(defaultValue = "1212", description = "유저 비밀번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userPw;
}
