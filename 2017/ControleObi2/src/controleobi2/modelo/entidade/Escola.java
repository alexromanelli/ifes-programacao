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
public class Escola {
    private long codigo;
    private String nome;
    private String endereco;
    private String cidade;
    private int cep;
    private byte ddd;
    private String telefone;
    private TipoEscola tipoEscola;

    public Escola(long codigo) {
        this.codigo = codigo;
    }

    public Escola(String nome, String endereco, String cidade, int cep, byte ddd, String telefone, TipoEscola tipoEscola) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.ddd = ddd;
        this.telefone = telefone;
        this.tipoEscola = tipoEscola;
    }

    public Escola(long codigo, String nome, String endereco, String cidade, int cep, byte ddd, String telefone, TipoEscola tipoEscola) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.ddd = ddd;
        this.telefone = telefone;
        this.tipoEscola = tipoEscola;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public byte getDdd() {
        return ddd;
    }

    public void setDdd(byte ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoEscola getTipoEscola() {
        return tipoEscola;
    }

    public void setTipoEscola(TipoEscola tipoEscola) {
        this.tipoEscola = tipoEscola;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Escola)obj).codigo == this.codigo;
    }
    
}
