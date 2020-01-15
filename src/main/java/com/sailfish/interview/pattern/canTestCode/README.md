## 可测试代码

### 测试用例

1. 正常情况下，交易执行成功，回填用于对账(交易与钱包的交易流水)用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
2. buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
3. 交易已过期(createTimestamp 超过 14 天)，交易状态设置为 EXPIRED，返回 false。
4. 交易已经执行了(status==EXECUTED)，不再重复执行转钱逻辑，返回 true。
5. 钱包(WalletRpcService)转钱失败，交易状态设置为 FAILED，函数返回 false。
6. 交易正在执行着，不会被重复执行，函数直接返回 false。


### 步骤

#### 将RPC 抽离，使其可MOCK

> 单元测试主要是测试程序员自己编写的代码逻辑的正 确性，并非是端到端的集成测试，它不需要测试所依赖的外部系统(分布式锁、Wallet RPC 服务)的逻辑正确性。所以，如果代码中依赖了外部系统或者不可控组件，比如，需 要依赖数据库、网络通信、文件系统等，那我们就需要将被测代码与外部系统解依赖，而这 种解依赖的方法就叫作“mock”。所谓的 mock 就是用一个“假”的服务替换真正的服 务。mock 的服务完全在我们的控制之下，模拟输出我们想要的数据。


