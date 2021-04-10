package model;

public class ModelRecursos {

    public ModelRecursos() {
    }

    private int idRecurso;
    private String descricao;
    private String tipoRecurso;

    /**
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipoRecurso
     */
    public String getTipoRecurso() {
        return tipoRecurso;
    }

    /**
     * @param tipoRecurso the tipoRecurso to set
     */
    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    @Override
    public String toString() {
        return "modelRecursos {" + "::idRecurso = " + this.idRecurso + "::descricao = " + this.descricao + "::tipoRecurso = " + this.tipoRecurso + "}";
    }

}
