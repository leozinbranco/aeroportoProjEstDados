import java.lang.reflect.*;

public class ListaVoos<X> {
   
    private class No
    {
        private Voo info;
        private No prox;

        public No (Voo v, No p)
        {
            this.info = v;
            this.prox = p;
        }

        public No (Voo v)
        {
            this.info = v;
            this.prox = null;
        }

        public Voo getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (Voo v)
        {
            this.info = v;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }

    } //fim da classe No

    private No primeiro, ultimo;

    public ListaVoos() 
    {
		this.primeiro = null;
		this.ultimo   = null;
	}

    public boolean isVazia ()
    {
        return this.primeiro==null/*&&this.ultimo==null*/;
    }
    
    public boolean tem (X i) throws Exception
    {
		if (i==null)
		    throw new Exception ("Informacao ausente");
		
        No atual=this.primeiro;

        while (atual!=null)
        {
            if (i.equals(atual.getInfo()))
                return true;
                
            atual = atual.getProx();
        }
        
        return false;
    }

    public Voo procura(int codigo) throws Exception {
        if (codigo == 0)
            throw new Exception("Informacao ausente3");

        No atual = this.primeiro;

        while (atual != null) {
            if (codigo == (atual.getInfo().getCodigo()))
                return atual.getInfo();

            atual = atual.getProx();
        }

        return null;
    }

    public int getQtd ()
    {
        No  atual=this.primeiro;
        int ret  =0;

        while (atual!=null)
        {
            ret++;                
            atual = atual.getProx();
        }
        
        return ret;
    }
    
    private X meuCloneDeX (X x)
    {
      //return (X)x.clone();

        X ret=null;

        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tiposDosParms = null; // null pq clone nao tem parametros
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null; // null pq clone nao tem parametros
            ret = (X)metodo.invoke(x,parms);
        }
        catch (Exception erro)
        {} // pq sei que estou chamando clone de um objeto que é Cloneable e, portanto, nao há risco do método não existir ou de ser chamado com parametros errado

        return ret;
    }
    
    public void insiraNoInicio (Voo v) throws Exception
    {
        if (v==null)
            throw new Exception ("Informacao ausente");

        Voo inserir=null;
        if (v instanceof Cloneable)
            inserir = (Voo)v.clone(); //meuCloneDeX(i);
        else 
            inserir = v;
            
        this.primeiro = new No (inserir,this.primeiro);

        if (this.ultimo==null)
            this.ultimo=this.primeiro;
    }

    public void insiraNoFim (Voo v) throws Exception
    {
        if (v==null)
            throw new Exception ("Informacao ausente");

        Voo inserir=null;
        if (v instanceof Cloneable)
            inserir = (Voo)v.clone();//meuCloneDeX(i);
        else
            inserir = v;
            
        if (this.ultimo==null) // && this.primeiro==null
        {
            this.ultimo   = new No (inserir);
            this.primeiro = this.ultimo;
        }
        else
        {
            this.ultimo.setProx (new No (inserir));
            this.ultimo = this.ultimo.getProx();
        }
    }

    public Voo getDoInicio () throws Exception
    {
        if (this.primeiro==null/*&&this.fim==null)*/)
            throw new Exception ("Nada a obter");

        Voo ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = (Voo)ret.clone(); //meuCloneDeX (ret);
            
        return ret;
    }

    public Voo getDoFim () throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null)*/)
            throw new Exception ("Nada a obter");

        Voo ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = (Voo) ret.clone();//meuCloneDeX (ret);
            
        return ret;
    }

    public void removaDoInicio () throws Exception
    {
        if (this.primeiro==null /*&& this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo) //so 1 elemento
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        this.primeiro = this.primeiro.getProx();
    }
    
    public void removaDoFim () throws Exception
    {
        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo)
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        No atual;
        for (atual=this.primeiro;
             atual.getProx()!=this.ultimo;
             atual=atual.getProx())
             /*comando vazio*/;

        atual.setProx(null);
        this .ultimo=atual;
    }
    
    public void remova (Voo v) throws Exception //Remoção de um vôo indicado pelo número;
    {
        if (v==null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Lista vazia");

        if (v.equals(this.primeiro.getInfo()))
        {
            if (this.ultimo==this.primeiro)
                this.ultimo=null;

            this.primeiro=this.primeiro.getProx();

            return;
        }

        No atual=this.primeiro;

        for(;;) // FOR EVER (repete até Exception ou return)
        {
            if (atual.getProx()==null)
                throw new Exception ("Informacao inexistente");

            if (v.equals(atual.getProx().getInfo()))
            {
                if (this.ultimo==atual.getProx())
                    this.ultimo=atual;

                atual.setProx(atual.getProx().getProx());

                return;
            }

            atual=atual.getProx();
        }
    }

    public void remova (int cod) throws Exception //Remoção de um vôo indicado pelo número;
    {
        if (cod==0)
            throw new Exception ("Informacao ausente1");

        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Lista vazia");

        if (cod == this.primeiro.getInfo().getCodigo())
        {
            if (this.ultimo==this.primeiro)
                this.ultimo=null;

            this.primeiro=this.primeiro.getProx();

            return;
        }

        No atual=this.primeiro;

        for(;;) // FOR EVER (repete até Exception ou return)
        {
            if (atual.getProx()==null)
                throw new Exception ("Informacao inexistente");  //acabou

            if (cod == atual.getInfo().getCodigo())
            {
                if (this.ultimo==atual.getProx())  //verofica se atual é o penúltimo, caso for:
                    this.ultimo=atual;              //substitui o atual(removido) pelo ultimo

                atual.setProx(atual.getProx().getProx());   //

                return;
            }

            atual=atual.getProx();
        }
    }
	
    // exercicio que deixado para ser feito; feito!
    public void invertaSe ()
    {
		if (this.primeiro==null)
		    return; // lista vazia; nao há o que inverter
		    
		if (this.primeiro.getProx() == null)
		    return; // lista com um elemento só; nao ha o que inverter
		    
		// tendo 2 ou mais nós, percorre invertendo
        No anterior=null, atual=this.primeiro, seguinte=atual.getProx();
        while (seguinte!=null)
        {
			atual.setProx (anterior);
			anterior = atual;
			atual    = seguinte;
			seguinte = seguinte.getProx();
		}
		
		// this.primeiro vira this.ultimo e vice-versa 
		No   backup   = this.primeiro;
		this.primeiro = this.ultimo;
		this.ultimo   = backup;
    }
	
    // exercicio que deixado para ser feito; feito!
    public ListaVoos<X> inversao ()
    {
        ListaVoos<X> ret = new ListaVoos<X> ();
        
        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
            // preferi nao usar this.insiraNoInicio pelo bem da eficiencia,
            // economizando tempo, deixando de validar, e economizando
            // memória e tempo, deixando de clonar; e fica a pergunta:
            // entendem porque não é necessario clonar? Nao entendendo,
            // monitoria!
            ret.primeiro = new No (atual.getInfo(),ret.primeiro);

        return ret;
	}
	
	public String toString ()
    {
        String ret="[";

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret=ret+atual.getInfo().toString();

            if (atual!=this.ultimo)
                ret=ret+", \n";

            atual=atual.getProx();
        }

        return ret+"]";
    }
    
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

            ListaVoos<X> lista =
       (ListaVoos<X>)obj;

        No atualThis =this .primeiro;
        No atualLista=lista.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null  /* && atualLista==null */)
            return false;

        if (atualLista!=null /* && atualThis ==null */)
            return false;

        // atualThis==null && atualLista==null
        return true;
    }

    public int hashCode ()
    {
        final int PRIMO = 13; // qualquer número primo serve
        
        int ret=666; // qualquer inteiro positivo serve

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
             ret = 17*ret + atual.getInfo().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    // construtor de copia
    public ListaVoos (ListaVoos<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return; // sai do construtor, pq this.primeiro ja é null

        this.primeiro = new No (modelo.primeiro.getInfo());

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx (new No (atualDoModelo.getInfo()));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone ()
    {
        ListaVoos<X> ret=null;

        try
        {
            ret = new ListaVoos (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}
