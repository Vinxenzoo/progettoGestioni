package DAO;

import DTO.SedeDTO;
import DTO.ConferenzaDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.sql.Date;
import java.util.*;


public class ConferenzaDAO
{
    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public ConferenzaDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }


    public List<ConferenzaDTO> recuperaListaConferenze() {
        List<ConferenzaDTO> Conferenza = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.conferenza";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codConferenza = resultSet.getInt("cod_conferenza");
                String sponsor = resultSet.getString("sponsor");
                String descrizione = resultSet.getString("descrizione");
                String ente = resultSet.getString("ente");
                int spesa = resultSet.getInt("spesa");
                Date data_i = resultSet.getDate("data_i");
                java.sql.Date data_f = resultSet.getDate("data_f");
                int cod_s = resultSet.getInt("cod_sede");


                SedeDTO sed = new SedeDTO();
                sed.setCodSede(cod_s);

                    ConferenzaDTO conf = new ConferenzaDTO(codConferenza, sponsor, descrizione, ente, spesa, data_i, data_f, sed);
                    Conferenza.add(conf);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return Conferenza;
    }



}


