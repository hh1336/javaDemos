package ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

public class client {
    public static void main(String[] args) {
//        获取容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        根据bean的id得到对应创建的实例
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        ac.close();
    }
}
