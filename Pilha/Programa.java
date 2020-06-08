public class Programa
{
    public static void main (String[] args)
    {
		try
		{
			Pilha<String> p = new Pilha<String> ();
			
			p.guardeUmItem ("C");
			p.guardeUmItem ("C++");
			p.guardeUmItem ("Java");
			
			while (!p.isVazia())
			{
				System.out.println (p.recupereUmItem());
				p.removaUmItem();
			}
        }
        catch (Exception erro)
        {
			System.err.println (erro.getMessage());
		}
    }
}
