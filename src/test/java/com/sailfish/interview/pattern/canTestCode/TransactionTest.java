package com.sailfish.interview.pattern.canTestCode;

import com.sailfish.interview.pattern.canTestCode.good.step1.MockWalletRpcServiceOne;
import com.sailfish.interview.pattern.canTestCode.good.step1.TransactionStep1;
import com.sailfish.interview.pattern.canTestCode.good.step2.TransactionLock;
import com.sailfish.interview.pattern.canTestCode.good.step2.TransactionStep2;
import com.sailfish.interview.pattern.canTestCode.good.step3.TransactionStep3;

import org.junit.Test;

import javax.transaction.InvalidTransactionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author sailfish
 * @create 2020-01-15-10:05 AM
 */
public class TransactionTest {


    /**
     * Base Test：只是为了演示可测试性（不覆盖测试用例）
     *
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecuteCanTestStep1() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        String orderId = "456";
        TransactionStep1 transaction = new TransactionStep1(null, buyerId, sellerId, productId, orderId, 8.9);
        // 使用 mock 对象来替代真正的 RPC 服务
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }


    /**
     * Base Test：只是为了演示可测试性（不覆盖测试用例）
     * 抽离分布式锁
     *
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecuteCanTestStep2() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        String orderId = "456";
        TransactionStep2 transaction = new TransactionStep2(null, buyerId, sellerId, productId, orderId, 8.9);
        // 使用 mock 对象来替代真正的 RPC 服务
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());

        // 添加锁的MOCK
        TransactionLock lock = new TransactionLock(){
            @Override
            public boolean lock(String id) {
                return true;
            }

            @Override
            public void unLock(String id) {
            }
        };
        transaction.setTransactionLock(lock);

        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }


    /**
     * Base Test：只是为了演示可测试性（不覆盖测试用例）
     * 将未决行为抽离
     *
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecuteCanTestStep3() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        String orderId = "456";
        TransactionStep3 transaction = new TransactionStep3(null, buyerId, sellerId, productId, orderId, 8.9){
            @Override
            protected boolean isExpired() {
                return true;
            }
        };
        // 使用 mock 对象来替代真正的 RPC 服务
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());

        // 添加锁的MOCK
        TransactionLock lock = new TransactionLock(){
            @Override
            public boolean lock(String id) {
                return true;
            }

            @Override
            public void unLock(String id) {
            }
        };
        transaction.setTransactionLock(lock);

        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

}
