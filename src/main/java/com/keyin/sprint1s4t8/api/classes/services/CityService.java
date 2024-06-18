package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.models.CityModel;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class CityService {
    private Map<Integer, CityModel> cityMap;
    private String cityNotFoundMessage;
    public CityService() {
        this.cityMap = new HashMap<Integer, CityModel>();
        this.cityNotFoundMessage = "Error: city not found.";
    }
    public List<CityModel> list() {
        return List.copyOf(cityMap.values());
    }
    public CityModel show(int index) {
        return cityMap.get(index);
    }
    public String add(CityModel city) {
        cityMap.put(cityMap.size() + 1, city);
        return "City successfully added.";
    }
    public String edit(int index, CityModel update) {
        try {
            cityMap.put(index, update);
            return "City successfully updated.";
        } catch (RuntimeException runtimeException) {
            return cityNotFoundMessage;
        }
    }
    public String delete(int index) {
        try {
            cityMap.remove(index);
            return "City successfully deleted.";
        } catch (RuntimeException runtimeException) {
            return cityNotFoundMessage;
        }
    }
}