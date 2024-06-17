package com.keyin.sprint1s4t8.api.classes.models;
import com.keyin.sprint1s4t8.api.classes.abstracts.Model;
public final class CityModel extends Model {
    private String name;
    private String province;
    public CityModel(
        int id,
        String name,
        String province
    ) {
        super(id);
        this.name = name;
        this.province = province;
    }
    public CityModel() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
}