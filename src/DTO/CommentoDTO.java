package DTO;

public class CommentoDTO
{
        private int codCommento;
        private String commento;
        private PartecipanteDTO partecipante;
        private FeedbackDTO feedback;

        // Costruttore vuoto
        public CommentoDTO() {
        }

        // Costruttore con parametri
        public CommentoDTO(int codCommento, String commento, PartecipanteDTO partecipante, FeedbackDTO feedback) {
            this.codCommento = codCommento;
            this.commento = commento;
            this.partecipante = partecipante;
            this.feedback = feedback;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodCommento() {
            return codCommento;
        }

        public void setCodCommento(int codCommento) {
            this.codCommento = codCommento;
        }

        public String getCommento() {
            return commento;
        }

        public void setCommento(String commento) {
            this.commento = commento;
        }

        public PartecipanteDTO getPartecipante() {
            return partecipante;
        }

        public void setPartecipante(PartecipanteDTO partecipante) {
            this.partecipante = partecipante;
        }

        public FeedbackDTO getFeedback() {
            return feedback;
        }

        public void setFeedback(FeedbackDTO feedback) {
            this.feedback = feedback;
        }

        @Override
        public String toString() {
            return "CommentoDTO{" +
                    "codCommento=" + codCommento +
                    ", commento='" + commento + '\'' +
                    ", partecipante=" + partecipante +
                    ", feedback=" + feedback +
                    '}';
        }
}


