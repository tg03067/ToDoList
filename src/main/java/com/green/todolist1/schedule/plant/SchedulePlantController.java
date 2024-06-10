package com.green.todolist1.schedule.plant;

import com.green.todolist1.common.model.ResultDto;
import com.green.todolist1.schedule.plant.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/schedule/plant")
@Tag(name = "식물등록관련", description = "식물등록관련 CRUD")
public class SchedulePlantController {
    private final SchedulePlantService service;

    @PostMapping()
    @Operation(summary = "식물등록", description = "식물등록관련 Post")
    public ResultDto<Integer> insSchedulePlant(@RequestBody SchedulePlantPostReq p){
        try {
            int result = service.insSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg("정상적으로 등록되었습니다.").
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류발생").build();
        }
    }

    @PatchMapping
    @Operation(summary = "식물등록 수정", description = "식물등록관련 Patch")
    public ResultDto<Integer> updSchedulePlant(@RequestBody SchedulePlantPatchReq p){
        try {
            int result = service.updateSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg(result == 1 ? "정상적으로 수정되었습니다." : "수정에 실패했습니다.").
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류발생").build();
        }

    }
    @DeleteMapping
    @Operation(summary = "식물등록 삭제", description = "식물등록관련 Delete")
    public ResultDto<Integer> deleteSchedulePlant(@ParameterObject @ModelAttribute SchedulePlantDeleteReq p){
        try {
            int result = service.deleteSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg(result == 1 ? "정상적으로 삭제되었습니다." : "삭제에 실패했습니다.").
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("오류발생").build();
        }
    }

    @GetMapping("/list")
    @Operation(summary = "식물등록리스트 조회", description = "식물등록관련 ListGet")
    public ResultDto<List<SchedulePlantGetListRes>> selSchedulePlantList(@ParameterObject @ModelAttribute SchedulePlantGetListReq p) {
        try {
            List<SchedulePlantGetListRes> result = service.selSchedulePlantList(p);

            return ResultDto.<List<SchedulePlantGetListRes>>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<List<SchedulePlantGetListRes>>builder().code(-1).msg("오류발생").build();
        }
    }

    @GetMapping("/detail")
    @Operation(summary = "식물등록리스트 상세 조회", description = "식물등록관련 DetailGet")
    public ResultDto<SchedulePlantGetDetailRes> selSchedulePlantDetail(@ParameterObject @ModelAttribute SchedulePlantGetDetailReq p) {
        try {
            SchedulePlantGetDetailRes result = service.selSchedulePlant(p);

            return ResultDto.<SchedulePlantGetDetailRes>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<SchedulePlantGetDetailRes>builder().code(-1).msg("오류발생").build();
        }
    }
}
