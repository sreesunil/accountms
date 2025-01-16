package com.tekarch.accountms.Services;

import com.tekarch.accountms.Models.Accounts;

import java.util.List;

public interface AccountsService {

    List<Accounts> getAllAccounts();
    Accounts getAccountById(Long accountId);
    Accounts addAccount(Accounts accounts);
    void deleteAccount(Long accountId);
    Accounts updateAccount(Accounts accounts);


}
