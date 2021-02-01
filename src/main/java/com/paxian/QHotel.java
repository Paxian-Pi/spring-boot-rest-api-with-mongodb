package com.paxian;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QHotel extends EntityPathBase {

    public StringPath id = createString("id");
    public StringPath name = createString("name");
    public NumberPath pricePerNight = createNumber("pricePerNight", int.class);
    public QAddress address = new QAddress("address");
    public List<QReview> reviews;

    public QHotel(String variable) {
        super(QHotel.class, forVariable(variable));
    }

    public QHotel(Path path) {
        super(path.getType(), path.getMetadata());
    }

    public QHotel(PathMetadata metadata) {
        super(QHotel.class, metadata);
    }
}
