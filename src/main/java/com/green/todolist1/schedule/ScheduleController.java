package com.green.todolist1.schedule;

import com.green.todolist1.common.model.ResultDto;
import com.green.todolist1.schedule.model.SchedulePostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/schedule")
@Tag(name = "일정등록관련", description = "일정등록관련 CRUD")
public class ScheduleController {
    private final ScheduleService service;

    @PostMapping("registration")
    @Operation(summary = "일정등록", description = "일정관련 Post")
    public ResultDto<Integer> selSchedule(@RequestBody SchedulePostReq p){
        int result = service.selSchedule(p);

        return ResultDto.<Integer>builder().
                code(1).
                msg(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
