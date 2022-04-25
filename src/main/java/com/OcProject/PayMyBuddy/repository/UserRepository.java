package com.OcProject.PayMyBuddy.repository;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.IRepository.IUserRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UserRepository implements IUserRepository {


    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mybuddy");
    public static EntityManager em = emf.createEntityManager();

    @Override
    public User createANewUser(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public User findAUser(long userId) {
      User user = em.find(User.class, userId);
        return user;
    }

    @Override
    public boolean updateAUser(User user, long userId) {

       em.getTransaction().begin();

        User userToUpdate = em.find(User.class, userId);

        userToUpdate.setUserId((int) user.getUserId());
        userToUpdate.setBalance(user.getBalance());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setMail(user.getMail());
        userToUpdate.setPassword(user.getPassword());

        em.getTransaction().commit();

        return true;

    }

    @Override
    public boolean deleteAUser(long userId) {

        em.getTransaction().begin();

        User userToDelete = em.find(User.class, userId);

        em.remove(userToDelete);

        em.getTransaction().commit();

        return true;
    }
}
