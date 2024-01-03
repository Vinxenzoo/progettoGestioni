package DAO;

import DTO.PartecipanteDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PartecipanteDAO {
    DBConnection dbConnection;

    //Oggetto controller che consente di far comunicare la classe DAO con la classe Controller
    Controller currcontroller;
    private Statement statement;

    //Costruttore che riceve l'oggetto controller
    public PartecipanteDAO(Controller controller) {
        currcontroller = controller;
        dbConnection = DBConnection.getConnessione();

    }

    //verifica la presenza del nome e cognome del partecipante all'interno del database
    public boolean verificaPresenza(String nome, String cognome) {
        String query = "SELECT COUNT(*) FROM gestioniscientifiche.partecipante WHERE nome = ? AND cognome = ?";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }
        return false;
    }

    //consente di inserire all'interno della tabella partecipante
    public void insertPartecipante(PartecipanteDTO partec) {
        String query = "INSERT INTO gestioniscientifiche.partecipante (nome, num_civico, cognome, email, titolo, istituzione, partecipante_s, keynote_speaker, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, partec.getNome());
            preparedStatement.setInt(2, partec.getNumCivico());
            preparedStatement.setString(3, partec.getCognome());
            preparedStatement.setString(4, partec.getEmail());
            preparedStatement.setString(5, partec.getTitolo());
            preparedStatement.setString(6, partec.getIstituzione());
            preparedStatement.setString(7, partec.getPartecipante_s());
            preparedStatement.setString(8, partec.getKeynoteSpeaker());
            preparedStatement.setString(9, partec.getPassword());

            preparedStatement.executeUpdate();
            System.out.println("Inserimento riuscito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Integer cod_part;

    //verifica se presenti le credenziali di accesso di un partecipante
    public boolean verificacredenzialipartec(String email, String pass) {
        String query = "SELECT * FROM gestioniscientifiche.partecipante WHERE email = ? AND password = ?";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }
        return false;
    }


    Integer codice_part;
    AmmissioneDAO am = new AmmissioneDAO(currcontroller);

    public void verificaAmminp(String email, Integer cod_sess) {
        System.out.println("valore codice part: " + email);
        String query = "SELECT cod_partecipante FROM gestioniscientifiche.partecipante WHERE email = ? ";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    codice_part = resultSet.getInt("cod_partecipante");
                    am.insert(cod_sess, codice_part);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }
    }


    public boolean presenzaChiave(PartecipanteDTO par, String no, String co) {
        String query = "SELECT cod_partecipante, nome, cognome  FROM gestioniscientifiche.partecipante WHERE cod_partecipante = ?";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setInt(1, par.getCodPartecipante());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    no = resultSet.getString("nome");
                    co = resultSet.getString("cognome");

                    PartecipanteDTO partec = new PartecipanteDTO(no, co);

                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }
        return false;
    }

    FeedbackDAO fe = new FeedbackDAO(currcontroller);

    public void lasciaf(Integer cod_interv, String feed, String email) {
        System.out.println("valore codice part: " + email);
        String query = "SELECT cod_partecipante FROM gestioniscientifiche.partecipante WHERE email = ? ";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    codice_part = resultSet.getInt("cod_partecipante");
                    System.out.println(" codice partecipante: " + codice_part);
                    fe.insertinfeed(cod_interv, feed, codice_part);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }

    }

    InterventoDAO in = new InterventoDAO(currcontroller);

    public void   vainterv(Integer cod_sess, String abs, String email) {
        System.out.println("valore codice part: " + email);
        String query = "SELECT cod_partecipante FROM gestioniscientifiche.partecipante WHERE email = ? ";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    codice_part = resultSet.getInt("cod_partecipante");
                    System.out.println(" codice partecipante: " + codice_part);
                    in.insinterv(cod_sess, abs, codice_part);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


CommentoDAO comm = new CommentoDAO(currcontroller);

    public void  lasciacomm( Integer cod_feed, String commento, String email) {
        System.out.println("valore codice part: " + email);
        String query = "SELECT cod_partecipante FROM gestioniscientifiche.partecipante WHERE email = ? ";
        try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    codice_part = resultSet.getInt("cod_partecipante");
                    System.out.println(" codice partecipante: " + codice_part);
                    comm.insert(cod_feed, commento, codice_part);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestisci l'eccezione in modo appropriato
        }

    }

}




