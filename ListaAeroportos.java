import java.lang.reflect.*;

public class ListaAeroportos {
    private class No
    {
        private X  info;
        private No prox;

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }

        public No (X i)
        {
            this.info = i;
            this.prox = null;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    } //fim da classe No

    private Aer primeiro;
    private Aer ultimo;
    
    public ListaAeroportos()
    {
        this.primeiro = null;
        this.ultimo = null;
    }

    

}