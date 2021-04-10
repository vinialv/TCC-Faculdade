package DAO;

import model.ModelEtapas;
import conexoes.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOEtapas extends ConexaoMySql {

    private ResultSet resultSet;

    public int salvarCadastroEtapa(ModelEtapas pModelEtapas) {

        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_etapas ("
                    + "eta_nome"
                    + ") VALUES ("
                    + "'" + pModelEtapas.getDescricao() + "'"
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

        ArrayList<ModelEtapas> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_etapas;");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelEtapas eta = new ModelEtapas();
                eta.setIdEtapa(rs.getInt("pk_id_codigo"));
                eta.setDescricao(rs.getString("eta_nome"));

                lista.add(eta);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_etapas;");

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

    public boolean excluirEtapasDAO(int pIdEtapa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_etapas "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdEtapa + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public List<ModelEtapas> getListaEtapasDAO() {
        ArrayList<ModelEtapas> listaModelEtapas = new ArrayList();
        ModelEtapas modelEtapas = new ModelEtapas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_etapas"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEtapas = new ModelEtapas();
                modelEtapas.setIdEtapa(getResultSet().getInt(1));
                modelEtapas.setDescricao(getResultSet().getString(2));
                listaModelEtapas.add(modelEtapas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelEtapas;

    }

    public ModelEtapas retornarEtapasDAO(int pCodigo) {
        ModelEtapas modelEtapas = new ModelEtapas();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_etapas"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelEtapas.setIdEtapa(getResultSet().getInt(1));
                modelEtapas.setDescricao(getResultSet().getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEtapas;
    }

    public boolean atualizarEtapaDAO(ModelEtapas pModelEtapas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_etapas SET "
                    + "pk_id_codigo = '" + pModelEtapas.getIdEtapa() + "',"
                    + "eta_nome = '" + pModelEtapas.getDescricao() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelEtapas.getIdEtapa() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
