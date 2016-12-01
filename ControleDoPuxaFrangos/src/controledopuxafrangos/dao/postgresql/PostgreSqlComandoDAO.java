/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao.postgresql;

import controledopuxafrangos.dados.Comando;
import controledopuxafrangos.dados.ComandoGarra;
import controledopuxafrangos.dados.ComandoMovimento;
import controledopuxafrangos.dados.ListaComandos;
import controledopuxafrangos.dao.ComandoDAO;
import controledopuxafrangos.dao.DAOFactory;
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
class PostgreSqlComandoDAO implements ComandoDAO {

    @Override
    public ArrayList<Comando> selecionarPorLista(long idLista) {
        try {
            PostgreSqlDAOFactory daoFactory = ((PostgreSqlDAOFactory) DAOFactory
                    .getDefaultDAOFactory());
            Connection con = daoFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(""
                    + "select id, sequencial, tipo, angulo, "
                    + "       coord_x, coord_y, coord_z "
                    + "  from comando "
                    + " where lista = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ps.setLong(1, idLista);
            
            ResultSet rs = ps.executeQuery();

            ListaComandos lc = daoFactory.getListaComandosDAO()
                    .selecionarPorId(idLista);
            ArrayList<Comando> listaComandos = new ArrayList<>();
            
            rs.beforeFirst();
            while (rs.next()) {
                long id = rs.getLong(1);
                int sequencial = rs.getInt(2);
                char tipo = rs.getString(3).charAt(0);
                Comando c = null;
                switch (tipo) {
                    case 'G': // criar um objeto da classe ComandoGarra
                        int angulo = rs.getInt(4);
                        c = new ComandoGarra(id, lc, sequencial, angulo);
                        break;
                    case 'P': // criar um objeto da classe ComandoMovimento
                        int coordX = rs.getInt(5);
                        int coordY = rs.getInt(6);
                        int coordZ = rs.getInt(7);
                        c = new ComandoMovimento(id, lc, sequencial, coordX, coordY, coordZ);
                        break;
                }
                listaComandos.add(c);
            }
            
            return listaComandos;
            
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
    public Comando selecionarPorId(long id) {
        try {
            PostgreSqlDAOFactory daoFactory = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory()));
            Connection con = daoFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select lista, sequencial, tipo, angulo, coord_x, "
                            + " coord_y, coord_z from comando where id = ?");
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()) {
                long idLista = rs.getLong(1);
                ListaComandos lc = daoFactory.getListaComandosDAO()
                        .selecionarPorId(idLista);
                int sequencial = rs.getInt(2);
                char tipo = rs.getString(3).charAt(0);
                Comando c = null;
                switch (tipo) {
                    case 'G':
                        int angulo = rs.getInt(4);
                        c = new ComandoGarra(id, lc, sequencial, angulo);
                        break;
                    case 'P':
                        int coordX = rs.getInt(5);
                        int coordY = rs.getInt(6);
                        int coordZ = rs.getInt(7);
                        c = new ComandoMovimento(id, lc, sequencial, 
                                coordX, coordY, coordZ);
                        break;
                }
                return c;
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
    public boolean inserir(Comando c) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into comando (lista, sequencial, tipo, angulo,"
                            + " coord_x, coord_y, coord_z) values "
                            + " (?, ?, ?, ?, ?, ?, ?)");
            ps.setLong(1, c.getLista().getId());
            ps.setInt(2, c.getSequencial());
            if (c instanceof ComandoGarra) {
                ps.setString(3, "G");
                ComandoGarra cg = (ComandoGarra) c;
                ps.setInt(4, cg.getAngulo());
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setNull(7, java.sql.Types.INTEGER);
            } else if (c instanceof ComandoMovimento) {
                ps.setString(3, "P");
                ComandoMovimento cm = (ComandoMovimento) c;
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setInt(5, cm.getX());
                ps.setInt(6, cm.getY());
                ps.setInt(7, cm.getZ());
            }
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
    public boolean alterar(Comando c) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update comando set lista = ?, sequencial = ?, "
                            + " tipo = ?, angulo = ?, coord_x = ?, "
                            + " coord_y = ?, coord_z = ? where "
                            + " id = ?");
            ps.setLong(1, c.getLista().getId());
            ps.setInt(2, c.getSequencial());
            if (c instanceof ComandoGarra) {
                ps.setString(3, "G");
                ComandoGarra cg = (ComandoGarra) c;
                ps.setInt(4, cg.getAngulo());
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setNull(7, java.sql.Types.INTEGER);
            } else if (c instanceof ComandoMovimento) {
                ps.setString(3, "P");
                ComandoMovimento cm = (ComandoMovimento) c;
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setInt(5, cm.getX());
                ps.setInt(6, cm.getY());
                ps.setInt(7, cm.getZ());
            }
            ps.setLong(8, c.getId());
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
    public boolean excluir(Comando c) {
        try {
            Connection con = ((PostgreSqlDAOFactory)
                    (DAOFactory.getDefaultDAOFactory())).getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "delete from comando where id = ?");
            ps.setLong(1, c.getId());
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
