package com.green.todolist1.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScheduleManagementGetDayDetailReq {
    private long userSeq;
    private long plantManagementSeq;
    @Schema(description = "해당 일")
    private String managementDate;
}
