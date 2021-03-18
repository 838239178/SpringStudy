package cn.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private int id;
    private String usrname;
    private String pwd;
    private int money;

    public Account() {
        id = money = -1;
        usrname = pwd = "";
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", usrname='" + usrname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    //region getter/setter

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    //endregion
}
