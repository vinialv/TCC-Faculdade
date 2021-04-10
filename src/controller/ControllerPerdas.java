package controller;

import model.ModelPerdas;
import DAO.DAOPerdas;
import java.util.ArrayList;

public class ControllerPerdas {

    private DAOPerdas daoPerdas = new DAOPerdas();

    /**
     * grava Cadastra uma nova perda no sistema
     *
     * @param pModelPerdas return int
     */
    public int salvarCadastroPerdas(ModelPerdas pModelPerdas) {
        return this.daoPerdas.salvarCadastroPerdas(pModelPerdas);
    }


    public ArrayList<ModelPerdas> retornarListaPerdasController(String etapa, String recurso) {
        return this.daoPerdas.getListaPerdasDAO(etapa, recurso);
    }

    public ArrayList<ModelPerdas> retornarListaPerdasGeralController(String etapa, String recurso) {
        return this.daoPerdas.getListaPerdasGeralDAO(etapa, recurso);
    }    
    
    public boolean atualizarPerdas(ModelPerdas pModelPerdas) {
        return this.daoPerdas.atualizarPerdasDAO(pModelPerdas);
    }

    public ModelPerdas retornarListaPerdasController(int pCodigo) {
        return this.daoPerdas.retornarPerdasDAO(pCodigo);
    }

    public boolean atualizarPerdasController(ModelPerdas pModelPerdas) {
        return this.daoPerdas.atualizarParadasDAO(pModelPerdas);
    }

    public boolean excluirCadastroPerdas(int pIdPerda) {
        return this.daoPerdas.excluirProducaoDAO(pIdPerda);
    }


}
