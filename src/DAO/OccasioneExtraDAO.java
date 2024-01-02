package DAO;

import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OccasioneExtraDAO
{
    DBConnection dbConnection;
    Controller currcontroller;
    private Statement statement;

    public OccasioneExtraDAO(Controller controller)
    {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();


    }


    public void ins(Integer cod_ses, String descrizione, String tipo)
    {
        try {

            if ("evento".equals(tipo) || "Evento".equals(tipo) || "Evento Specifico".equals(tipo) || "Evento specifico".equals(tipo)
                    ||"evento Specifico".equals(tipo) || "evento specifico".equals(tipo) || "EventoSpecifico".equals(tipo) || "Eventospecifico".equals(tipo) ||
                  "eventoSpecifico".equals(tipo) || "eventospecifico".equals(tipo))
            {

                String query = "INSERT INTO gestioniscientifiche.occasione_extra ( tipo_evento_s, tipo_spazio_i, cod_sessione, descrizione) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
                    preparedStatement.setString(1, tipo);
                    preparedStatement.setString(2, "");
                    preparedStatement.setInt(3, cod_ses);
                    preparedStatement.setString(4, descrizione);


                    preparedStatement.executeUpdate();
                    System.out.println("Inserimento riuscito");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                if ("Spazio intervello".equals(tipo) || "spazio intervello".equals(tipo) || "spazio Intervello".equals(tipo)|| "Spazio Intervello".equals(tipo)
                        || "SpazioIntervello".equals(tipo) || "spazioIntervello".equals(tipo) ||"Spaziointervello".equals(tipo) || "spaziointervello".equals(tipo))
                {

                    String query = "INSERT INTO gestioniscientifiche.occasione_extra ( tipo_evento_s, tipo_spazio_i, cod_sessione, descrizione) VALUES (?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
                        preparedStatement.setString(1, "");
                        preparedStatement.setString(2, tipo);
                        preparedStatement.setInt(3, cod_ses);
                        preparedStatement.setString(4, descrizione);


                        preparedStatement.executeUpdate();
                        System.out.println("Inserimento riuscito");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("valore inserito in tipo non valido, riprova");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Non hai inserito nessun valore");
        }
    }

}
