
public class ProgramaLists {
    public static void main(String[] args) {
        ListaVoos listaVoosBR = new ListaVoos();
        ListaVoos listaVoosBH = new ListaVoos();
        ListaVoos listaVoosRJ = new ListaVoos();
        ListaVoos listaVoosSP = new ListaVoos();
        ListaVoos listaVoosSA = new ListaVoos();

        Aeroporto aerBR  = new Aeroporto("Brasíla", "BSB", listaVoosBR, 01  );

        Aeroporto aerBH  = new Aeroporto("Belo Horizonte", "CNF", listaVoosBH, 02  );

        Aeroporto aerRJ  = new Aeroporto("Rio de Janeiro", "GIG", listaVoosRJ, 03  );

        Aeroporto aerSP = new Aeroporto("São Paulo", "GRU", listaVoosSP, 04  );

        Aeroporto aerSA  = new Aeroporto("Salvador", "SSA", listaVoosSA, 05  );

        Voo voo1BR = new Voo(aerSA, 107);  //Voo(onde vai, cod);

        Voo voo1BH = new Voo(aerSA, 214); 
        Voo voo2BH = new Voo(aerRJ, 555); 
        Voo voo3BH = new Voo(aerSP, 101); 

        Voo voo1RJ = new Voo(aerBH, 554); 
        Voo voo2RJ = new Voo(aerSP, 90); 

        Voo voo1SP = new Voo(aerBR, 50); 
        Voo voo2SP = new Voo(aerRJ, 89); 
        Voo voo3SP = new Voo(aerBH, 102); 

        Voo voo1SA = new Voo(aerBH,215);
        
        ListaAeroportos listaAero = new ListaAeroportos();



        try{


            listaAero.insiraNoFim(aerBR);
            listaAero.insiraNoFim(aerBH);
            listaAero.insiraNoFim(aerRJ);
            listaAero.insiraNoFim(aerSP);
            listaAero.insiraNoFim(aerSA);


            //brasilia
            listaVoosBR.insiraNoFim(voo1BR);

            //BH
            listaVoosBH.insiraNoFim(voo1BH);
            listaVoosBH.insiraNoFim(voo2BH);
            listaVoosBH.insiraNoFim(voo3BH);

            //RJ

            listaVoosRJ.insiraNoFim(voo1RJ);
            listaVoosRJ.insiraNoFim(voo2RJ);

            //sp
            listaVoosSP.insiraNoFim(voo1SP);
            listaVoosSP.insiraNoFim(voo2SP);
            listaVoosSP.insiraNoFim(voo3SP);

            //SA
            listaVoosSA.insiraNoFim(voo1SA);
            

            System.out.println("Lista de Aeroportos: ");
            System.out.println(listaAero.toString());

            /*System.out.println(" \n Voos de Brasília: \n" + listaVoosBR.toString());
            System.out.println(" \n Voos de Belo Horizonte: \n" + listaVoosBH.toString());
            System.out.println(" \n Voos de Rio de Janeiro: \n" + listaVoosRJ.toString());
            System.out.println(" \n Voos de São Paulo: \n" + listaVoosSP.toString());*/
            System.out.println(" \n Voos de Salvador: \n" + listaVoosSA.toString());

            listaVoosSA.remova(215);

            System.out.println(" \n Voos de Salvador: \n" + listaVoosSA.toString());

            
            
        
            
            

        }catch(Exception err)
        {   
            System.err.println(err);
        }
        
        


        
    }
}