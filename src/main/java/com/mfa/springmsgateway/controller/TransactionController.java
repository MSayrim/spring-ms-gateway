package com.mfa.springmsgateway.controller;

import com.google.gson.JsonElement;
import com.mfa.springmsgateway.security.UserPrincipal;
import com.mfa.springmsgateway.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement transaction){
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }
    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTrasnaction(@PathVariable Long transactionId){
        transactionService.deleteTransaction(transactionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal){
        return ResponseEntity.ok(transactionService.getAllTransactionsOfUser(principal.getId()));
    }
}
