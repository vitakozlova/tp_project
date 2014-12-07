package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * Created by Vadim on 05.12.14.
 */
@Entity
@Table(name = TPLabContract.DB.Catalog.TABLE_NAME)
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.Catalog.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.Catalog.PRODUCT_COST, nullable = false)
    private double productCost;

    @Column(name = TPLabContract.DB.Catalog.PRODUCT_DESCRIPTION, nullable = false)
    private String productDesc;

    public Catalog() {
    }

    public Catalog(String productDesc, double productCost) {
        this.productDesc = productDesc;
        this.productCost = productCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Catalog(double productCost, String productDesc) {
        this.productCost = productCost;
        this.productDesc = productDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (Double.compare(catalog.productCost, productCost) != 0) return false;
        if (!id.equals(catalog.id)) return false;
        if (!productDesc.equals(catalog.productDesc)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        temp = Double.doubleToLongBits(productCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + productDesc.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", productCost=" + productCost +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
