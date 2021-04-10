package model;

import java.sql.Date;
import java.sql.Time;

public class ModelProducao {

    private int idCodigo;
    private String descProduto;
    private String descEtapa;
    private String descRecurso;
    private Date dataInicio;
    private Date dataTermino;
    private double pesoProducao;
    private String operador;
    private String tipo;
    private String extra;
    private Time horaInicio;
    private Time horaTermino;

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getDescEtapa() {
        return descEtapa;
    }

    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    public String getDescRecurso() {
        return descRecurso;
    }

    public void setDescRecurso(String descRecurso) {
        this.descRecurso = descRecurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getPesoProducao() {
        return pesoProducao;
    }

    public void setPesoProducao(double pesoProducao) {
        this.pesoProducao = pesoProducao;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }


}
