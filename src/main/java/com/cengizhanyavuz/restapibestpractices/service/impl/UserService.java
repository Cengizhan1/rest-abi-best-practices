package com.cengizhanyavuz.restapibestpractices.service.impl;

import com.cengizhanyavuz.restapibestpractices.exception.UserNotFoundException;
import com.cengizhanyavuz.restapibestpractices.model.UserDto;
import com.cengizhanyavuz.restapibestpractices.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService<UserDto> {

    private final Map<Integer, UserDto> userMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public UserDto getById(int id) {
        UserDto user = userMap.get(id);
        if (user == null) {
            throw new UserNotFoundException("User: " + id + " not found");
        }
        return user;
    }

    @Override
    public List<UserDto> getUsers(int maxRecords) {
        return userMap.values().stream().limit(maxRecords).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setId(nextId++);
        userMap.put(userDto.getId(), userDto);
        return userDto;
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User: " + id + " not found");
        }
        userDto.setId(id);
        userMap.put(id, userDto);
        return userDto;
    }

    @Override
    public UserDto patchUser(int id, UserDto userDto) {
        UserDto user = getById(id);
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getDetail() != null) {
            user.setDetail(userDto.getDetail());
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        if (userMap.remove(id) == null) {
            throw new UserNotFoundException("User: " + id + " not found");
        }
    }
}
