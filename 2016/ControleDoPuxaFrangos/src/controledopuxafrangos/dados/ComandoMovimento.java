package controledopuxafrangos.dados;

/**
 *
 * @author romanelli
 */
public class ComandoMovimento extends Comando {
    
    private int x;
    private int y;
    private int z;

    public ComandoMovimento(int sequencial, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        super.setSequencial(sequencial);
    }

    public ComandoMovimento(long id, ListaComandos lista, int sequencial, 
            int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        super.setLista(lista);
        super.setSequencial(sequencial);
        super.setId(id);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String obterStringComando() {
        String comando = "";
        // implementar...
        return comando;
    }

    @Override
    public String obterTipoComando() {
        return "Posicionar base da garra";
    }
    
    
}
