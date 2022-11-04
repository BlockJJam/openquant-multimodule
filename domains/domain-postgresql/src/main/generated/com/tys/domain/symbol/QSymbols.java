package com.tys.domain.symbol;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSymbols is a Querydsl query type for Symbols
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSymbols extends EntityPathBase<Symbols> {

    private static final long serialVersionUID = -892971966L;

    public static final QSymbols symbols = new QSymbols("symbols");

    public final StringPath code = createString("code");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final NumberPath<Integer> symbolSeq = createNumber("symbolSeq", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public QSymbols(String variable) {
        super(Symbols.class, forVariable(variable));
    }

    public QSymbols(Path<? extends Symbols> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSymbols(PathMetadata metadata) {
        super(Symbols.class, metadata);
    }

}

