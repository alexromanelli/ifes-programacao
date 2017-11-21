/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.visao;

import controleobi2.modelo.entidade.NivelModalidade;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class ModeloTabelaNivelModalidade extends AbstractTableModel {

    private ArrayList<NivelModalidade> listaNivelModalidade;
    
    private static String[] TITULOS_COLUNAS = {
        "Código",
        "Modalidade",
        "Nível",
        "Eligibilidade"
    };
    
    public ModeloTabelaNivelModalidade(ArrayList<NivelModalidade> lista) {
        listaNivelModalidade = lista;
    }
    
    @Override
    public int getRowCount() {
        return listaNivelModalidade.size();
    }

    @Override
    public int getColumnCount() {
        return TITULOS_COLUNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NivelModalidade nivelModalidade = listaNivelModalidade.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return nivelModalidade.getCodigo();
            case 1:
                return nivelModalidade.getModalidade().getNome();
            case 2:
                return nivelModalidade.getNivel();
            case 3:
                return nivelModalidade.getEligibilidade();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return TITULOS_COLUNAS[column];
    }
    
    
    
}
