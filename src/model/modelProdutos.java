package model;

public class ModelProdutos {

    public ModelProdutos() {
    }

    private int idProduto;
    private String descricao;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "modelProdutos {" + "::idProduto = " + this.idProduto + "::descricao = " + this.descricao + "}";
    }

}
