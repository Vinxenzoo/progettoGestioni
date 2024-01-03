package UTILITIES;

import DAO.*;
import DTO.*;

import java.util.List;


public class Controller {



    private DBConnection dbConnection;

    private AmmissioneDAO ammissione = new AmmissioneDAO(this);

    private ConferenzaDAO conferenzaDAO  = new ConferenzaDAO(this);;

    private CoordinatoreDAO coordinatore = new CoordinatoreDAO(this);

    private GestioneDAO gestioneDAO;

    private InterventoDAO intervento = new InterventoDAO(this);

    private FeedbackDAO feedback = new FeedbackDAO(this);

    private OccasioneExtraDAO occasioneExtra = new OccasioneExtraDAO(this);

    private OrganizzatoreDAO organizzatore= new OrganizzatoreDAO(this);

    private PartecipanteDAO partec = new PartecipanteDAO(this);

    private SedeDAO sedeDAO = new SedeDAO(this);;

    private SessioneDAO sessione = new SessioneDAO(this);

    private TenutaDAO tenutaDAO;

    private ComitatoDAO comitato = new ComitatoDAO(this );

    private CommentoDAO commento = new CommentoDAO(this);

    private String email_p, password_p;





    public Controller(DBConnection conn)
    {

        this.dbConnection = conn;


    }

    public DBConnection getDBConnection() { return dbConnection;}

    public List<ConferenzaDTO> getListaConferenze() { return conferenzaDAO.recuperaListaConferenze();}

    public List<CommentoDTO> getListacommento() { return commento.recuperaListaCommento();}

    public List<FeedbackDTO> getListafeedback() { return feedback.recuperaListaCfeedback();}

    public List<AmmissioneDTO> getListaammissione() {
        return ammissione.recuperaListaAmmissione();
    }

    public List<ComitatoDTO> getListacomitato() { return comitato.recuperaListacomitato();}

    public List<InterventoDTO> getListaintervento() {return intervento.recuperaListaintervento();}

    public List<SessioneDTO> getListaSessione() { return sessione.recuperaListaSessione(); }

    public List<SedeDTO> getListaSede() { return sedeDAO.recuperaListaSede();}

    public List<PartecipanteDTO> getListaPartecipante() { return partec.recuperaListaPartecipanti();}

    public boolean presenzanome(String no, String co)
    {

        if( partec.verificaPresenza(no,co) )
            return true;
        else
            return false;
    }


    public boolean accesso(String em, String pass)
    {

       if(  partec.verificacredenzialipartec(em,pass))
       {
           email_p = em; password_p = pass;
           return true;
       }
       else
       {
           return false;
       }
    }

    public boolean accessocoo(String no, String co, String em, String pass)
    {

        if(  coordinatore.verificaPresenzaCoordinatore(no,co,em,pass))
            return true;
        else
            return false;
    }

    public boolean accessoorg(String no, String co, String em, String pass)
    {

        if(  organizzatore.verificaPresenzaOrganizzatore(no,co,em,pass))
            return true;
        else
            return false;
    }


    public void ins(PartecipanteDTO parteci)
    {

        partec.insertPartecipante(parteci);

    }

    public Boolean verifica(PartecipanteDTO partec)
    {

                        if(partec.getPassword() != "")
                        {

                             ins(partec);
                             return true;
                        }
                        else
                        {
                            System.out.println(" IL campo Password è obbligatorio inseriscilo");
                        }

        return false;

    }

    public void insertinammissione (Integer cod_sess, String email)
    {

        partec.verificaAmminp(  email, cod_sess);
        System.out.println("valore codice part: "+ email );
    }

    public void cancellai (Integer cod_i)
        {
            intervento.deleteIntervento(cod_i);
        }

    public void cancellap (Integer cod_p, Integer cod_s)  {ammissione.deleteAmmpartecipante(cod_p,cod_s);}

    public void lasciaf (Integer cod_intervento, String feed, String email)
    {

        partec.lasciaf( cod_intervento, feed, email);
        System.out.println("valore codice part: "+ email );
    }

    public void lasciacommento(Integer cod_feedback, String commento, String email)
    {

        partec.lasciacomm( cod_feedback, commento, email);
        System.out.println("valore codice part: "+ email );
    }

    public void insinter (Integer cod_sessione, String abs, String email)
    {
        partec.vainterv( cod_sessione, abs, email);
    }

    public void inse_occ_ex (Integer cod_sessione, String des, String tipo)
    {
        occasioneExtra.ins( cod_sessione, des, tipo);
    }

    public void rendikeyorspec( Integer cod_part, String rule)
    {
        partec.keyorspec(cod_part, rule);
    }

}


