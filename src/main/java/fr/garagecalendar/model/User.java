package fr.garagecalendar.model;

import java.util.ArrayList;

public class User {
    String login;
    String password;
    String name;
    ArrayList<Slot> slots;


    public User(String login, String password, String name, ArrayList<Slot> slots){
        setLogin(login);
        setPassword(password);
        setName(name);
        setSlots(slots);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }
}
