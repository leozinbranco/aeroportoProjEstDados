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

    public Voo (Voo modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.codigo==null || modelo.aeroporto == null)
            return; // sai do construtor, pq this.primeiro ja � null

        this.setCodigo(modelo.codigo); 
        this.setAerporto(modelo.aeroporto);
        
    }

    public String toString(){
        String ret = "";
        ret = "Voo "+ this.codigo + "\n Destino: " + this.aeroporto.getCity() + " ( "+ this.aeroporto.getSiglaAer() + " ) " + ",\n "+ "Código do Voo: " + this.codigo;
        return ret;   
    }

    public Object clone()
    {
        Voo ret=null;

        try
        {
            ret = new Voo(this); //(city, siglaAer, voos, cod);
        }
        catch (Exception erro)
        {} // sei que this NUNCA � null e o contrutor de copia da erro quando seu parametro � null

        return ret;
    }
 
     //fim da classe Voos

}