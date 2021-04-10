package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelListaTodos;

public class DAOListaTodos extends ConexaoMySql{

    public ArrayList<ModelListaTodos> getListaTodosDAO() {
        ArrayList<ModelListaTodos> listaModelTodos = new ArrayList();
        ModelListaTodos modelListaTodos = new ModelListaTodos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM `tbl_paradas`, `tbl_perdas`, `tbl_producao` "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelListaTodos = new ModelListaTodos();
                


                listaModelTodos.add(modelListaTodos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelTodos;
    }

}
