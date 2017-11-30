/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi2.modelo.dao.pg;

import controleobi2.modelo.dao.TipoEscolaDAO;
import controleobi2.modelo.entidade.TipoEscola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandre
 */
public class PgTipoEscolaDAO implements TipoEscolaDAO {

    private static final String SCRIPT_BUSCAR =
            "select codigo, tipo from tipoescola where codigo = ?";
    
    private static final String SCRIPT_INSERIR =
            "insert into tipoescola (tipo) values (?)";
    
    private static final String SCRIPT_ALTERAR =
            "update tipoescola " +
            "   set tipo = ? " +
            " where codigo = ?";
    
    private static final String SCRIPT_EXCLUIR =
            "delete from tipoescola where codigo = ?";
    
    private static final String SCRIPT_GET_LISTA =
            "select codigo, tipo " +
            "  from tipoescola " +
            " order by tipo";
    
    
    @Override
    public TipoEscola buscar(TipoEscola tipoEscola) {
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_BUSCAR);
            ps.setLong(1, tipoEscola.getCodigo());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                long codigo = rs.getLong(1);
                String tipo = rs.getString(2);
                
                TipoEscola tipoEscolaBuscado = new TipoEscola(codigo, tipo);
                
                return tipoEscolaBuscado;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao buscar registro de tipo de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public boolean inserir(TipoEscola tipoEscola) {
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_INSERIR);
            ps.setString(1, tipoEscola.getTipo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao inserir registro de tipo de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean alterar(TipoEscola tipoEscola) {
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_ALTERAR);
            ps.setString(1, tipoEscola.getTipo());
            ps.setLong(2, tipoEscola.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao alterar registro de tipo de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean excluir(TipoEscola tipoEscola) {
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_EXCLUIR);
            ps.setLong(1, tipoEscola.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao excluir registro de tipo de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private ArrayList<TipoEscola> listaTipoEscola;
    
    @Override
    public ArrayList<TipoEscola> getLista() {
        if (listaTipoEscola == null)
            listaTipoEscola = new ArrayList<>();
        else
            listaTipoEscola.clear();
        
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_GET_LISTA);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                long codigo = rs.getLong(1);
                String tipo = rs.getString(2);
                
                TipoEscola tipoEscola = new TipoEscola(codigo, tipo);
                
                listaTipoEscola.add(tipoEscola);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao obter registros de tipos de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return listaTipoEscola;
    }
    
}
