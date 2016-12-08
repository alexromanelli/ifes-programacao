package controledopuxafrangos.dao.postgresql;

import controledopuxafrangos.dados.Comando;
import controledopuxafrangos.dados.ComandoGarra;
import controledopuxafrangos.dados.ComandoMovimento;
import controledopuxafrangos.dados.ListaComandos;
import controledopuxafrangos.dao.DAOFactory;
import controledopuxafrangos.dao.ListaComandosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author romanelli
 */
public class PostgreSqlListaComandosDAO implements ListaComandosDAO {

    @Override
    public ArrayList<ListaComandos> selecionarTodas() {
        try {
            PostgreSqlDAOFactory daoFactory = ((PostgreSqlDAOFactory) DAOFactory
                    .getDefaultDAOFactory());
            Connection con = daoFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(""
                    + "select id, nome from lista_comandos order by nome",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = ps.executeQuery();

            ArrayList<ListaComandos> listaListaComandos = new ArrayList<>();
            
            rs.beforeFirst();
            while (rs.next()) {
                long id = rs.getLong(1);
                String nome = rs.getString(2);
                ListaComandos lc = new ListaComandos(id, nome, null);
                listaListaComandos.add(lc);
            }
            
            return listaListaComandos;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Houve um erro ao selecionar dados do banco.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public ListaComandos selecionarPorId(long id) {
        try {
            PostgreSqlDAOFactory daoFactory = ((PostgreSqlDAOFactory) DAOFactory
                    .getDefaultDAOFactory());
            Connection con = daoFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(""
                    + "select nome from lista_comandos where id = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                String nome = rs.getString(1);
                ListaComandos lc = new ListaComandos(id, nome, null);
                return lc;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Houve um erro ao selecionar dados do banco.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public boolean inserir(ListaComandos lc) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into lista_comandos (nome) values (?)");
            ps.setString(1, lc.getNome());
            int result = ps.executeUpdate();
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Houve um erro ao inserir registro do banco.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean alterar(ListaComandos lc) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update lista_comandos set nome = ? where id = ?");
            ps.setString(1, lc.getNome());
            ps.setLong(2, lc.getId());
            int result = ps.executeUpdate();
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Houve um erro ao alterar registro do banco.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean excluir(ListaComandos lc) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "delete from lista_comandos where id = ?");
            ps.setLong(1, lc.getId());
            int result = ps.executeUpdate();
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Houve um erro ao excluir registro do banco.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}
