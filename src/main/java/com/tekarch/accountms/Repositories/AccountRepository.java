package com.tekarch.accountms.Repositories;

import com.tekarch.accountms.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserId(Long userId);




}
