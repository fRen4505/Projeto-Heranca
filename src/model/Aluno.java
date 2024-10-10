package model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;

        //get set de curso

    public void setCurso(String curso){
        this.curso = curso;
    }
    public String GetCurso() {
        return curso;
    }

    //get set de matricula

    public void setMatri(String matri){
        this.matricula = matri;
    }
    public String GetMatri() {
        return matricula;
    }

    //construtor
    public Aluno(Integer id, String nom, String emai, String matri, String cur){
        super(id, nom, emai);
        this.matricula = matri;
        this.curso = cur;
    }
}
