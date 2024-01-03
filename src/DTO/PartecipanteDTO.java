package DTO;

public class PartecipanteDTO
{
       private int codPartecipante;
        private String nome;
        private int numCivico;
        private String cognome;
        private String email;
        private String titolo;
        private String istituzione;

        private String partecipante_s;

        private String keynote_Speaker;

        private String pass;

        // Costruttore vuoto
        public PartecipanteDTO() {
        }

        // Costruttore con parametri
        public PartecipanteDTO(int codPartecipante, String nome, int numCivico, String cognome, String email, String titolo, String istituzione, String partecipante, String keynoteSpeaker, String pass)
        {

            this.codPartecipante = codPartecipante;
            this.nome = nome;
            this.numCivico = numCivico;
            this.cognome = cognome;
            this.email = email;
            this.titolo = titolo;
            this.istituzione = istituzione;
            this.partecipante_s = partecipante;
            this.keynote_Speaker = keynoteSpeaker;
            this.pass = pass;
        }

    public PartecipanteDTO( String nome, int numCivico, String cognome, String email, String titolo, String istituzione, String partecipante, String keynoteSpeaker, String pass)
    {
        this.nome = nome;
        this.numCivico = numCivico;
        this.cognome = cognome;
        this.email = email;
        this.titolo = titolo;
        this.istituzione = istituzione;
        this.partecipante_s = partecipante;
        this.keynote_Speaker = keynoteSpeaker;
        this.pass = pass;
    }

    public PartecipanteDTO( String nome,  String cognome)
    {
        this.nome = nome;

        this.cognome = cognome;

    }

        // Metodi getter e setter per ogni attributo
        public int getCodPartecipante() {
            return codPartecipante;
        }

        public void setCodPartecipante(int codPartecipante) {
            this.codPartecipante = codPartecipante;
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

        public String getPartecipante_s() {
        return partecipante_s;
    }

    public void setPartecipante_s(String partecipante) { this.partecipante_s = partecipante;}

    public String getKeynoteSpeaker() {
        return keynote_Speaker;
    }

    public void setKeynoteSpeaker(String keynoteSpeaker) {
        this.keynote_Speaker = keynoteSpeaker;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return
                    "" + codPartecipante;
        }
    }

