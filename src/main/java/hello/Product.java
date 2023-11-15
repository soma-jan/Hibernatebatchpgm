package hello;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @TableGenerator(name = "PRODUCT_SEQ")
    // As we are doing batch insert, using TableGenerator,
    // unique key is determined
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "PRODUCT_SEQ")
    // data members of product
    private Long id;

    private String productName;
    private String productBrand;
    private int price;
    // Getter and setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductBrand() { return productBrand; }

    public void setProductBrand(String productBrand)
    {
        this.productBrand = productBrand;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
    // This is essentially required to avoid exceptions
    public Product() {}
}
