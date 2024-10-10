import java.time.LocalDate;
import java.util.Random;

import model.*;

public class ControleEmprestimo {

    private Usuario tempuser = new Usuario(0, "", "");
    private Livro templivro = new Livro(0, "", "");
    private LocalDate tempDate = LocalDate.now();

    RegistroEmprestimo registro = new RegistroEmprestimo(0, tempuser, templivro, tempDate, tempDate);    

    public void registrarEmprestimo(model.Usuario user, model.Livro livro){
        Random rand = new Random();

        Integer ID = rand.nextInt(700, 3500);
        LocalDate dataEmp = LocalDate.now();
        int year = Integer.valueOf(dataEmp.getYear());
        int day = Integer.valueOf(dataEmp.getDayOfYear());
        int daydev = day + 10;
        LocalDate dataDevo = LocalDate.ofYearDay(year, daydev);

        registro.setIdEmprestimo(ID);

        String nome = user.getNome();
        String email = user.getEmail();
        int userID = user.getIdUser();
        registro.setUsuario(userID, nome, email);

        String titulo = livro.getTitulo();
        String autor = livro.getAutor();
        int livroID = livro.getIdLivro();
        registro.setLivro(livroID, titulo, autor);
        
        registro.setDataEmprestimo(dataEmp);
        registro.setDataDevoulucao(dataDevo);

        livro.setDisponibilidade(1);

        System.out.println("======================================================================================");
        System.out.println("ID: "+registro.getIdEmprestimo() + "\n Livro: " + registro.getLivro() +" Emprestado para:"+ registro.getUsuario() +"\n Na data: "+ registro.getDataEmprestimo());
        System.out.println("Para ser devolvido na data: "+registro.getDataDevolucao());
        System.out.println("======================================================================================");

    }

    public void registrarDevolucao(model.Usuario user, model.Livro livro){

         
        LocalDate dataAtual = LocalDate.now();

        livro.setDisponibilidade(0);
        System.out.println("======================================================================================");
        System.out.println(registro.getIdEmprestimo() + "\n Livro: \t" + registro.getLivro() +" Emprestado para: "+ registro.getUsuario() +"\n Na data"+ registro.getDataEmprestimo());
        System.out.println("Sendo a data para devolver: "+registro.getDataDevolucao()+"\n Foi devolvido na data de: "+ dataAtual);
        System.out.println("======================================================================================");

    }

    public ControleEmprestimo(){

    }

}
