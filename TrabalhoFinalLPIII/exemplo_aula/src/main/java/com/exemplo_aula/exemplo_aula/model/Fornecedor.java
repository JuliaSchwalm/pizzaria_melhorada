package com.exemplo_aula.exemplo_aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornecedor;

    private String nome;
    private String cnpj;
    private String ingrediente;
    public Long getIdFornecedor() {
        return idFornecedor;
    }
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cNPJ) {
        cnpj = cNPJ;
    }
    public String getIngrediente() {
        return ingrediente;
    }
    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
    @Override
    public String toString() {
        return "Fornecedor [idFornecedor=" + idFornecedor + ", nome=" + nome + ", CNPJ=" + cnpj + ", ingrediente="
                + ingrediente + "]";
    }
    

}
