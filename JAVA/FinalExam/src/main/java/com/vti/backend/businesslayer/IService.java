package com.vti.backend.businesslayer;

import com.vti.entity.User;

import java.util.List;

public interface IService {
    public List<User> getUserByProjectId(int id);

    public List<User> getAllMagager();

    public boolean login(String email, String password);

}
