package cn.demo.bean;

public class Account {
    private int id;
    private String usrname;
    private String pwd;

    public Account() {
        id = -1;
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
