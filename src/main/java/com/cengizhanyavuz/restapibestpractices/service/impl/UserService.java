package com.cengizhanyavuz.restapibestpractices.service.impl;

import com.cengizhanyavuz.restapibestpractices.model.UserDto;
import com.cengizhanyavuz.restapibestpractices.model.repository.IUserRepository;
import com.cengizhanyavuz.restapibestpractices.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService<UserDto> {

    private final IUserRepository userRepository;

    @Override
    public UserDto getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDto> getUsers(int maxRecords) {
        return userRepository.findTopNUsers(maxRecords);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public UserDto patchUser(int id,UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
