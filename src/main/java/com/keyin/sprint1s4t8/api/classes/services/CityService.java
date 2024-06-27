package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.models.CityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class CityService {
    private Map<Integer, CityModel> cityMap;
    public CityService() {
        this.cityMap = new HashMap<Integer, CityModel>();
    }
    public List<CityModel> list() {
        return List.copyOf(cityMap.values());
    }
    public CityModel show(int id) {
        return cityMap.get(id);
    }
    public String add(CityModel city) {
        cityMap.put(cityMap.size() + 1, city);
        return "City successfully added.";
    }
    public String edit(
        int id,
        CityModel update
    ) {
        try {
            cityMap.put(id, update);
            return "City successfully updated.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String delete(int id) {
        try {
            cityMap.remove(id);
            return "City successfully deleted.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }

    public List<CityModel> searchCityById(int id) {
        List<CityModel> idCitySearchResult = new ArrayList<>();

        for(CityModel cityModel: cityMap.values()){
            if(cityModel.getId() == id){
                idCitySearchResult.add(cityModel);
            }
        }
        return idCitySearchResult;
    }
}