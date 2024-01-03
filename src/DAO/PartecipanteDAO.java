package DAO;

import DTO.PartecipanteDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    //recupero una lista di partecipanti
    public List<PartecipanteDTO> recuperaListaPartecipanti() {
        List<PartecipanteDTO> partec = new ArrayList<>();

        try {
            String query = "SELECT * FROM gestioniscientifiche.partecipante";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codpart = resultSet.getInt("cod_partecipante");
                String nome = resultSet.getString("nome");
                int num_civico = resultSet.getInt("num_civico");
                String cognome = resultSet.getString("cognome");
                String email = resultSet.getString("email");
                String titolo = resultSet.getString("titolo");
                String istruzione = resultSet.getString("istituzione");
                String partec_s = resultSet.getString("partecipante_s");
                String key = resultSet.getString("keynote_speaker");
                String pass = resultSet.getString("password");

                PartecipanteDTO pa = new PartecipanteDTO(codpart, nome, num_civico, cognome, email, titolo, istruzione, partec_s, key, pass);
                partec.add(pa);
            }
        } catch (SQLException e) {
            System.out.println("Errore durante il recupero delle sedi dal DB");
            e.printStackTrace();
        }
        return partec;

    }

    public void keyorspec(Integer cod_p, String rule)
    {
        try {

            if (rule == "Keynote Speaker")
            {

                String query = "update gestioniscientifiche.partecipante\n" +
                                "set keynote_speaker = 'Si'\n" +
                                "where cod_partecipante = ?";

                try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
                    preparedStatement.setInt(1, cod_p);


                    preparedStatement.executeUpdate();
                    System.out.println("Inserimento riuscito");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else
            {
                if (rule == "Partecipante Specifico")
                {

                    String query = "update gestioniscientifiche.partecipante\n" +
                            "set partecipante_s = 'Si'\n" +
                            "where cod_partecipante = ?";

                    try (PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query)) {
                        preparedStatement.setInt(1, cod_p);


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




