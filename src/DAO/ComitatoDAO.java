package DAO;

import DTO.ComitatoDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComitatoDAO
{
    DBConnection dbConnection;
    Controller currcontroller;

    private Statement statement;

    public ComitatoDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


    public List<ComitatoDTO> recuperaListacomitato() {
        List<ComitatoDTO> comitato = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.comitato";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codcomitato= resultSet.getInt("cod_comitato");
                String tipo = resultSet.getString("tipo_c");
                String nome= resultSet.getString("nome_c");


                ComitatoDTO Co = new ComitatoDTO(codcomitato, tipo, nome);
                comitato.add(Co);

            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return comitato;
    }



}


