/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hieule
 */
public class Item {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private String imagePath;
    private String description;

    public Item(String name, float price, int quantity, String image_path, String description) {
        this.id = -1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = image_path;
        this.description = description;
    }
    
    public Item(int id, String name, float price, int quantity, String image_path, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = image_path;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image_path=" + imagePath + ", description=" + description + '}';
    }
    
    
}
