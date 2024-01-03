package DAO;

import DTO.*;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InterventoDAO
{

    //oggetto che conterrà la connessione al database
    DBConnection dbConnection;
    //Oggetto controller che consente di far comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    public InterventoDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }

     //recupera una lista di interventi dalla tabella intervetno del database
    public List<InterventoDTO> recuperaListaintervento() {
        List<InterventoDTO> intervento = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.intervento";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codintervento = resultSet.getInt("cod_intervento");
                String ab = resultSet.getString("abstract");
                int cod_sess = resultSet.getInt("cod_sessione");
                int cod_partec = resultSet.getInt("cod_partecipante");


               SessioneDTO se = new SessioneDTO();
                se.setCodSessione(cod_sess);

                PartecipanteDTO pa = new PartecipanteDTO();
                pa.setCodPartecipante(cod_partec);

                InterventoDTO in = new InterventoDTO(codintervento, ab, se, pa);
               intervento.add(in);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return intervento;
    }

    //Consente di eliminare dalla tabella intervento un intervento fatto da un partecipante
    public boolean deleteIntervento(Integer codIntervento)
    {
        String query = "DELETE FROM gestioniscientifiche.intervento WHERE cod_intervento = ?";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setInt(1, codIntervento);

            int rowsAffected = preparedStatement.executeUpdate();

            // Restituisce true se almeno una riga è stata eliminata, altrimenti false
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Gestisci l'eccezione in modo appropriato
        }

        // Restituisce false in caso di errori
        return false;
    }

    //consente di inserire un intervento nella tabella intervento
    public void insinterv(Integer cod_sess, String abs, Integer codice_part)
    {
        String query = "INSERT INTO gestioniscientifiche.intervento (abstract, cod_sessione, cod_partecipante ) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setString(1, abs);
            preparedStatement.setInt(2, cod_sess);
            preparedStatement.setInt(3, codice_part);

            preparedStatement.executeUpdate();
            System.out.println("Inserimento riuscito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}









