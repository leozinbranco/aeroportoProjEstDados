public class Aeroporto {
    private String city;
    private String siglaAer;
    private int codAer;
    private ListVoos voos; 

    public Aeroporto (String city,String siglaAer, ListVoos voos, int cod)
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

    public void setVoos(ListVoos voos){
        this.voos = voos;
    }

    public void setCod(int cod){
        this.codAer = cod;
    }

    public ListVoos getListVoos(){
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


}