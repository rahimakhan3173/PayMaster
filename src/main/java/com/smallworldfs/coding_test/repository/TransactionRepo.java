package com.smallworldfs.coding_test.repository;

import com.smallworldfs.coding_test.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionInfo, Long> {
    @Query(value = "Select * from transaction_info where sender_full_name = :senderName", nativeQuery = true)
    List<TransactionInfo> findTransactionInfoBySender_full_name(@Param("senderName") String senderName);

    @Query(value = "select top 1 * from transaction_info order by amount desc", nativeQuery = true)
    TransactionInfo findHighestTrnAmount();
    @Query(value = "select count(Distinct beneficiary_full_name) from transaction_info", nativeQuery = true)
    int findTotalDistinctBene();
    @Query(value = "select count(Distinct sender_full_name) from transaction_info", nativeQuery = true)
    int findTotalSender();

    @Query(value = "select distinct top 3 amount from transaction_info order by amount desc", nativeQuery = true)
    List<Double> getTop3Trn();

    @Query(value = "select issue_message from transaction_info where issue_solved = 1", nativeQuery = true)
    List<String> solvedIssueMessages();

    @Query(value = "select issue_id from transaction_info where issue_solved = 0", nativeQuery = true)
    List<Integer> getUnsolvedIssueIds();

    @Query(value = "select DISTINCT beneficiary_full_name from transaction_info", nativeQuery = true)
    List<String> getTrnByBene();

    @Query(value = "Select * from transaction_info where beneficiary_full_name = :bene", nativeQuery = true)
    List<TransactionInfo> findTrnByBene(@Param("bene") String bene);

    @Query(value = "select issue_solved from transaction_info where beneficiary_full_name = :clientFullName OR sender_full_name =:clientFullName", nativeQuery = true)
    List<Boolean> getOpenIssuesList(@Param("clientFullName") String clientFullName);
}
