package com.keyin.sprint1s4t8.api.classes.abstracts;
import com.keyin.sprint1s4t8.api.interfaces.Serve;
public abstract class RouteService implements Serve {
    protected String e404msg;
    protected String s200msg;
    protected String s201msg;
    protected String s204msg;
    public RouteService(String model) {
        this.e404msg = "Error 404: " + model + " not found.";
        this.s200msg = "200: " + model + " successfully updated.";
        this.s201msg = "201: " + model + " successfully added.";
        this.s204msg = "204: " + model + " successfully deleted.";
    }
    @Override
    public abstract String delete(int id);
}