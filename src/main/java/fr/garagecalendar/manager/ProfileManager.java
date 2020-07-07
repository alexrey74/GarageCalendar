package fr.garagecalendar.manager;

import fr.garagecalendar.model.User;

public class ProfileManager {
    private static final ProfileManager instance = new ProfileManager();
    private User user;
    public static ProfileManager getInstance() {return  instance;}
    public User getUser() {return user;}
    public void setUser(User user) { this.user = user;}
}
