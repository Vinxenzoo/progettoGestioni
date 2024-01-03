package DTO;

public class FeedbackDTO
{
    //attribut della classe feedack
        private int codFeedback;
        private String feedbackText;
        private PartecipanteDTO partecipante;
        private InterventoDTO intervento;

        // Costruttore vuoto
        public FeedbackDTO() {
        }

        // Costruttore con parametri
        public FeedbackDTO(int codFeedback, String feedbackText, PartecipanteDTO partecipante, InterventoDTO intervento) {
            this.codFeedback = codFeedback;
            this.feedbackText = feedbackText;
            this.partecipante = partecipante;
            this.intervento = intervento;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodFeedback() {
            return codFeedback;
        }

        public void setCodFeedback(int codFeedback) {
            this.codFeedback = codFeedback;
        }

        public String getFeedbackText() {
            return feedbackText;
        }

        public void setFeedbackText(String feedbackText) {
            this.feedbackText = feedbackText;
        }

        public PartecipanteDTO getPartecipante() {
            return partecipante;
        }

        public void setPartecipante(PartecipanteDTO partecipante) {
            this.partecipante = partecipante;
        }

        public InterventoDTO getIntervento() {
            return intervento;
        }

        public void setIntervento(InterventoDTO intervento) {
            this.intervento = intervento;
        }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
        @Override
        public String toString() {
            return
                    "" + codFeedback;
        }
}


