package controller;

import model.ModelProducao;
import DAO.DAOProducao;
import java.util.ArrayList;

public class ControllerProducao {

    private DAOProducao daoProducao = new DAOProducao();

    /**
     * grava Cadastra uma nova produção no sistema
     *
     * @param pModelProducao return int
     */
    public int salvarCadastroProducao(ModelProducao pModelProducao) {
        return this.daoProducao.salvarCadastroProducao(pModelProducao);
    }

    public ArrayList<ModelProducao> retornarListaProducaoController(String etapa, String recurso) {
        return this.daoProducao.getListaProducaoDAO(etapa, recurso);
    }
    
    public ArrayList<ModelProducao> retornarListaProducaoGeralController(String etapa, String recurso) {
        return this.daoProducao.getListaProducaoGeralDAO(etapa, recurso);
    }    

    public ModelProducao retornarListaProducaoController(int pCodigo) {
        return this.daoProducao.retornarProdutosDAO(pCodigo);
    }

    public boolean atualizarProducaoController(ModelProducao pModelProducao) {
        return this.daoProducao.atualizarProducaoDAO(pModelProducao);
    }

    public boolean excluirCadastroProducao(int pIdProducao) {
        return this.daoProducao.excluirProducaoDAO(pIdProducao);
    }

}
