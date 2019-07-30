package factory;

import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * 静态工厂
 */
public class Staticfactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
