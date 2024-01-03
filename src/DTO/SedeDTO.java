package DTO;

public class SedeDTO {

        private int codSede;
        private String via;

        private int numCivico;
        private String luogo;

        private String nome_s;

        public  SedeDTO ()
        {

        }

        public SedeDTO(int codSede, String via, int numCivico, String luogo, String nome_s) {
            this.codSede = codSede;
            this.via = via;
            this.numCivico = numCivico;
            this.luogo = luogo;
            this.nome_s = nome_s;
        }

        public int getCodSede() {
            return codSede;
        }

        public void setCodSede(int codSede) {
            this.codSede = codSede;
        }

        public String getVia() {
            return via;
        }

        public void setVia(String via) {
            this.via = via;
        }

        public int getNumCivico() {
            return numCivico;
        }

        public void setNumCivico(int numCivico) {
            this.numCivico = numCivico;
        }

        public String getLuogo() {
            return luogo;
        }

        public void setLuogo(String luogo) {
            this.luogo = luogo;
        }

        public String getNome_s() {
        return nome_s;
    }

        public void setNome_s(String S) {
        this.nome_s= S;
    }

    //riscrittura del metodo tostring per poterlo utilizzare durante il codice
    @Override
    public String toString() {
        return "SedeDTO{" +
                "codSede=" + codSede +
                ", via='" + via + '\'' +
                ", numCivico=" + numCivico +
                ", luogo='" + luogo + '\'' +
                ", nome_s='" + nome_s + '\'' +
                '}';
    }
}





