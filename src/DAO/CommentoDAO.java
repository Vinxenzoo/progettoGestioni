package DAO;


import DTO.*;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentoDAO
{
        DBConnection dbConnection;
        Controller currcontroller;
        private Statement statement;

        public CommentoDAO(Controller controller)
        {
            currcontroller = controller;
            dbConnection = DBConnection.getConnessione();


        }

    public void insert(Integer cod_feedback, String comm, Integer codice_part)
    {
        String query = "INSERT INTO gestioniscientifiche.commento (commento, cod_partecipante, cod_feedback ) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setString(1, comm);
            preparedStatement.setInt(2, codice_part);
            preparedStatement.setInt(3, cod_feedback);

            preparedStatement.executeUpdate();
            System.out.println("Inserimento riuscito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<CommentoDTO> recuperaListaCommento()
    {
        List<CommentoDTO> commento = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.commento";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codcommento = resultSet.getInt("cod_commento");
                String comm = resultSet.getString("commento");
                int cod_part = resultSet.getInt("cod_partecipante");
                int cod_feed = resultSet.getInt("cod_feedback");


                PartecipanteDTO co = new PartecipanteDTO();
                co.setCodPartecipante(cod_part);

                FeedbackDTO coo = new FeedbackDTO();
                coo.setCodFeedback(cod_feed);

                CommentoDTO Se = new CommentoDTO(codcommento,comm,  co, coo);
                commento.add(Se);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return commento;
    }

}


