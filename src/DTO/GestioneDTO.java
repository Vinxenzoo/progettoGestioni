package DTO;

public class GestioneDTO {
        private ConferenzaDTO conferenza;  // Chiave esterna per la tabella "conferenza"
         private OrganizzatoreDTO organizzatore;  // Chiave esterna per la tabella "organizzatore"

        // Costruttore vuoto
        public GestioneDTO() {
        }

        // Costruttore con parametri
        public GestioneDTO(ConferenzaDTO conferenza, OrganizzatoreDTO organizzatore) {
            this.conferenza = conferenza;
            this.organizzatore = organizzatore;
        }

        // Metodi getter e setter per ogni attributo
        public ConferenzaDTO getConferenza() {
            return conferenza;
        }

        public void setConferenza(ConferenzaDTO conferenza) {
            this.conferenza = conferenza;
        }

        public OrganizzatoreDTO getOrganizzatore() {
            return organizzatore;
        }

        public void setOrganizzatore(OrganizzatoreDTO organizzatore) {
            this.organizzatore = organizzatore;
        }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return "GestioneDTO{" +
                    "conferenza=" + conferenza +
                    ", organizzatore=" + organizzatore +
                    '}';
        }
}




