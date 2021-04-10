package DAO;

import conexoes.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelProducao;

public class DAOProducao extends ConexaoMySql {

    public int salvarCadastroProducao(ModelProducao pModelProducao) {

        try {

            String query = "INSERT INTO tbl_producao "
                    + "(pro_produto, pro_etapa, pro_recurso, pro_data_inicio, pro_data_final, pro_peso, pro_operador, pro_time_inicio, pro_time_termino) "
                    + "VALUES "
                    + "( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conectar().prepareStatement(query);
            statement.setString(1, pModelProducao.getDescProduto());
            statement.setString(2, pModelProducao.getDescEtapa());
            statement.setString(3, pModelProducao.getDescRecurso());
            statement.setDate(4, (java.sql.Date) pModelProducao.getDataInicio());
            statement.setDate(5, (java.sql.Date) pModelProducao.getDataTermino());
            statement.setDouble(6, pModelProducao.getPesoProducao());
            statement.setString(7, pModelProducao.getOperador());
            statement.setTime(8, pModelProducao.getHoraInicio());
            statement.setTime(9, pModelProducao.getHoraTermino());

            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<ModelProducao> getListaProducaoDAO(String etapa, String recurso) {
        ArrayList<ModelProducao> listaModelProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_producao"
                    + " WHERE pro_etapa LIKE '%" + etapa + "%' AND pro_recurso LIKE '%" + recurso + "%'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelProducao = new ModelProducao();
                modelProducao.setIdCodigo(this.getResultSet().getInt(1));
                modelProducao.setDescEtapa(this.getResultSet().getString(3));
                modelProducao.setDescRecurso(this.getResultSet().getString(4));
                modelProducao.setTipo(tipo = "Produção");
                modelProducao.setDataInicio(this.getResultSet().getDate(5));
                modelProducao.setDataTermino(this.getResultSet().getDate(6));
                modelProducao.setPesoProducao(this.getResultSet().getDouble(7));
                modelProducao.setOperador(this.getResultSet().getString(8));
                modelProducao.setHoraInicio(this.getResultSet().getTime(9));
                modelProducao.setHoraTermino(this.getResultSet().getTime(10));
                modelProducao.setExtra(tipoExtra = null);
                listaModelProducao.add(modelProducao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProducao;
    }

    public ArrayList<ModelProducao> getListaProducaoGeralDAO(String etapa, String recurso) {
        ArrayList<ModelProducao> listaModelProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM "
                    + " tbl_producao"
                    + ";"
            );

            while (this.getResultSet().next()) {
                String tipo, tipoExtra;
                modelProducao = new ModelProducao();
                modelProducao.setIdCodigo(this.getResultSet().getInt(1));
                modelProducao.setDescEtapa(this.getResultSet().getString(3));
                modelProducao.setDescRecurso(this.getResultSet().getString(4));
                modelProducao.setTipo(tipo = "Produção");
                modelProducao.setDataInicio(this.getResultSet().getDate(5));
                modelProducao.setDataTermino(this.getResultSet().getDate(6));
                modelProducao.setPesoProducao(this.getResultSet().getDouble(7));
                modelProducao.setOperador(this.getResultSet().getString(8));
                modelProducao.setHoraInicio(this.getResultSet().getTime(9));
                modelProducao.setHoraTermino(this.getResultSet().getTime(10));
                modelProducao.setExtra(tipoExtra = null);
                listaModelProducao.add(modelProducao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProducao;
    }    
    
    public int buscaCodigoMaximo() throws SQLException {

        int lista = 0;

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_producao;");

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

    public ModelProducao retornarProdutosDAO(int pCodigo) {
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_producao"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelProducao.setIdCodigo(getResultSet().getInt(1));
                modelProducao.setDescProduto(getResultSet().getString(2));
                modelProducao.setDescEtapa(getResultSet().getString(3));
                modelProducao.setDescRecurso(getResultSet().getString(4));
                modelProducao.setDataInicio(getResultSet().getDate(5));
                modelProducao.setDataTermino(getResultSet().getDate(6));
                modelProducao.setPesoProducao(getResultSet().getDouble(7));
                modelProducao.setOperador(getResultSet().getString(8));
                modelProducao.setHoraInicio(getResultSet().getTime(9));
                modelProducao.setHoraTermino(getResultSet().getTime(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProducao;
    }

    public boolean atualizarProducaoDAO(ModelProducao pModelProducao) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_producao SET "
                    + "pk_id_codigo = '" + pModelProducao.getIdCodigo() + "',"
                    + "pro_produto = '" + pModelProducao.getDescProduto() + "',"
                    + "pro_etapa = '" + pModelProducao.getDescEtapa() + "',"
                    + "pro_recurso = '" + pModelProducao.getDescRecurso() + "',"
                    + "pro_data_inicio = '" + pModelProducao.getDataInicio() + "',"
                    + "pro_data_final = '" + pModelProducao.getDataTermino() + "',"
                    + "pro_peso = '" + pModelProducao.getPesoProducao() + "',"
                    + "pro_operador = '" + pModelProducao.getOperador() + "',"
                    + "pro_time_inicio = '" + pModelProducao.getHoraInicio() + "',"
                    + "pro_time_termino = '" + pModelProducao.getHoraTermino() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelProducao.getIdCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirProducaoDAO(int pIdProducao) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_producao "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdProducao + "'"
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
