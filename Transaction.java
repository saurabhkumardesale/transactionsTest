package com.ncr.olbm.Transactions;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table
public class Transaction {
    @Id
    private String txnId;
    private String fromAcc;
    private String toAcc;
    private Double amount;
    private Timestamp time;
    private String label;
    private String status;


    public Transaction() {

    }

    public Transaction(String txnId, String fromAcc, String toAcc, Double amount, String label, String status) {
        this.txnId = txnId;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.time = Timestamp.from(Instant.now());
        this.label = label;
        this.status = status;
    }

    public Transaction(String txnId, String fromAcc, String toAcc, Double amount, Timestamp time, String label, String status) {
        this.txnId = String.valueOf(UUID.randomUUID());
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.time = Timestamp.from(Instant.now());
        this.label = label;
        this.status = status;
    }



    public String getTxnId() {
        return txnId;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public String getToAcc() {
        return toAcc;
    }

    public Double getAmount() {
        return amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txnId='" + txnId + '\'' +
                ", fromAcc='" + fromAcc + '\'' +
                ", toAcc='" + toAcc + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                ", label='" + label + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

