package com.palex.practice.controller;

import com.palex.practice.service.UserService;
import com.palex.practice.view.ResultView;
import com.palex.practice.view.SuccessView;
import com.palex.practice.view.User.UserListFilterView;
import com.palex.practice.view.User.UserSaveFilterView;
import com.palex.practice.view.User.UserUpdateFilterView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.POST
    )
    public ResultView userList(
            @RequestBody @Valid UserListFilterView userListFilterView
    ) {
        return new ResultView(userService.list(userListFilterView));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResultView userGetById(
            @PathVariable("id") Long id
    ){
        return new ResultView(userService.getById(id));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public SuccessView userUpdate(
            @RequestBody @Valid UserUpdateFilterView userUpdateFilterView
    ) {
        userService.update(userUpdateFilterView);
        return new SuccessView();
    }

    @RequestMapping(
            value = "/save",
            method = {POST})
    public SuccessView userSave(
            @RequestBody @Valid UserSaveFilterView userSaveFilterView
    ) {
        userService.save(userSaveFilterView);
        return new SuccessView();
    }
}