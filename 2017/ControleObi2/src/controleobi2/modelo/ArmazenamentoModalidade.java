/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo;

import controleobi2.modelo.entidade.Modalidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class ArmazenamentoModalidade {
    
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/obi";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "romanelli";
    
    private ArrayList<Modalidade> listaModalidade;
    
    private Connection con;
    
    public ArmazenamentoModalidade() {
        listaModalidade = new ArrayList<>();
        
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
    
    public boolean inserir(Modalidade modalidade) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "insert into modalidade (nome, descricao) values (?, ?)");
            ps.setString(1, modalidade.getNome());
            ps.setString(2, modalidade.getDescricao());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao inserir registro no banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public Modalidade buscar(Modalidade modalidade) {
        Modalidade modalidadeProcurada = null;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "select nome, descricao from modalidade where codigo = ?");
            ps.setLong(1, modalidade.getCodigo());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                long codigo = modalidade.getCodigo();
                String nome = rs.getString(1);
                String descricao = rs.getString(2);
                modalidadeProcurada = new Modalidade(codigo, nome, descricao);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao obter registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return modalidadeProcurada;
    }
    
    public boolean alterar(Modalidade modalidade) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "update modalidade set nome = ?, descricao = ? where codigo = ?");
            ps.setString(1, modalidade.getNome());
            ps.setString(2, modalidade.getDescricao());
            ps.setLong(3, modalidade.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao alterar registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean excluir(Modalidade modalidade) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "delete from modalidade where codigo = ?");
            ps.setLong(1, modalidade.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao excluir registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public ArrayList<Modalidade> getLista() {
        listaModalidade.clear();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "select codigo, nome, descricao from modalidade order by nome");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                do {
                    long codigo = rs.getLong(1);
                    String nome = rs.getString(2);
                    String descricao = rs.getString(3);
                    listaModalidade.add(new Modalidade(codigo, nome, descricao));
                } while (rs.next());
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao obter registros do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return listaModalidade;
    }
}
