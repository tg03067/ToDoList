package com.green.todolist1.schedule.plant.model;

import lombok.Data;

@Data
public class SchedulePlantPatchReq {
    private long userSeq;
    private long plantSeq;
    private String plantNicKName;
    private String etc;
}
