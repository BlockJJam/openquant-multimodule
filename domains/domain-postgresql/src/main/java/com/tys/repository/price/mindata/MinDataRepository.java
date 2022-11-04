package com.tys.repository.price.mindata;

import com.tys.domain.price.MinData;
import com.tys.domain.price.key.MinDataId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MinDataRepository extends JpaRepository<MinData, MinDataId> {
        List<MinData> findMinDataByCodeAndDateTimeGreaterThanEqualAndAndDateTimeLessThanEqualOrderByDateTime(String code, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
