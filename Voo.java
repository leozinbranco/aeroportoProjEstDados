public class Voo {

    private Aeroporto aeroporto;
    //private X info
    private Integer codigo;
    

    public Voo(Aeroporto aeroporto, Integer codigo) {
        this.aeroporto = aeroporto;
        this.codigo = codigo;
    }

    public Aeroporto getAeroporto() {
        return this.aeroporto;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setAerporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public void setCodigo(Integer cod) {
        this.codigo = cod;
    }
 
     //fim da classe Voos

}