package DAO;

import model.ModelCadastroUsuarios;
import conexoes.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class DAOCadastroUsuarios extends ConexaoMySql {

    /**
     * grava CadastroUsuarios
     *
     * @param pModelCadastroUsuarios return int
     */
    public int salvarCadastroUsuariosDAO(ModelCadastroUsuarios pModelCadastroUsuarios) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_usuarios ("
                    + "cad_usu_cpf,"
                    + "cad_usu_nome,"
                    + "cad_usu_email,"
                    + "cad_usu_telefone,"
                    + "cad_usu_dataNasc,"
                    + "cad_usu_login,"
                    + "cad_usu_senha"
                    + ") VALUES ("
                    + "'" + pModelCadastroUsuarios.getCpf() + "',"
                    + "'" + pModelCadastroUsuarios.getNome() + "',"
                    + "'" + pModelCadastroUsuarios.getEmail() + "',"
                    + "'" + pModelCadastroUsuarios.getTelefone() + "',"
                    + "'" + pModelCadastroUsuarios.getDataNascimento() + "',"
                    + "'" + pModelCadastroUsuarios.getUsuNome() + "',"
                    + "'" + pModelCadastroUsuarios.getUsuSenha() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            //  return 0;
        } finally {
            this.fecharConexao();
        }
        return 0;
    }

    /**
     * recupera CadastroUsuarios
     *
     * @param pIdUsuario return ModelCadastroUsuarios
     */
    public ModelCadastroUsuarios getCadastroUsuariosDAO(int pIdUsuario) {

        ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " pk_id_codigo = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadastroUsuarios.setCodigo(getResultSet().getInt(1));
                modelCadastroUsuarios.setCpf(getResultSet().getString(2));
                modelCadastroUsuarios.setNome(getResultSet().getString(3));
                modelCadastroUsuarios.setEmail(getResultSet().getString(4));
                modelCadastroUsuarios.setTelefone(getResultSet().getString(5));
                modelCadastroUsuarios.setDataNascimento(getResultSet().getDate(6));
                modelCadastroUsuarios.setUsuNome(this.getResultSet().getString(7));
                modelCadastroUsuarios.setUsuSenha(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroUsuarios;
    }

    public ModelCadastroUsuarios getUsuarioDAO(String pLogin) {
        ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " cad_usu_login = '" + pLogin + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadastroUsuarios.setCodigo(getResultSet().getInt(1));
                modelCadastroUsuarios.setCpf(getResultSet().getString(2));
                modelCadastroUsuarios.setNome(getResultSet().getString(3));
                modelCadastroUsuarios.setEmail(getResultSet().getString(4));
                modelCadastroUsuarios.setTelefone(getResultSet().getString(5));
                modelCadastroUsuarios.setDataNascimento(getResultSet().getDate(6));
                modelCadastroUsuarios.setUsuNome(this.getResultSet().getString(7));
                modelCadastroUsuarios.setUsuSenha(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroUsuarios;
    }

    /**
     * recupera uma lista de CadastroUsuarios return ArrayList
     */
    public ArrayList<ModelCadastroUsuarios> getListaCadastroUsuariosDAO() {
        ArrayList<ModelCadastroUsuarios> listamodelCadastroUsuarios = new ArrayList();
        ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_usuarios"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadastroUsuarios = new ModelCadastroUsuarios();
                modelCadastroUsuarios.setCodigo(getResultSet().getInt(1));
                modelCadastroUsuarios.setCpf(getResultSet().getString(2));
                modelCadastroUsuarios.setNome(getResultSet().getString(3));
                modelCadastroUsuarios.setEmail(getResultSet().getString(4));
                modelCadastroUsuarios.setTelefone(getResultSet().getString(5));
                modelCadastroUsuarios.setDataNascimento(getResultSet().getDate(6));
                modelCadastroUsuarios.setUsuNome(this.getResultSet().getString(7));
                modelCadastroUsuarios.setUsuSenha(this.getResultSet().getString(8));
                listamodelCadastroUsuarios.add(modelCadastroUsuarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCadastroUsuarios;
    }

    /**
     * atualiza CadastroUsuarios
     *
     * @param pModelCadastroUsuarios return boolean
     */
    public boolean atualizarCadastroUsuariosDAO(ModelCadastroUsuarios pModelCadastroUsuarios) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_usuarios SET "
                    + "pk_id_codigo = '" + pModelCadastroUsuarios.getCodigo() + "',"
                    + "cad_usu_cpf = '" + pModelCadastroUsuarios.getCpf() + "',"
                    + "cad_usu_nome = '" + pModelCadastroUsuarios.getNome() + "',"
                    + "cad_usu_email = '" + pModelCadastroUsuarios.getEmail() + "',"
                    + "cad_usu_telefone = '" + pModelCadastroUsuarios.getTelefone() + "',"
                    + "cad_usu_dataNasc = '" + pModelCadastroUsuarios.getDataNascimento() + "',"
                    + "cad_usu_login = '" + pModelCadastroUsuarios.getUsuNome() + "',"
                    + "cad_usu_senha = '" + pModelCadastroUsuarios.getUsuSenha() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelCadastroUsuarios.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui CadastroUsuarios
     *
     * @param pIdUsuario return boolean
     */
    public boolean excluirCadastroUsuariosDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_usuarios "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdUsuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean getValidarUsuarioDAO(ModelCadastroUsuarios pModelCadastroUsuarios) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " cad_usu_login = '" + pModelCadastroUsuarios.getUsuNome() + "' AND cad_usu_senha = '" + pModelCadastroUsuarios.getUsuSenha() + "'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Usuario
     *
     * @param pIdUsuario return ModelUsuario
     */
    public ModelCadastroUsuarios getUsuarioDAO(int pIdUsuario) {
        ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " cad_usu_login = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadastroUsuarios.setCodigo(getResultSet().getInt(1));
                modelCadastroUsuarios.setCpf(getResultSet().getString(2));
                modelCadastroUsuarios.setNome(getResultSet().getString(3));
                modelCadastroUsuarios.setEmail(getResultSet().getString(4));
                modelCadastroUsuarios.setTelefone(getResultSet().getString(5));
                modelCadastroUsuarios.setDataNascimento(getResultSet().getDate(6));
                modelCadastroUsuarios.setUsuNome(this.getResultSet().getString(7));
                modelCadastroUsuarios.setUsuSenha(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroUsuarios;

    }

    public ArrayList busca() throws SQLException {

        ArrayList<ModelCadastroUsuarios> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_usuarios;");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelCadastroUsuarios cadu = new ModelCadastroUsuarios();
                cadu.setCodigo(rs.getInt("pk_id_codigo"));
                cadu.setCpf(rs.getString("cad_usu_cpf"));
                cadu.setNome(rs.getString("cad_usu_nome"));
                cadu.setEmail(rs.getString("cad_usu_email"));
                cadu.setTelefone(rs.getString("cad_usu_telefone"));
                cadu.setDataNascimento(rs.getDate("cad_usu_dataNasc"));
                cadu.setUsuNome(rs.getString("cad_usu_login"));
                cadu.setUsuSenha(rs.getString("cad_usu_senha"));

                lista.add(cadu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public ModelCadastroUsuarios retornarCadastroUsuariosDAO(int pIdCadastro) {
        ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " pk_id_codigo = '" + pIdCadastro + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelCadastroUsuarios.setCodigo(getResultSet().getInt(1));
                modelCadastroUsuarios.setCpf(getResultSet().getString(2));
                modelCadastroUsuarios.setNome(getResultSet().getString(3));
                modelCadastroUsuarios.setEmail(getResultSet().getString(4));
                modelCadastroUsuarios.setTelefone(getResultSet().getString(5));
                modelCadastroUsuarios.setDataNascimento(getResultSet().getDate(6));
                modelCadastroUsuarios.setUsuNome(this.getResultSet().getString(7));
                modelCadastroUsuarios.setUsuSenha(this.getResultSet().getString(8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroUsuarios;
    }

    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_usuarios;");

            //recupera o ultimo id inserido
            while (rs.next()) {

                lista = rs.getInt(1);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }
}
