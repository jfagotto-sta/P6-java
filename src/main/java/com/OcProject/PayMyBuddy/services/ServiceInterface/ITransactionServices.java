package com.OcProject.PayMyBuddy.services.ServiceInterface;

import com.OcProject.PayMyBuddy.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ITransactionServices  {

    public <S extends Transaction> S save(S entity);

    public <S extends Transaction> Iterable<S> saveAll(Iterable<S> entities);

    public Optional<Transaction> findById(Integer integer);

    public boolean existsById(Integer integer);

    public Iterable<Transaction> findAll();

    public Iterable<Transaction> findAllById(Iterable<Integer> integers);

    public long count();

    public void deleteById(Integer integer);

    public void delete(Transaction entity);

    public void deleteAllById(Iterable<? extends Integer> integers);

    public void deleteAll(Iterable<? extends Transaction> entities);

    public void deleteAll();
}
