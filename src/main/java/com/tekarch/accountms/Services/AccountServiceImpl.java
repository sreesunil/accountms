package com.tekarch.accountms.Services;


import com.tekarch.accountms.DTO.UserDTO;
import com.tekarch.accountms.Models.Account;
import com.tekarch.accountms.Repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl {
    private final RestTemplate restTemplate;
    private final AccountRepository accountRepository;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public AccountServiceImpl(AccountRepository accountRepository, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.accountRepository = accountRepository;
    }


    public Account createAccount(Account account) {
        UserDTO userDTO = getUserById(account.getUserId());
        if (userDTO == null) {
            throw new IllegalArgumentException("User does not exist with ID: " + account.getUserId());
        }

        // Save account
        return accountRepository.save(account);

    }

    private UserDTO getUserById(Long userId) {
        String url = userServiceUrl + "/users/" + userId; // Example: http://localhost:8080/api/users/{userId}
        try {
            return restTemplate.getForObject(url, UserDTO.class);
        } catch (Exception e) {
            System.err.println("Error fetching user with ID " + userId + ": " + e.getMessage());
            return null;
        }
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
