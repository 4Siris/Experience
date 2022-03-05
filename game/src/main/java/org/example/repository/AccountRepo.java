package org.example.repository;

import org.springframework.data.repository.CrudRepository;

//Интерфейс для запроса в базу данных
public interface AccountRepo extends CrudRepository<Account,Long>{
    Iterable<Account> findByOrderByLogin();
    Iterable<Account> findByOrderByScoreDesc();
    Account findByLogin(String login);
}