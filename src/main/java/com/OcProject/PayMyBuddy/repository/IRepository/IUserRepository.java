package com.OcProject.PayMyBuddy.repository.IRepository;

import com.OcProject.PayMyBuddy.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {

    public User createANewUser(User user);

    public User findAUser(long userId);

    public boolean updateAUser (User user, long userId);

    public boolean deleteAUser (long userId);




}
