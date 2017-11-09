/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao;

import controleobi2.modelo.entidade.Modalidade;
import java.util.ArrayList;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public interface ModalidadeDAO {

    public boolean inserir(Modalidade modalidade);

    public boolean alterar(Modalidade modalidade);

    public boolean excluir(Modalidade modalidade);

    public Modalidade buscar(Modalidade modalidade);

    public ArrayList<Modalidade> getLista();

}
