/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi2.modelo.dao.pg;

import controleobi2.modelo.dao.EscolaDAO;
import controleobi2.modelo.entidade.Escola;
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
public class PgEscolaDAO implements EscolaDAO {

    private static final String SCRIPT_BUSCAR =
            "select e.codigo, e.nome, e.endereco, e.cidade, e.cep, e.ddd, e.telefone, " +
            "       e.tipoescola, t.tipo " +
            "  from escola e join tipoescola t on (e.tipoescola = t.codigo) " +
            " where e.codigo = ?";
    
    private static final String SCRIPT_INSERIR =
            "insert into escola (nome, endereco, cidade, cep, ddd, telefone, tipoescola) " +
            "values (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SCRIPT_ALTERAR =
            "update escola " +
            "   set nome = ?, " +
            "       endereco = ?, " +
            "       cidade = ?, " +
            "       cep = ?, " +
            "       ddd = ?, " +
            "       telefone = ?, " +
            "       tipoescola = ? " +
            " where codigo = ?";
    
    private static final String SCRIPT_EXCLUIR =
            "delete from escola where codigo = ?";
    
    private static final String SCRIPT_GET_LISTA =
            "select e.codigo, e.nome, e.endereco, e.cidade, e.cep, e.ddd, e.telefone, " +
            "       e.tipoescola, t.tipo " +
            "  from escola e join tipoescola t on (e.tipoescola = t.codigo) " +
            " order by e.nome";
    
    @Override
    public Escola buscar(Escola escola) {
        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_BUSCAR);
            ps.setLong(1, escola.getCodigo());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                long codigo = rs.getLong(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String cidade = rs.getString(4);
                int cep = rs.getInt(5);
                byte ddd = rs.getByte(6);
                String telefone = rs.getString(7);
                long codigoTipoEscola = rs.getLong(8);
                String tipo = rs.getString(9);
                
                TipoEscola tipoEscola = new TipoEscola(codigoTipoEscola, tipo);
                
                Escola escolaBuscada = new Escola(codigo, nome, endereco, 
                        cidade, cep, ddd, telefone, tipoEscola);
                
                return escolaBuscada;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao buscar registro de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public boolean inserir(Escola escola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Escola escola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Escola escola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<Escola> listaEscola;
    
    @Override
    public ArrayList<Escola> getLista() {
        if (listaEscola == null)
            listaEscola = new ArrayList<>();
        else
            listaEscola.clear();

        try {
            Connection con = PostgreSqlDAOFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(SCRIPT_GET_LISTA);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                long codigo = rs.getLong(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String cidade = rs.getString(4);
                int cep = rs.getInt(5);
                byte ddd = rs.getByte(6);
                String telefone = rs.getString(7);
                long codigoTipoEscola = rs.getLong(8);
                String tipo = rs.getString(9);
                
                TipoEscola tipoEscola = new TipoEscola(codigoTipoEscola, tipo);
                
                Escola escola = new Escola(codigo, nome, endereco, 
                        cidade, cep, ddd, telefone, tipoEscola);
                
                listaEscola.add(escola);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao buscar registro de escola.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
