package br.usjt.arqdesis.cadcliente;

import com.orm.SugarRecord;

/**
 * Created by hugom on 20/10/2017.
 */

public class Cliente extends SugarRecord {

    String nome;
    int idade;
    String cpf;
    String telefone;

    public Cliente() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}
