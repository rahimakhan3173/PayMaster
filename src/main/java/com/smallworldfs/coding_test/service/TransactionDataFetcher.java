package com.smallworldfs.coding_test.service;

import com.smallworldfs.coding_test.model.TransactionInfo;
import com.smallworldfs.coding_test.repository.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TransactionDataFetcher {
    @Autowired
    private TransactionRepo transactionRepo;

    public double getSumOfAllTransaction() {
        List<TransactionInfo> transactionList = transactionRepo.findAll();
        double TotalAmount = transactionList.stream().mapToDouble(TransactionInfo::getAmount).sum();
        log.info("Sum of All transactions = {} ", TotalAmount);
        return TotalAmount;
    }

    public double getTotalTransactionAmountSentBy(String senderName) {
        try {
//          get all transactions of sender
            List<TransactionInfo> transactionList = transactionRepo.findTransactionInfoBySender_full_name(senderName);
            double TotalAmount = 0.0;

//          sum transaction amount
            for (TransactionInfo transaction : transactionList){
                TotalAmount += transaction.getAmount();
            }
            log.info("Total amount of Sender {} is {}", senderName, TotalAmount);
            return TotalAmount;

        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public double getMaxTransactionAmount() {
        try {
            double maxAmount =  transactionRepo.findHighestTrnAmount().getAmount();
            log.info("Highest transaction amount {} ", maxAmount);
            return maxAmount;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public long countUniqueClients() {
        int uniqueClient = transactionRepo.findTotalDistinctBene() + transactionRepo.findTotalSender();
        log.info("Total distinct client who send or receive transactions are {}",uniqueClient );
        return uniqueClient;
    }

    public String getTopSender() {
        String senderFullName = transactionRepo.findHighestTrnAmount().getSender_full_name();
        log.info("Sender with highest transaction amount is {}", senderFullName);
        return senderFullName;
    }

    public List<Double> getTop3Trn() {
        List<Double> top3trnList = transactionRepo.getTop3Trn();
        log.info("top 3 transactions are {}", top3trnList);
        return top3trnList;
    }

    public List<String > getAllSolveIssueMessage() {
        List<String> solvedIssueMsg = transactionRepo.solvedIssueMessages();
        log.info("Solved Issue's messages are {}", solvedIssueMsg);
        return solvedIssueMsg;
    }

    public List<Integer> getUnsolvedIssueIds() {
        List<Integer> unsolvedIssueIds = transactionRepo.getUnsolvedIssueIds();
        log.info("Unsolved Issue's Id are {}", unsolvedIssueIds);
        return unsolvedIssueIds;
    }

    public Map<String, List<TransactionInfo>> getTrnByBeneName() {
        HashMap<String, List<TransactionInfo>> hashMap = new HashMap<>();
        List<String> beneList = transactionRepo.getTrnByBene();

//        get transaction according to beneficiary
        for (String bene : beneList){
            hashMap.put(bene, transactionRepo.findTrnByBene(bene));
        }
        log.info("Trn By beneficiary {}", hashMap);
        return hashMap;
    }

    public boolean getOpenIssueOfClient(String clientFullName) {
        List<Boolean> openIssue = transactionRepo.getOpenIssuesList(clientFullName);
        boolean openIssues = openIssue.contains(false)? true: false;
        log.info("open Issue of client {} is ?  {}",clientFullName,  openIssues);
        return openIssues;

    }
}
