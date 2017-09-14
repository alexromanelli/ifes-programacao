/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.visao;

import controleobi2.modelo.entidade.Modalidade;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class ModeloTabelaModalidades extends AbstractTableModel {

    private ArrayList<Modalidade> listaModalidades;
    private static final int QUANTIDADE_COLUNAS_TABELA = 3;
    private static final String[] TITULOS_COLUNAS = {
        "Código",
        "Nome",
        "Descrição"
    };
    
    public ModeloTabelaModalidades(ArrayList<Modalidade> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }
    
    @Override
    public int getRowCount() {
        return listaModalidades.size();
    }

    @Override
    public int getColumnCount() {
        return QUANTIDADE_COLUNAS_TABELA;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Modalidade modalidade = listaModalidades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return modalidade.getCodigo();
            case 1:
                return modalidade.getNome();
            case 2:
                return modalidade.getDescricao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return TITULOS_COLUNAS[column];
    }
    
}
