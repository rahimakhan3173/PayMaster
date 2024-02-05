package com.smallworldfs.coding_test.controller;

import com.smallworldfs.coding_test.model.TransactionInfo;
import com.smallworldfs.coding_test.service.TransactionDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/smallworldfs")
public class TransactionController {
    @Autowired
    TransactionDataFetcher transactionDataFetcher;

//     Returns the sum of the amounts of all transactions
    @GetMapping("/sumOfTrn")
    public double getSumOfAllTrn(){
        return transactionDataFetcher.getSumOfAllTransaction();
    }

//      Returns the sum of the amounts of all transactions sent by the specified client
    @GetMapping("/sumOfTrn/{senderName}")
    public double getTotalTransactionAmountSentBy(@PathVariable(name = "senderName") String SenderName) {
        return transactionDataFetcher.getTotalTransactionAmountSentBy(SenderName);
    }

//   Returns the highest transaction amount
    @GetMapping("/highestTrnAmount")
    public double getHighestTransactionAmount(){

        return transactionDataFetcher.getMaxTransactionAmount();
    }

//    Counts the number of unique clients that sent or received a transaction
    @GetMapping("/uniqueClient")
    public long getUniqueClient(){
        return transactionDataFetcher.countUniqueClients();
    }

//    Returns the sender with the most total sent amount
    @GetMapping("/topSender")
    public String getTopSender() {
        return transactionDataFetcher.getTopSender();
    }

//    Returns the 3 transactions with highest amount sorted by amount descending

    @GetMapping("/top3Trn")
    public List<Double> getTop3TransactionsByAmount() {
        return transactionDataFetcher.getTop3Trn();
    }

//     Returns a list of all solved issue messages
    @GetMapping("/solvedIssueMsg")
    public List<String> getAllSolvedIssueMessages() {
        return transactionDataFetcher.getAllSolveIssueMessage();
    }


//     Returns the identifiers of all open compliance issues
    @GetMapping("/unsolvedIssueIds")
    public List<Integer> getUnsolvedIssueIds() {
            return transactionDataFetcher.getUnsolvedIssueIds();
    }

//      Returns all transactions indexed by beneficiary name
     @GetMapping("/beneTrn")
    public Map<String, List<TransactionInfo>> getTransactionsByBeneficiaryName() {
        return transactionDataFetcher.getTrnByBeneName();
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    @GetMapping("/openIssue/{clientFullName}")
    public boolean hasOpenComplianceIssues(@PathVariable(name = "clientFullName")String clientFullName) {
        return transactionDataFetcher.getOpenIssueOfClient(clientFullName);
    }

}
