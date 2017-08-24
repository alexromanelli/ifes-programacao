package controledopuxafrangos;

import controledopuxafrangos.dados.ComandoMovimento;
import controledopuxafrangos.dados.Comando;
import controledopuxafrangos.dados.ComandoGarra;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author romanelli
 */
public class ModeloTabelaComandos extends AbstractTableModel {

    private ArrayList<Comando> listaComandos;
    private static final int QUANTIDADE_COLUNAS_TABELA = 3;
    private static final String[] TITULOS_COLUNAS = {
        "Sequencial",
        "Tipo",
        "Parametro"
    };

    public ModeloTabelaComandos(ArrayList<Comando> listaComandos) {
        this.listaComandos = listaComandos;
    }

    public ArrayList<Comando> getListaComandos() {
        return listaComandos;
    }

    public void setListaComandos(ArrayList<Comando> listaComandos) {
        this.listaComandos = listaComandos;
    }

    @Override
    public int getRowCount() {
        return listaComandos.size();
    }

    @Override
    public int getColumnCount() {
        return QUANTIDADE_COLUNAS_TABELA;
    }

    @Override
    public String getColumnName(int column) {
        return TITULOS_COLUNAS[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comando c = listaComandos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getSequencial();
            case 1:
                return c.obterTipoComando();
            case 2:
                if (c instanceof ComandoGarra) {
                    return Integer.toString(((ComandoGarra) c).getAngulo());
                } else if (c instanceof ComandoMovimento) {
                    return "(" + ((ComandoMovimento) c).getX() + ", "
                            + ((ComandoMovimento) c).getY() + ", "
                            + ((ComandoMovimento) c).getZ() + ")";
                }
            default:
                return null;
        }
    }

}
