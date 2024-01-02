package DTO;
import java.sql.Date;

public class ConferenzaDTO
{
        private int codConferenza;
        private String sponsor;
        private String descrizione;
        private String ente;
        private int spesa;
        private Date dataInizio;
        private Date dataFine;
        private SedeDTO sede_es;  // Chiave esterna

        // Costruttore vuoto
        public ConferenzaDTO() {
        }

        // Costruttore con parametri
        public ConferenzaDTO(int codConferenza, String sponsor, String descrizione, String ente, int spesa, Date dataInizio, Date dataFine, SedeDTO sede) {
            this.codConferenza = codConferenza;
            this.sponsor = sponsor;
            this.descrizione = descrizione;
            this.ente = ente;
            this.spesa = spesa;
            this.dataInizio = dataInizio;
            this.dataFine = dataFine;
            this.sede_es = sede;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodConferenza() {
            return codConferenza;
        }

        public void setCodConferenza(int codConferenza) {
            this.codConferenza = codConferenza;
        }

        public String getSponsor() {
            return sponsor;
        }

        public void setSponsor(String sponsor) {
            this.sponsor = sponsor;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public String getEnte() {
            return ente;
        }

        public void setEnte(String ente) {
            this.ente = ente;
        }

        public int getSpesa() {
            return spesa;
        }

        public void setSpesa(int spesa) {
            this.spesa = spesa;
        }

        public Date getDataInizio() {
            return dataInizio;
        }

        public void setDataInizio(Date dataInizio) {
            this.dataInizio = dataInizio;
        }

        public Date getDataFine() {
            return dataFine;
        }

        public void setDataFine(Date dataFine) {
            this.dataFine = dataFine;
        }

        public SedeDTO getSede() {
            return sede_es;
        }

        public void setSede(SedeDTO sede) {
            this.sede_es = sede;
        }

        @Override
        public String toString() {
            return
                    "Codice Conferenza = " + codConferenza;
        }


}




