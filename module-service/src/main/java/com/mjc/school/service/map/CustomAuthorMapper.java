package com.mjc.school.service.map;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomAuthorMapper {
    CustomAuthorMapper INSTANCE = Mappers.getMapper(CustomAuthorMapper.class);



    @Mappings(value = {@Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateDate", ignore = true)})
    AuthorModel toAuthorModel(AuthorDtoRes request);
    AuthorDtoRes toAuthorDtoResponse(AuthorModel model);
}