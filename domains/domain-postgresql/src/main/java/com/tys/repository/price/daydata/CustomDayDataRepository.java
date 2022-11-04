package com.tys.repository.price.daydata;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface CustomDayDataRepository {
    public LocalDate findDateByCompDate(LocalDate compDate, Period period);

    public List<String> findAllCodeByExistsByTerm(LocalDate currDate, LocalDate termDate);

    Double findOneReturnsOfStockByCodeAndCurrPriceAndTerm(String code, Integer currPrice, LocalDate Term);
}
