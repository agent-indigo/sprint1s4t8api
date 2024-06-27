package com.keyin.sprint1s4t8.api.classes.models;
import com.keyin.sprint1s4t8.api.classes.abstracts.Model;
import com.keyin.sprint1s4t8.api.enums.ProvTerrCode;

import java.util.ArrayList;
import java.util.List;

public final class CityModel extends Model {
    private String name;
    private ProvTerrCode provTerrCode;

    List<AirportModel> airportModelList = new ArrayList<>();

    public CityModel(
        int id,
        String name,
        ProvTerrCode provTerrCode

    ) {
        super(id);
        this.name = name;
        this.provTerrCode = provTerrCode;
        airportModelList = new ArrayList<>();
    }
    public CityModel() {
        super();
        airportModelList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ProvTerrCode getProvince() {
        return provTerrCode;
    }
    public void setProvince(ProvTerrCode provTerrCode) {
        this.provTerrCode = provTerrCode;
    }

    public ProvTerrCode getProvTerrCode() {
        return provTerrCode;
    }

    public void setProvTerrCode(ProvTerrCode provTerrCode) {
        this.provTerrCode = provTerrCode;
    }

    public List<AirportModel> getAirportModelList() {
        return airportModelList;
    }

    public void setAirportModelList(List<AirportModel> airportModelList) {
        this.airportModelList = airportModelList;
    }
    public void addAirportToCitys(AirportModel airportModel){
        airportModelList.add(airportModel);
    }


}