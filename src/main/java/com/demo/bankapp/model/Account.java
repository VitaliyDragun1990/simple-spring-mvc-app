package com.demo.bankapp.model;

import com.demo.bankapp.validations.PSCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Account {

    @NotNull
    private Integer accountNo;

    @NotNull
    @Size(min = 2, max = 50, message = "Invalid length for Account Holder Name")
    @Pattern(regexp = "[A-Za-z(\\s)]+", message = "Invalid Account Holder Name")
    private String accountHolderName;

    @NotNull
    @Min(value = 5000, message = "Minimum balance must not be less then 5000")
    private Integer balance;

    @NotEmpty
    private String accountType;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past(message = "Account cannot be created for a person not born")
    private Date dateOfBirth;

    @NotEmpty
    @PSCode(value = "PSUSA", message = "Security Code should start with PSUSA")
    private String psCode;

    public Account() {
        accountNo = 0;
        accountHolderName = "";
        balance = 0;
        accountType = "";
        dateOfBirth = new Date();
        psCode = "";
    }

    public Account(Integer accountNo, String accountHolderName, Integer balance, String accountType,
                   Date dateOfBirth, String psCode) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.dateOfBirth = dateOfBirth;
        this.psCode = psCode;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }
}
