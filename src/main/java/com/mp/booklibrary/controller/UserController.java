package com.mp.booklibrary.controller;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.Save(userDto.toEntity()),HttpStatus.CREATED);

    }
}
