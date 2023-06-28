package application.controller;

import application.model.QueryManager;
import entity.Utenti;

//An interface for the basic Controller that links the view to the model(DB).
public abstract class Controller {
   private final QueryManager queryManager = new QueryManager();
   public QueryManager getQueryManager() {
       return this.queryManager;
   }
}
