package service.impl;

import service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {
    private String name;
    private int age;
    private Date time;

    public AccountServiceImpl(String name, int age, Date time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public AccountServiceImpl() {
        System.out.println("实现类被创建");
    }

    public void saveAccount() {
        System.out.println("saveAccount:" + name + "+" + age + "+" + time);
    }

    public void init() {
        System.out.println("初始化了");
    }

    public void destory() {
        System.out.println("销毁了");
    }
}
