package controller;

import DAO.DAOEtapas;
import java.util.ArrayList;
import java.util.List;
import model.ModelEtapas;

public class ControllerEtapas {

    private DAOEtapas daoEtapas = new DAOEtapas();

    /**
     * grava Cadastra uma nova etapa no sistema
     *
     * @param pModelEtapas return int
     */
    public int salvarCadastroEtapas(ModelEtapas pModelEtapas) {
        return this.daoEtapas.salvarCadastroEtapa(pModelEtapas);
    }

    public boolean excluirCadastroEtapas(int pIdEtapa) {
        return this.daoEtapas.excluirEtapasDAO(pIdEtapa);
    }

    public List<ModelEtapas> getListaEtapas() {
        return this.daoEtapas.getListaEtapasDAO();
    }

    public ModelEtapas retornarEtapasController(int pCodigo) {
        return this.daoEtapas.retornarEtapasDAO(pCodigo);
    }

    public boolean atualizarEtapaController(ModelEtapas pModelEtapas) {
        return this.daoEtapas.atualizarEtapaDAO(pModelEtapas);
    }

}
