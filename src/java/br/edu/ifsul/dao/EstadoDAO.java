package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateless
public class EstadoDAO<TIPO> extends DAOGenerico<Estado> implements Serializable {

    public EstadoDAO(){
        super();
        classePersistente = Estado.class;
    }
    
}
