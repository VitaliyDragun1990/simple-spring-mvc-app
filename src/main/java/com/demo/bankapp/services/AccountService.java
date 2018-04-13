package com.demo.bankapp.services;

import com.demo.bankapp.model.Account;

import java.util.List;

public interface AccountService {

    boolean saveAccount(Account account);

    List<Account> getAccounts();

    Account getAccount(Integer accountNo);

    boolean deleteAccount(Integer accountNo);
}
