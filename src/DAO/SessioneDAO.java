package DAO;

import DTO.ConferenzaDTO;
import DTO.CoordinatoreDTO;
import DTO.SessioneDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessioneDAO
{

    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public SessioneDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


    public List<SessioneDTO> recuperaListaSessione() {
        List<SessioneDTO> sessione = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.sessione";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codSessione = resultSet.getInt("cod_sessione");
                Date data = resultSet.getDate("data_prestabilita");
                Time orario= resultSet.getTime("orario_predefinito");
                int cod_conf = resultSet.getInt("cod_conferenza");
                int cod_coo = resultSet.getInt("cod_coordinatore");


                ConferenzaDTO co = new ConferenzaDTO();
                co.setCodConferenza(cod_conf);

                CoordinatoreDTO coo = new CoordinatoreDTO();
                coo.setCodCoordinatore(cod_coo);

                SessioneDTO Se = new SessioneDTO(codSessione, data, orario, co, coo);
                sessione.add(Se);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return sessione;
    }

}


