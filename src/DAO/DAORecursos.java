package DAO;

import conexoes.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelRecursos;

public class DAORecursos extends ConexaoMySql {

    public int salvarCadastroRecurso(ModelRecursos pModelRecursos) {

        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_recursos ("
                    + "rec_tipo,"
                    + "rec_descricao"
                    + ") VALUES ("
                    + "'" + pModelRecursos.getTipoRecurso() + "',"
                    + "'" + pModelRecursos.getDescricao() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList busca() throws SQLException {

        ArrayList<ModelRecursos> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_recursos;");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelRecursos rec = new ModelRecursos();
                rec.setIdRecurso(rs.getInt("pk_id_codigo"));
                rec.setTipoRecurso(rs.getString("rec_tipo"));
                rec.setDescricao(rs.getString("rec_descricao"));

                lista.add(rec);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public boolean excluirRecursosDAO(int pIdRecurso) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_recursos "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdRecurso + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public List<ModelRecursos> getListaRecursosDAO() {
        ArrayList<ModelRecursos> listaModelRecursos = new ArrayList();
        ModelRecursos modelRecursos = new ModelRecursos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_recursos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelRecursos = new ModelRecursos();
                modelRecursos.setIdRecurso(getResultSet().getInt(1));
                modelRecursos.setTipoRecurso(getResultSet().getString(2));
                modelRecursos.setDescricao(getResultSet().getString(3));
                listaModelRecursos.add(modelRecursos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelRecursos;

    }

    public ModelRecursos retornarRecursosDAO(int pCodigo) {
        ModelRecursos modelRecursos = new ModelRecursos();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_recursos"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelRecursos.setIdRecurso(getResultSet().getInt(1));
                modelRecursos.setTipoRecurso(getResultSet().getString(2));
                modelRecursos.setDescricao(getResultSet().getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelRecursos;
    }

    public boolean atualizarRecursosDAO(ModelRecursos pModelRecursos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_recursos SET "
                    + "pk_id_codigo = '" + pModelRecursos.getIdRecurso() + "',"
                    + "rec_tipo = '" + pModelRecursos.getTipoRecurso() + "',"
                    + "rec_descricao = '" + pModelRecursos.getDescricao() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelRecursos.getIdRecurso() + "'"
                    + ";"
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
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_recursos;");

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
