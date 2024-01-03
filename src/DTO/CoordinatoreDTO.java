package DTO;

import sun.security.util.Password;

import java.sql.Date;

public class CoordinatoreDTO
{
    //attributi della classe coordinatore
        private int codCoordinatore;
        private String nome;
        private String cognome;
        private Date dataNascita;

        private String emailcoo;

        private Password passwordcoo;

        // Costruttore vuoto
        public CoordinatoreDTO() {
        }

        // Costruttore con parametri
        public CoordinatoreDTO(int codCoordinatore, String nome, String cognome, Date dataNascita, String email, Password pass) {
            this.codCoordinatore = codCoordinatore;
            this.nome = nome;
            this.cognome = cognome;
            this.dataNascita = dataNascita;
            this.emailcoo = email;
            this.passwordcoo = pass;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodCoordinatore() {
            return codCoordinatore;
        }

        public void setCodCoordinatore(int codCoordinatore) {
            this.codCoordinatore = codCoordinatore;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public Date getDataNascita() {
            return dataNascita;
        }

        public void setDataNascita(Date dataNascita) {
            this.dataNascita = dataNascita;
        }

        public String getEmailcoo() {
        return emailcoo;
    }

        public void setEmailcoo(String emailPartecipante) {
        this.emailcoo = emailcoo;
    }

        public Password getPasswordcoo() { return passwordcoo; }

        public void setPasswordcoo(Password password) {
        this.passwordcoo = password;
    }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return "CoordinatoreDTO{" +
                    "codCoordinatore=" + codCoordinatore +
                    ", nome='" + nome + '\'' +
                    ", cognome='" + cognome + '\'' +
                    ", dataNascita=" + dataNascita +
                    '}';
        }
}


