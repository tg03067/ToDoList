package com.green.todolist1.schedule.plant;

import com.green.todolist1.schedule.plant.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchedulePlantMapper {
    int insSchedule(SchedulePlantPostReq p);
    int updateSchedule(SchedulePlantPatchReq p);
    int deleteSchedule(SchedulePlantDeleteReq p);
    List<SchedulePlantGetListRes> getSchedulePlantsList(SchedulePlantGetListReq p);
    SchedulePlantGetDetailRes getSchedulePlantDetail(SchedulePlantGetDetailReq p);
}
