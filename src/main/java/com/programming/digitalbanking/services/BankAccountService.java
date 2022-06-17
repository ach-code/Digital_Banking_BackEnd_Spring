package com.programming.digitalbanking.services;

import java.util.List;

import com.programming.digitalbanking.dtos.AccountHistoryDTO;
import com.programming.digitalbanking.dtos.AccountOperationDTO;
import com.programming.digitalbanking.dtos.BankAccountDTO;
import com.programming.digitalbanking.dtos.CurrentBankAccountDTO;
import com.programming.digitalbanking.dtos.CustomerDTO;
import com.programming.digitalbanking.dtos.SavingBankAccountDTO;
import com.programming.digitalbanking.exceptions.BalanceNotSufficientException;
import com.programming.digitalbanking.exceptions.BankAccountNotFoundException;
import com.programming.digitalbanking.exceptions.CustomerNotFoundException;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccountDTO> bankAccountList();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);

}
