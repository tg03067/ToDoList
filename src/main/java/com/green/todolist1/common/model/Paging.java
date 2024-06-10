package com.green.todolist1.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.todolist1.common.GlobalConst;
import lombok.Data;

@Data
public class Paging {
    private int page;
    private int size;

    public Paging(int page, int size) {
        this.page = page == 0 ? GlobalConst.PAGE_NUM : page;
        this.size = size == 0 ? GlobalConst.SIZE_NUM : size;
        this.startIdx =this.page - 1 < 0 ? 0 : ( this.page - 1 ) * this.size;
    }
    @JsonIgnore
    private int startIdx;
}
