package DAO;

import conexoes.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelPerdas;

public class DAOPerdas extends ConexaoMySql {

    public int salvarCadastroPerdas(ModelPerdas pModelPerdas) {

        try {

            String query = "INSERT INTO tbl_perdas "
                    + "(per_produto, per_etapa, per_recurso, per_data, per_motivo, per_peso, per_operador, per_time_perda) "
                    + "VALUES "
                    + "( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conectar().prepareStatement(query);
            statement.setString(1, pModelPerdas.getDescProduto());
            statement.setString(2, pModelPerdas.getDescEtapa());
            statement.setString(3, pModelPerdas.getDescRecurso());
            statement.setDate(4, (java.sql.Date) pModelPerdas.getDataPerda());
            statement.setString(5, pModelPerdas.getMotivo());
            statement.setDouble(6, pModelPerdas.getPesoPerda());
            statement.setString(7, pModelPerdas.getOperador());
            statement.setTime(8, (pModelPerdas.getHoraPerda()));

            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<ModelPerdas> getListaPerdasDAO(String etapa, String recurso) {
        ArrayList<ModelPerdas> listaModelPerdas = new ArrayList();
        ModelPerdas modelPerdas = new ModelPerdas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_perdas"
                    + " WHERE per_etapa LIKE '%" + etapa + "%' AND per_recurso LIKE '%" + recurso + "%'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelPerdas = new ModelPerdas();
                modelPerdas.setIdCodigo(this.getResultSet().getInt(1));
                modelPerdas.setDescEtapa(this.getResultSet().getString(3));
                modelPerdas.setDescRecurso(this.getResultSet().getString(4));
                modelPerdas.setTipo("Perdas");
                modelPerdas.setDataPerda(this.getResultSet().getDate(5));
                modelPerdas.setDataPerda(this.getResultSet().getDate(5));
                modelPerdas.setPesoPerda(this.getResultSet().getDouble(7));
                modelPerdas.setOperador(this.getResultSet().getString(8));
                modelPerdas.setMotivo(this.getResultSet().getString(6));
                modelPerdas.setHoraPerda(this.getResultSet().getTime(9));
                listaModelPerdas.add(modelPerdas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelPerdas;
    }

    
    public ArrayList<ModelPerdas> getListaPerdasGeralDAO(String etapa, String recurso) {
        ArrayList<ModelPerdas> listaModelPerdas = new ArrayList();
        ModelPerdas modelPerdas = new ModelPerdas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_perdas"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelPerdas = new ModelPerdas();
                modelPerdas.setIdCodigo(this.getResultSet().getInt(1));
                modelPerdas.setDescEtapa(this.getResultSet().getString(3));
                modelPerdas.setDescRecurso(this.getResultSet().getString(4));
                modelPerdas.setTipo("Perdas");
                modelPerdas.setDataPerda(this.getResultSet().getDate(5));
                modelPerdas.setDataPerda(this.getResultSet().getDate(5));
                modelPerdas.setPesoPerda(this.getResultSet().getDouble(7));
                modelPerdas.setOperador(this.getResultSet().getString(8));
                modelPerdas.setMotivo(this.getResultSet().getString(6));
                modelPerdas.setHoraPerda(this.getResultSet().getTime(9));
                listaModelPerdas.add(modelPerdas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelPerdas;
    }
    
    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_perdas;");

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

    public boolean atualizarPerdasDAO(ModelPerdas pModelPerdas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_perdas SET "
                    + "pk_id_codigo = '" + pModelPerdas.getIdCodigo() + "',"
                    + "per_produto = '" + pModelPerdas.getDescProduto() + "',"
                    + "per_etapa = '" + pModelPerdas.getDescEtapa() + "',"
                    + "per_recurso = '" + pModelPerdas.getDescRecurso() + "',"
                    + "per_data = '" + pModelPerdas.getDataPerda() + "',"
                    + "per_motivo = '" + pModelPerdas.getMotivo() + "',"
                    + "per_peso = '" + pModelPerdas.getPesoPerda() + "',"
                    + "per_operador = '" + pModelPerdas.getOperador() + "',"
                    + "per_time_perda = '" + pModelPerdas.getHoraPerda() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelPerdas.getIdCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean atualizarParadasDAO(ModelPerdas pModelPerdas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_perdas SET "
                    + "pk_id_codigo = '" + pModelPerdas.getIdCodigo() + "',"
                    + "per_produto = '" + pModelPerdas.getDescProduto() + "',"
                    + "per_etapa = '" + pModelPerdas.getDescEtapa() + "',"
                    + "per_recurso = '" + pModelPerdas.getDescRecurso() + "',"
                    + "per_data = '" + pModelPerdas.getDataPerda() + "',"
                    + "per_motivo = '" + pModelPerdas.getMotivo() + "',"
                    + "per_peso = '" + pModelPerdas.getPesoPerda() + "',"
                    + "per_operador = '" + pModelPerdas.getOperador() + "',"
                    + "per_time_perda = '" + pModelPerdas.getHoraPerda() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelPerdas.getIdCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelPerdas retornarPerdasDAO(int pCodigo) {
        ModelPerdas modelPerdas = new ModelPerdas();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_perdas"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelPerdas.setIdCodigo(getResultSet().getInt(1));
                modelPerdas.setDescProduto(getResultSet().getString(2));
                modelPerdas.setDescEtapa(getResultSet().getString(3));
                modelPerdas.setDescRecurso(getResultSet().getString(4));
                modelPerdas.setDataPerda(getResultSet().getDate(5));
                modelPerdas.setMotivo(getResultSet().getString(6));
                modelPerdas.setPesoPerda(getResultSet().getDouble(7));
                modelPerdas.setOperador(getResultSet().getString(8));
                modelPerdas.setHoraPerda(getResultSet().getTime(9));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPerdas;

    }

    public boolean excluirProducaoDAO(int pIdPerda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_perdas "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdPerda + "'"
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
