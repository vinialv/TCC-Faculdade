package controller;

import model.ModelCadastroUsuarios;
import DAO.DAOCadastroUsuarios;
import java.util.ArrayList;

/**
 *
 * @author Vinicius Alves
 */
public class ControllerCadastroUsuarios {

    private DAOCadastroUsuarios daoCadastroUsuarios = new DAOCadastroUsuarios();

    /**
     * grava CadastroUsuarios
     *
     * @param pModelCadastroUsuarios return int
     */
    public int salvarCadastroUsuariosController(ModelCadastroUsuarios pModelCadastroUsuarios) {
        return this.daoCadastroUsuarios.salvarCadastroUsuariosDAO(pModelCadastroUsuarios);
    }


    public ModelCadastroUsuarios getUsuarioController(int pIdUsuario) {
        return this.daoCadastroUsuarios.getUsuarioDAO(pIdUsuario);
    }

    public ModelCadastroUsuarios getUsuarioController(String pLogin) {
        return this.daoCadastroUsuarios.getUsuarioDAO(pLogin);
    }

        public ModelCadastroUsuarios retornarCadastroUsuariosController(int pIdCadastro) {
        return this.daoCadastroUsuarios.retornarCadastroUsuariosDAO(pIdCadastro);
    }
    
    /**
     * recupera CadastroUsuarios
     *
     * @param pIdUsuario return ModelCadastroUsuarios
     */
    public ModelCadastroUsuarios getCadastroUsuariosController(int pIdUsuario) {
        return this.daoCadastroUsuarios.getCadastroUsuariosDAO(pIdUsuario);
    }

    /**
     * recupera uma lista deCadastroUsuarios
     *
     * @param pIdUsuario return ArrayList
     */
    public ArrayList<ModelCadastroUsuarios> getListaCadastroUsuariosController() {
        return this.daoCadastroUsuarios.getListaCadastroUsuariosDAO();
    }

    /**
     * atualiza CadastroUsuarios
     *
     * @param pModelCadastroUsuarios return boolean
     */
    public boolean atualizarCadastroUsuariosController(ModelCadastroUsuarios pModelCadastroUsuarios) {
        return this.daoCadastroUsuarios.atualizarCadastroUsuariosDAO(pModelCadastroUsuarios);
    }

    /**
     * exclui CadastroUsuarios
     *
     * @param pIdUsuario return boolean
     */
    public boolean excluirCadastroUsuariosController(int pIdUsuario) {
        return this.daoCadastroUsuarios.excluirCadastroUsuariosDAO(pIdUsuario);
    }

    /**
     * Validar login e senha do usuario
     *
     * @param pModelUsuario
     * @return
     */
    public boolean getValidarUsuarioController(ModelCadastroUsuarios pModelCadastroUsuarios) {
        return this.daoCadastroUsuarios.getValidarUsuarioDAO(pModelCadastroUsuarios);
    }

}
