package DTO;

public class InterventoDTO
{
        private int codIntervento;
        private String abstractIntervento;
        private SessioneDTO sessione_es;  // Chiave esterna

        private PartecipanteDTO partecipante_es;


        // Costruttore vuoto
        public InterventoDTO() {
        }

        // Costruttore con parametri
        public InterventoDTO(int codIntervento, String abstractIntervento, SessioneDTO sessione, PartecipanteDTO partec) {
            this.codIntervento = codIntervento;
            this.abstractIntervento = abstractIntervento;
            this.sessione_es = sessione;
            this.partecipante_es = partec;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodIntervento() {
            return codIntervento;
        }

        public void setCodIntervento(int codIntervento) {
            this.codIntervento = codIntervento;
        }

        public String getAbstractIntervento() {
            return abstractIntervento;
        }

        public void setAbstractIntervento(String abstractIntervento) {
            this.abstractIntervento = abstractIntervento;
        }

        public SessioneDTO getSessione() {
            return sessione_es;
        }

        public void setSessione(SessioneDTO sessione) {
        this.sessione_es = sessione;
        }

        public  PartecipanteDTO getPartecipante() { return partecipante_es;}

        public void setPartecipante(PartecipanteDTO partec) {
        this.partecipante_es = partec;
    }

    @Override
        public String toString() {
            return "" + codIntervento;
        }
    }

//intervento di una certa persona in una certa sessione da non confondere cpn le occasioni extra o con interventi di manutenzione
