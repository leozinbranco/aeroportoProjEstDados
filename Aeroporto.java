public class Aeroporto {
    private String city;
    private String siglaAer;

    public Aeroporto(String city,String siglaAer)
    {
        setCity(city);
        setSiglaAer(siglaAer);
    }

    public void setCity(String city){
        this.city = city;
    }

    
    public void setSiglaAer(String siglaAer){
        this.siglaAer = siglaAer;
    }

    public String getCity(){
        return this.city;
    }

    public String getSiglaAer(){
        return this.siglaAer;
    }

    public String toString(){
        String ret = "";
        ret = siglaAer + ", " + city;
        return ret;   
    }

    public int hashCode(){
        final int PRIMO = 13; 

        int ret = 2;

        ret = ret*7 + Integer(Integer.parseInt(this.city)).hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }
}