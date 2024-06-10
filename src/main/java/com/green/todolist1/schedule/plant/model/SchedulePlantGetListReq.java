package com.green.todolist1.schedule.plant.model;

import com.green.todolist1.common.model.Paging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulePlantGetListReq extends Paging{
    private long userSeq;

    public SchedulePlantGetListReq(int page, int size, long userSeq) {
        super(page, size);
        this.userSeq = userSeq;
    }
}
