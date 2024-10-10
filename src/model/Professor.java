package model;

public class Professor extends Usuario {
    private String departamento;
    private String titulação;

    //get set departamento

    public String getDeparta(){
        return departamento;
    }

    public void setDeparta(String depar){
        this.departamento = depar;
    }

    //get set titulação

    public String getTitula(){
        return titulação;
    }

    public void setTitula(String titulo){
        this.titulação = titulo;
    }

    //construtor

    public Professor(Integer id, String nom, String emai, String depar, String titulo){
        super(id, nom, emai);
        this.departamento = depar;
        this.titulação = titulo;
    }

}
