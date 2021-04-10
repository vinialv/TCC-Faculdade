package model;

import java.sql.Date;

/**
 *
 * @author Vinicius Alves
 */
public class ModelCadastroUsuarios {

    private int codigo;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String usuNome;
    private String usuSenha;

    /**
     * Construtor
     */
    public ModelCadastroUsuarios() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setUsuNome(String pUsuNome) {
        this.usuNome = pUsuNome;
    }

    public String getUsuNome() {
        return this.usuNome;
    }

    public void setUsuSenha(String pUsuSenha) {
        this.usuSenha = pUsuSenha;
    }

    public String getUsuSenha() {
        return this.usuSenha;
    }
}
