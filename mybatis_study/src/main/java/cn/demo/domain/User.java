package cn.demo.domain;

import java.io.Serializable;
import java.util.List;

/**
 * users
 * @author 
 */
public class User implements Serializable {
    private Integer id;

    private String username;

    private String email;

    private String password;

    private String phonenum;

    private List<Order> orderList;

    private List<Role> roleList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", orderList'" + orderList + '\'' +
                ", roleList'" + roleList + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;
}