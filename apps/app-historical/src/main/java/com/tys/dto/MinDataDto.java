package com.tys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tys.domain.price.MinData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MinDataDto {
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


        public void toListForStrategy(List<MinData> minDataList){
            this.data = minDataList.stream()
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
        @JsonProperty("mindata_datetime")
        private LocalDateTime date;
        private int close;

        static DataForStrategy toDataForStrategy(MinData minData){
            return DataForStrategy.builder()
                    .date(minData != null? minData.getDateTime() : LocalDateTime.MAX)
                    .close(minData != null? minData.getBasePrice().getClosePrice() : -1)
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


        public void toListForChart(List<MinData> minDataList){
            this.data = minDataList.stream()
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
        @JsonProperty("mindata_datetime")
        private LocalDateTime date;
        @JsonProperty("symbol_code")
        private String symbolCode;
        private int open;
        private int close;
        private int high;
        private int low;

        static DataForChart toDataForChart(MinData minData){
            return DataForChart.builder()
                    .date(minData.getDateTime() != null? minData.getDateTime() : LocalDateTime.MAX)
                    .symbolCode(minData.getCode() != null? minData.getCode() : "No Code")
                    .open(minData.getBasePrice() != null? minData.getBasePrice().getOpenPrice() : -1)
                    .close(minData.getBasePrice() != null? minData.getBasePrice().getClosePrice() : -1)
                    .high(minData.getBasePrice() != null? minData.getBasePrice().getHighPrice() : -1)
                    .low(minData.getBasePrice() != null? minData.getBasePrice().getLowPrice() : -1)
                    .build();
        }
    }
}
