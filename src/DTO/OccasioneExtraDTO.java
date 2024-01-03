package DTO;

public class OccasioneExtraDTO
{
    //attributi di una qualsoasi occasione extra
        private int codOccasione;
        private String tipoEvento;
        private String tipoSpazio;
        private String descrizione;
        private SessioneDTO sessione;  // Chiave esterna


        // Costruttore vuoto
        public OccasioneExtraDTO() {
        }

        // Costruttore con parametri
        public OccasioneExtraDTO(int codOccasione, String tipoEvento, String tipoSpazio, SessioneDTO sessione, String descrizione) {
            this.codOccasione = codOccasione;
            this.tipoEvento = tipoEvento;
            this.tipoSpazio = tipoSpazio;
            this.sessione = sessione;
            this.descrizione = descrizione;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodOccasione() {
            return codOccasione;
        }

        public void setCodOccasione(int codOccasione) {
            this.codOccasione = codOccasione;
        }

        public String getTipoEvento() {
            return tipoEvento;
        }

        public void setTipoEvento(String tipoEvento) {
            this.tipoEvento = tipoEvento;
        }

        public String getTipoSpazio() {
            return tipoSpazio;
        }

        public void setTipoSpazio(String tipoSpazio) {
            this.tipoSpazio = tipoSpazio;
        }

        public SessioneDTO getSessione() {
            return sessione;
        }

        public void setSessione(SessioneDTO sessione) {
            this.sessione = sessione;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return "OccasioneExtraDTO{" +
                    "codOccasione=" + codOccasione +
                    ", tipoEvento='" + tipoEvento + '\'' +
                    ", tipoSpazio='" + tipoSpazio + '\'' +
                    ", sessione=" + sessione +
                    ", descrizione='" + descrizione + '\'' +
                    '}';
        }
}


