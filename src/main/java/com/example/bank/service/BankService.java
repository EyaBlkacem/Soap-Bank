package com.example.bank.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class BankService {

  public static class Account {
    public final String accountId;
    public final String owner;
    public BigDecimal balance;
    public final String currency;

    public Account(String accountId, String owner, BigDecimal balance, String currency) {
      this.accountId = accountId;
      this.owner = owner;
      this.balance = balance;
      this.currency = currency;
    }
  }

  private final Map<String, Account> db = new ConcurrentHashMap<>();

  public BankService() {
    db.put("A100", new Account("A100", "Alice", new BigDecimal("150.00"), "TND"));
    db.put("B200", new Account("B200", "Bob",   new BigDecimal("80.50"),  "TND"));
  }

  public Account getAccount(String accountId) {
    return db.get(accountId);
  }

  public BigDecimal deposit(String accountId, BigDecimal amount) {
    if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new InvalidAmountException("Amount must be > 0");
    }
    Account acc = db.get(accountId);
    if (acc == null) {
      throw new UnknownAccountException("Unknown accountId: " + accountId);
    }
    acc.balance = acc.balance.add(amount);
    return acc.balance;
  }
   public BigDecimal withdraw(String accountId, BigDecimal amount) {
        Account acc = getAccount(accountId);
        if (acc == null) throw new UnknownAccountException("Account not found");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (acc.balance.compareTo(amount) < 0) throw new IllegalArgumentException("Insufficient funds");

        acc.balance = acc.balance.subtract(amount);
        return acc.balance;
    }
    public BigDecimal[] transfer(String fromAccountId, String toAccountId, BigDecimal amount) {
    Account from = getAccount(fromAccountId);
    Account to   = getAccount(toAccountId);

    if (from == null) throw new UnknownAccountException("Source account not found");
    if (to == null) throw new UnknownAccountException("Destination account not found");
    if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
    if (from.balance.compareTo(amount) < 0) throw new IllegalArgumentException("Insufficient funds");

    from.balance = from.balance.subtract(amount);
    to.balance = to.balance.add(amount);

    return new BigDecimal[]{from.balance, to.balance};
}

}
