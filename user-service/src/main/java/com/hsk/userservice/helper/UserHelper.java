package com.hsk.userservice.helper;

import com.hsk.userservice.api.payload.UserRequest;
import com.hsk.userservice.mapper.UserMapper;
import com.hsk.userservice.persistent.entity.User;
import com.hsk.userservice.service.UserService;
import com.hsk.userservice.utils.ResponseData;
import com.hsk.userservice.utils.ResponseUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class UserHelper {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserHelper(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public ResponseData registerUser(UserRequest userRequest, BindingResult bindingResult) {
        BindingResultHelper.processBindingResult(bindingResult);
        User user = userService.registerUser(userMapper.toEntity(userRequest));
        return ResponseUtil.responseConverter(userMapper.toDto(user));
    }

    public ResponseData getUserById(Long userId) {
        User user = userService.getUserById(userId);
        return ResponseUtil.responseConverter(userMapper.toDto(user));
    }

    public ResponseData getUserByEmail(String email) {
        User user = userService.getUserByEmail(email);
        return ResponseUtil.responseConverter(userMapper.toDto(user));
    }

    public ResponseData updateUser(Long userId,UserRequest userRequest, BindingResult bindingResult) {
        BindingResultHelper.processBindingResult(bindingResult);
        User user = userService.updateUserById(userId,userMapper.toEntity(userRequest));
        return ResponseUtil.responseConverter(userMapper.toDto(user));
    }

    public ResponseData deleteUserById(Long userId) {
        User user = userService.deleteUserById(userId);
        return ResponseUtil.responseConverter(userMapper.toDto(user));
    }
}
