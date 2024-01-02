package UTILITIES;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/Gestioniscientifiche";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "nunzia09";

    /*I tipi Connection e Statement fanno parte della libreria java.SQL*/

    private Connection connection;
    private Statement statement;
    private static DBConnection istanza;

    /*Impostiamo il costruttore come private per assicurarci che ci sia una sola istanza per quanto riguarda
    la connesione al database (Singleton Pattern)*/

    public DBConnection()
    {

        statement = null;

        /*Utilizziamo try per garantire che la connessione al database sia stata eseguita correttamente e in caso
        di errore viene stampato il messaggio del fallimento dell'operazione*/

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch(SQLException e) {

            System.out.println("Connessione al Database fallita");
            e.printStackTrace();
        }

        /*Dopo aver stabilito la connesione con il DB possiamo definire la variabile statement che è quella che
        ci permette di inviare le query al database*/

        try {

            statement = connection.createStatement();

        } catch(SQLException e) {

            System.out.println("Errore nella creazione dello statement");
        }
    }

    public static DBConnection getConnessione() {

        if(istanza == null) {
            istanza = new DBConnection();

            System.out.println("Connessione al database andata bene!");

        }

        return istanza;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {

        return statement;

    }

    /*Metodo che ci permette di creare prima una connessione con il database e poi eseguire
     * una query passata come paramentro*/
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);

    }

    //Metodo che permette la chiusura della connessione con il database
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

