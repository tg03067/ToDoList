package com.green.todolist1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInUserRes {
    @JsonIgnore
    private long userSeq;

    private String userId;
    private String userName;
    private String userEmail;
}
