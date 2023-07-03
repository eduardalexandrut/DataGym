package application.controller;

import entity.Utenti;

public class MainController extends Controller {
    private Utenti user;
    public Utenti getUser() {
        return this.user;
    }
    public void setUser(final Utenti user) {
        this.user = user;
    }
}
