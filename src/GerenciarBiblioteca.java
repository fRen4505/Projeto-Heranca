import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GerenciarBiblioteca {

    public static void main(String[] args) {

        String opc;

        java.util.Scanner scan = new Scanner(System.in);
        java.util.Random rand = new Random();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ControleEmprestimo emprestimo = new ControleEmprestimo();
        
        do{
            System.out.println("\t LIVROS:");
            for (Livro l : livros) {
                System.out.print("\n =>Livro: "+l.getTitulo() + "\n -Disponivel: "+l.getDispo()+"\n");
            }

            
            System.out.println("\n \t USUARIOS:");
            for (Usuario u : usuarios) {
                System.out.println("\n =>Usuario: "+u.getNome()+"\n -Emprestados: "+u.getEmprestados().toString());
            }
            
            System.out.println("\t \t ==>OPCOES<==");
            System.out.println("\n C.cadastrar-se \t L.cadastrar Livro \t E.emprestar \t S.sair \n");
            opc = scan.nextLine();

            switch (opc) {
                case "c":
                    System.out.println("\t => CADASTRO DE USUARIO");
                    String name;
                    String email;
                    String opuser;
                    int usID = rand.nextInt(10,900);

                    System.out.println("Digite seu nome");
                    name = scan.nextLine();

                    System.out.println("Digite seu email");
                    email = scan.nextLine();

                    System.out.println("Digite sua função entre: \n A.aluno \t P.professor \t F.funcionario");
                    opuser = scan.nextLine();
                    switch (opuser) {
                        case "a":
                            String matricula;
                            System.out.println("digite sua matricula");
                            matricula = scan.nextLine();

                            String curso;
                            System.out.println("digite seu curso");
                            curso = scan.nextLine();

                            Aluno aluno = new Aluno(usID, name, email, matricula, curso);
                            
                            usuarios.add(aluno);

                            break;
                        case "p":
                            String departamento;
                            System.out.println("digite seu departamento");
                            departamento = scan.nextLine();

                            String titulo;
                            System.out.println("digite seu titulo");
                            titulo = scan.nextLine();

                            Professor profe = new Professor(usID, name, email, departamento, titulo);

                            usuarios.add(profe);
                            break;
                        case "f":
                            String cargo;
                            System.out.println("digite seu cargo");
                            cargo = scan.nextLine();

                            String setor;
                            System.out.println("digite seu setor");
                            setor = scan.nextLine();

                            Funcionario funcio = new Funcionario(usID, name, email, cargo, setor);
                            
                            usuarios.add(funcio);
                            break;
                    
                        default:
                            break;
                    }
                    break;

                case "l":
                    System.out.println("\t =>CADASTRO DE LIVROS");
                    int ID = rand.nextInt(1000, 100000);
                    String titulo;
                    String autor;

                    System.out.println("Digite titulo do livro");
                    titulo = scan.nextLine();
                    System.out.println("Digite autor");
                    autor = scan.nextLine();

                    Livro livro = new Livro(ID, titulo, autor);

                    livro.setDisponibilidade(0);

                    livros.add(livro);

                    break;
                case "e":
                    System.out.println("\t =>EMPRESTAR E DEVOLUCAO DE LIVROS");
                    
                    String user;
                    System.out.println("Digite seu usuario");
                    user = scan.nextLine();

                    String eopc;
                    System.out.println("Deseja \n E.emprestar livro \t D.devolver livro");
                    eopc = scan.nextLine();
                    switch (eopc) {
                        case "e":
                            for (Usuario us : usuarios) {
                                if (us.getNome().equals(user)) {
                                    String usLivro;
                                    System.out.println("Digite o nome do livro que procura");
                                    usLivro = scan.nextLine();
                                    for (Livro ls : livros) {
                                        if (ls.getTitulo().equals(usLivro)) {
                                            emprestimo.registrarEmprestimo(us, ls);
                                            us.setEmprestados(ls);
                                        } 
                                    }
                                    break;
                                }else{
                                    System.out.println("Usuario não achado");
                                }
                            }
                            break;
                        case "d": 
                            for (Usuario us : usuarios) {
                                if (us.getNome().equals(user)) {
                                    String usLivro;
                                    System.out.println("Digite o nome do livro que deseja devolver");
                                    usLivro = scan.nextLine();
                                    for (Livro ls : livros) {
                                        if (us.getEmprestados().contains(ls)) {
                                            emprestimo.registrarDevolucao(us, ls);
                                            us.getEmprestados().remove(ls);
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        } while(!opc.equals("s"));
        
        scan.close();
    }
}
