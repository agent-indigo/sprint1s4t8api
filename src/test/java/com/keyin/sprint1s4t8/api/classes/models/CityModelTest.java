package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.keyin.sprint1s4t8.api.enums.ProvTerrCode;
public final class CityModelTest {
    private CityModel city;
    public CityModelTest() {
        this.city = new CityModel();
    }
    @Test
    public void testCreate() {
        city.setId(1);
        city.setName("Montreal");
        city.setProvince(ProvTerrCode.QC);
        Assertions.assertEquals(1, city.getId());
        Assertions.assertEquals("Montreal", city.getName());
        Assertions.assertEquals(ProvTerrCode.QC, city.getProvince());
    }
}