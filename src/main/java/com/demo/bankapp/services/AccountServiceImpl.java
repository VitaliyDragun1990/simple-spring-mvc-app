package com.demo.bankapp.services;

import com.demo.bankapp.dao.AccountDAO;
import com.demo.bankapp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Transactional
    @Override
    public boolean saveAccount(Account account) {
        return accountDAO.saveAccount(account);
    }

    @Transactional
    @Override
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    @Transactional
    @Override
    public Account getAccount(Integer accountNo) {
        return accountDAO.getAccount(accountNo);
    }

    @Transactional
    @Override
    public boolean deleteAccount(Integer accountNo) {
        return accountDAO.deleteAccount(accountNo);
    }
}
