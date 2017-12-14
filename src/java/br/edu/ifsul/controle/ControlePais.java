package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PaisDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controlePais")
@RequestScoped
public class ControlePais implements Serializable {
    
    @EJB
    private PaisDAO dao;
    
    public ControlePais(){
        
    }

    public PaisDAO getDao() {
        return dao;
    }

    public void setDao(PaisDAO dao) {
        this.dao = dao;
    }

}
