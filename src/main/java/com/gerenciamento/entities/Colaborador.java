package com.gerenciamento.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colaboradores")
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")

public class Colaborador implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 	
    private String cpf;

    private String nome;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    private String funcao;

    private BigDecimal remuneracao;

    @ManyToOne
    @JoinColumn(name = "gerente_id")

    private Colaborador gerente;

    @OneToMany(mappedBy = "gerente")
    @JsonIgnore
    private List<Colaborador> subordinados;

	
    public Colaborador() {
    }
    
    public Colaborador(Long id, String cpf, String nome, LocalDate dataAdmissao, String funcao, BigDecimal remuneracao,
			Colaborador gerente, List<Colaborador> subordinados) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.funcao = funcao;
		this.remuneracao = remuneracao;
		this.gerente = gerente;
		this.subordinados = subordinados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public Colaborador getGerente() {
		return gerente;
	}

	public void setGerente(Colaborador gerente) {
		this.gerente = gerente;
	}

	public List<Colaborador> getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(List<Colaborador> subordinados) {
		this.subordinados = subordinados;
	}
	
  
}
