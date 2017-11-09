/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao.pg;

import controleobi2.modelo.dao.ModalidadeDAO;
import controleobi2.modelo.entidade.Modalidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class PgModalidadeDAO implements ModalidadeDAO {

    @Override
    public boolean inserir(Modalidade modalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
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

    @Override
    public boolean alterar(Modalidade modalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
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

    @Override
    public boolean excluir(Modalidade modalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
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

    @Override
    public Modalidade buscar(Modalidade modalidade) {
        Modalidade modalidadeProcurada = null;
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
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

    private ArrayList<Modalidade> listaModalidade;
    
    @Override
    public ArrayList<Modalidade> getLista() {
        if (listaModalidade == null)
            listaModalidade = new ArrayList<>();
        else
            listaModalidade.clear();
        
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
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
