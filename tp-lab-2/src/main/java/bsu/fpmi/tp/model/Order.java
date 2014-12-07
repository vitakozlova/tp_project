package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * Created by Vadim on 05.12.14.
 */
@Entity
@Table(name = TPLabContract.DB.Orders.TABLE_NAME)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.Orders.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.Orders.DEMAND_ID, nullable = false, unique = true)
    private Integer demandId;

    @Column(name = TPLabContract.DB.Orders.PRODUCT_LIST_ID, nullable = false)
    private Integer productListId;

    @Column(name = TPLabContract.DB.Orders.ORDER_SUM, nullable = false)
    private double orderSum;

    @Column(name = TPLabContract.DB.Orders.CLIENT_ADDRESS, nullable = false)
    private String clientAddress;

    @Column(name = TPLabContract.DB.Orders.CLIENT_EMAIL, nullable = false)
    private String clientEmail;

    @Column(name = TPLabContract.DB.Orders.CLIENT_NAME, nullable = false)
    private String clientName;

    @Column(name = TPLabContract.DB.Orders.CLIENT_PHONE, nullable = false)
    private String clientPhone;


    public Order(Integer demandId, Integer productListId, double orderSum, String clientAddress, String clientEmail, String clientName, String clientPhone) {
        this.demandId = demandId;
        this.productListId = productListId;
        this.orderSum = orderSum;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
    }

    public Order() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.orderSum, orderSum) != 0) return false;
        if (!clientAddress.equals(order.clientAddress)) return false;
        if (!clientEmail.equals(order.clientEmail)) return false;
        if (!clientName.equals(order.clientName)) return false;
        if (!clientPhone.equals(order.clientPhone)) return false;
        if (!demandId.equals(order.demandId)) return false;
        if (!id.equals(order.id)) return false;
        if (!productListId.equals(order.productListId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + demandId.hashCode();
        result = 31 * result + productListId.hashCode();
        temp = Double.doubleToLongBits(orderSum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + clientAddress.hashCode();
        result = 31 * result + clientEmail.hashCode();
        result = 31 * result + clientName.hashCode();
        result = 31 * result + clientPhone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", demandId=" + demandId +
                ", productListId=" + productListId +
                ", orderSum=" + orderSum +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                '}';
    }
}
