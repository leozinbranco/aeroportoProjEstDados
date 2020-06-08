public class Programa
{
    public static void main (String[] args)
    {
		try
		{
			Fila<String> f = new Fila<String> ();
			
			f.guardeUmItem ("C");
			f.guardeUmItem ("C++");
			f.guardeUmItem ("Java");
			
			while (!f.isVazia())
			{
				System.out.println (f.recupereUmItem());
				f.removaUmItem();
			}
        }
        catch (Exception erro)
        {
			System.err.println (erro.getMessage());
		}
    }
}
