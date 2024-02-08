package com.openapi.generator.Controller;

import com.openapi.generator.service.UserService;
import lombok.AllArgsConstructor;
import org.SwaggerCodeGenExample.api.CreateApi;
import org.SwaggerCodeGenExample.api.DeleteApi;
import org.SwaggerCodeGenExample.api.GetApi;
import org.SwaggerCodeGenExample.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
//@RequestMapping("api/v1/users")
public class UserController implements CreateApi {

    private UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(@Valid UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @Override
    public ResponseEntity<UserDto> getUserById( Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @Override
    public ResponseEntity<List<UserDto>> getUser(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

}
