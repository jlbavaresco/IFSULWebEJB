package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateless
public class PaisDAO implements Serializable {
    
    @PersistenceContext(unitName = "IFSULWebEJBPU")
    private EntityManager em;
    private List<Pais> listaObjetos;

    public PaisDAO(){
        
    }
    
    public List<Pais> getListaObjetos() {
        return em.createQuery("from Pais order by nome").getResultList();
    }    
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListaObjetos(List<Pais> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

}
