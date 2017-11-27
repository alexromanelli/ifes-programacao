/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.dao.pg;

import controleobi2.modelo.dao.NivelModalidadeDAO;
import controleobi2.modelo.entidade.Modalidade;
import controleobi2.modelo.entidade.NivelModalidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class PgNivelModalidadeDAO implements NivelModalidadeDAO {

    @Override
    public NivelModalidade buscar(NivelModalidade nivelModalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
                              "select nm.modalidade, nm.nivel, nm.eligibilidade, "
                            + "       m.nome, m.descricao "
                            + "from nivelmodalidade nm "
                            + "     join modalidade m on (nm.modalidade = m.codigo) "
                            + "where nm.codigo = ?");
            ps.setLong(1, nivelModalidade.getCodigo());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                long codigoModalidade = rs.getLong(1);
                String nivel = rs.getString(2);
                String eligibilidade = rs.getString(3);
                String nomeModalidade = rs.getString(4);
                String descricaoModalidade = rs.getString(5);
                
                Modalidade modalidade = new Modalidade(codigoModalidade, 
                        nomeModalidade, descricaoModalidade);
                
                NivelModalidade nivelModalidadeProcurado = 
                        new NivelModalidade(nivelModalidade.getCodigo(),
                                modalidade, nivel, eligibilidade);
                
                return nivelModalidadeProcurado;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao obter registro de nível de modalidade.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public boolean inserir(NivelModalidade nivelModalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
                            "insert into nivelmodalidade "
                            + "(modalidade, nivel, eligibilidade) values (?, ?, ?)");
            ps.setLong(1, nivelModalidade.getModalidade().getCodigo());
            ps.setString(2, nivelModalidade.getNivel());
            ps.setString(3, nivelModalidade.getEligibilidade());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao inserir registro de nível de modalidade.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean alterar(NivelModalidade nivelModalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
                            "update nivelmodalidade "
                            + "set modalidade = ?, nivel = ?, eligibilidade = ? "
                            + "where codigo = ?");
            ps.setLong(1, nivelModalidade.getModalidade().getCodigo());
            ps.setString(2, nivelModalidade.getNivel());
            ps.setString(3, nivelModalidade.getEligibilidade());
            ps.setLong(4, nivelModalidade.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao alterar registro de nível de modalidade.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean excluir(NivelModalidade nivelModalidade) {
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
                            "delete from nivelmodalidade where codigo = ?");
            ps.setLong(1, nivelModalidade.getCodigo());
            
            int resultado = ps.executeUpdate();
            
            return resultado == 1;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao excluir registro de nível de modalidade.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private ArrayList<NivelModalidade> listaModalidade;
    
    @Override
    public ArrayList<NivelModalidade> getLista() {
        if (listaModalidade == null)
            listaModalidade = new ArrayList<>();
        else
            listaModalidade.clear();
        
        try {
            PreparedStatement ps = 
                    PostgreSqlDAOFactory.getConnection().prepareStatement(
                              "select nm.codigo, nm.modalidade, nm.nivel, "
                            + "       nm.eligibilidade, m.nome, m.descricao "
                            + "from nivelmodalidade nm "
                            + "     join modalidade m on (nm.modalidade = m.codigo) "
                            + "order by nm.nivel");
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long codigo = rs.getLong(1);
                long codigoModalidade = rs.getLong(2);
                String nivel = rs.getString(3);
                String eligibilidade = rs.getString(4);
                String nomeModalidade = rs.getString(5);
                String descricaoModalidade = rs.getString(6);
                
                Modalidade modalidade = new Modalidade(codigoModalidade, 
                        nomeModalidade, descricaoModalidade);
                
                NivelModalidade nivelModalidade = 
                        new NivelModalidade(codigo, modalidade, nivel, 
                                eligibilidade);
                
                listaModalidade.add(nivelModalidade);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao obter registros de nível de modalidade.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return listaModalidade;
    }
    
}
