package com.tys.service;

import com.tys.dto.DayDataDto;
import com.tys.dto.MinDataDto;
import com.tys.repository.price.daydata.DayDataRepository;
import com.tys.repository.price.mindata.MinDataRepository;
import com.tys.repository.symbols.SymbolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class HistoricalDataService {
    private final SymbolRepository symbolRepository;
    private final DayDataRepository dayDataRepository;
    private final MinDataRepository minDataRepository;

    /**
     * 종목코드, 조회할 시작과 끝 날짜를 활용해 해당 기간의 과거 일봉 데이터를 전략용 DTO에 담아서 제공하는 service
     * @param code: 종목 코드
     * @param startDate: 시세를 가져올 시작 날짜
     * @param endDate: 시세를 가져올 끝 날짜
     * @return dayDataListForStrategy: 전략용 과거 일봉 데이터 리스트
     * @author jaemin.joo
     */
    public DayDataDto.ListForStrategy findDayDataForStrategyByReq(String code, LocalDate startDate, LocalDate endDate) {
        DayDataDto.ListForStrategy listForStrategy = new DayDataDto.ListForStrategy();
        // fill hasSymbolCode, allowedDateRange
        listForStrategy.fillAuthForHistoricalData( symbolRepository.findByCode(code).isPresent(), startDate.isBefore(endDate));

        if(hasAuthForReservingHistroicalData(listForStrategy.isAllowedDateRange(), listForStrategy.isHasSymbolCode())){
            listForStrategy.toListForStrategy(
                    dayDataRepository.findDayDataByCodeAndDateGreaterThanEqualAndDateLessThanEqualOrderByDate( code, startDate, endDate));
        }

        return listForStrategy;
    }

    /**
     * 종목코드, 조회할 시작과 끝 날짜를 활용해 해당 기간의 과거 분봉 데이터를 전략용 DTO에 제공하는 service
     * @param code: 종목 코드
     * @param startDateTime: 시세를 가져올 시작 날짜
     * @param endDateTime: 시세를 가져올 끝 날짜
     * @return minDataListForStrategy: 전략용 과거 분봉 데이터 리스트
     * @author jaemin.joo
     */
    public MinDataDto.ListForStrategy findMinDataForStrategyByReq(String code, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        MinDataDto.ListForStrategy listForStrategy = new MinDataDto.ListForStrategy();
        // fill hasSymbolCode, allowedDateRange
        listForStrategy.fillAuthForHistoricalData(symbolRepository.findByCode(code).isPresent(), startDateTime.isBefore(endDateTime));

        if(hasAuthForReservingHistroicalData(listForStrategy.isAllowedDateRange(), listForStrategy.isHasSymbolCode())){
            listForStrategy.toListForStrategy(
                    minDataRepository.findMinDataByCodeAndDateTimeGreaterThanEqualAndAndDateTimeLessThanEqualOrderByDateTime(code, startDateTime, endDateTime)
            );
        }

        return listForStrategy;
    }

    /**
     * 종목코드, 조회할 시작과 끝 날짜를 활용해 해당 기간의 과거 일봉 데이터를 차트용 DTO에 제공하는 service
     * @param code: 종목 코드
     * @param startDate: 시세를 가져올 시작 날짜
     * @param endDate: 시세를 가져올 끝 날짜
     * @return dayDataListForChart: 차트용 과거 일봉 데이터 리스트
     * @author jaemin.joo
     */
    public DayDataDto.ListForChart findDayDataForChartByReq(String code, LocalDate startDate, LocalDate endDate) {
        DayDataDto.ListForChart listForChart = new DayDataDto.ListForChart();

        // fill hasSymbolCode, allowedDateRange
        listForChart.fillAuthForHistoricalData(symbolRepository.findByCode(code).isPresent(), startDate.isBefore(endDate));

        if(hasAuthForReservingHistroicalData(listForChart.isAllowedDateRange(), listForChart.isHasSymbolCode())){
            listForChart.toListForChart(
                    dayDataRepository.findDayDataByCodeAndDateGreaterThanEqualAndDateLessThanEqualOrderByDate( code, startDate, endDate));
        }

        return listForChart;
    }

    /**
     * 종목코드, 조회할 시작과 끝 날짜를 활용해 해당 기간의 과거 분봉 데이터를 차트용 DTO에 제공하는 service
     * @param code: 종목 코드
     * @param startDateTime: 시세를 가져올 시작 날짜
     * @param endDateTime: 시세를 가져올 끝 날짜
     * @return minDataListForStrategy: 차트용 과거 분봉 데이터 리스트
     * @author jaemin.joo
     */
    public MinDataDto.ListForChart findMinDataForChartByReq(String code, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        MinDataDto.ListForChart listForChart = new MinDataDto.ListForChart();

        // fill hasSymbolCode, allowedDateRange
        listForChart.fillAuthForHistoricalData(symbolRepository.findByCode(code).isPresent(), startDateTime.isBefore(endDateTime));

        if(hasAuthForReservingHistroicalData(listForChart.isAllowedDateRange(), listForChart.isHasSymbolCode())){
            listForChart.toListForChart(
                    minDataRepository.findMinDataByCodeAndDateTimeGreaterThanEqualAndAndDateTimeLessThanEqualOrderByDateTime(code, startDateTime, endDateTime)
            );
        }

        return listForChart;
    }

    /**
     *
     * @param allowedDateRange: 시세 조회 시작날짜가 끝날짜의 앞에 있도록 맞게 범위를 지정했는지 여부
     * @param hasSymbolCode: 해당 종목 코드를 가지고 있는지 여부
     * @return boolean: 과거 시세 정보를 받아도 되는지 여부
     * @author jaemin.joo
     */
    private boolean hasAuthForReservingHistroicalData(boolean allowedDateRange, boolean hasSymbolCode ) {
        return allowedDateRange && hasSymbolCode;
    }

}
