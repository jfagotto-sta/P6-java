package com.OcProject.PayMyBuddy.services.ServiceInterface;

import com.OcProject.PayMyBuddy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User createANewUser(User user);

    public User findAUser(long userId);

    public boolean updateAUser(User user, long userId);

    public boolean deleteAUSer(long userId);
}
