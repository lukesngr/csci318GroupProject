package csci318.parta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    String productCategory, name;
    double price;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "details_id")
    @JsonIgnore
    // Hide the address field in a library.
    // This prevents an infinite nesting references of library and address.
    private ProductDetail detail;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductDetail getDetail() {
        return detail;
    }

    public void setDetail(ProductDetail detail) {
        this.detail = detail;
    }
};