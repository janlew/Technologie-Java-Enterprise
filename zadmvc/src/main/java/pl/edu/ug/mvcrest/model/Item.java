package pl.edu.ug.mvcrest.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Item {
    private String id;
    @NotEmpty(message = "Please provide a name")
    private String name;
    @NotNull(message = "Please provide a price")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double price;
    @NotNull(message = "Please provide a quantity")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer quantity;


    public Item() {
    }

    public Item(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
