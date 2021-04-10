package controller;

import DAO.DAOProdutos;
import java.util.List;
import model.ModelProdutos;

public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();

    /**
     * grava Cadastra um novo produto no sistema
     *
     * @param pModelProdutos return int
     */
    public int salvarCadastroProdutos(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarCadastroProdutos(pModelProdutos);
    }

    public boolean excluirCadastroProduto(int pIdEtapa) {
        return this.daoProdutos.excluirProdutosDAO(pIdEtapa);
    }

    public List<ModelProdutos> getListaProduto() {
        return this.daoProdutos.getListaProdutosDAO();
    }

    public ModelProdutos retornarProdutoController(int pCodigo) {
        return this.daoProdutos.retornarProdutosDAO(pCodigo);
    }

    public boolean atualizarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

}
