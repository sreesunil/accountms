package com.tekarch.accountms.Services;

import com.tekarch.accountms.Models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsService {

    public Account createAccount(Account account);
    public List<Account> getAllAccounts();
    public Optional<Account> getAccountById(Long accountId);
    public List<Account> getAccountsByUserId(Long userId);


}
