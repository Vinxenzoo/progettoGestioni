package GUI;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import javax.swing.*;

public class inizioApplicazione
{
    static DBConnection dbconnection = DBConnection.getConnessione();
    static Controller currcontroller = new Controller(dbconnection);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaLogin loginPage = new PaginaLogin(currcontroller);
            loginPage.setVisible(true);
        });
    }
}
