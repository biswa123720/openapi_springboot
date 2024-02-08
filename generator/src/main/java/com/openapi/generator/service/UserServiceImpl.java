package com.openapi.generator.service;

import com.openapi.generator.Mapper.AutoUserMapper;
import com.openapi.generator.Repository.UserRepository;
import com.openapi.generator.entity.User;
import lombok.AllArgsConstructor;
import org.SwaggerCodeGenExample.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    AutoUserMapper autoUserMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
        // User user = UserMapper.mapToUser(userDto);

        //User user = modelMapper.map(userDto, User.class);

        User user = autoUserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = autoUserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return autoUserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> autoUserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmailAddress());
        User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return autoUserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }
}
