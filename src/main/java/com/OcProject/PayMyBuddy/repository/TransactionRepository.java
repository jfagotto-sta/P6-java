//package com.OcProject.PayMyBuddy.repository;
//
//import com.OcProject.PayMyBuddy.model.Transaction;
//import com.OcProject.PayMyBuddy.repository.IRepository.ITransactionRepository;
//import org.springframework.stereotype.Repository;
//
//import static com.OcProject.PayMyBuddy.repository.UserRepository.em;
//
//@Repository
//public class TransactionRepository implements ITransactionRepository {
//
//
//    @Override
//    public Transaction createANewTransaction(Transaction transaction) {
//
//        em.getTransaction().begin();
//        em.persist(transaction);
//        em.getTransaction().commit();
//
//        return transaction;
//    }
//
//    @Override
//    public Transaction findATransaction(long transactionID) {
//       Transaction transaction = em.find(Transaction.class, transactionID);
//        return transaction;
//    }
//
//    @Override
//    public boolean updateATransaction(Transaction transaction, long transactionID) {
//
//        em.getTransaction().begin();
//
//        Transaction transactionToUpdate = em.find(Transaction.class, transactionID);
//
//        transactionToUpdate.setTransactionID(transactionID);
//        transactionToUpdate.setDateOfTransaction(transaction.getDateOfTransaction());
//        transactionToUpdate.setAmount(transaction.getAmount());
//        transactionToUpdate.setFees(transaction.getFees());
//        transactionToUpdate.setRecipient(transaction.getRecipient());
//        transactionToUpdate.setSender(transaction.getSender());
//
//        em.getTransaction().commit();
//
//        return true;
//
//    }
//
//    @Override
//    public boolean deleteATransaction(long transationId) {
//
//        em.getTransaction().begin();
//
//        Transaction userToDelete = em.find(Transaction.class, transationId);
//
//        em.remove(userToDelete);
//
//        em.getTransaction().commit();
//
//        return true;
//    }
//
//
//
//}
