/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi2.modelo.dao;

import controleobi2.modelo.entidade.TipoEscola;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public interface TipoEscolaDAO {
    
    public TipoEscola buscar(TipoEscola tipoEscola);
    
    public boolean inserir(TipoEscola tipoEscola);
    
    public boolean alterar(TipoEscola tipoEscola);
    
    public boolean excluir(TipoEscola tipoEscola);
    
    public ArrayList<TipoEscola> getLista();

}
