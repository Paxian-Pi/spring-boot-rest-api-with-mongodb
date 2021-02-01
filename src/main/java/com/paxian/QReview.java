package com.paxian;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;
import javax.annotation.Nullable;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QReview extends EntityPathBase {

    public StringPath userName = createString("userName");
    public NumberPath rating = createNumber("rating", int.class);
    public BooleanPath approved = createBoolean("approved");

    public QReview(String variable) {
        super(QReview.class, forVariable(variable));
    }

    public QReview(Path path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(QReview.class, metadata);
    }
}
