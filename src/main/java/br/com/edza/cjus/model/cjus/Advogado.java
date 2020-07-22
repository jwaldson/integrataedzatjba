package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_advogado")
public class Advogado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Advogado(Integer id, Boolean intimacao, String nome, String inscricao, String numeroDocumentoPrincipal,
			String tipoRepresentante, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String estado, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.inscricao = inscricao;
		this.numeroDocumentoPrincipal = numeroDocumentoPrincipal;
		this.tipoRepresentante = tipoRepresentante;
		Cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	
	public Advogado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Advogado(Integer pessoaid_adm) {
		super();
		this.pessoaid_adm = pessoaid_adm;
	}

	@Id
	@Column(name = "advogadoid")
	private Integer id;

	@Column(name = "pessoaid_adm")
	private Integer pessoaid_adm;

	@Column(name = "nome")
	private String nome;

	@Column(name = "inscricao")
	private String inscricao;

	@Column(name = "numerodocumentoprincipal")
	private String numeroDocumentoPrincipal;

	@Column(name = "tiporepresentante")
	private String tipoRepresentante;

	@Column(name = "cep")
	private String Cep;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	@Column(name = "pais")
	private String pais;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPessoaidadm() {
		return pessoaid_adm;
	}

	public void setPessoaidadm(Integer pessoaidadm) {
		this.pessoaid_adm = pessoaidadm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getNumeroDocumentoPrincipal() {
		return numeroDocumentoPrincipal;
	}

	public void setNumeroDocumentoPrincipal(String numeroDocumentoPrincipal) {
		this.numeroDocumentoPrincipal = numeroDocumentoPrincipal;
	}

	public String getTipoRepresentante() {
		return tipoRepresentante;
	}

	public void setTipoRepresentante(String tipoRepresentante) {
		this.tipoRepresentante = tipoRepresentante;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}

