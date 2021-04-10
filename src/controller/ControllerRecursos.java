package controller;

import DAO.DAORecursos;
import java.util.ArrayList;
import java.util.List;
import model.ModelRecursos;

public class ControllerRecursos {

    private DAORecursos daoRecursos = new DAORecursos();

    /**
     * grava Cadastra um novo recurso no sistema
     *
     * @param pModelRecursos return int
     */
    public int salvarCadastroRecursos(ModelRecursos pModelRecursos) {
        return this.daoRecursos.salvarCadastroRecurso(pModelRecursos);
    }

    public boolean excluirCadastroRecursos(int pIdRecurso) {
        return this.daoRecursos.excluirRecursosDAO(pIdRecurso);
    }

    public List<ModelRecursos> getListaRecursos() {
        return this.daoRecursos.getListaRecursosDAO();
    }

    public ModelRecursos retornarRecursosController(int pCodigo) {
        return this.daoRecursos.retornarRecursosDAO(pCodigo);
    }

    public boolean atualizarRecursosController(ModelRecursos pModelRecursos) {
        return this.daoRecursos.atualizarRecursosDAO(pModelRecursos);
    }
}
