package com.sailfish.interview.pattern.canTestCode.good.step1;

import com.sailfish.interview.pattern.canTestCode.WalletRpcService;

/**
 *
 *
 * @author sailfish
 * @create 2020-01-14-6:46 PM
 */
public class MockWalletRpcServiceOne extends WalletRpcService {


    public String moveMoney(String id, Long buyerId, Long sellerId) {
        return "123bac";
    }

}
