/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi2.modelo.dao;

import controleobi2.modelo.entidade.Escola;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public interface EscolaDAO {
    
    public Escola buscar(Escola escola);
    
    public boolean inserir(Escola escola);
    
    public boolean alterar(Escola escola);
    
    public boolean excluir(Escola escola);
    
    public ArrayList<Escola> getLista();

}
