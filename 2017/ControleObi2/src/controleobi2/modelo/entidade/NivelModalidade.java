/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.modelo.entidade;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class NivelModalidade {
    private long codigo;
    private Modalidade modalidade;
    private String nivel;
    private String eligibilidade;

    public NivelModalidade(long codigo, Modalidade modalidade, String nivel, String eligibilidade) {
        this.codigo = codigo;
        this.modalidade = modalidade;
        this.nivel = nivel;
        this.eligibilidade = eligibilidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEligibilidade() {
        return eligibilidade;
    }

    public void setEligibilidade(String eligibilidade) {
        this.eligibilidade = eligibilidade;
    }
    
}
