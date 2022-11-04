package com.tys.domain.price.embed;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasePrice is a Querydsl query type for BasePrice
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBasePrice extends BeanPath<BasePrice> {

    private static final long serialVersionUID = 701081057L;

    public static final QBasePrice basePrice = new QBasePrice("basePrice");

    public final NumberPath<Integer> closePrice = createNumber("closePrice", Integer.class);

    public final NumberPath<Integer> highPrice = createNumber("highPrice", Integer.class);

    public final NumberPath<Integer> lowPrice = createNumber("lowPrice", Integer.class);

    public final NumberPath<Integer> openPrice = createNumber("openPrice", Integer.class);

    public final NumberPath<Integer> volume = createNumber("volume", Integer.class);

    public QBasePrice(String variable) {
        super(BasePrice.class, forVariable(variable));
    }

    public QBasePrice(Path<? extends BasePrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasePrice(PathMetadata metadata) {
        super(BasePrice.class, metadata);
    }

}

