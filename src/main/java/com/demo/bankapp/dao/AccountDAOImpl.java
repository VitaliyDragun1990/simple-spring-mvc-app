package com.demo.bankapp.dao;

import com.demo.bankapp.entity.AccountEntity;
import com.demo.bankapp.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class.getName());

    private SessionFactory sessionFactory;

    @Autowired
    public AccountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean saveAccount(Account account) {
        boolean saveFlag = true;

        AccountEntity accountEntity = mapAccountToEntity(account);

        Session currentSession = sessionFactory.getCurrentSession();
        try {
//            currentSession.saveOrUpdate(accountEntity);
            currentSession.save(accountEntity);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            saveFlag = false;
        }
        return saveFlag;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts;

        Session currentSession = sessionFactory.getCurrentSession();
        try {
            Query<AccountEntity> query = currentSession.createQuery("From AccountEntity", AccountEntity.class);
            List<AccountEntity> accountEntities = query.getResultList();
            accounts = accountEntities.stream().map(this::mapEntityToAccount).collect(Collectors.toList());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            accounts = Collections.emptyList();
        }

        return accounts;
    }

    @Override
    public Account getAccount(Integer accountNo) {
        Account account = null;
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            AccountEntity accountEntity = currentSession.get(AccountEntity.class, accountNo);
            account = mapEntityToAccount(accountEntity);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return account;
    }

    @Override
    public boolean deleteAccount(Integer accountNo) {
        boolean deleteFlag = true;
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            AccountEntity accountEntity = currentSession.load(AccountEntity.class, accountNo);
            currentSession.delete(accountEntity);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            deleteFlag = false;
        }
        return deleteFlag;
    }

    private Account mapEntityToAccount(AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        Account account = new Account();
        account.setAccountNo(entity.getAccNo());
        account.setAccountHolderName(entity.getAccHolderName());
        account.setBalance(entity.getBalance());
        account.setAccountType(entity.getAccountType());
        account.setDateOfBirth(entity.getDateOfBirth());
        account.setPsCode(entity.getPsCode());
        return account;
    }

    private AccountEntity mapAccountToEntity(Account account) {
        if (account == null) {
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccNo(account.getAccountNo());
        accountEntity.setAccHolderName(account.getAccountHolderName());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setAccountType(account.getAccountType());
        accountEntity.setDateOfBirth(account.getDateOfBirth());
        accountEntity.setPsCode(account.getPsCode());
        return accountEntity;
    }
}
