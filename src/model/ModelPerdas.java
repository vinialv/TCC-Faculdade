package model;

import java.sql.Time;
import java.util.Date;


public class ModelPerdas {

    private int idCodigo;
    private String descProduto;
    private String descEtapa;
    private String descRecurso;
    private Date dataPerda;
    private String motivo;
    private double pesoPerda;
    private String operador;
    private String tipo;
    private String extra;
    private Time horaPerda;

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

    public Date getDataPerda() {
        return dataPerda;
    }

    public void setDataPerda(Date dataPerda) {
        this.dataPerda = dataPerda;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getPesoPerda() {
        return pesoPerda;
    }

    public void setPesoPerda(double pesoPerda) {
        this.pesoPerda = pesoPerda;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "ModelPerdas {" + "::idCodigo = " + this.idCodigo + "::descProduto = " + this.descProduto + "::descEtapa = " + this.descEtapa + "::descRecurso = " + this.descRecurso + "::dataPerda = " + this.dataPerda + "::motivo = " + this.motivo + "::pesoPerda = " + this.pesoPerda + "::operador = " + this.operador + " }";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Time getHoraPerda() {
        return horaPerda;
    }

    public void setHoraPerda(Time horaPerda) {
        this.horaPerda = horaPerda;
    }

}
