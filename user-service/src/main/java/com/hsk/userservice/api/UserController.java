package com.hsk.userservice.api;

import com.hsk.userservice.api.payload.UserRequest;
import com.hsk.userservice.helper.UserHelper;
import com.hsk.userservice.utils.ResponseData;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserHelper userHelper;

    public UserController(UserHelper userHelper) {
        this.userHelper = userHelper;
    }

    @PostMapping
    public ResponseData registerUser(
            @RequestBody
            UserRequest userRequest,
            BindingResult bindingResult
    ){
        return userHelper.registerUser(userRequest,bindingResult);
    }

    @GetMapping("/{userId}")
    public ResponseData getUserById(
            @PathVariable("userId")
            Long userId
    ){
        return userHelper.getUserById(userId);
    }

    @GetMapping
    public ResponseData getUserByEmail(
            @RequestParam("email")
            String email
    ){
        return userHelper.getUserByEmail(email);
    }

    @PutMapping("/{userId}")
    public ResponseData updateUser(
            @PathVariable("userId")
            Long userId,
            @RequestBody
            UserRequest userRequest,
            BindingResult bindingResult
    ){
        return userHelper.updateUser(userId,userRequest,bindingResult);
    }

    @DeleteMapping("/{userId}")
    public ResponseData deleteUserById(
            @PathVariable("userId")
            Long userId
    ){
        return userHelper.deleteUserById(userId);
    }
}
