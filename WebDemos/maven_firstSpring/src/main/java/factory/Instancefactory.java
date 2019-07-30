package factory;

import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * 这是一个工厂类
 */
public class Instancefactory {

    /**
     * 返回一个接口对象实现
     * @return
     */
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
