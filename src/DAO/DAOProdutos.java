package DAO;

import model.ModelProdutos;
import conexoes.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelProdutos;

public class DAOProdutos extends ConexaoMySql {

    public int salvarCadastroProdutos(ModelProdutos pModelProdutos) {

        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_produtos ("
                    + "pro_descricao"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getDescricao() + "'"
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

        ArrayList<ModelProdutos> lista = new ArrayList<>();

        try {
            conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_produtos;");

            //recupera o ultimo id inserido
            while (rs.next()) {

                ModelProdutos pro = new ModelProdutos();
                pro.setIdProduto(rs.getInt("pk_id_codigo"));
                pro.setDescricao(rs.getString("pro_descricao"));

                lista.add(pro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        } finally {
            fecharConexao();
        }

        return lista;

    }

    public boolean excluirProdutosDAO(int pIdProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produtos "
                    + " WHERE "
                    + "pk_id_codigo = '" + pIdProdutos + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public List<ModelProdutos> getListaProdutosDAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM"
                    + " tbl_produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(getResultSet().getInt(1));
                modelProdutos.setDescricao(getResultSet().getString(2));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;

    }

    public ModelProdutos retornarProdutosDAO(int pCodigo) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM"
                    + " tbl_produtos"
                    + " WHERE"
                    + " pk_id_codigo = '" + pCodigo + "'"
                    + ";"
            );
            while (getResultSet().next()) {
                modelProdutos.setIdProduto(getResultSet().getInt(1));
                modelProdutos.setDescricao(getResultSet().getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    public boolean atualizarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produtos SET "
                    + "pk_id_codigo = '" + pModelProdutos.getIdProduto() + "',"
                    + "pro_descricao = '" + pModelProdutos.getDescricao() + "'"
                    + " WHERE "
                    + "pk_id_codigo = '" + pModelProdutos.getIdProduto() + "'"
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
            ResultSet rs = st.executeQuery("SELECT MAX(pk_id_codigo) FROM tbl_produtos;");

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
