package com.technicaltest.test.mapper;

public interface IMapper <I, O> {

    public O MapDtoEntity(I in);

}
