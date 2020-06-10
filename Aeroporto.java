public class Aeroporto {
    private String city;
    private String siglaAer;
    private int codAer;
    private ListaVoos voos; 

    public Aeroporto (String city,String siglaAer, ListaVoos voos, int cod)
    {
        setCity(city);
        setSiglaAer(siglaAer);
        setVoos(voos);
        setCod(cod);
    }

    public void setCity(String city){
        this.city = city;
    }

    
    public void setSiglaAer(String siglaAer){
        this.siglaAer = siglaAer;
    }

    public void setVoos(ListaVoos voos){
        this.voos = voos;
    }

    public void setCod(int cod){
        this.codAer = cod;
    }

    public ListaVoos getListVoos(){
        return this.voos;
    }

    public String getCity(){
        return this.city;
    }

    public String getSiglaAer(){
        return this.siglaAer;
    }

    public int getCod(){
        return this.codAer;
    }

    public String toString(){
        String ret = "";
        ret = siglaAer + ", " + city;
        return ret;   
    }

    public int hashCode(){
        final int PRIMO = 13; 

        int ret = 2;

        ret = ret*PRIMO + this.city.hashCode();
        ret = ret*PRIMO + this.siglaAer.hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.city==null || modelo.codAer == 0 || modelo.siglaAer==null || modelo.voos == null)
            return; // sai do construtor, pq this.primeiro ja � null

        this.setCity(modelo.city); 
        this.setCod(modelo.codAer);
        this.setSiglaAer(modelo.siglaAer);
        this.setVoos(modelo.voos); 
        
    }

    public Object clone ()
    {
        Aeroporto ret=null;

        try
        {
            ret = new Aeroporto(this); //(city, siglaAer, voos, cod);
        }
        catch (Exception erro)
        {} // sei que this NUNCA � null e o contrutor de copia da erro quando seu parametro � null

        return ret;
    }


}