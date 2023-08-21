package com.mjc.school.service.map;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoReq;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomNewsMapper {
    CustomNewsMapper INSTANCE = Mappers.getMapper(CustomNewsMapper.class);

    @Mappings(value = {
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true)
    })
    NewsModel mapDtoRequestToNewsModel(NewsDtoReq req);

    NewsDtoReq mapNewsModelToDtoResponse(NewsModel model);

}
