package DAO;

import conexoes.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelParadas;

public class DAOParadas extends ConexaoMySql {

    public int salvarCadastroParada(ModelParadas pModelParadas) {

        try {

            String query = "INSERT INTO tbl_paradas "
                    + "(par_produto, par_etapa, par_recurso, par_data_inicio, par_data_final, par_motivo, par_operador, par_time_inicio, par_time_termino) "
                    + "VALUES "
                    + "( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conectar().prepareStatement(query);
            statement.setString(1, pModelParadas.getDescProduto());
            statement.setString(2, pModelParadas.getDescEtapa());
            statement.setString(3, pModelParadas.getDescRecurso());
            statement.setDate(4, (java.sql.Date) pModelParadas.getDataInicio());
            statement.setDate(5, (java.sql.Date) pModelParadas.getDataTermino());
            statement.setString(6, pModelParadas.getMotivo());
            statement.setString(7, pModelParadas.getOperador());
            statement.setTime(8, (pModelParadas.getHoraInicio()));
            statement.setTime(9, (pModelParadas.getHoraTermino()));

            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<ModelParadas> getListaParadasDAO(String etapa, String recurso) {
        ArrayList<ModelParadas> listamodelParadas = new ArrayList();
        ModelParadas modelParadas = new ModelParadas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_paradas"
                    + " WHERE par_etapa LIKE '%" + etapa + "%' AND par_recurso LIKE '%" + recurso + "%'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelParadas = new ModelParadas();
                modelParadas.setIdCodigo(this.getResultSet().getInt(1));
                modelParadas.setDescEtapa(this.getResultSet().getString(3));
                modelParadas.setDescRecurso(this.getResultSet().getString(4));
                modelParadas.setTipo(tipo = "Paradas");
                modelParadas.setDataInicio(this.getResultSet().getDate(5));
                modelParadas.setDataTermino(this.getResultSet().getDate(6));
                modelParadas.setHoraInicio(this.getResultSet().getTime(9));
                modelParadas.setHoraTermino(this.getResultSet().getTime(10));
                modelParadas.setExtra(tipoExtra = null);
                modelParadas.setOperador(this.getResultSet().getString(8));
                modelParadas.setMotivo(this.getResultSet().getString(7));
                listamodelParadas.add(modelParadas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelParadas;
    }
    
    public ArrayList<ModelParadas> getListaParadasGeralDAO(String etapa, String recurso) {
        ArrayList<ModelParadas> listamodelParadas = new ArrayList();
        ModelParadas modelParadas = new ModelParadas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_paradas"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelParadas = new ModelParadas();
                modelParadas.setIdCodigo(this.getResultSet().getInt(1));
                modelParadas.setDescEtapa(this.getResultSet().getString(3));
                modelParadas.setDescRecurso(this.getResultSet().getString(4));
                modelParadas.setTipo(tipo = "Paradas");
                modelParadas.setDataInicio(this.getResultSet().getDate(5));
                modelParadas.setDataTermino(this.getResultSet().getDate(6));
                modelParadas.setHoraInicio(this.getResultSet().getTime(9));
                modelParadas.setHoraTermino(this.getResultSet().getTime(10));
                modelParadas.setExtra(tipoExtra = null);
                modelParadas.setOperador(this.getResultSet().getString(8));
                modelParadas.setMotivo(this.getResultSet().getString(7));
                listamodelParadas.add(modelParadas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelParadas;
    }

    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_paradas;");

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

    public boolean atualizarParadasDAO(ModelParadas pModelParadas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_paradas SET "
                    + "pk_id_codigo = '" + pModelParadas.getIdCodigo() + "',"
                    + "par_produto = '" + pModelParadas.getDescProduto() + "',"
                    + "par_etapa = '" + pModelParadas.getDescEtapa() + "',"
                    + "par_recurso = '" + pModelParadas.getDescRecurso() + "',"
                    + "par_data_inicio = '" + pModelParadas.getDataInicio() + "',"
                    + "par_data_final = '" + pModelParadas.getDataTermino() + "',"
                    + "par_motivo = '" + pModelParadas.getMotivo() + "',"
                    + "par_operador = '" + pModelParadas.getOperador() + "',"
                    + "par_time_inicio = '" + pModelParadas.getHoraInicio() + "',"
                    + "par_time_termino = '" + pModelParadas.getHoraTermino() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelParadas.getIdCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelParadas retornarParadasDAO(int pCodigo) {
        ModelParadas modelParadas = new ModelParadas();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_paradas"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelParadas.setIdCodigo(getResultSet().getInt(1));
                modelParadas.setDescProduto(getResultSet().getString(2));
                modelParadas.setDescEtapa(getResultSet().getString(3));
                modelParadas.setDescRecurso(getResultSet().getString(4));
                modelParadas.setDataInicio(getResultSet().getDate(5));
                modelParadas.setDataTermino(getResultSet().getDate(6));
                modelParadas.setMotivo(getResultSet().getString(7));
                modelParadas.setOperador(getResultSet().getString(8));
                modelParadas.setHoraInicio(getResultSet().getTime(9));
                modelParadas.setHoraTermino(getResultSet().getTime(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelParadas;
    }

    public boolean excluirProducaoDAO(int pIdParada) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_paradas "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdParada + "'"
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
