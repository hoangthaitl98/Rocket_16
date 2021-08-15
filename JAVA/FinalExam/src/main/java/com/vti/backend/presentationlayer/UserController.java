package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

import java.util.List;

public class UserController implements IController{
    IService service;

    public UserController(){
        service = new UserService();
    }

    public List<User> getUserByProjectId(int id){
        return service.getUserByProjectId(id);
    }

    @Override
    public List<User> getAllMagager() {
        return service.getAllMagager();
    }

    @Override
    public boolean login(String email, String password) {
        return service.login(email, password);
    }
}
