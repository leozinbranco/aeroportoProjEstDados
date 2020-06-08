import java.lang.reflect.*;

public class ListaAeroporto <Aeroporto> {
    private class No {
        private Aeroporto info; // Aeroporto
        
        private No prox;

        public No(Aeroporto i, No p) {
            this.info = i;
            this.prox = p;
        }

        public No(Aeroporto i) {
            this.info = i;
            this.prox = null;
        }

        public Aeroporto getInfo() {
            return this.info;
        }

        public No getprox() {
            return this.prox;
        }

        public void setInfo(Aeroporto i) {
            this.info = i;
        }

        public void setProx(No p) {
            this.prox = p;
        }
    } // fim da classe No

    private No primeiro, ultimo;

    public ListaAeroporto
    () {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean isVazia() {
        return this.primeiro == null/* &&this.ultimo==null */;
    }

    public boolean tem(Aeroporto i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        No atual = this.primeiro;

        while (atual != null) {
            if (i.equals(atual.getInfo()))
                return true;

            atual = atual.getprox();
        }

        return false;
    }

    public int getQtd() {
        No atual = this.primeiro;
        int ret = 0;

        while (atual != null) {
            ret++;
            atual = atual.getprox();
        }

        return ret;
    }

    private Aeroporto meuCloneDeAeroporto (Aeroporto Aeroporto) {
        // return (Aeroporto)Aeroporto.clone();

        Aeroporto
        ret = null;

        try {
            Class<?> classe = Aeroporto.getClass();
            Class<?>[] tiposDosParms = null; // null pq clone nao tem parametros
            Method metodo = classe.getMethod("clone", tiposDosParms);
            Object[] parms = null; // null pq clone nao tem parametros
            ret = (Aeroporto) metodo.invoke(Aeroporto, parms);
        } catch (Exception erro) {
        } // pq sei que estou chamando clone de um objeto que � Cloneable e, portanto, nao
          // h� risco do m�todo n�o eAeroporto
         //istir ou de ser chamado com parametros
          // errado

        return ret;
    }

    public void insiraNoInicio(Aeroporto
     i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        Aeroporto inserir = null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeAeroporto(i);
        else
            inserir = i;

        this.primeiro = new No(inserir, this.primeiro);

        if (this.ultimo == null)
            this.ultimo = this.primeiro;
    }

    public void insiraNoFim(Aeroporto i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        Aeroporto inserir = null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeAeroporto(i);
        else
            inserir = i;

        if (this.ultimo == null) // && this.primeiro==null
        {
            this.ultimo = new No(inserir);
            this.primeiro = this.ultimo;
        } else {
            this.ultimo.setProx(new No(inserir));
            this.ultimo = this.ultimo.getprox();
        }
    }

    public Aeroporto getDoInicio() throws Exception {
        if (this.primeiro == null/* &&this.fim==null) */)
            throw new Exception("Nada a obter");

        Aeroporto ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeAeroporto(ret);

        return ret;
    }

    public Aeroporto getDoFim() throws Exception {
        if (this.primeiro == null/* &&this.ultimo==null) */)
            throw new Exception("Nada a obter");

        Aeroporto ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeAeroporto(ret);

        return ret;
    }

    public void removaDoInicio() throws Exception {
        if (this.primeiro == null /* && this.ultimo==null */)
            throw new Exception("Nada a remover");

        if (this.primeiro == this.ultimo) // so 1 elemento
        {
            this.primeiro = null;
            this.ultimo = null;
            return;
        }

        this.primeiro = this.primeiro.getprox();
    }

    public void removaDoFim() throws Exception {
        if (this.primeiro == null/* &&this.ultimo==null */)
            throw new Exception("Nada a remover");

        if (this.primeiro == this.ultimo) {
            this.primeiro = null;
            this.ultimo = null;
            return;
        }

        No atual;
        for (atual = this.primeiro; atual.getprox() != this.ultimo; atual = atual.getprox())
            /* comando vazio */;

        atual.setProx(null);
        this.ultimo = atual;
    }

    public void remova(Aeroporto i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        if (this.primeiro == null/* &&this.ultimo==null */)
            throw new Exception("Lista vazia");

        if (i.equals(this.primeiro.getInfo())) {
            if (this.ultimo == this.primeiro)
                this.ultimo = null;

            this.primeiro = this.primeiro.getprox();

            return;
        }

        No atual = this.primeiro;

        for (;;) // FOR EVER (repete at� Exception ou return)
        {
            if (atual.getprox() == null)
                throw new Exception("Informacao Aeroporto inexistente");

            if (i.equals(atual.getprox().getInfo())) {
                if (this.ultimo == atual.getprox())
                    this.ultimo = atual;

                atual.setProx(atual.getprox().getprox());

                return;
            }

            atual = atual.getprox();
        }
    }

    
    public void invertaSe() {
        if (this.primeiro == null)
            return; // lista vazia; nao h� o que inverter

        if (this.primeiro.getprox() == null)
            return; // lista com um elemento s�; nao ha o que inverter

        // tendo 2 ou mais n�s, percorre invertendo
        No anterior = null, atual = this.primeiro, seguinte = atual.getprox();
        while (seguinte != null) {
            atual.setProx(anterior);
            anterior = atual;
            atual = seguinte;
            seguinte = seguinte.getprox();
        }

        // this.primeiro vira this.ultimo e vice-versa
        No backup = this.primeiro;
        this.primeiro = this.ultimo;
        this.ultimo = backup;
    }

    public ListaAeroporto<Aeroporto> inversao() {
        ListaAeroporto<Aeroporto> ret = new ListaAeroporto <Aeroporto>();

        for (No atual = this.primeiro; atual != null; atual = atual.getprox())
            // preferi nao usar this.insiraNoInicio pelo bem da eficiencia,
            // economizando tempo, deiAeroporto
            //ando de validar, e economizando
            // mem�ria e tempo, deiAeroporto
            //ando de clonar; e fica a pergunta:
            // entendem porque n�o � necessario clonar? Nao entendendo,
            // monitoria!
            ret.primeiro = new No(atual.getInfo(), ret.primeiro);

        return ret;
    }

    public String toString() {
        String ret = "[";

        No atual = this.primeiro;

        while (atual != null) {
            ret = ret + atual.getInfo();

            if (atual != this.ultimo)
                ret = ret + ",";

            atual = atual.getprox();
        }

        return ret + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaAeroporto
        <Aeroporto
        > lista = (ListaAeroporto
        <Aeroporto
        >) obj;

        No atualThis = this.primeiro;
        No atualLista = lista.primeiro;

        while (atualThis != null && atualLista != null) {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis = atualThis.getprox();
            atualLista = atualLista.getprox();
        }

        if (atualThis != null /* && atualLista==null */)
            return false;

        if (atualLista != null /* && atualThis ==null */)
            return false;

        // atualThis==null && atualLista==null
        return true;
    }

    public int hashCode() {
        final int PRIMO = 13; // qualquer n�mero primo serve

        int ret = 666; // qualquer inteiro positivo serve

        for (No atual = this.primeiro; atual != null; atual = atual.getprox())
            ret = 17 * ret + atual.getInfo().hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    // construtor de copia
    public ListaAeroporto
    (ListaAeroporto
    <Aeroporto
    > modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");

        if (modelo.primeiro == null)
            return; // sai do construtor, pq this.primeiro ja � null

        this.primeiro = new No(modelo.primeiro.getInfo());

        No atualDoThis = this.primeiro;
        No atualDoModelo = modelo.primeiro.getprox();

        while (atualDoModelo != null) {
            atualDoThis.setProx(new No(atualDoModelo.getInfo()));
            atualDoThis = atualDoThis.getprox();
            atualDoModelo = atualDoModelo.getprox();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone() {
        ListaAeroporto
        <Aeroporto
        > ret = null;

        try {
            ret = new ListaAeroporto
            (this);
        } catch (Exception erro) {
        } // sei que this NUNCA � null e o contrutor de copia da erro quando seu parametro
          // � null

        return ret;
    }

}