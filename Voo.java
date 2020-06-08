public class Voo {

    private Aeroporto aeroporto;
    private Voo prox;

    public Voo(Aeroporto aeroporto, Voo prox) {
        this.aeroporto = aeroporto;
        this.prox = prox;
    }

    public Voo (Aeroporto aeroporto)
        {
            this.aeroporto = aeroporto;
            this.prox = null;
        }

    public Aeroporto getAeroporto() {
        return this.aeroporto;
    }

    public Voo getProx() {
        return this.prox;
    }

    public void setAerporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public void setProx(Voo prox) {
        this.prox = prox;
    }
       
     //fim da classe Voos


}