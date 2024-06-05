package com.green.todolist1.schedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SchedulePostReq {
    @JsonIgnore
    private long userSeq;

    private String scdStartDt;
    private String scdEndDt;
    private String scdStartTime;
    private String scdEndTime;
    @Schema(description = "1: 물주기, 2: 분갈이하기, 3: 가지치기, 4: 환기하기")
    private String gardening;

    private String plantInfo;
}
