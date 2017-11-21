/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao;

import controleobi2.modelo.dao.pg.PostgreSqlDAOFactory;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public abstract class DAOFactory {
    public static final int TIPO_POSTGRESQL = 1;
    public static final int TIPO_MYSQL = 2;
    public static final int TIPO_ORACLE = 3;
    
    public static DAOFactory getDAOFactory(int tipo) {
        switch (tipo) {
            case TIPO_POSTGRESQL:
                return new PostgreSqlDAOFactory();
            default:
                return null;
        }
    }
    
    public static DAOFactory getDefaultDAOFactory() {
        return getDAOFactory(TIPO_POSTGRESQL);
    }

    public abstract ModalidadeDAO getModalidadeDAO();
    
    public abstract NivelModalidadeDAO getNivelModalidadeDAO();
    
    public abstract TipoEscolaDAO getTipoEscolaDAO();
    
    public abstract FaseDAO getFaseDAO();
    
    public abstract LinguagemDAO getLinguagemDAO();
    
    public abstract NivelCursoDAO getNivelCursoDAO();
    
}
