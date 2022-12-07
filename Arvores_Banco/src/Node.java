public class Node {
    
    int info;
    Node esq;
    Node dir;
    int Valor;

    public Node(int info){
        this.info = info;
        this.esq = null;
        this.dir = null;

    }


    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getEsq() {
        return this.esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return this.dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }

    public int getValor() {
        return this.Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    
    
}
