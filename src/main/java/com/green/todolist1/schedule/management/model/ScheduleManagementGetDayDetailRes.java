package com.green.todolist1.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScheduleManagementGetDayDetailRes {
    private String managementDate;
    private int gardening;
    private String plantPid;
    private String plantName;
    private String content;
}
