package model;

import java.sql.Date;
import java.sql.Time;

public class ModelParadas {

    private int idCodigo;
    private String descProduto;
    private String descEtapa;
    private String descRecurso;
    private Date dataInicio;
    private Date dataTermino;
    private String motivo;
    private String operador;
    private String tipo;
    private String extra;
    private Time horaInicio ;
    private Time horaTermino;

    public ModelParadas() {
    }

    /**
     * @return the idCodigo
     */
    public int getIdCodigo() {
        return idCodigo;
    }

    /**
     * @param idCodigo the idCodigo to set
     */
    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    /**
     * @return the descProduto
     */
    public String getDescProduto() {
        return descProduto;
    }

    /**
     * @param descProduto the descProduto to set
     */
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    /**
     * @return the descEtapa
     */
    public String getDescEtapa() {
        return descEtapa;
    }

    /**
     * @param descEtapa the descEtapa to set
     */
    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    /**
     * @return the descRecurso
     */
    public String getDescRecurso() {
        return descRecurso;
    }

    /**
     * @param descRecurso the descRecurso to set
     */
    public void setDescRecurso(String descRecurso) {
        this.descRecurso = descRecurso;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Date getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }

    /**
     * @return the operador
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param operador the operador to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ModelParadas {" + "::idCodigo = " + this.idCodigo + "::descProduto = " + this.descProduto + "::descEtapa = " + this.descEtapa + "::descRecurso = " + this.descRecurso + "::dataInicio = " + this.dataInicio + "::dataTermino = " + this.dataTermino + "::motivo = " + this.motivo + "::operador = " + this.operador + " }";
    }

    public Object getDescricao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Time horaTermino) {
        this.horaTermino = horaTermino;
    }

}
