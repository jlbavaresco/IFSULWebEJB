package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controleCidade")
@ViewScoped
public class ControleCidade implements Serializable {

    @EJB
    private CidadeDAO<Cidade> dao;
    private Cidade objeto;
    private Boolean editando;
    @EJB
    private EstadoDAO<Estado> daoEstado;
    
    public ControleCidade(){
        editando = false;
    }
    
    public String listar(){
        return "/privado/cidade/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Cidade();
        editando = true;
    }
    
    public void alterar(Integer id){
        try {
            objeto = dao.getObjectById(id);
            editando = true;
        } catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remover(objeto);            
        } catch(Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }    
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            editando = false;
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public CidadeDAO<Cidade> getDao() {
        return dao;
    }

    public void setDao(CidadeDAO<Cidade> dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public EstadoDAO<Estado> getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(EstadoDAO<Estado> daoEstado) {
        this.daoEstado = daoEstado;
    }
}
