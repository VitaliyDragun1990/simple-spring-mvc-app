package com.demo.bankapp.aop;

import com.demo.bankapp.dao.AccountDAO;
import com.demo.bankapp.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Before("execution(* com.demo.bankapp.dao.AccountDAOImpl.saveAccount(..))")
    public void validateAccount(JoinPoint joinPoint) {
        logger.info("Method: ValidateAccount is being processed.");
        Object []args = joinPoint.getArgs();
        Account account = (Account)args[0];
        AccountDAO accountDAO = (AccountDAO)joinPoint.getTarget();
        int accountNo = account.getAccountNo();
        if (accountDAO.getAccount(accountNo) != null) {
            throw new RuntimeException("Account with Account Number " + accountNo + " is already exist");
        }
    }
}
