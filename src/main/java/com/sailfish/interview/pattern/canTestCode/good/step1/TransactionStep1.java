package com.sailfish.interview.pattern.canTestCode.good.step1;

import com.sailfish.interview.pattern.canTestCode.STATUS;
import com.sailfish.interview.pattern.canTestCode.WalletRpcService;
import com.sailfish.interview.pattern.canTestCode.bad.IdGenerator;
import com.sailfish.interview.pattern.canTestCode.bad.RedisDistributedLock;

import javax.transaction.InvalidTransactionException;

/**
 * @author sailfish
 * @create 2020-01-14-6:42 PM
 */
public class TransactionStep1 {

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

    // End

    public TransactionStep1(String preAssignedId, Long buyerId, Long sellerId, Long productId,
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
            isLocked = RedisDistributedLock.getSingletonInstance().lockTransaction(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回 false，job 兜底执行
            }
            if (status == STATUS.EXECUTED) {
                return true; // double check
            }
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > 14) {
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
                RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
            }
        }
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

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
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
