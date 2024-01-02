package GUI;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import javax.swing.*;

public class inizioApplicazione
{
    DBConnection dbconnection = DBConnection.getConnessione();
     Controller currcontroller = new Controller(dbconnection);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaLogin loginPage = new PaginaLogin();
            loginPage.setVisible(true);
        });
    }
}
