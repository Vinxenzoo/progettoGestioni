package DTO;
import java.sql.Date;
import java.sql.Time;

public class SessioneDTO
{
        private int codSessione;
        private Date dataPrestabilita;
        private Time orarioPredefinito;
        private ConferenzaDTO conferenza_es;  // Chiave esterna per conferenza
        private CoordinatoreDTO coordinatore_es;  // Chiave esterna per coordinatore

        // Costruttore vuoto
        public SessioneDTO() {
        }

        // Costruttore con parametri
        public SessioneDTO(int codSessione, Date dataPrestabilita, Time orarioPredefinito, ConferenzaDTO conferenza, CoordinatoreDTO coordinatore) {
            this.codSessione = codSessione;
            this.dataPrestabilita = dataPrestabilita;
            this.orarioPredefinito = orarioPredefinito;
            this.conferenza_es = conferenza;
            this.coordinatore_es = coordinatore;
        }

        // Metodi getter e setter per ogni attributo
        public int getCodSessione() {
            return codSessione;
        }

        public void setCodSessione(int codSessione) {
            this.codSessione = codSessione;
        }

        public Date getDataPrestabilita() {
            return dataPrestabilita;
        }

        public void setDataPrestabilita(Date dataPrestabilita) {
            this.dataPrestabilita = dataPrestabilita;
        }

        public Time getOrarioPredefinito() {
            return orarioPredefinito;
        }

        public void setOrarioPredefinito(Time orarioPredefinito) {
            this.orarioPredefinito = orarioPredefinito;
        }

        public ConferenzaDTO getConferenza() {
            return conferenza_es;
        }

        public String getSTRConferenza() {
        return conferenza_es.getDescrizione();
    }

        public void setConferenza(ConferenzaDTO conferenza) {
            this.conferenza_es = conferenza;
        }

        public CoordinatoreDTO getCoordinatore() {
            return coordinatore_es;
        }

        public void setCoordinatore(CoordinatoreDTO coordinatore) {
            this.coordinatore_es = coordinatore;
        }

        @Override
        public String toString() {
            return
                    "" + codSessione ;
        }
    }
