package com.green.todolist1.schedule.plant;

import com.green.todolist1.schedule.plant.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulePlantService {
    private final SchedulePlantMapper mapper;

    public int insSchedule(SchedulePlantPostReq p){
        return mapper.insSchedule(p);
    }
    public int updateSchedule(SchedulePlantPatchReq p){
        return mapper.updateSchedule(p);
    }
    public int deleteSchedule(SchedulePlantDeleteReq p){
        return mapper.deleteSchedule(p);
    }
    public List<SchedulePlantGetListRes> selSchedulePlantList(SchedulePlantGetListReq p){
        return mapper.getSchedulePlantsList(p);
    }
    public SchedulePlantGetDetailRes selSchedulePlant(SchedulePlantGetDetailReq p){
        return mapper.getSchedulePlantDetail(p);
    }
}
