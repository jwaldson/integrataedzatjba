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
@Table(name = "tr_tj_documento")
public class Documento implements Serializable {

	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documento(Integer id,   String documentoIdVinculado,
			Timestamp dataHoraDocumento, String descricaoDocumento, String hashDocumento,
			Integer nivelSigiloDocumento, String tipoDocumento, String conteudoDocumento, String mimetypeDocumento) {
		super();
		this.id = id;
		this.documentoIdVinculado = documentoIdVinculado;
		this.dataHoraDocumento = dataHoraDocumento;
		this.descricaoDocumento = descricaoDocumento;
		this.hashDocumento = hashDocumento;
		this.nivelSigiloDocumento = nivelSigiloDocumento;
		this.tipoDocumento = tipoDocumento;
		this.conteudoDocumento = conteudoDocumento;
		this.mimetypeDocumento = mimetypeDocumento;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "documentoid")
	private Integer id;

	@Column(name = "processoid")
	private Integer processoid;

	@Column(name = "documentoidvinculado")
	private String documentoIdVinculado;

	@Column(name = "datahoradocumento")
	private Timestamp dataHoraDocumento;

	@Column(name = "descricao")
	private String descricaoDocumento;

	@Column(name = "hashdocumento")
	private String hashDocumento;

	@Column(name = "nivelsigilo")
	private Integer nivelSigiloDocumento;

	@Column(name = "tipodocumento")
	private String tipoDocumento;

	@Column(name = "conteudodocumento")
	private String conteudoDocumento;

	@Column(name = "mimetypedocumento")
	private String mimetypeDocumento;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "documentoid")
	private List<Assinatura> assinatura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumentoIdVinculado() {
		return documentoIdVinculado;
	}

	public void setDocumentoIdVinculado(String documentoIdVinculado) {
		this.documentoIdVinculado = documentoIdVinculado;
	}

	public Timestamp getDataHoraDocumento() {
		return dataHoraDocumento;
	}

	public void setDataHoraDocumento(Timestamp dataHoraDocumento) {
		this.dataHoraDocumento = dataHoraDocumento;
	}

	public String getDescricaoDocumento() {
		return descricaoDocumento;
	}

	public void setDescricaoDocumento(String descricaoDocumento) {
		this.descricaoDocumento = descricaoDocumento;
	}

	public String getHashDocumento() {
		return hashDocumento;
	}

	public void setHashDocumento(String hashDocumento) {
		this.hashDocumento = hashDocumento;
	}

	public Integer getNivelSigiloDocumento() {
		return nivelSigiloDocumento;
	}

	public void setNivelSigiloDocumento(Integer nivelSigiloDocumento) {
		this.nivelSigiloDocumento = nivelSigiloDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getConteudoDocumento() {
		return conteudoDocumento;
	}

	public void setConteudoDocumento(String conteudoDocumento) {
		this.conteudoDocumento = conteudoDocumento;
	}

	public String getMimetypeDocumento() {
		return mimetypeDocumento;
	}

	public void setMimetypeDocumento(String mimetypeDocumento) {
		this.mimetypeDocumento = mimetypeDocumento;
	}

	public List<Assinatura> getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(List<Assinatura> assinatura) {
		this.assinatura = assinatura;
	}

	public Integer getProcessoid() {
		return processoid;
	}

	public void setProcessoid(Integer processoid) {
		this.processoid = processoid;
	}
}

