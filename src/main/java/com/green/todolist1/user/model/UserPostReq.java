package com.green.todolist1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserPostReq {
    @Schema(defaultValue = "mic12", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(defaultValue = "1212", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userPw;
    @Schema(defaultValue = "홍길동", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
    @Schema(defaultValue = "qwer@naver.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userEmail;

    @JsonIgnore
    private long userSeq;
    @JsonIgnore
    @Schema(name = "1", defaultValue = "1", description = "1: 이메일, 2: 카카오, 3: 네이버, 4: 구글")
    private int userLoginGb;
//    @JsonIgnore
//    @Schema(name = "1", defaultValue = "1", description = "1: 정상, 2: 정지, 3: 탈퇴")
//    private int userGb;
}
