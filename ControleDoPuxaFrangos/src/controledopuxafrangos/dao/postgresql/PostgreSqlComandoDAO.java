/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao.postgresql;

import controledopuxafrangos.dados.Comando;
import controledopuxafrangos.dao.ComandoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author romanelli
 */
class PostgreSqlComandoDAO implements ComandoDAO {

    @Override
    public ArrayList<Comando> selecionarPorLista(long idLista) {
        try {
            
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public Comando selecionarPorId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
