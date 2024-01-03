package DTO;

public class ComitatoDTO
{

        //attributi della classe comitato
        private int codComitato;
        private String tipoC;
        private String nomeC;

        // Costruttore vuoto
        public ComitatoDTO() {
        }

        // Costruttore con parametri
        public ComitatoDTO(int codComitato, String tipoC, String nomeC) {
            this.codComitato = codComitato;
            this.tipoC = tipoC;
            this.nomeC = nomeC;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodComitato() {
            return codComitato;
        }

        public void setCodComitato(int codComitato) {
            this.codComitato = codComitato;
        }

        public String getTipoC() { return tipoC;}

        public void setTipoC(String tipoC) {
            this.tipoC = tipoC;
        }

        public String getNomeC() {
            return nomeC;
        }

        public void setNomeC(String nomeC) {
            this.nomeC = nomeC;
        }


        public String mostracomitato() {
            return "ComitatoDTO{" +
                    "codComitato=" + codComitato +
                    ", tipoC='" + tipoC + '\'' +
                    ", nomeC='" + nomeC + '\'' +
                    '}';
        }
}


