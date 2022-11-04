package com.tys.api;

import com.tys.dto.DayDataDto;
import com.tys.dto.MinDataDto;
import com.tys.service.HistoricalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.*;

@Validated
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/historical")
public class HistoricalDataController {

    private final HistoricalDataService historicalDataService;

    /**
     * 전략용 과거 일봉 데이터 요청을 라우팅하는 controller
     * @param code: 종목 코드
     * @param startDate: 시세를 가져올 시작 날짜
     * @param endDate: 시세를 가져올 끝 날짜
     * @return dayDataListForStrategy: 전략용 과거 일봉 데이터 리스트
     * @author jaemin.joo
     */
    @GetMapping("/strategy/daydata")
    public ResponseEntity<DayDataDto.ListForStrategy> getDayDataForStrategyByReq(@NotBlank @RequestParam("symbol_code") String code,
                                                                                        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("start_date") LocalDate startDate,
                                                                                        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("end_date") LocalDate endDate){
        return ResponseEntity.ok(historicalDataService.findDayDataForStrategyByReq(code, startDate, endDate));
    }

    /**
     * 전략용 과거 분봉 데이터를 요청을 라우팅하는 controller
     * @param code: 종목 코드
     * @param startDateTime: 시세를 가져올 시작 날짜
     * @param endDateTime: 시세를 가져올 끝 날짜
     * @return minDataListForStrategy: 전략용 과거 분봉 데이터 리스트
     * @author jaemin.joo
     */
    @GetMapping("/strategy/mindata")
    public ResponseEntity<MinDataDto.ListForStrategy> getMinDataForStrategyByReq(@NotBlank @RequestParam("symbol_code") String code,
                                                                                        @DateTimeFormat(iso= ISO.DATE_TIME) @RequestParam("start_datetime") LocalDateTime startDateTime,
                                                                                        @DateTimeFormat(iso= ISO.DATE_TIME) @RequestParam("end_datetime") LocalDateTime endDateTime){
        return ResponseEntity.ok(historicalDataService.findMinDataForStrategyByReq(code, startDateTime, endDateTime));
    }

    /**
     * 차트용 과거 일봉 데이터를 요청을 라우팅하는 controller
     * @param code: 종목 코드
     * @param startDate: 시세를 가져올 시작 날짜
     * @param endDate: 시세를 가져올 끝 날짜
     * @return dayDataListForChart: 차트용 과거 일봉 데이터 리스트
     * @author jaemin.joo
     */
    @GetMapping("/chart/daydata")
    public ResponseEntity<DayDataDto.ListForChart> getDayDataForChartByReq(@NotBlank @RequestParam("symbol_code") String code,
                                                                                        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("start_date") LocalDate startDate,
                                                                                        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("end_date") LocalDate endDate){
        return ResponseEntity.ok(historicalDataService.findDayDataForChartByReq(code, startDate, endDate));
    }

    /**
     * 차트용 과거 분봉 데이터를 요청을 라우팅하는 controller
     * @param code: 종목 코드
     * @param startDateTime: 시세를 가져올 시작 날짜
     * @param endDateTime: 시세를 가져올 끝 날짜
     * @return minDataListForStrategy: 차트용 과거 분봉 데이터 리스트
     * @author jaemin.joo
     */
    @GetMapping("/chart/mindata")
    public ResponseEntity<MinDataDto.ListForChart> getMinDataForChartByReq(@NotBlank @RequestParam("symbol_code") String code,
                                                                                        @DateTimeFormat(iso= ISO.DATE_TIME) @RequestParam("start_datetime") LocalDateTime startDateTime,
                                                                                        @DateTimeFormat(iso= ISO.DATE_TIME) @RequestParam("end_datetime") LocalDateTime endDateTime){
        return ResponseEntity.ok(historicalDataService.findMinDataForChartByReq(code, startDateTime, endDateTime));
    }
}
