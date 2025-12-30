package com.maxx.database.controller;

import com.maxx.database.DTO.UserCreationDTO;
import com.maxx.database.models.Users;
import com.maxx.database.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/")
public class UserInfoController {

private final UserInfoService userInfoService;

    @GetMapping("/pleaseWork")
    public ResponseEntity<Users> getUser () throws ExecutionException, InterruptedException {
       return  ResponseEntity.ok(userInfoService.something());
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser (@RequestBody UserCreationDTO userCreationDTO) throws ExecutionException, InterruptedException{

     String id = userInfoService.create(userCreationDTO);


        return ResponseEntity.ok("User Created with ID:" + id);

    }


}
