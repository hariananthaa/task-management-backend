package com.hsk.userservice.web;

import com.hsk.userservice.web.payload.UserSignupRequest;
import com.hsk.userservice.helper.UserHelper;
import com.hsk.userservice.utils.ResponseData;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false") // TODO: remove this in PROD ENV
public class UserController {
    private final UserHelper userHelper;

    public UserController(UserHelper userHelper) {
        this.userHelper = userHelper;
    }

    @PostMapping("/register")
    public ResponseData registerUser(
            @RequestBody
            UserSignupRequest userSignupRequest,
            BindingResult bindingResult
    ){
        return userHelper.registerUser(userSignupRequest,bindingResult);
    }

    @GetMapping("/{userId}")
    public ResponseData getUserById(
            @PathVariable("userId")
            Long userId
    ){
        return userHelper.getUserById(userId);
    }

    @GetMapping("/email")
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
            UserSignupRequest userSignupRequest,
            BindingResult bindingResult
    ){
        return userHelper.updateUser(userId, userSignupRequest,bindingResult);
    }

    @DeleteMapping("/{userId}")
    public ResponseData deleteUserById(
            @PathVariable("userId")
            Long userId
    ){
        return userHelper.deleteUserById(userId);
    }

    @GetMapping
    public ResponseData getAllUsers() {
        return userHelper.getAllUsers();
    }

}
