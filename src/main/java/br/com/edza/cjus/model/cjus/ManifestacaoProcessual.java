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
@Table(name = "tr_tj_processo")
public class ManifestacaoProcessual implements Serializable {

	private static final long serialVersionUID = 1L;

	public ManifestacaoProcessual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManifestacaoProcessual(Integer id, Integer statusProcessamento, String numeroProcesso, Timestamp dataEnvio,
			Integer classeProcessual, String codigoLocalidade, Double valorCausa, Boolean retornoSucesso,
			String retornoMensagem, String retornoProtocoloRecebimento, Timestamp retornoDataOperacao,
			String retornoRecibo, String conteudoRetornado, Timestamp dataGravacao, Timestamp dataStatus,
			String mensagemStatus) {
		super();
		this.id = id;
		this.statusProcessamento = statusProcessamento;
		this.numeroProcesso = numeroProcesso;
		this.dataEnvio = dataEnvio;
		this.classeProcessual = classeProcessual;
		this.codigoLocalidade = codigoLocalidade;
		this.valorCausa = valorCausa;
		this.retornoSucesso = retornoSucesso;
		this.retornoMensagem = retornoMensagem;
		this.retornoProtocoloRecebimento = retornoProtocoloRecebimento;
		this.retornoDataOperacao = retornoDataOperacao;
		this.retornoRecibo = retornoRecibo;
		this.conteudoRetornado = conteudoRetornado;
		this.dataGravacao = dataGravacao;
		this.dataStatus = dataStatus;
		this.mensagemStatus = mensagemStatus;
	}

	@Id
	@Column(name = "processoid")
	private Integer id;

	@Column(name = "configuracaoid")
	private Integer configuracaoid;

	@Column(name = "statusid")
	private Integer statusProcessamento;

	@Column(name = "numero")
	private String numeroProcesso;

	@Column(name = "dtenvio")
	private Timestamp dataEnvio;
	
	@Column(name = "classe")
	private Integer classeProcessual;
	
	@Column(name = "localidade")
	private String codigoLocalidade;
	
	@Column(name = "vlrcausa")
	private Double valorCausa;

	@Column(name = "retornosucesso")
	private Boolean retornoSucesso;

	@Column(name = "retornomensagem")
	private String retornoMensagem;

	@Column(name = "retornoprotocolorecebimento")
	private String retornoProtocoloRecebimento;

	@Column(name = "retornodataoperacao")
	private Timestamp retornoDataOperacao;

	@Column(name = "retornorecibo")
	private String retornoRecibo;

	@Column(name = "conteudoretornado")
	private String conteudoRetornado;

	@Column(name = "dtgravacao")
	private Timestamp dataGravacao;

	@Column(name = "dtstatus")
	private Timestamp dataStatus;

	@Column(name = "mensagemstatus")
	private String mensagemStatus;

	@Column(name = "loteid")
	private Integer loteid;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "processoid")
	private List<Polo> polo;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "processoid")
	private List<Documento> documentos;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "processoid")
	private List<AssuntoProcessual> assuntos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusProcessamento() {
		return statusProcessamento;
	}

	public void setStatusProcessamento(Integer statusProcessamento) {
		this.statusProcessamento = statusProcessamento;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Timestamp getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Timestamp dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getClasseProcessual() {
		return classeProcessual;
	}

	public void setClasseProcessual(Integer classeProcessual) {
		this.classeProcessual = classeProcessual;
	}

	public String getCodigoLocalidade() {
		return codigoLocalidade;
	}

	public void setCodigoLocalidade(String codigoLocalidade) {
		this.codigoLocalidade = codigoLocalidade;
	}

	public Double getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(Double valorCausa) {
		this.valorCausa = valorCausa;
	}

	public Boolean getRetornoSucesso() {
		return retornoSucesso;
	}

	public void setRetornoSucesso(Boolean retornoSucesso) {
		this.retornoSucesso = retornoSucesso;
	}

	public String getRetornoMensagem() {
		return retornoMensagem;
	}

	public void setRetornoMensagem(String retornoMensagem) {
		this.retornoMensagem = retornoMensagem;
	}

	public String getRetornoProtocoloRecebimento() {
		return retornoProtocoloRecebimento;
	}

	public void setRetornoProtocoloRecebimento(String retornoProtocoloRecebimento) {
		this.retornoProtocoloRecebimento = retornoProtocoloRecebimento;
	}

	public Timestamp getRetornoDataOperacao() {
		return retornoDataOperacao;
	}

	public void setRetornoDataOperacao(Timestamp retornoDataOperacao) {
		this.retornoDataOperacao = retornoDataOperacao;
	}

	public String getRetornoRecibo() {
		return retornoRecibo;
	}

	public void setRetornoRecibo(String retornoRecibo) {
		this.retornoRecibo = retornoRecibo;
	}

	public String getConteudoRetornado() {
		return conteudoRetornado;
	}

	public void setSaiConteudoRetornado(String saiConteudoRetornado) {
		this.conteudoRetornado = conteudoRetornado;
	}

	public Timestamp getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Timestamp dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Timestamp getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Timestamp dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getMensagemStatus() {
		return mensagemStatus;
	}

	public void setMensagemStatus(String mensagemStatus) {
		this.mensagemStatus = mensagemStatus;
	}

	public List<Polo> getPolo() {
		return polo;
	}

	public void setPolo(List<Polo> polo) {
		this.polo = polo;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<AssuntoProcessual> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<AssuntoProcessual> assuntos) {
		this.assuntos = assuntos;
	}

	public void setConteudoRetornado(String conteudoRetornado) {
		this.conteudoRetornado = conteudoRetornado;
	}

	public Integer getConfiguracaoid() {
		return configuracaoid;
	}

	public void setConfiguracaoid(Integer configuracaoid) {
		this.configuracaoid = configuracaoid;
	}

	public Integer getLoteid() {
		return loteid;
	}

	public void setLoteid(Integer loteid) {
		this.loteid = loteid;
	}

}
