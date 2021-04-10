
package controller;

import DAO.DAOListaTodos;
import java.util.ArrayList;
import model.ModelListaTodos;


public class ControllerListaTodos {
    
        private DAOListaTodos daoListaTodos = new DAOListaTodos();
    
        public ArrayList<ModelListaTodos> retornarListaTodosController() {
        return this.daoListaTodos.getListaTodosDAO();
    }
    
}
