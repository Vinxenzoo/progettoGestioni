package DAO;

import DTO.*;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO
{
    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public FeedbackDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }


    public void insertinfeed(Integer cod_interv, String feed, Integer codice_part)
    {
        String query = "INSERT INTO gestioniscientifiche.feedback (feedback, cod_partecipante, cod_intervento ) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setString(1, feed);
            preparedStatement.setInt(2, codice_part);
            preparedStatement.setInt(3, cod_interv);

            preparedStatement.executeUpdate();
            System.out.println("Inserimento riuscito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<FeedbackDTO> recuperaListaCfeedback() {
        List<FeedbackDTO> feedback = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.feedback";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codfeed = resultSet.getInt("cod_feedback");
                String feed = resultSet.getString("feedback");
                int cod_pa = resultSet.getInt("cod_partecipante");
                int cod_inte = resultSet.getInt("cod_intervento");


                 PartecipanteDTO co = new PartecipanteDTO();
                co.setCodPartecipante(cod_pa);

                InterventoDTO coo = new InterventoDTO();
                coo.setCodIntervento(cod_inte);

                FeedbackDTO Se = new FeedbackDTO(codfeed, feed, co, coo);
                feedback.add(Se);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return feedback;
    }


}
