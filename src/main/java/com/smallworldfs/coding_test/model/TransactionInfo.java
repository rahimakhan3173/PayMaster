package com.smallworldfs.coding_test.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Transaction_info")
public class TransactionInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    private int mtn;
    private double amount;
    private int beneficiary_age;
    private String beneficiary_full_name;

    @Column(nullable = true)
    private Integer issue_id;
    @Column(nullable = true)
    private Boolean issue_solved;
    @Column(nullable = true)
    private String issue_message;
    private String sender_full_name;
    private int sender_age;
}
