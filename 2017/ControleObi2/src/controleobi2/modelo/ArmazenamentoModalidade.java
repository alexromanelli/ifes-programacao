/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo;

import controleobi2.modelo.entidade.Modalidade;
import java.util.ArrayList;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class ArmazenamentoModalidade {
    private ArrayList<Modalidade> listaModalidade;
    
    public ArmazenamentoModalidade() {
        listaModalidade = new ArrayList<>();
    }
    
    public boolean inserir(Modalidade modalidade) {
        // obter o último código
        if (listaModalidade.size() > 0) {
            modalidade.setCodigo(
                    listaModalidade.get(listaModalidade.size() - 1).getCodigo() + 1);
        } else {
            modalidade.setCodigo(1);
        }
        listaModalidade.add(modalidade);
        return true;
    }
    
    public Modalidade buscar(Modalidade modalidade) {
        Modalidade modalidadeProcurada = null;
        for (Modalidade m : listaModalidade) {
            if (m.getCodigo() == modalidade.getCodigo()) {
                modalidadeProcurada = m;
                break;
            }
        }
        return modalidadeProcurada;
    }
    
    public boolean alterar(Modalidade modalidade) {
        Modalidade modalidadeLista = buscar(modalidade);
        if (modalidadeLista != null) {
            modalidadeLista.setNome(modalidade.getNome());
            modalidadeLista.setDescricao(modalidade.getDescricao());
            return true;
        }
        return false;
    }
    
    public boolean excluir(Modalidade modalidade) {
        Modalidade modalidadeLista = buscar(modalidade);
        if (modalidadeLista != null) {
            return listaModalidade.remove(modalidadeLista);
        }
        return false;
    }
    
    public ArrayList<Modalidade> getLista() {
        return listaModalidade;
    }
}
