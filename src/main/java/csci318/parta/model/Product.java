package csci318.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public
@Entity
class Product {

    @Id
    @GeneratedValue
    private long id;
    private String productCatogry;
    private String name;
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCatogry() {
        return productCatogry;
    }

    public void setProductCatogry(String productCatogry) {
        this.productCatogry = productCatogry;
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
}

class ProductDetail {

    private String description;
    private String comment;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
