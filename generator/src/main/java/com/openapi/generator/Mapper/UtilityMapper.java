//package com.openapi.generator.Mapper;
//
//import com.openapi.generator.Util.Role;
//import org.SwaggerCodeGenExample.model.UserDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.ValueMapping;
//
//@Mapper
//public interface UtilityMapper {
//    @ValueMapping(source = "DB_Administrator",target = "DBAdministrator")
//    @ValueMapping(source = "DATA_ENGINEER",target = "DataEngineer")
//    @ValueMapping(source = "DATA_SCIENTIST",target = "DataScientist")
//    @ValueMapping(source = "CLOUD_ENGINEER",target = "CloudEngineer")
//    @ValueMapping(source = "Developer",target = "Developer")
//    Role getEnum(UserDto.UserRoleEnum role);
//}
