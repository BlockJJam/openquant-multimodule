package com.tys.domain.price;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMinData is a Querydsl query type for MinData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMinData extends EntityPathBase<MinData> {

    private static final long serialVersionUID = 925069530L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMinData minData = new QMinData("minData");

    public final com.tys.domain.price.embed.QBasePrice basePrice;

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> dateTime = createDateTime("dateTime", java.time.LocalDateTime.class);

    public QMinData(String variable) {
        this(MinData.class, forVariable(variable), INITS);
    }

    public QMinData(Path<? extends MinData> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMinData(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMinData(PathMetadata metadata, PathInits inits) {
        this(MinData.class, metadata, inits);
    }

    public QMinData(Class<? extends MinData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.basePrice = inits.isInitialized("basePrice") ? new com.tys.domain.price.embed.QBasePrice(forProperty("basePrice")) : null;
    }

}

