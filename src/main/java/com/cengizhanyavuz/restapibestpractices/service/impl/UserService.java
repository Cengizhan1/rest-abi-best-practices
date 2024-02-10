package com.cengizhanyavuz.restapibestpractices.service.impl;

import com.cengizhanyavuz.restapibestpractices.model.UserDto;
import com.cengizhanyavuz.restapibestpractices.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService<UserDto> {
    @Override
    public UserDto getById(int id) {
        return null;
    }

    @Override
    public List<UserDto> getUsers(int maxRecords) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto patchUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
