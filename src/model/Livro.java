package model;

public class Livro {
    private Integer idlivro;
    private String titulo;
    private String autor;
    private Boolean disponivel;

    //get set de id

    public void setIdLivro(Integer insert) {
        this.idlivro = insert;
    }
    public Integer getIdLivro() {
        return idlivro;
    }

    //get set de titulo

    public void setTitulo(String tituloIns) {
        this.titulo = tituloIns;
    }
    public String getTitulo() {
        return titulo;
    }

    //get set de autor

    public void setAutor(String autorIns) {
        this.autor = autorIns;
    }
    public String getAutor() {
        return autor;
    }

    //get set de disponivel

    public void setDisponibilidade(int emp){
        //se ele for emprestado(1), definido pelo integer que recebe, ele retorna false pois ja foi emprestado
        if (emp == 1) {
            this.disponivel = false;
        } else {
            this.disponivel = true;
        }
    }
    public boolean getDispo(){
        return disponivel;
    }

    //construtor
    
    public Livro(int idIns, String tituloIns, String autorIns){
        this.idlivro = idIns;
        this.titulo = tituloIns;
        this.autor = autorIns;
    }

}
