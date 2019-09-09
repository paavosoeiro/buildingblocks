package com.udemy.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.udemy.restservices.dtos.UserMsDto;
import com.udemy.restservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({ @Mapping(source = "email", target = "emailaddress"), @Mapping(source = "role", target = "rolename"), })
	UserMsDto userToUserMsDto(User user);

	List<UserMsDto> usersToUserDtos(List<User> users);
}
