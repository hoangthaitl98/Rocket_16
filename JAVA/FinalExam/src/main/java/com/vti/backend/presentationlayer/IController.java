package com.vti.backend.presentationlayer;

import com.vti.entity.User;

import java.util.List;

public interface IController {

    public List<User> getUserByProjectId(int id);

    public List<User> getAllMagager();

    public boolean login(String email, String password);

}
