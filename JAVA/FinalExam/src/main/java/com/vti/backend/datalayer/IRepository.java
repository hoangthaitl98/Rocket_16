package com.vti.backend.datalayer;

import com.vti.entity.User;

import java.util.List;

public interface IRepository {
    public List<User> getUserByProjectId(int id);

    public List<User> getAllMagager();

    public boolean login(String email, String password);
}
