/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao;

import controleobi2.modelo.entidade.NivelModalidade;
import java.util.ArrayList;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public interface NivelModalidadeDAO {
    
    public NivelModalidade buscar(NivelModalidade nivelModalidade);
    
    public boolean inserir(NivelModalidade nivelModalidade);
    
    public boolean alterar(NivelModalidade nivelModalidade);
    
    public boolean excluir(NivelModalidade nivelModalidade);
    
    public ArrayList<NivelModalidade> getLista();
}
