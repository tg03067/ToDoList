package com.green.todolist1.schedule;

import com.green.todolist1.schedule.model.SchedulePostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleMapper mapper;

    public int selSchedule(SchedulePostReq p){
        return mapper.selSchedule(p);
    }
}
