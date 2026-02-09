package com.example.bank.endpoint;
import com.example.bank.ws.TransferRequest;
import com.example.bank.ws.TransferResponse;
import java.math.BigDecimal;
import com.example.bank.ws.WithdrawRequest;
import com.example.bank.ws.WithdrawResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.bank.service.BankService;
import com.example.bank.service.BankService.Account;
import com.example.bank.service.UnknownAccountException;
import com.example.bank.ws.AccountType;
import com.example.bank.ws.DepositRequest;
import com.example.bank.ws.DepositResponse;
import com.example.bank.ws.GetAccountRequest;
import com.example.bank.ws.GetAccountResponse;

@Endpoint
public class BankEndpoint {

  private static final String NAMESPACE_URI = "http://example.com/bank";
  private final BankService bankService;

  public BankEndpoint(BankService bankService) {
    this.bankService = bankService;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAccountRequest")
  @ResponsePayload
  public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
    Account acc = bankService.getAccount(request.getAccountId());
    if (acc == null) {
      throw new UnknownAccountException("Unknown accountId: " + request.getAccountId());
    }

    AccountType dto = new AccountType();
    dto.setAccountId(acc.accountId);
    dto.setOwner(acc.owner);
    dto.setBalance(acc.balance);
    dto.setCurrency(acc.currency);

    GetAccountResponse resp = new GetAccountResponse();
    resp.setAccount(dto);
    return resp;
  }
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TransferRequest")
@ResponsePayload
public TransferResponse transfer(@RequestPayload TransferRequest request) {
    BigDecimal[] balances;
    try {
        balances = bankService.transfer(
            request.getFromAccountId(),
            request.getToAccountId(),
            request.getAmount()
        );
    } catch (UnknownAccountException | IllegalArgumentException e) {
        throw new RuntimeException(e.getMessage()); // SOAP Fault
    }

    TransferResponse response = new TransferResponse();
    response.setFromNewBalance(balances[0]);
    response.setToNewBalance(balances[1]);
    return response;
}
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "WithdrawRequest")
@ResponsePayload
public WithdrawResponse withdraw(@RequestPayload WithdrawRequest request) {
    BigDecimal newBalance;
    try {
        // on fait appel a service bancaire pour effectuer le retrait
        newBalance = bankService.withdraw(request.getAccountId(), request.getAmount());
    } catch (UnknownAccountException e) {
        // ici dans le cas ou Compte inconnu 
        throw new RuntimeException(e.getMessage());
    } catch (IllegalArgumentException e) {
        //ici dans le cas ou Montant négatif ou solde insuffisant 
        throw new RuntimeException(e.getMessage());
    }

    WithdrawResponse response = new WithdrawResponse();
    response.setNewBalance(newBalance);
    return response;
}
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DepositRequest")
  @ResponsePayload
  public DepositResponse deposit(@RequestPayload DepositRequest request) {
    BigDecimal newBalance = bankService.deposit(request.getAccountId(), request.getAmount());
    DepositResponse resp = new DepositResponse();
    resp.setNewBalance(newBalance);
    return resp;
  }
}
