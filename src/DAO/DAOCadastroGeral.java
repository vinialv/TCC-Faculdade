package DAO;

import conexoes.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelCadastroGeral;

public class DAOCadastroGeral extends ConexaoMySql {

    public int salvarCadastroGeralDAO(ModelCadastroGeral pModelCadastroGeral) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_cadastros ("
                    + "cad_tipo,"
                    + "cad_nome"
                    + ") VALUES ("
                    + "'" + pModelCadastroGeral.getTipoCadastro() + "',"
                    + "'" + pModelCadastroGeral.getDescricao() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelCadastroGeral getCadastroGeralDAO(int pIdCadastro) {
        ModelCadastroGeral modelCadastroGeral = new ModelCadastroGeral();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_codigo,"
                    + "cad_tipo,"
                    + "cad_nome"
                    + " FROM"
                    + " tbl_cadastros"
                    + " WHERE"
                    + " pk_id_codigo = '" + pIdCadastro + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCadastroGeral.setIdCadastro(this.getResultSet().getInt(1));
                modelCadastroGeral.setTipoCadastro(this.getResultSet().getString(2));
                modelCadastroGeral.setDescricao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroGeral;
    }

    public ArrayList busca() throws SQLException {

        ArrayList<ModelCadastroGeral> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `tbl_cadastros` WHERE cad_tipo = 'Motivo de parada';");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelCadastroGeral cadg = new ModelCadastroGeral();
                cadg.setIdCadastro(rs.getInt("pk_id_codigo"));
                cadg.setTipoCadastro(rs.getString("cad_tipo"));
                cadg.setDescricao(rs.getString("cad_nome"));

                lista.add(cadg);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public ArrayList buscaPerdas() throws SQLException {

        ArrayList<ModelCadastroGeral> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `tbl_cadastros` WHERE cad_tipo = 'Motivo de perda';");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelCadastroGeral cadg = new ModelCadastroGeral();
                cadg.setIdCadastro(rs.getInt("pk_id_codigo"));
                cadg.setTipoCadastro(rs.getString("cad_tipo"));
                cadg.setDescricao(rs.getString("cad_nome"));

                lista.add(cadg);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public boolean atualizarCadastroGeralDAO(ModelCadastroGeral pModelCadastroGeral) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_cadastros SET "
                    + "cad_tipo = '" + pModelCadastroGeral.getTipoCadastro() + "',"
                    + "cad_nome = '" + pModelCadastroGeral.getDescricao() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelCadastroGeral.getIdCadastro() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelCadastroGeral> getListaCadastroGeralDAO() {
        ArrayList<ModelCadastroGeral> listaCadastroGeral = new ArrayList();
        ModelCadastroGeral modelCadastroGeral = new ModelCadastroGeral();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM `tbl_cadastros` "
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelCadastroGeral = new ModelCadastroGeral();
                modelCadastroGeral.setIdCadastro(this.getResultSet().getInt(1));
                modelCadastroGeral.setTipoCadastro(this.getResultSet().getString(2));
                modelCadastroGeral.setDescricao(this.getResultSet().getString(3));
                listaCadastroGeral.add(modelCadastroGeral);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaCadastroGeral;

    }

    public ModelCadastroGeral retornarCadastroGeralDAO(int pIdCadastro) {
        ModelCadastroGeral modelCadastroGeral = new ModelCadastroGeral();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_codigo, "
                    + "cad_tipo,"
                    + "cad_nome"
                    + " FROM"
                    + " tbl_cadastros"
                    + " WHERE"
                    + " pk_id_codigo = '" + pIdCadastro + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelCadastroGeral.setIdCadastro(getResultSet().getInt(1));
                modelCadastroGeral.setTipoCadastro(getResultSet().getString(2));
                modelCadastroGeral.setDescricao(getResultSet().getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCadastroGeral;
    }

    public boolean excluirCadastroGeralDAO(int pIdCadastro) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_cadastros WHERE pk_id_codigo = '" + pIdCadastro + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_cadastros;");

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
