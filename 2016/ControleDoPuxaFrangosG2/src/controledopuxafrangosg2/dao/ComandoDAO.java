/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2.dao;

import controledopuxafrangosg2.dados.Comando;
import java.util.ArrayList;

/**
 *
 * @author romanelli
 */
public interface ComandoDAO {
    public ArrayList<Comando> selecionarTodosPorIdListaComandos
        (long idListaComandos);
    public Comando selecionarPorId(long id);
    public boolean inserir(Comando c);
    public boolean alterar(Comando c);
    public boolean excluir(Comando c);
}
