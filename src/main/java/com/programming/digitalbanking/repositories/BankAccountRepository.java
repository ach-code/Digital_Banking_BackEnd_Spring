package com.programming.digitalbanking.repositories;

import com.programming.digitalbanking.entities.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String>{
    
}
