package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.Statement;

    public class TenutaDAO
{
    //oggetto su cui verrà passata la connessione
    DBConnection dbConnection;
    //Oggetto controller che consente di far comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    //Costruttore che ammette un oggetto controller
    public TenutaDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


}
