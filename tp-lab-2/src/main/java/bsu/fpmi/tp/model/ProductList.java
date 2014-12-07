package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * Created by Vadim on 05.12.14.
 */
@Entity
@Table(name = TPLabContract.DB.ProductList.TABLE_NAME)
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.ProductList.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.ProductList.PRODUCT_COUNT, nullable = false)
    private int productCount;

    @Column(name = TPLabContract.DB.ProductList.PRODUCT_FIX_COST, nullable =false)
    private double productFixCost;

    @Column(name = TPLabContract.DB.ProductList.PRODUCT_ID, nullable =false)
    private Integer productId;

    public ProductList(int productCount, double productFixCost, Integer productId) {
        this.productCount = productCount;
        this.productFixCost = productFixCost;
        this.productId = productId;
    }

    public ProductList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getProductFixCost() {
        return productFixCost;
    }

    public void setProductFixCost(int productFixCost) {
        this.productFixCost = productFixCost;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        if (productCount != that.productCount) return false;
        if (Double.compare(that.productFixCost, productFixCost) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!productId.equals(that.productId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + productCount;
        temp = Double.doubleToLongBits(productFixCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + productId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "id=" + id +
                ", productCount=" + productCount +
                ", productFixCost=" + productFixCost +
                ", productId=" + productId +
                '}';
    }
}
