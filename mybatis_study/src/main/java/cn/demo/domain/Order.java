package cn.demo.domain;

import java.io.Serializable;
/**
 * orders
 * @author 
 */
public class Order implements Serializable {
    private Integer id;

    private String addTime;

    private String detail;

    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", addTime='" + addTime + '\'' +
                ", detail='" + detail + '\'' +
                ", user=" + user +
                '}';
    }

    private static final long serialVersionUID = 1L;
}