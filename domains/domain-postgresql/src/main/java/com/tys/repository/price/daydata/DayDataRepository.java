package com.tys.repository.price.daydata;



import com.tys.domain.dto.function.ReturnsDto;
import com.tys.domain.price.DayData;
import com.tys.domain.price.key.DayDataId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayDataRepository extends JpaRepository<DayData, DayDataId>, CustomDayDataRepository {
    List<DayData> findAllByCode(String code, Pageable pageable);

    @Query(nativeQuery = true)
    List<ReturnsDto> findReturnsTop20OrderByTerm(@Param("term") String term);


    List<DayData> findDayDataByCodeAndDateGreaterThanEqualAndDateLessThanEqualOrderByDate(String code, LocalDate startDate, LocalDate endDate);
}

