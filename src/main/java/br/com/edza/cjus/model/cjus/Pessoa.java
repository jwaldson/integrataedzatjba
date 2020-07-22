package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer poloid) {
		super();
		this.poloid = poloid;
	}

	public Pessoa(Integer id, Integer pessoaid, String nome, String sexo, Timestamp dataNascimento,
			String numeroDocumentoPrincipal, String tipoPessoa, String cidadeNatural, String estadoNatural,
			String nacionalidade, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String estado, String pais, String codigoDocumento, String emissorDocumento,
			String tipoDocumento) {
		super();
		this.id = id;
		this.pessoaid = pessoaid;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.numeroDocumentoPrincipal = numeroDocumentoPrincipal;
		this.tipoPessoa = tipoPessoa;
		this.cidadeNatural = cidadeNatural;
		this.estadoNatural = estadoNatural;
		this.nacionalidade = nacionalidade;
		this.Cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.codigoDocumento = codigoDocumento;
		this.emissorDocumento = emissorDocumento;
		this.tipoDocumento = tipoDocumento;
	}

	@Id
	@Column(name = "pessoaid_adm")
	private Integer id;

	@Column(name = "poloid")
	private Integer poloid;

	@Column(name = "pessoaid")
	private Integer pessoaid;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "dtnascimento")
	private Timestamp dataNascimento;

	@Column(name = "numdocumentoprincipal")
	private String numeroDocumentoPrincipal;

	@Column(name = "tppessoa")
	private String tipoPessoa;

	@Column(name = "naturalidade")
	private String cidadeNatural;

	@Column(name = "ufnaturalidade")
	private String estadoNatural;

	@Column(name = "nacionalidade")
	private String nacionalidade;

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

	@Column(name = "municipio")
	private String cidade;

	@Column(name = "uf")
	private String estado;

	@Column(name = "pais")
	private String pais;
	
	@Column(name = "coddocumento")
	private String codigoDocumento;

	@Column(name = "emissordocumento")
	private String emissorDocumento;

	@Column(name = "tpdocumento")
	private String tipoDocumento;

//	@Column(name = "nome_detentora")
//	private String nomeDetentora;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoaid_adm")
	List<Advogado> advogados;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoaid")
	List<Pessoa> pessoasRelacionadas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoloid() {
		return poloid;
	}

	public void setPoloid(Integer poloid) {
		this.poloid = poloid;
	}

	public Integer getPessoaid() {
		return pessoaid;
	}

	public void setPessoaid(Integer pessoaid) {
		this.pessoaid = pessoaid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Timestamp getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroDocumentoPrincipal() {
		return numeroDocumentoPrincipal;
	}

	public void setNumeroDocumentoPrincipal(String numeroDocumentoPrincipal) {
		this.numeroDocumentoPrincipal = numeroDocumentoPrincipal;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCidadeNatural() {
		return cidadeNatural;
	}

	public void setCidadeNatural(String cidadeNatural) {
		this.cidadeNatural = cidadeNatural;
	}

	public String getEstadoNatural() {
		return estadoNatural;
	}

	public void setEstadoNatural(String estadoNatural) {
		this.estadoNatural = estadoNatural;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getEmissorDocumento() {
		return emissorDocumento;
	}

	public void setEmissorDocumento(String emissorDocumento) {
		this.emissorDocumento = emissorDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<Advogado> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<Advogado> advogados) {
		this.advogados = advogados;
	}

	public List<Pessoa> getPessoasRelacionadas() {
		return pessoasRelacionadas;
	}

	public void setPessoasRelacionadas(List<Pessoa> pessoasRelacionadas) {
		this.pessoasRelacionadas = pessoasRelacionadas;
	}
	
}

