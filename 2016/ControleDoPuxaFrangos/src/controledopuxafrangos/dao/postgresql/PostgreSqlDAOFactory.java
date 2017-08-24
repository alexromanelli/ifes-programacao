/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao.postgresql;

import controledopuxafrangos.dao.ComandoDAO;
import controledopuxafrangos.dao.DAOFactory;
import controledopuxafrangos.dao.ListaComandosDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author romanelli
 */
public class PostgreSqlDAOFactory extends DAOFactory {

    private static final String DB_URL = 
            "jdbc:postgresql://localhost:5432/puxafrangos";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "romanelli";
    
    private Connection con;
    
    public PostgreSqlDAOFactory() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar driver de banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao conectar ao banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    @Override
    public ComandoDAO getComandoDAO() {
        return new PostgreSqlComandoDAO();
    }

    @Override
    public ListaComandosDAO getListaComandosDAO() {
        return new PostgreSqlListaComandosDAO();
    }
    
}
