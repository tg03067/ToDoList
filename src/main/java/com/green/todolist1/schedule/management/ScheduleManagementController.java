package com.green.todolist1.schedule.management;

import com.green.todolist1.common.model.ResultDto;
import com.green.todolist1.schedule.management.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/schedule/plant/management")
public class ScheduleManagementController {
    private final ScheduleManagementService service;

    @PostMapping
    @Operation(summary = "식물일정등록", description = "식물일정등록 Post")
    public ResultDto<Integer> insScheduleManagement(@RequestBody ScheduleManagementPostReq p) {
        try {
            int result = service.insScheduleManagement(p);
            return ResultDto.<Integer>builder().
                    code(1).
                    msg(result == 1 ? "등록에 성공했습니다." : "등록에 실패했습니다.").
                    data(result).
                    build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류").build();
        }
    }

    @DeleteMapping
    @Operation(summary = "식물일정등록 삭제", description = "식물일정등록 Delete")
    public ResultDto<Integer> delScheduleManagement(@ModelAttribute ScheduleManagementDeleteReq p) {
        try {
            int result = service.delScheduleManagement(p);
            return ResultDto.<Integer>builder().
                    code(1).
                    msg(result == 1 ? "삭제에 성공했습니다." : "삭제에 실패했습니다.").
                    data(result).
                    build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류").build();
        }
    }

    @PatchMapping
    @Operation(summary = "식물일정등록 수정", description = "식물일정등록 Patch")
    public ResultDto<Integer> updScheduleManagement(@RequestBody ScheduleManagementPatchReq p) {
        try {
            int result = service.updateScheduleManagement(p);
            return ResultDto.<Integer>builder().
                    code(1).
                    msg(result == 1 ? "수정에 성공했습니다." : "수정에 실패했습니다.").
                    data(result).
                    build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류").build();
        }
    }

    @GetMapping("/month")
    @Operation(summary = "식물일정 월 단위 조회", description = "식물일정조회 MonthGet")
    public ResultDto<List<ScheduleManagementGetMonthRes>> getScheduleManagementMonth(@ParameterObject @ModelAttribute
                                                                                     ScheduleManagementGetMonthReq p){
        try {
            List<ScheduleManagementGetMonthRes> result = service.getScheduleManagementMonth(p);

            return ResultDto.<List<ScheduleManagementGetMonthRes>>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<List<ScheduleManagementGetMonthRes>>builder().code(-1).msg("조회 오류").build();
        }
    }
    @GetMapping("/day")
    @Operation(summary = "식물일정 일 단위 조회", description = "식물일정조회 DayGet")
    public ResultDto<List<ScheduleManagementGetDayRes>> selScheduleManagementDay(@ParameterObject @ModelAttribute ScheduleManagementGetDayReq p){
        try {
            List<ScheduleManagementGetDayRes> result = service.selScheduleManagementDay(p);

            return ResultDto.<List<ScheduleManagementGetDayRes>>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<List<ScheduleManagementGetDayRes>>builder().code(-1).msg("조회 오류").build();
        }
    }

    @GetMapping("/detail")
    @Operation(summary = "식물일정 상세 조회", description = "식물일정조회 DayDetailGet")
    public ResultDto<ScheduleManagementGetDayDetailRes> selScheduleManagementDetail(@ParameterObject @ModelAttribute ScheduleManagementGetDayDetailReq p){
        try {
            ScheduleManagementGetDayDetailRes result = service.selScheduleManagementDetail(p);

            return ResultDto.<ScheduleManagementGetDayDetailRes>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<ScheduleManagementGetDayDetailRes>builder().code(-1).msg("조회 오류").build();
        }
    }
}