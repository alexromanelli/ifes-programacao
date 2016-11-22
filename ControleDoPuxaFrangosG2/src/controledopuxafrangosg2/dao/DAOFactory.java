/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2.dao;

/**
 *
 * @author romanelli
 */
public abstract class DAOFactory {
    
    private static final int BD_POSTGRESQL = 1;
    
    private static DAOFactory getDAOFactory(int tipo) {
        switch (tipo) {
            case BD_POSTGRESQL:
                return new PostgreSqlDAOFactory();
            default:
                return null;
        }
    }
    
    public static DAOFactory getDefaultDAOFactory() {
        return getDAOFactory(BD_POSTGRESQL);
    }
    
    public abstract ListaComandosDAO getListaComandosDAO();
    
    public abstract ComandoDAO getComandoDAO();
}
