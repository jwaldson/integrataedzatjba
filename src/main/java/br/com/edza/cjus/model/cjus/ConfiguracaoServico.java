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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tr_tj_configuracao")
public class ConfiguracaoServico implements Serializable {

	private static final long serialVersionUID = 1L;

	public ConfiguracaoServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfiguracaoServico(Integer id, String idManifestante, String senhaManifestante) {
		super();
		this.id = id;
		this.idManifestante = idManifestante;
		this.senhaManifestante = senhaManifestante;
	}

	@Id
	@Column(name = "configuracaoid")
	private Integer id;

	@Column(name = "codigo")
	private String idManifestante;

	@Column(name = "senha")
	private String senhaManifestante;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "usuario")
	private String usuario;

	@Column(name = "classe")
	private Integer classe;

	@Column(name = "localidade")
	private String localidade;

	@Column(name = "codigonacionalassunto")
	private Integer codigonacionalassunto;
	
	@Column(name = "codigopeticaoinicial")
	private String codigopeticionalinicial;

	@Column(name = "codigocda")
	private String codigocda;

	@Column(name = "ativo")
	private String ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdManifestante() {
		return idManifestante;
	}

	public void setIdManifestante(String idManifestante) {
		this.idManifestante = idManifestante;
	}

	public String getSenhaManifestante() {
		return senhaManifestante;
	}

	public void setSenhaManifestante(String senhaManifestante) {
		this.senhaManifestante = senhaManifestante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getClasse() {
		return classe;
	}

	public void setClasse(Integer classe) {
		this.classe = classe;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Integer getCodigonacionalassunto() {
		return codigonacionalassunto;
	}

	public void setCodigonacionalassunto(Integer codigonacionalassunto) {
		this.codigonacionalassunto = codigonacionalassunto;
	}

	public String getCodigopeticionalinicial() {
		return codigopeticionalinicial;
	}

	public void setCodigopeticionalinicial(String codigopeticionalinicial) {
		this.codigopeticionalinicial = codigopeticionalinicial;
	}

	public String getCodigocda() {
		return codigocda;
	}

	public void setCodigocda(String codigocda) {
		this.codigocda = codigocda;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
