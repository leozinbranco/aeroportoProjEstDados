import java.lang.reflect.Method;

public class Pilha <X>
{
    private ListaSimplesDesordenada<X> elementos;

    public Pilha ()
    {
        this.elementos = new ListaSimplesDesordenada<X> ();
    }

    public void guardeUmItem (X x) throws Exception
    {
        if (x==null)
            throw new Exception ("Falta o que guardar");

        this.elementos.insiraNoInicio (x);
    }

    public X recupereUmItem () throws Exception
    {
        if (this.elementos.isVazia())
            throw new Exception ("Nada a recuperar");

        return this.elementos.getDoInicio();
    }

    public void removaUmItem () throws Exception
    {
        if (this.elementos.isVazia())
            throw new Exception ("Nada a remover");

        this.elementos.removaDoInicio();
    }

    public boolean isVazia ()
    {
        return this.elementos.isVazia();
    }

    public String tostring()
    {
        String ret = this.elementos.getQtd() + " elementos";
        
        try
		{
            ret += ", sendo o ultimo "+this.elementos.getDoInicio();
        }
        catch (Exception erro)
        {} // se der erro, nao quero nada acrescentar ao ret
              
        return ret;
    }

    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Pilha<X> pil = (Pilha<X>) obj;

        if(this.elementos.equals (pil.elementos))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666/*qualquer positivo*/;

        ret = ret*7/*primo*/ + this.elementos.hashCode();

        if (ret<0)
            ret=-ret;

        return ret;
    }

    public Pilha(Pilha<X> modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("modelo ausente");

        this.elementos = new ListaSimplesDesordenada<X> (modelo.elementos);
    }

    public Object clone()
    {
        Pilha<X> ret = null;

        try
        {
            ret  = new Pilha(this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}
