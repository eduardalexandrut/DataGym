package application.controller;

import entity.Utenti;

import java.util.Optional;

public class RecipesController extends Controller {
    private Optional<Utenti> user = Optional.empty();

    public Optional<Utenti> getUser() {
        return user;
    }

    public void setUser(Optional<Utenti> user) {
        this.user = user;
    }
}
