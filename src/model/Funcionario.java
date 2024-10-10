package model;

public class Funcionario extends Usuario {
    private String cargo;
    private String setor;

    //get set cargo

    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargoIns){
        this.cargo = cargoIns;
    }

    //get set setor

    public String getSetor(){
        return setor;
    }
    public void setSetor(String setorIns){
        this.setor = setorIns;
    }

    //construtor
    public Funcionario(Integer id, String nom, String emai, String cargoIns, String setorIns){
        super(id, nom, emai);
        this.cargo = cargoIns;
        this.setor = setorIns;
    }

}
