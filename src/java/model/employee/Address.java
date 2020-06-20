/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee;

/**
 *
 * @author hieule
 */
public class Address {
    private int id;
    private String road;
    private String town;
    private String city;
    private String district;

    public Address(int id, String road, String town, String city, String district) {
        this.id = id;
        this.road = road;
        this.town = town;
        this.city = city;
        this.district = district;
    }
    
    public Address(String road, String town, String city, String district) {
        this.id = -1;
        this.road = road;
        this.town = town;
        this.city = city;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    @Override
    public String toString() {
        return String.format("street %s,town %s,city %s", road, town, city);
    }
}
