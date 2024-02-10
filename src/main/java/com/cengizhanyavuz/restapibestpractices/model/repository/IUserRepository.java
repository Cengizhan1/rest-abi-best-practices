package com.cengizhanyavuz.restapibestpractices.model.repository;

import com.cengizhanyavuz.restapibestpractices.model.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<UserDto, Integer> {

    List<UserDto> findTopNUsers(int maxRecords);

}
