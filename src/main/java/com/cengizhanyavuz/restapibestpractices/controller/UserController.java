package com.cengizhanyavuz.restapibestpractices.controller;

import com.cengizhanyavuz.restapibestpractices.model.BaseResponse;
import com.cengizhanyavuz.restapibestpractices.model.UserDto;
import com.cengizhanyavuz.restapibestpractices.service.impl.UserService;
import io.swagger.annotations.*;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "users", description = "Rest api for User Management")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Retrieve a user by id ", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<UserDto> retrieveUser(@PathVariable("id") int id) {
        UserDto user = userService.getById(id);
        return BaseResponse.success(user,"OK");
    }

    @ApiOperation(value = "Retrieve users according to max records parameter")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "There is not a user in list")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<List<UserDto>> retrieveAllUsers(
            @ApiParam(value = "maxRecords", required = false, defaultValue = "5")
            @RequestParam(required = false, defaultValue = "5") int maxRecords) {
        List<UserDto> users = userService.getUsers(maxRecords);
        return BaseResponse.success(users,"OK");
    }

    @ApiOperation(value = "create a user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "user created"),
            @ApiResponse(code = 400, message = "Invalid user object.")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<UserDto> createUser(@Valid @RequestBody UserDto userDTO) {
        UserDto user = userService.createUser(userDTO);
        return BaseResponse.success(user,"user created");
    }

    @ApiOperation(value = "update a user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid user object."),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable int id, @RequestBody UserDto userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @ApiOperation(value = "patch a user info")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid user object."),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<UserDto> patchUpdateUser(@PathVariable(name = "id") int id, @RequestBody UserDto userDTO) {
        UserDto user = userService.patchUser(id, userDTO);
        return BaseResponse.success(user, "Partial update is succesfully completed via patch.");
    }

    @ApiOperation(value = "delete a user info")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
