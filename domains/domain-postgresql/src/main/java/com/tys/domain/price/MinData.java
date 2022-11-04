package com.tys.domain.price;

import com.tys.domain.price.embed.BasePrice;
import com.tys.domain.price.key.MinDataId;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="min_data", schema = "openquant")
@IdClass(MinDataId.class)
public class MinData{

    @Id
    private LocalDateTime dateTime;

    @Id
    @Column(length = 50)
    private String code;

    @Embedded
    private BasePrice basePrice;
}
