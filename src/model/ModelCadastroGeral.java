package model;

import java.util.ArrayList;

public class ModelCadastroGeral {

    private int idCadastro;
    private String tipoCadastro;
    private String descricao;

    public ModelCadastroGeral() {
    }

    
    public int getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ModelCadastroGeral {" + "::idCadastro = " + this.idCadastro + "::tipoCadastro = " + this.tipoCadastro + "::descricao = " + this.descricao + "}";
    }
}
