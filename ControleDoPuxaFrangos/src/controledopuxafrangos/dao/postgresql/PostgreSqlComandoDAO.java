/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao.postgresql;

import controledopuxafrangos.dados.Comando;
import controledopuxafrangos.dados.ComandoGarra;
import controledopuxafrangos.dados.ComandoMovimento;
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
            Connection con = ((PostgreSqlDAOFactory) DAOFactory
                    .getDefaultDAOFactory()).getConnection();
            PreparedStatement ps = con.prepareStatement(""
                    + "select id, sequencial, tipo, angulo, "
                    + "       coord_x, coord_y, coord_z "
                    + "  from comando "
                    + " where lista = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ps.setLong(1, idLista);
            
            ResultSet rs = ps.executeQuery();
            
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
                        c = new ComandoGarra(id, sequencial, angulo);
                        break;
                    case 'P': // criar um objeto da classe ComandoMovimento
                        int coordX = rs.getInt(5);
                        int coordY = rs.getInt(6);
                        int coordZ = rs.getInt(7);
                        c = new ComandoMovimento(id, sequencial, coordX, coordY, coordZ);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Comando c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
