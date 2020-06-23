import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Programa {

    public static void main(String[] args) {

        boolean continuar_execucao = true;
        ListaAeroportos lista_de_aeroportos = new ListaAeroportos();

       // populaDados(lista_de_aeroportos);

        while (continuar_execucao) {

            System.out.println("\nPressione o número da opção que deseja executar: \n");

            System.out.println("1. Cadastramento de um novo aeroporto");
            System.out.println("2. Cadastramento de um vôo");
            System.out.println("3. Remoção de um vôo indicado pelo número;");
            System.out.println("4. Listagem na tela de todos os vôos que saem de um determinado aeroporto");
            System.out.println("5. Listagem na tela dos vôos de todos aeroportos. \n");

            System.out.println("Pressione o número da opção que deseja executar: \n");

            try {
                String a = new BufferedReader(new InputStreamReader(System.in)).readLine();

                // System.out.println(a);

                switch (a) {
                    case "1": {

                        System.out.println("1. Cadastramento de um novo aeroporto");

                        System.out.println("Digite a cidade do aeroporto");
                        String cidade = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        System.out.println("Digite uma sigla para o novo aeroporto");
                        String sigla = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        System.out.println("Digite um codigo para o novo aeroporto");
                        String codigo = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        if (cidade.equals("") || sigla.equals("") || codigo.equals("") ) {
                            System.out.println("Preencha corretamente as informações pedidas");
                            break;
                        }

                        ListaVoos lista_voos_novo_aeroporto = new ListaVoos();

                        Aeroporto novo_aeroporto = new Aeroporto(cidade, sigla, lista_voos_novo_aeroporto,
                                Integer.parseInt(codigo));

                        lista_de_aeroportos.insiraNoFim(novo_aeroporto);

                        System.out.println("Aeroporto inserido com sucesso: \n" );

                        System.out.println(lista_de_aeroportos.toString());

                    }
                        break;
                    case "2": {

                        System.out.println("2. Cadastramento de um vôo");

                        System.out.println("Digite o codigo do aeroporto origem");
                        String codigo_aeroporto_origem = new BufferedReader(new InputStreamReader(System.in))
                                .readLine();

                        System.out.println("Digite o codigo do aeroporto destino");
                        String codigo_aeroporto_destino = new BufferedReader(new InputStreamReader(System.in))
                                .readLine();

                        System.out.println("Digite um codigo para esse voo");
                        String codigo_voo = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        if (codigo_voo == null) {
                            System.out.println("Codigo de nao informado, Preencha corretamente as informações pedidas");
                            break;
                        }

                        Aeroporto aeroporto_origem = lista_de_aeroportos
                                .procura(Integer.parseInt(codigo_aeroporto_origem));

                        if (aeroporto_origem == null) {
                            System.out.println("Codigo do aeroporto ORIGEM invalido");
                            break;
                        }

                        Aeroporto aeroporto_destino = lista_de_aeroportos
                                .procura(Integer.parseInt(codigo_aeroporto_destino));

                        if (aeroporto_destino == null) {
                            System.out.println("Codigo do aeroporto DESTINO invalido");
                            break;
                        }

                        Voo novo_voo = new Voo(aeroporto_destino, Integer.parseInt(codigo_voo));

                        ListaVoos lista_de_voos = aeroporto_origem.getListVoos(); // Lsta de voos do aeroporto origem

                        lista_de_voos.insiraNoFim(novo_voo);

                        System.out.println("Voo inserido com sucesso: \n" + novo_voo);

                        

                    }
                        break;
                    case "3": {

                        System.out.println("3. Remoção de um vôo indicado pelo número;");

                        System.out.println("Digite o codigo do voo a ser excluido");
                        String codigo_voo = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        if (lista_de_aeroportos.excluiVoo(Integer.parseInt(codigo_voo)) == false)
                            System.out.println("Voo nao encontrado em nenhum aeroporto");
                        else
                            System.out.println("Voo excluído com sucesso!");

                    }
                        break;
                    case "4": {

                        System.out.println("4. Listagem na tela de todos os vôos que saem de um determinado aeroporto");

                        System.out.println("Digite o codigo do Aeroporto");
                        String codigo_aeroporto = new BufferedReader(new InputStreamReader(System.in)).readLine();

                        Aeroporto aeroporto_buscado = lista_de_aeroportos.procura(Integer.parseInt(codigo_aeroporto));

                        if (aeroporto_buscado == null) {
                            System.out.println("Código Inválido!");
                        } else {
                            System.out.println("Lista de voos do aeroporto " + aeroporto_buscado.getSiglaAer());
                            System.out.println(aeroporto_buscado.getListVoos().toString());
                        }

                    }
                        break;
                    case "5": {
                        System.out.println("5. Listagem na tela dos vôos de todos aeroportos. \n");
                        System.out.println(lista_de_aeroportos.toString());
                    }
                        break;
                    default: {
                        System.out.print("Opção Inválida!");

                    }
                        break;
                }
                
                System.out.println(" \n [Pressione qualquer tecla para voltar ao menu.] \n");
                new BufferedReader(new InputStreamReader(System.in)).readLine();

            } catch (Exception e) {
                System.out.print(e.getMessage());

                // TODO: handle exception
            }

        }

    }

    public static void populaDados(ListaAeroportos lista) {
        ListaVoos listaVoosBR = new ListaVoos();
        ListaVoos listaVoosBH = new ListaVoos();
        ListaVoos listaVoosRJ = new ListaVoos();
        ListaVoos listaVoosSP = new ListaVoos();
        ListaVoos listaVoosSA = new ListaVoos();

        Aeroporto aerBR = new Aeroporto("Brasíla", "BSB", listaVoosBR, 01);

        Aeroporto aerBH = new Aeroporto("Belo Horizonte", "CNF", listaVoosBH, 02);

        Aeroporto aerRJ = new Aeroporto("Rio de Janeiro", "GIG", listaVoosRJ, 03);

        Aeroporto aerSP = new Aeroporto("São Paulo", "GRU", listaVoosSP, 04);

        Aeroporto aerSA = new Aeroporto("Salvador", "SSA", listaVoosSA, 05);

        Voo voo1BR = new Voo(aerSA, 107); // Voo(onde vai, cod);

        Voo voo1BH = new Voo(aerSA, 214);
        Voo voo2BH = new Voo(aerRJ, 555);
        Voo voo3BH = new Voo(aerSP, 101);

        Voo voo1RJ = new Voo(aerBH, 554);
        Voo voo2RJ = new Voo(aerSP, 90);

        Voo voo1SP = new Voo(aerBR, 50);
        Voo voo2SP = new Voo(aerRJ, 89);
        Voo voo3SP = new Voo(aerBH, 102);

        Voo voo1SA = new Voo(aerBH, 215);

        try {

            lista.insiraNoFim(aerBR);
            lista.insiraNoFim(aerBH);
            lista.insiraNoFim(aerRJ);
            lista.insiraNoFim(aerSP);
            lista.insiraNoFim(aerSA);

            // brasilia
            listaVoosBR.insiraNoFim(voo1BR);

            // BH
            listaVoosBH.insiraNoFim(voo1BH);
            listaVoosBH.insiraNoFim(voo2BH);
            listaVoosBH.insiraNoFim(voo3BH);

            // RJ

            listaVoosRJ.insiraNoFim(voo1RJ);
            listaVoosRJ.insiraNoFim(voo2RJ);

            // sp
            listaVoosSP.insiraNoFim(voo1SP);
            listaVoosSP.insiraNoFim(voo2SP);
            listaVoosSP.insiraNoFim(voo3SP);

            // SA
            listaVoosSA.insiraNoFim(voo1SA);

            // System.out.println("Lista de Aeroportos: ");

        } catch (Exception err) {
            System.err.println(err);
        }

    }

}