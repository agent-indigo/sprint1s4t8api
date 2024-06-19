// CityModelTest
package com.keyin.sprint1s4t8.api.classes.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.keyin.sprint1s4t8.api.enums.ProvTerrCode;

public class CityModelTest {
    @Test
    public void testCityCreate() {
        CityModel cityModel = new CityModel(1, "Montreal", ProvTerrCode.QC);

        Assertions.assertEquals(1, cityModel.getId());
        Assertions.assertEquals("Montreal", cityModel.getName());
        Assertions.assertEquals(ProvTerrCode.QC, cityModel.getProvince());
    }

    @Test
    public void testCityEdit() {
        CityModel cityModel = new CityModel(1, "Montreal", ProvTerrCode.QC);

        cityModel.setName("Toronto");
        cityModel.setProvince(ProvTerrCode.ON);

        Assertions.assertEquals("Toronto", cityModel.getName());
        Assertions.assertEquals(ProvTerrCode.ON, cityModel.getProvince());
    }
}
