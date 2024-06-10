package com.green.todolist1.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScheduleManagementPostReq {
    private long userSeq;
    private long plantSeq;
    private String managementDate;
    @Schema(description = "1: 물주기, 2: 분갈이하기, 3: 가지치기, 4: 환기하기")
    private int gardening;
    private String contents;
}
