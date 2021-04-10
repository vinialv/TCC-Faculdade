package controller;

import DAO.DAOCadastroGeral;
import java.util.ArrayList;
import model.ModelCadastroGeral;

public class ControllerCadastroGeral {

    private DAOCadastroGeral daoCadastroGeral = new DAOCadastroGeral();

    /**
     * grava CadastroUsuarios
     *
     * @param pModelCadastroUsuarios return int
     */
    public int salvarCadastroGeralController(ModelCadastroGeral pModelCadastroGeral) {
        return this.daoCadastroGeral.salvarCadastroGeralDAO(pModelCadastroGeral);
    }

    public ArrayList<ModelCadastroGeral> retornarListaParadasController() {
        return this.daoCadastroGeral.getListaCadastroGeralDAO();
    }

    public ModelCadastroGeral getCadastroGeralController(int pIdCadastro) {
        return this.daoCadastroGeral.getCadastroGeralDAO(pIdCadastro);
    }

    public boolean atualizarCadastroGeralController(ModelCadastroGeral pModelCadastroGeral) {
        return this.daoCadastroGeral.atualizarCadastroGeralDAO(pModelCadastroGeral);
    }

    public ModelCadastroGeral retornarCadastroGeralController(int pIdCadastro) {
        return this.daoCadastroGeral.retornarCadastroGeralDAO(pIdCadastro);
    }

    public boolean excluirCadastroGeralController(int pCodigo) {
        return this.daoCadastroGeral.excluirCadastroGeralDAO(pCodigo);
    }

}
