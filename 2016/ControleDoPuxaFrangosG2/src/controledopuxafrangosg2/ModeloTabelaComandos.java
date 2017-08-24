package controledopuxafrangosg2;

import controledopuxafrangosg2.dados.Comando;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romanelli
 */
public class ModeloTabelaComandos extends AbstractTableModel {

    private static String[] TITULOS_COLUNAS = {
        "Sequencial", "Tipo", "Parametro"
    };
    
    private ArrayList<Comando> listaComandos;
    
    public ModeloTabelaComandos(ArrayList<Comando> dados) {
        listaComandos = dados;
    }

    @Override
    public String getColumnName(int column) {
        return TITULOS_COLUNAS[column];
    }
    
    @Override
    public int getRowCount() {
        return listaComandos.size();
    }

    @Override
    public int getColumnCount() {
        return TITULOS_COLUNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comando c = listaComandos.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getSequencial();
            case 1: return c.getTipo();
            case 2: return c.getParametro();
            default: return null;
        }
    }
    
}
