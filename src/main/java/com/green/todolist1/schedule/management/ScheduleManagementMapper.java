package com.green.todolist1.schedule.management;

import com.green.todolist1.schedule.management.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleManagementMapper {
    int insScheduleManagement(ScheduleManagementPostReq p);
    int delScheduleManagement(ScheduleManagementDeleteReq p);
    int updateScheduleManagement(ScheduleManagementPatchReq p);
    List<ScheduleManagementGetMonthRes> selScheduleManagementMonth(ScheduleManagementGetMonthReq p);
    List<ScheduleManagementGetDayRes> selScheduleManagementDay(ScheduleManagementGetDayReq p);
    ScheduleManagementGetDayDetailRes selScheduleManagementDetail(ScheduleManagementGetDayDetailReq p);
}
