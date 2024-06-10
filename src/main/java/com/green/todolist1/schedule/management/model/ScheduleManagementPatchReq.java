package com.green.todolist1.schedule.management.model;

import lombok.Data;

@Data
public class ScheduleManagementPatchReq {
    private long userSeq;
    private long plantManagementSeq;
    private int gardening;
    private String content;
}
