package controller;

import model.ModelParadas;
import DAO.DAOParadas;
import java.util.ArrayList;

public class ControllerParadas {

    private DAOParadas daoParadas = new DAOParadas();

    /**
     * grava Cadastra uma nova parada no sistema
     *
     * @param pModelParadas return int
     */
    public int salvarCadastroParada(ModelParadas pModelParadas) {
        return this.daoParadas.salvarCadastroParada(pModelParadas);
    }

    public ArrayList<ModelParadas> retornarListaParadasController(String etapa, String recurso) {
        return this.daoParadas.getListaParadasDAO(etapa, recurso);
    }

    public ArrayList<ModelParadas> retornarListaParadasGeralController(String etapa, String recurso) {
        return this.daoParadas.getListaParadasGeralDAO(etapa, recurso);
    }

    public ModelParadas retornarListaParadasController(int pCodigo) {
        return this.daoParadas.retornarParadasDAO(pCodigo);
    }

    public boolean atualizarParadasController(ModelParadas pModelParadas) {
        return this.daoParadas.atualizarParadasDAO(pModelParadas);
    }

    public boolean excluirCadastroParadas(int pIdParada) {
        return this.daoParadas.excluirProducaoDAO(pIdParada);
    }

}
