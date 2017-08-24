/*
 * Se for usar este código, cite o autor.
 */
package controleobi;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class NivelModalidade {
    private int codigo;
    private String nivel;
    private String eligibilidade;
    private Modalidade modalidade;
    
    public NivelModalidade(int codigo, String nivel, String eligibilidade,
            Modalidade modalidade) {
        this.codigo = codigo;
        this.nivel = nivel;
        this.eligibilidade = eligibilidade;
        this.modalidade = modalidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    
}
