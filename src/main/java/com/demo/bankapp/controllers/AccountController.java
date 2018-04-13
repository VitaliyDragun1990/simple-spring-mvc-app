package com.demo.bankapp.controllers;

import com.demo.bankapp.model.Account;
import com.demo.bankapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account-form";
    }

    @GetMapping("/edit")
    public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
        Account account = accountService.getAccount(accountNo);
        model.addAttribute("account", account);
        return "account-form";
    }

    @GetMapping("/delete")
    public String deleteAccount(@RequestParam("accountNo") int accountNo) {
        accountService.deleteAccount(accountNo);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "listAccounts";
    }

    @GetMapping("/find")
    public String viewAccount(Model model) {

        return "findAccount";
    }

    @PostMapping("/showAccount")
    public String showAccount() {
        return "showAccount";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@Valid @ModelAttribute("account") Account account,
                              BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "account-form";
        }
        String message = "";
        boolean isSaveSuccessful = true;
        try {
            isSaveSuccessful = accountService.saveAccount(account);
        } catch (Exception ex) {
            message = ex.getMessage();
            isSaveSuccessful = false;
        }
        if (!isSaveSuccessful) {
            model.addAttribute("message", message);
            return "account-form";
        }
        return "redirect:/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        // register trimmer for every string request param property
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }
}
