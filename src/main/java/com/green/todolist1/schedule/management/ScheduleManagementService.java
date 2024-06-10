package com.green.todolist1.schedule.management;

import com.green.todolist1.schedule.management.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementService {
    private final ScheduleManagementMapper mapper;

    public int insScheduleManagement(ScheduleManagementPostReq p){
        return mapper.insScheduleManagement(p);
    }
    public int delScheduleManagement(ScheduleManagementDeleteReq p){
        return mapper.delScheduleManagement(p);
    }
    public int updateScheduleManagement(ScheduleManagementPatchReq p){
        return mapper.updateScheduleManagement(p);
    }
    public List<ScheduleManagementGetMonthRes> getScheduleManagementMonth(ScheduleManagementGetMonthReq p){
        return mapper.selScheduleManagementMonth(p);
    }
    public List<ScheduleManagementGetDayRes> selScheduleManagementDay(ScheduleManagementGetDayReq p){
        return mapper.selScheduleManagementDay(p);
    }
    public ScheduleManagementGetDayDetailRes selScheduleManagementDetail(ScheduleManagementGetDayDetailReq p){
        return mapper.selScheduleManagementDetail(p);
    }
}
