package cn.demo.domain;

import java.io.Serializable;
import java.util.List;

/**
 * roles
 * @author 
 */
public class Role implements Serializable {
    private Integer id;

    private String rolename;

    private String roledesc;

    private List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                ", userList=" + userList +
                '}';
    }

    private static final long serialVersionUID = 1L;
}