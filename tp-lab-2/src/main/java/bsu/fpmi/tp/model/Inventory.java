package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * Created by Vadim on 05.12.14.
 */
@Entity
@Table(name = TPLabContract.DB.Inventory.TABLE_NAME)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.Inventory.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.Inventory.PRODUCT_COUNT, nullable = false)
    private int productCount;

    public Inventory(int productCount) {
        this.productCount = productCount;
    }

    public Inventory() {
    }

    public Integer getId() {
        return id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (productCount != inventory.productCount) return false;
        if (!id.equals(inventory.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + productCount;
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productCount=" + productCount +
                '}';
    }
}

