/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao.pg;

import controleobi2.modelo.dao.DAOFactory;
import controleobi2.modelo.dao.ModalidadeDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class PostgreSqlDAOFactory extends DAOFactory {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/obi";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "romanelli";

    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (ClassNotFoundException e1) {
                JOptionPane.showMessageDialog(null, 
                        "Não foi possível carregar o driver para PostgreSQL.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(null, 
                        "Ocorreu um erro ao conectar com o banco de dados.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return con;
    }
    
    @Override
    public ModalidadeDAO getModalidadeDAO() {
        return new PgModalidadeDAO();
    }

    @Override
    public TipoEscolaDAO getTipoEscolaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FaseDAO getFaseDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinguagemDAO getLinguagemDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NivelCursoDAO getNivelCursoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
