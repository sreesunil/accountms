package com.tekarch.accountms.Services;


import com.tekarch.accountms.Models.Account;
import com.tekarch.accountms.Models.User;
import com.tekarch.accountms.Repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl {

    private final AccountRepository accountRepository;
    private final UserClient userClient;


    public AccountServiceImpl(AccountRepository accountRepository, UserClient userClient) {
        this.accountRepository = accountRepository;
        this.userClient = userClient;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }



}
