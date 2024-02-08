package com.openapi.generator.Mapper;

import com.openapi.generator.entity.User;
import org.SwaggerCodeGenExample.model.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",injectionStrategy= InjectionStrategy.FIELD)
public interface AutoUserMapper {
   // AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    @Mapping(source = "email", target = "emailAddress")
    UserDto mapToUserDto(User user);

    @Mapping(source = "emailAddress", target = "email")
    User mapToUser(UserDto userDto);

}
