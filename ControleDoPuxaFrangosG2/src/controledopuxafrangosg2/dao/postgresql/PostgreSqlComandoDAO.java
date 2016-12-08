/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2.dao.postgresql;

import controledopuxafrangosg2.dados.Comando;
import controledopuxafrangosg2.dados.ListaComandos;
import controledopuxafrangosg2.dados.MovimentoGarra;
import controledopuxafrangosg2.dados.PosicionamentoGarra;
import controledopuxafrangosg2.dao.ComandoDAO;
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
public class PostgreSqlComandoDAO implements ComandoDAO {

    @Override
    public ArrayList<Comando> selecionarTodosPorIdListaComandos(long idListaComandos) {
        try {
            Connection con = PostgreSqlDAOFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select id, sequencial, tipo, angulo, "
                            + " coord_x, coord_y, coord_z " 
                            + " from comando " 
                            + " where lista = ?", 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            ps.setLong(1, idListaComandos);
            
            ArrayList<Comando> listaComandos = new ArrayList<>();
            
            ListaComandos lc = PostgreSqlDAOFactory.getInstance()
                    .getListaComandosDAO().selecionarPorId(idListaComandos);
            
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                long id = rs.getLong(1);
                int sequencial = rs.getInt(2);
                char tipo = rs.getString(3).charAt(0);
                Comando c = null;
                if (tipo == 'P') {
                    int coordX = rs.getInt(5);
                    int coordY = rs.getInt(6);
                    int coordZ = rs.getInt(7);
                    c = new PosicionamentoGarra(id, lc, sequencial, 
                            coordX, coordY, coordZ);
                } else if (tipo == 'G') {
                    int angulo = rs.getInt(4);
                    c = new MovimentoGarra(id, lc, sequencial, angulo);
                }
                listaComandos.add(c);
            }
            
            return listaComandos;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao obter registros do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public Comando selecionarPorId(long id) {
        try {
            Connection con = PostgreSqlDAOFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select lista, sequencial, tipo, angulo, "
                            + " coord_x, coord_y, coord_z " 
                            + " from comando where id = ?", 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()) {
                long idLista = rs.getLong(1);
                ListaComandos lc = PostgreSqlDAOFactory.getInstance()
                    .getListaComandosDAO().selecionarPorId(idLista);
                
                int sequencial = rs.getInt(2);
                char tipo = rs.getString(3).charAt(0);
                Comando c = null;
                if (tipo == 'P') {
                    int coordX = rs.getInt(5);
                    int coordY = rs.getInt(6);
                    int coordZ = rs.getInt(7);
                    c = new PosicionamentoGarra(id, lc, sequencial, 
                            coordX, coordY, coordZ);
                } else if (tipo == 'G') {
                    int angulo = rs.getInt(4);
                    c = new MovimentoGarra(id, lc, sequencial, angulo);
                }
                return c;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao obter registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }

    @Override
    public boolean inserir(Comando c) {
        try {
            Connection con = PostgreSqlDAOFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into comando (lista, sequencial, tipo,"
                            + " angulo, coord_x, coord_y, coord_z) values "
                            + " (?, ?, ?, ?, ?, ?, ?)");
            ps.setLong(1, c.getLista().getId());
            ps.setInt(2, c.getSequencial());
            if (c instanceof PosicionamentoGarra) {
                
                ps.setString(3, "P");
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setInt(5, ((PosicionamentoGarra) c).getX());
                ps.setInt(6, ((PosicionamentoGarra) c).getY());
                ps.setInt(7, ((PosicionamentoGarra) c).getZ());
            
            } else if (c instanceof MovimentoGarra) {
                
                ps.setString(3, "G");
                ps.setInt(4, ((MovimentoGarra) c).getAngulo());
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setNull(7, java.sql.Types.INTEGER);
            
            }
            
            
            int result = ps.executeUpdate();
            
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao inserir registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean alterar(Comando c) {
        try {
            Connection con = PostgreSqlDAOFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update comando "
                            + " set lista = ?, sequencial = ?, tipo = ?, "
                            + " angulo = ?, coord_x = ?, coord_y = ?, "
                            + " coord_z = ? "
                            + " where id = ?");
            ps.setLong(1, c.getLista().getId());
            ps.setInt(2, c.getSequencial());
            if (c instanceof PosicionamentoGarra) {
                
                ps.setString(3, "P");
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setInt(5, ((PosicionamentoGarra) c).getX());
                ps.setInt(6, ((PosicionamentoGarra) c).getY());
                ps.setInt(7, ((PosicionamentoGarra) c).getZ());
            
            } else if (c instanceof MovimentoGarra) {
                
                ps.setString(3, "G");
                ps.setInt(4, ((MovimentoGarra) c).getAngulo());
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setNull(7, java.sql.Types.INTEGER);
            
            }
            ps.setLong(8, c.getId());
            
            int result = ps.executeUpdate();
            
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao alterar registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean excluir(Comando c) {
        try {
            Connection con = PostgreSqlDAOFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "delete from comando where id = ?");
            ps.setLong(1, c.getId());
            
            int result = ps.executeUpdate();
            
            return result == 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Ocorreu um erro ao excluir registro do banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}
