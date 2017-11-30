/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi2.modelo.entidade;

/**
 *
 * @author alexandre
 */
public class TipoEscola {
    
    private long codigo;
    private String tipo;

    public TipoEscola(long codigo) {
        this.codigo = codigo;
    }

    public TipoEscola(String tipo) {
        this.tipo = tipo;
    }

    public TipoEscola(long codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

    @Override
    public boolean equals(Object obj) {
        return ((TipoEscola)obj).codigo == this.codigo;
    }
    
}
