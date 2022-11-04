package com.tys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tys.domain.price.DayData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.*;

public class DayDataDto {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListForStrategy{
        private List<DataForStrategy> data;
        @JsonProperty("has_symbol_code")
        private boolean hasSymbolCode;

        @JsonProperty("is_allowed_date_range")
        private boolean allowedDateRange;


        public void toListForStrategy(List<DayData> dayDataList){
            this.data = dayDataList.stream()
                    .map(DataForStrategy::toDataForStrategy)
                    .collect(toList());
        }

        /**
         * 과거 시세 데이터를 받기 위한 종목코드 소유 여부, 조회 기간 허용 범위 여부를 채워주는 method
         * @param hasSymbolCode: 종목코드 소유 여부
         * @param allowedDateRange: 올바른 조회 기간 허용 범위 여부
         * @author jaemin.joo
         */
        public void fillAuthForHistoricalData(boolean hasSymbolCode, boolean allowedDateRange){
            this.hasSymbolCode = hasSymbolCode;
            this.allowedDateRange = allowedDateRange;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataForStrategy{
        @JsonProperty("daydata_date")
        private LocalDate date;
        private int close;

        static DataForStrategy toDataForStrategy(DayData dayData){
            return DataForStrategy.builder()
                    .date(dayData.getDate() != null? dayData.getDate() : LocalDate.MAX)
                    .close(dayData.getBasePrice() != null? dayData.getBasePrice().getClosePrice() : -1)
                    .build();
        }
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListForChart{
        private List<DataForChart> data;
        @JsonProperty("has_symbol_code")
        private boolean hasSymbolCode;

        @JsonProperty("is_allowed_date_range")
        private boolean allowedDateRange;


        public void toListForChart(List<DayData> dayDataList){
            this.data = dayDataList.stream()
                    .map(DataForChart::toDataForChart)
                    .collect(toList());
        }

        /**
         * 과거 시세 데이터를 받기 위한 종목코드 소유 여부, 조회 기간 허용 범위 여부를 채워주는 method
         * @param hasSymbolCode: 종목코드 소유 여부
         * @param allowedDateRange: 올바른 조회 기간 허용 범위 여부
         * @author jaemin.joo
         */
        public void fillAuthForHistoricalData(boolean hasSymbolCode, boolean allowedDateRange){
            this.hasSymbolCode = hasSymbolCode;
            this.allowedDateRange = allowedDateRange;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataForChart{
        @JsonProperty("daydata_date")
        private LocalDate date;
        @JsonProperty("symbol_code")
        private String symbolCode;
        private int open;
        private int close;
        private int high;
        private int low;
        private int volume;


        static DataForChart toDataForChart(DayData dayData){
            return DataForChart.builder()
                    .date(dayData.getDate() != null? dayData.getDate() : LocalDate.MAX)
                    .symbolCode(dayData.getCode() != null? dayData.getCode() : "No Code")
                    .open(dayData.getBasePrice() != null? dayData.getBasePrice().getOpenPrice() : -1)
                    .close(dayData.getBasePrice() != null? dayData.getBasePrice().getClosePrice() : -1)
                    .high(dayData.getBasePrice() != null? dayData.getBasePrice().getHighPrice() : -1)
                    .low(dayData.getBasePrice() != null? dayData.getBasePrice().getLowPrice() : -1)
                    .volume(dayData.getBasePrice().getVolume() != null? dayData.getBasePrice().getVolume() : -1)
                    .build();
        }
    }

}
