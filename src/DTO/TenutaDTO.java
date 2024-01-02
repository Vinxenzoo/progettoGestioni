package DTO;

public class TenutaDTO
{
        private ConferenzaDTO conferenza;  // Chiave esterna per la tabella "conferenza"
        private SedeDTO sede;  // Chiave esterna per la tabella "sede"

        // Costruttore vuoto
        public TenutaDTO() {
        }

        // Costruttore con parametri
        public TenutaDTO(ConferenzaDTO conferenza, SedeDTO sede) {
            this.conferenza = conferenza;
            this.sede = sede;
        }

        // Metodi getter e setter per ogni attributo
        public ConferenzaDTO getConferenza() {
            return conferenza;
        }

        public void setConferenza(ConferenzaDTO conferenza) {
            this.conferenza = conferenza;
        }

        public SedeDTO getSede() {
            return sede;
        }

        public void setSede(SedeDTO sede) {
            this.sede = sede;
        }

        @Override
        public String toString() {
            return "TenutaDTO{" +
                    "conferenza=" + conferenza +
                    ", sede=" + sede +
                    '}';
        }
}


