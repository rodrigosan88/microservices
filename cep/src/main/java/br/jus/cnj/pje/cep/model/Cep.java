/**
 * pje-cep
 * Copyright (C) 2009-2017 Conselho Nacional de Justiça
 *
 * A propriedade intelectual deste programa, como código-fonte
 * e como sua derivação compilada, pertence à União Federal,
 * dependendo o uso parcial ou total de autorização expressa do
 * Conselho Nacional de Justiça.
 *
 **/
package br.jus.cnj.pje.cep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = Cep.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "nr_cep" }) })
@SequenceGenerator(allocationSize = 1, name = "gen_cep", sequenceName = "sq_tb_cep")
public class Cep implements java.io.Serializable {

	public static final String TABLE_NAME = "tb_cep";
	private static final long serialVersionUID = 1L;

	private int idCep;
	private String numeroCep;
	private String nomeLogradouro;
	private String nomeBairro;
	private Municipio municipio;
	private String complemento;
	private Boolean ativo;
	private String numeroEndereco;

	/**
	 * Construtor padrão.
	 */
	public Cep() {
	}

	/**
	 * Recupera o identificador unívoco interno de um dado CEP.
	 * 
	 * @return o identificador
	 */
	@Id
	@GeneratedValue(generator = "gen_cep")
	@Column(name = "id_cep", unique = true, nullable = false)
	public int getIdCep() {
		return this.idCep;
	}

	/**
	 * Define o identificador unívoco interno de um dado CEP.
	 * Não deve ser utilizado diretamente, uma vez que o identificador é automaticamente
	 * gerado pela implementação JPA utilizada na aplicação.
	 * 
	 * @param idCep o identificador a ser atribuído.
	 */
	public void setIdCep(int idCep) {
		this.idCep = idCep;
	}

	/**
	 * Recupera o número do CEP no formato DDDDD-DDD.
	 * 
	 * @return o número do CEP
	 */
	@Column(name = "nr_cep", nullable = false, length = 9, unique = true)
	@NotNull
	@Length(max = 9)
	public String getNumeroCep() {
		return this.numeroCep;
	}

	/**
	 * Atribui a esta entidade um número de CEP.
	 * 
	 * @param numeroCep o número do CEP no formato DDDDD-DDD
	 */
	public void setNumeroCep(String numeroCep) {
		this.numeroCep = numeroCep;
	}

	/**
	 * Recupera o logradouro a que está vinculado este CEP, se houver.
	 * 
	 * @return o logradouro, ou nulo se o CEP abranger mais de um logradouro
	 */
	@Column(name = "nm_logradouro", length = 200)
	@Length(max = 200)
	public String getNomeLogradouro() {
		return this.nomeLogradouro;
	}

	/**
	 * Atribui a este CEP um logradouro único.
	 * 
	 * @param nomeLogradouro o logradouro a ser atribuído
	 */
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	/**
	 * Recupera o nome do bairro vinculado a este CEP.
	 * 
	 * @return o nome do bairro, ou nulo se o CEP abranger mais de um bairro
	 */
	@Column(name = "nm_bairro", length = 100)
	@Length(max = 100)
	public String getNomeBairro() {
		return this.nomeBairro;
	}

	/**
	 * Atribui a este CEP um bairro único.
	 * 
	 * @param nomeBairro o nome do bairro a ser atribuído
	 */
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	/**
	 * Recupera o município federativo a que está vinculado o CEP.
	 * 
	 * @return o município
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * Atribui a este CEP um município de vinculação.
	 * 
	 * @param municipio o município a ser vinculado
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * Recupera o complemento de endereço vinculado a este CEP.
	 * 
	 * @return o complemento, ou nulo se o CEP abranger mais de uma unidade
	 * residencial, comercial ou geográfica
	 */
	@Column(name = "ds_complemento", length = 100)
	@Length(max = 100)
	public String getComplemento() {
		return this.complemento;
	}
   
	/**
	 * Atribui a este CEP um complemento de endereço.
	 * 
	 * @param complemento o complemento a ser atribuído
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Indica se este CEP está negocialmente ativo na aplicação.
	 * 
	 * @return true, se o CEP estiver ativo
	 */
	@Column(name = "in_ativo", nullable = false)
	@NotNull
	public Boolean getAtivo() {
		return this.ativo;
	}

	/**
	 * Permite indicar se o CEP está negocialmente ativo.
	 * 
	 * @param ativo indicação de atividade do CEP
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return numeroCep;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNumeroCep() == null) ? 0 : numeroCep.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cep))
			return false;
		Cep other = (Cep) obj;
		if (getNumeroCep() == null) {
			if (other.getNumeroCep() != null)
				return false;
		} else if (!numeroCep.equals(other.getNumeroCep()))
			return false;
		return true;
	}

	@Column(name = "nr_endereco_cep", length = 15)
	@Length(max = 15)
	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

}