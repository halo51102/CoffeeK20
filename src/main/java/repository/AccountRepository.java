/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.Account;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AccountRepository {

    Account login(String username, String password);

    void changePassword(Account account, String newPass);

    void update(Account account);

    List<Account> findByWord(String word);

    Account findByUsername(String username);

    List<Account> findAll();

    void create(Account account);

    void delete(Account account);

    int count();
}
