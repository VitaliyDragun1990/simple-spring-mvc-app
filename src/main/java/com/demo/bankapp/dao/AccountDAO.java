package com.demo.bankapp.dao;

import com.demo.bankapp.model.Account;

import java.util.List;

public interface AccountDAO {

    boolean saveAccount(Account account);

    List<Account> getAccounts();

    Account getAccount(Integer accountNo);

    boolean deleteAccount(Integer accountNo);
}
