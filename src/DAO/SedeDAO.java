package DAO;

import DTO.SedeDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SedeDAO {
    DBConnection dbConnection;

    //Oggetto controller che consente di far comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    public SedeDAO(Controller controller) {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }

    //Permette di poter estrarre le sedi dal database
    public SedeDAO leggiSede(int codSede, SedeDTO se)
    {
        try {
            String query = "SELECT * FROM gestioniscientifiche.sede WHERE cod_sede = ?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1, codSede);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int codSedeResult = resultSet.getInt("cod_sede");
                String via = resultSet.getString("via");
                int numCivico = resultSet.getInt("num_civico");
                String luogo = resultSet.getString("luogo");
                String nome_s = resultSet.getString("nome_s");

                // Crea e restituisci un'istanza di SedeDAO con i dati recuperati dal database
                 se = new SedeDTO (codSedeResult, via, numCivico, luogo, nome_s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Se non hai trovato alcuna corrispondenza, restituisci null o gestisci come preferisci
        return null;
    }

    //consente di recuperare una lista di sedi che poi verranno mostrate nella GUI
    public List<SedeDTO> recuperaListaSede() {
        List<SedeDTO> sede = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.sede";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codSede = resultSet.getInt("cod_sede");
                String via = resultSet.getString("via");
                int num_civico = resultSet.getInt("num_civico");
                String luogo = resultSet.getString("luogo");
                String nome_s = resultSet.getString("nome_s");

                SedeDTO se = new SedeDTO(codSede, via, num_civico, luogo, nome_s);
                sede.add(se);
            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return sede;

    }

}


