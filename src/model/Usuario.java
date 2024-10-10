package model;

import java.util.ArrayList;

public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String email;
    private ArrayList<Livro> emprestados = new ArrayList<Livro>();

    //get set de id

    public void setIdUser(Integer insert) {
        this.idUsuario = insert;
    }
    public Integer getIdUser() {
        return idUsuario;
    }

    //get set de email

    public void setEmail(String emaio) {
        this.email = emaio;
    }
    public String getEmail() {
        return email;
    }


    //get set de nome

    public String getNome() {
        return nome;
    }
    public void setNome(String nom) {
        this.email = nom;
    }

    //get set de lista de emprestados
    public void setEmprestados(Livro livro){
        this.emprestados.add(livro);
    }
    public ArrayList getEmprestados(){
        return emprestados;
    }

    //construtor

    public Usuario(Integer id, String nom, String emai){
        this.email = emai;
        this.nome = nom;
        this.idUsuario = id;
    }

    //construtor

}
