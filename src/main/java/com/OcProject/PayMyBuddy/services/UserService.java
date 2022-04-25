package com.OcProject.PayMyBuddy.services;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.services.ServiceInterface.IUserService;


public class UserService implements IUserService {

   private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createANewUser(User user) {
        return userRepo.createANewUser(user);
    }

    @Override
    public User findAUser(long userId) {
        return userRepo.findAUser(userId);
    }

    @Override
    public boolean updateAUser(User user, long userId) {
        return userRepo.updateAUser(user, userId);
    }

    @Override
    public boolean deleteAUSer(long userId) {
        return userRepo.deleteAUser(userId);
    }
}
