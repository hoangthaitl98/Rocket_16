package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IService{
    IRepository repository;

    public UserService(){
        repository = new UserRepository();
    }

    @Override
    public List<User> getUserByProjectId(int id) {
        return repository.getUserByProjectId(id);
    }

    @Override
    public List<User> getAllMagager() {
        return  repository.getAllMagager();
    }

    @Override
    public boolean login(String email, String password) {
        return repository.login(email, password);
    }
}
