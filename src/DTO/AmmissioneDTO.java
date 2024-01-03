package DTO;

public class AmmissioneDTO
{
        private SessioneDTO sessione;  // Chiave esterna per la tabella "sessione"
        private PartecipanteDTO partecipante;  // Chiave esterna per la tabella "partecipante"


        // Costruttore con parametri
        public AmmissioneDTO(SessioneDTO sessione, PartecipanteDTO partecipante) {
            this.sessione = sessione;
            this.partecipante = partecipante;
        }

        // Metodi getter e setter per ogni attributo
        public SessioneDTO getSessione() {
            return sessione;
        }

        public void setSessione(SessioneDTO sessione) {
            this.sessione = sessione;
        }

        public PartecipanteDTO getPartecipante() {
            return partecipante;
        }

        public void setPartecipante(PartecipanteDTO partecipante) {
            this.partecipante = partecipante;
        }


        //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return "AmmissioneDTO{" +
                    "sessione=" + sessione +
                    ", partecipante=" + partecipante +
                    '}';
        }
}

