package com.tys.domain.price;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDayData is a Querydsl query type for DayData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDayData extends EntityPathBase<DayData> {

    private static final long serialVersionUID = 1308596516L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDayData dayData = new QDayData("dayData");

    public final com.tys.domain.price.embed.QBasePrice basePrice;

    public final StringPath code = createString("code");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public QDayData(String variable) {
        this(DayData.class, forVariable(variable), INITS);
    }

    public QDayData(Path<? extends DayData> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDayData(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDayData(PathMetadata metadata, PathInits inits) {
        this(DayData.class, metadata, inits);
    }

    public QDayData(Class<? extends DayData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.basePrice = inits.isInitialized("basePrice") ? new com.tys.domain.price.embed.QBasePrice(forProperty("basePrice")) : null;
    }

}

