package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;

public class CoordinatoreDAO
{

    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public CoordinatoreDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }


    public boolean verificaPresenzaCoordinatore(String nome, String cognome, String email, String password) {
        try {
            // Preparare la query SQL
            String query = "SELECT count(*) FROM gestioniscientifiche.coordinatore WHERE nome = ? AND cognome = ? AND email = ? AND password = ?";
            try ( PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
            {
                // Impostare i parametri nella query
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);

                // Eseguire la query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in base alle tue esigenze
        }
        return false;
    }


}

