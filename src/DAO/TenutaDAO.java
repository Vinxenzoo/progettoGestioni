package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.Statement;

    public class TenutaDAO
{
    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public TenutaDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


}
