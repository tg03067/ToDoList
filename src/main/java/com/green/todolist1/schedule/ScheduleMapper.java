package com.green.todolist1.schedule;

import com.green.todolist1.schedule.model.SchedulePostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {
    int selSchedule(SchedulePostReq p);
}
