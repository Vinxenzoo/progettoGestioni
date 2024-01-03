package DAO;

import DTO.*;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmmissioneDAO
{

   //oggetto che consentira di gestire la connessione al database
    DBConnection dbConnection;
    //Oggetto controller che consente di cfar comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    //costruttore che ammette l'oggetto controller come parametro
    public AmmissioneDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }

    //inserimento di un'ammissione nella tabella ammissione del database
    public void insert(Integer cod_sed, int cod_partec)
    {
        String query = "INSERT INTO gestioniscientifiche.ammissione (cod_sessione, cod_partecipante) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setInt(1,cod_sed);
            preparedStatement.setInt(2, cod_partec);


            preparedStatement.executeUpdate();
            System.out.println("Inserimento riuscito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   //recupero lista per la GUI
    public List<AmmissioneDTO> recuperaListaAmmissione() {
        List<AmmissioneDTO> ammissione= new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.ammissione";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codSessione = resultSet.getInt("cod_sessione");
                int cod_pers = resultSet.getInt("cod_partecipante");

                SessioneDTO co = new SessioneDTO();
                co.setCodSessione(codSessione);

                PartecipanteDTO coo = new PartecipanteDTO();
                coo.setCodPartecipante(cod_pers);

                AmmissioneDTO amm = new AmmissioneDTO (co, coo);
                ammissione.add(amm);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return ammissione;
    }

    //elimina ammissione dalla tabella ammissione del database
    public boolean deleteAmmpartecipante(Integer codAmmp, Integer cod_s)
    {
        String query = "DELETE FROM gestioniscientifiche.ammissione WHERE cod_partecipante = ? AND cod_sessione = ?";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query))
        {
            preparedStatement.setInt(1, codAmmp);
            preparedStatement.setInt(2, cod_s);

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


}


