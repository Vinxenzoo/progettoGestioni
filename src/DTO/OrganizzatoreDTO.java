package DTO;

import sun.security.util.Password;

public class OrganizzatoreDTO
{
        private int codOrganizzatore;
        private String nome;
        private int numCivico;
        private String cognome;
        private String email;
        private String titolo;
        private String istituzione;
        private ComitatoDTO comitato_es;

        private Password passwordorg;

        // Costruttore vuoto
        public OrganizzatoreDTO() {
        }

        // Costruttore con parametri
        public OrganizzatoreDTO(int codOrganizzatore, String nome, int numCivico, String cognome, String email, String titolo, String istituzione, ComitatoDTO comitato, Password pa)
        {
            this.codOrganizzatore = codOrganizzatore;
            this.nome = nome;
            this.numCivico = numCivico;
            this.cognome = cognome;
            this.email = email;
            this.titolo = titolo;
            this.istituzione = istituzione;
            this.passwordorg = pa;
            this.comitato_es = comitato;

        }

        // Metodi getter e setter per ogni attributo
        public int getCodOrganizzatore() {
            return codOrganizzatore;
        }

        public void setCodOrganizzatore(int codOrganizzatore) {
            this.codOrganizzatore = codOrganizzatore;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getNumCivico() {
            return numCivico;
        }

        public void setNumCivico(int numCivico) {
            this.numCivico = numCivico;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTitolo() {
            return titolo;
        }

        public void setTitolo(String titolo) {
            this.titolo = titolo;
        }

        public String getIstituzione() {
            return istituzione;
        }

        public void setIstituzione(String istituzione) {
            this.istituzione = istituzione;
        }

        public ComitatoDTO getComitato() {
            return comitato_es;
        }

        public void setComitato(ComitatoDTO comitato) {
            this.comitato_es = comitato;
        }

        public Password getPasswordorg() { return passwordorg; }

        public void setPasswororg(Password password) {
        this.passwordorg = password;
    }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return "OrganizzatoreDTO{" +
                    "codOrganizzatore=" + codOrganizzatore +
                    ", nome='" + nome + '\'' +
                    ", numCivico=" + numCivico +
                    ", cognome='" + cognome + '\'' +
                    ", email='" + email + '\'' +
                    ", titolo='" + titolo + '\'' +
                    ", istituzione='" + istituzione + '\'' +
                    ", comitato=" + comitato_es +
                    '}';
        }
    }
