package controledopuxafrangos.dados;

import java.util.ArrayList;

/**
 *
 * @author romanelli
 */
public class ListaComandos {
    private long id;
    private String nome;
    private ArrayList<Comando> lista;

    public ListaComandos(long id, String nome, ArrayList<Comando> lista) {
        this.id = id;
        this.nome = nome;
        this.lista = lista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Comando> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Comando> lista) {
        this.lista = lista;
    }
    
}
