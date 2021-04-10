package model;

public class ModelEtapas {

    private int idEtapa;
    private String descricao;

    public ModelEtapas() {
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "modelEtapas {" + "::idEtapa = " + this.idEtapa + "::descricao = " + this.descricao +"}";
    }

}
