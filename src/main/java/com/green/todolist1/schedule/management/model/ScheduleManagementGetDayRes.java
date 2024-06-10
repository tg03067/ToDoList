package com.green.todolist1.schedule.management.model;

import com.green.todolist1.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleManagementGetDayRes extends Paging {
    private int gardening;
    private String plantPic;
    private String plantName;

    public ScheduleManagementGetDayRes(int page, int size, int gardening, String plantPic, String plantName) {
        super(page, size);
        this.gardening = gardening;
        this.plantPic = plantPic;
        this.plantName = plantName;
    }

    @Schema(description = "총 페이지 수")
    private int totalPage;
    @Schema(description = "총 등록된 일정 수")
    private int totalElement;
}
