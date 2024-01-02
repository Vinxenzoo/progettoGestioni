package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.Statement;

public class GestioneDAO
{
    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public GestioneDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


}
