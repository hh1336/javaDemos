package service.impl;

import service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private int age;
    private Date time;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public AccountServiceImpl2() {
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
