package com.tekarch.accountms.Controller;

import com.tekarch.accountms.Models.Accounts;
import com.tekarch.accountms.Services.AccountsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private AccountsServiceImpl accountsService;

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        System.out.println("Success");
        return new ResponseEntity<>(accountsService.getAllAccounts(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Accounts> createAccount(@RequestBody Accounts account) {
        Accounts createdAccount = accountsService.addAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Accounts> updateAccount(@RequestBody Accounts account) {
        Accounts createdAccount = accountsService.updateAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id) {
        Accounts account = accountsService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        if(!accountsService.getAccountById(id).getAccountId().equals(0L)) {
            accountsService.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
    }
}
