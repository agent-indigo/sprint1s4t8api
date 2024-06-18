package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class PassengerService {
    private Map<Integer, PassengerModel> passengerMap;
    public PassengerService() {
        this.passengerMap = new HashMap<Integer, PassengerModel>();
    }
    public List<PassengerModel> list() {
        return List.copyOf(passengerMap.values());
    }
    public PassengerModel show(int id) {
        return passengerMap.get(id);
    }
    public String add(PassengerModel passenger) {
        passengerMap.put(passengerMap.size() + 1, passenger);
        return "Passenger successfully added.";
    }
    public String edit(
        int id,
        PassengerModel update
    ) {
        try {
            passengerMap.put(id, update);
            return "Passenger successfully updated.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String delete(int id) {
        try {
            passengerMap.remove(id);
            return "Passenger successfully deleted.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}