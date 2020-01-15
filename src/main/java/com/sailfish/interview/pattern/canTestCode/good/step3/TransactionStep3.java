package com.sailfish.interview.pattern.canTestCode.good.step3;

import com.sailfish.interview.pattern.canTestCode.STATUS;
import com.sailfish.interview.pattern.canTestCode.WalletRpcService;
import com.sailfish.interview.pattern.canTestCode.bad.IdGenerator;
import com.sailfish.interview.pattern.canTestCode.good.step2.TransactionLock;

import javax.transaction.InvalidTransactionException;

/**
 * @author sailfish
 * @create 2020-01-14-6:42 PM
 */
public class TransactionStep3 {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;


    // 依赖注入是实现代码可测试性的最有效的手段。我们可以应用 依赖注入，将 WalletRpcService 对象的创建反转给上层逻辑，在外部创建好之后，再注入 到 Transaction 类中
    // Begin
    private WalletRpcService walletRpcService;

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    //    step2
    private TransactionLock transactionLock;

    public void setTransactionLock(TransactionLock transactionLock) {
        this.transactionLock = transactionLock;
    }
// End

    public TransactionStep3(String preAssignedId, Long buyerId, Long sellerId, Long productId,
                            String orderId, Double amount) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis(); // ?
        this.amount = amount;
    }


    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null) || (sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException("...");
        }
        if (status == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {
//            删除获取分布式锁
//            isLocked = RedisDistributedLock.getSingletonInstance().lockTransaction(id);
            isLocked = transactionLock.lock(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回 false，job 兜底执行
            }
            if (status == STATUS.EXECUTED) {
                return true; // double check
            }

//            将不确定的（未决行为）：例如时间，随机数等进行封装
//            long executionInvokedTimestamp = System.currentTimeMillis();
//            if (executionInvokedTimestamp - createTimestamp > 14) {
//                this.status = STATUS.EXPIRED;
//                return false;
//            }

            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }

//            删除在内部手动创建
//            WalletRpcService walletRpcService = new WalletRpcService();

            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                //            删除释放分布式锁
//                RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
                transactionLock.unLock(id);
            }
        }
    }


    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        if (executionInvokedTimestamp - createTimestamp > 14L * 24 * 3600 * 1000) {
            return true;
        }
        return false;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

}
