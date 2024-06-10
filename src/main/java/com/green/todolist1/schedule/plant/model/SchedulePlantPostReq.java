package com.green.todolist1.schedule.plant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SchedulePlantPostReq {
    @JsonIgnore
    private long plantSeq;

    private long userSeq;
    @Schema(description = "애칭")
    private String plantNickName;
    private String etc;
    private long odataSeq;
}
