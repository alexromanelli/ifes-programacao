/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2.dao.postgresql;

import controledopuxafrangosg2.dao.ComandoDAO;
import controledopuxafrangosg2.dao.DAOFactory;
import controledopuxafrangosg2.dao.ListaComandosDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author romanelli
 */
public class PostgreSqlDAOFactory extends DAOFactory {
    
    private static PostgreSqlDAOFactory INSTANCE;
    public static PostgreSqlDAOFactory getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PostgreSqlDAOFactory();
        return INSTANCE;
    }
    
    private static final String DB_URL = 
            "jdbc:postgresql://localhost:5432/puxafrangos";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "romanelli";
    
    private Connection con;
    
    public Connection getConnection() {
        return con;
    }
    
    public PostgreSqlDAOFactory() {
        INSTANCE = this;
        try {
            
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Não foi possível carregar o driver para PostgreSQL.",
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Ocorreu um erro ao conectar com o banco de dados.",
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ListaComandosDAO getListaComandosDAO() {
        return new PostgreSqlListaComandosDAO();
    }

    @Override
    public ComandoDAO getComandoDAO() {
        return new PostgreSqlComandoDAO();
    }
}
