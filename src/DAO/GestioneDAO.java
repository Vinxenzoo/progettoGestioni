package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.Statement;

public class GestioneDAO
{
    //oggetto che conterrà la connessione al database
    DBConnection dbConnection;

    //Oggetto controller che consente di cfar comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    public GestioneDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


}
