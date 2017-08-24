/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao;

import controledopuxafrangos.dao.postgresql.PostgreSqlDAOFactory;

/**
 *
 * @author romanelli
 */
public abstract class DAOFactory {
    private static final int OPCAO_BD_POSTGRESQL = 1;
    
    private static DAOFactory getDAOFactory(int opcao) {
        switch (opcao) {
            case OPCAO_BD_POSTGRESQL:
                return new PostgreSqlDAOFactory();
            default:
                return null;
        }
    }
    
    public static DAOFactory getDefaultDAOFactory() {
        return getDAOFactory(OPCAO_BD_POSTGRESQL);
    }
    
    public abstract ComandoDAO getComandoDAO();
    
    public abstract ListaComandosDAO getListaComandosDAO();
}
