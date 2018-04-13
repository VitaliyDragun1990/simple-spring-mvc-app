package com.demo.bankapp.controllers;

import com.demo.bankapp.model.Account;
import com.demo.bankapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountRESTController {

    private AccountService accountService;

    @Autowired
    public AccountRESTController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @ResponseBody
    @PostMapping
    public ResponseEntity<Account> getAccount(@RequestBody Account accnt) {
        System.out.println("Requested Account Number : " + accnt.getAccountNo());
        Account account = accountService.getAccount(accnt.getAccountNo());
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
