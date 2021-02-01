package com.paxian;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;
import javax.annotation.Nullable;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends EntityPathBase {

    public StringPath city = createString("city");
    public StringPath country = createString("country");

    public QAddress(String variable) {
        super(QAddress.class, forVariable(variable));
    }

    public QAddress(Path path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(QAddress.class, metadata);
    }
}
