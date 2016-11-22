/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos.dao;

import controledopuxafrangos.dados.ListaComandos;
import java.util.ArrayList;

/**
 *
 * @author romanelli
 */
public interface ListaComandosDAO {
    public ArrayList<ListaComandos> selecionarTodas();
    public ListaComandos selecionarPorId(long id);
    public boolean inserir(ListaComandos lc);
    public boolean alterar(ListaComandos lc);
    public boolean excluir(ListaComandos lc);
}
