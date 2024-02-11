package com.cengizhanyavuz.restapibestpractices.service;

import java.util.List;

public interface IUserService<D> {
    public D getById(int id);

    public List<D> getUsers(int maxRecords);

    public D createUser(D d);

    public D updateUser(int id,D d);

    public D patchUser(int id,D d);

    public void deleteUser(int id);
}