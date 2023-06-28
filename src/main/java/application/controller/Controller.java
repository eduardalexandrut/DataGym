package application.controller;

import entity.Utenti;

//An interface for the basic Controller that links the view to the model(DB).
public interface Controller {
    Utenti getUser();

    void setUser(final Utenti user);
}
