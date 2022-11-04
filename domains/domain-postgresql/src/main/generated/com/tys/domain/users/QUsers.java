package com.tys.domain.users;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = -1838131515L;

    public static final QUsers users = new QUsers("users");

    public final SetPath<Authority, QAuthority> authoritySet = this.<Authority, QAuthority>createSet("authoritySet", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final BooleanPath delNy = createBoolean("delNy");

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath pwd = createString("pwd");

    public final NumberPath<Integer> userSeq = createNumber("userSeq", Integer.class);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

