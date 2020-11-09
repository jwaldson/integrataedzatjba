package  br.com.edza.cjus.model.cjus;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;	
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transitorio_cnj_interop")
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transitorio_cnj_interop_id")
	private Integer id;
	
	@Column(name="entra_status_processamento")
	private String entra_status_processamento;

	@Column(name="id_manifestante")
	private String id_manifestante;

	@Column(name="senha_manifestante")
	private String senha_manifestante;

	@Column(name="classe_processual")
	private Integer classe_processual;

	@Column(name="codigo_localidade")
	private Integer codigo_localidade;

	@Column(name="competencia")
	private Integer competencia;

	@Column(name="modalidade_vinculacao_processo")
	private String modalidade_vinculacao_processo;

	@Column(name="prioridade")
	private String prioridade;

	@Column(name="valor_causa")
	private Double valor_causa;

	@Column(name="assistencia_judiciaria")
	private Boolean assistencia_judiciaria;

	@Column(name="nivel_sigilo")
	private BigInteger nivel_sigilo;

	@Column(name="data_ajuizamento")
	private String data_ajuizamento;

	@Column(name="outro_parametro")
	private String outro_parametro;
	
	@Column(name="polo")
	private String polo;

	@Column(name="parte_nome")
	private String parte_nome;

	@Column(name="parte_sexo")
	private String parte_sexo;

	@Column(name="parte_nome_genitor")
	private String parte_nome_genitor;

	@Column(name="parte_nome_genitora")
	private String parte_nome_genitora;

	@Column(name="parte_data_nascimento")
	private String parte_data_nascimento;

	@Column(name="parte_data_obito")
	private String parte_data_obito;

	@Column(name="parte_numero_documento_principal")
	private BigInteger parte_numero_documento_principal;

	@Column(name="parte_tipo_pessoa")
	private String parte_tipo_pessoa;

	@Column(name="parte_cidade_natural")
	private String parte_cidade_natural;

	@Column(name="parte_estado_natural")
	private String parte_estado_natural;

	@Column(name="parte_nacionalidade")
	private String parte_nacionalidade;

	@Column(name="parte_codigo_documento")
	private String parte_codigo_documento;

	@Column(name="parte_emissor_documento")
	private String parte_emissor_documento;

	@Column(name="parte_tipo_documento")
	private String parte_tipo_documento;

	@Column(name="parte_nome_detentora")
	private String parte_nome_detentora;

	@Column(name="parte_outro_nome")
	private String parte_outro_nome;

	@Column(name="endereco_cep")
	private String endereco_cep;
	
	@Column(name="endereco_logradouro")
	private String endereco_logradouro;

	@Column(name="endereco_numero")
	private String endereco_numero;

	@Column(name="endereco_complemento")
	private String endereco_complemento;

	@Column(name="endereco_bairro")
	private String endereco_bairro;

	@Column(name="endereco_cidade")
	private String endereco_cidade;
	
	@Column(name="endereco_estado")
	private String endereco_estado;

	@Column(name="endereco_pais")
	private String endereco_pais;

	@Column(name="repres_processual_intimacao")
	private Boolean repres_processual_intimacao;

	@Column(name="repres_processual_nome")
	private String repres_processual_nome;

	@Column(name="repres_processual_inscricao")
	private String repres_processual_inscricao;

	@Column(name="repres_processual_numero_documento_principal")
	private String repres_processual_numero_documento_principal;

	@Column(name="repres_processual_tipo_representante")
	private String repres_processual_tipo_representante;
	
	@Column(name="assunto_processual_principal")
	private Boolean assunto_processual_principal;

	@Column(name="assunto_processual_codigo_nacional")
	private Integer assunto_processual_codigo_nacional;

	@Column(name="assunto_processual_codigo_assunto")
	private Integer assunto_processual_codigo_assunto;

	@Column(name="assunto_processual_codigo_pai_acional")
	private Integer assunto_processual_codigo_pai_acional;

	@Column(name="assunto_processual_descricao")
	private String assunto_processual_descricao;

	@Column(name="id_documento")
	private String id_documento;

	@Column(name="id_documento_vinculado")
	private String id_documento_vinculado;

	@Column(name="tipo_documento_consultapje")
	private String tipo_documento_consultapje;

	@Column(name="data_hora_documento")
	private String data_hora_documento;

	@Column(name="descricao_documento")
	private String descricao_documento;

	@Column(name="hash_documento")
	private String hash_documento;

	@Column(name="nivel_sigilo_documento")
	private Integer nivel_sigilo_documento;

	@Column(name="tipo_documento")
	private String tipo_documento;

	@Column(name="conteudo_documento")
	private String conteudo_documento;

	@Column(name="mimetype_documento")
	private String mimetype_documento;

	@Column(name="assinatura")
	private String assinatura;

	@Column(name="algoritmo_hash_assinatura")
	private String algoritmo_hash_assinatura;

	@Column(name="cadeia_certificado_assinatura")
	private String cadeia_certificado_assinatura;

	@Column(name="codificacao_certificado_assinatura")
	private String codificacao_certificado_assinatura;

	@Column(name="dataassinatura")
	private String dataassinatura;

	@Column(name="signatariologin")
	private String signatariologin;

	@Column(name="retorno_sucesso")
	private Boolean retorno_sucesso;

	@Column(name="retorno_mensagem")
	private String retorno_mensagem;

	@Column(name="retorno_protocolo_recebimento")
	private BigInteger retorno_protocolo_recebimento;

	@Column(name="retorno_data_operacao")
	private String retorno_data_operacao;

	@Column(name="retorno_recibo")
	private String retorno_recibo;

	@Column(name="sai_conteudo_retornado")
	private String sai_conteudo_retornado;

	@Column(name="sai_data_atualizacao_registro")
	private String sai_data_atualizacao_registro;

	@Column(name="sai_erro_sistema")
	private String sai_erro_sistema;

	@Column(name="processoid")
	private Integer processoid;

	public Processo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Processo(Integer id, String id_manifestante, String senha_manifestante, Integer classe_processual, Integer codigo_localidade,
					Integer competencia, String modalidade_vinculacao_processo, String prioridade, Double valor_causa, Boolean assistencia_judiciaria, BigInteger nivel_sigilo,
					String data_ajuizamento, String outro_parametro, String polo, String parte_nome, String parte_sexo, String parte_nome_genitor, String parte_nome_genitora,
					String parte_data_nascimento, String parte_data_obito, BigInteger parte_numero_documento_principal, String parte_tipo_pessoa, String parte_cidade_natural,
					String parte_estado_natural, String parte_nacionalidade, String parte_codigo_documento, String parte_emissor_documento, String parte_tipo_documento,
					String parte_nome_detentora, String parte_outro_nome,String endereco_cep, String endereco_logradouro, String endereco_numero, String endereco_complemento,
					String endereco_bairro, String endereco_cidade, String endereco_estado, String endereco_pais, Boolean repres_processual_intimacao, String repres_processual_nome,
					String repres_processual_inscricao, String repres_processual_numero_documento_principal, String repres_processual_tipo_representante, Boolean assunto_processual_principal,
					Integer assunto_processual_codigo_nacional, Integer assunto_processual_codigo_assunto, Integer assunto_processual_codigo_pai_acional, String assunto_processual_descricao,
					String id_documento, String id_documento_vinculado, String tipo_documento_consultapje, String data_hora_documento, String descricao_documento, String hash_documento,
					Integer nivel_sigilo_documento, String tipo_documento, String conteudo_documento, String mimetype_documento, String assinatura, String algoritmo_hash_assinatura,
					String cadeia_certificado_assinatura, String codificacao_certificado_assinatura, String dataassinatura, String signatariologin, Boolean retorno_sucesso, 
					String retorno_mensagem, BigInteger retorno_protocolo_recebimento, String retorno_data_operacao, String retorno_recibo, String sai_conteudo_retornado, 
					String sai_data_atualizacao_registro, String sai_erro_sistema, Integer processoid)

 {
		  this.id=id;
		  this.id_manifestante=id_manifestante;
		  this.senha_manifestante=senha_manifestante;
		  this.classe_processual=classe_processual;
		  this.codigo_localidade=codigo_localidade;
		  this.competencia=competencia;
		  this.modalidade_vinculacao_processo=modalidade_vinculacao_processo;
		  this.prioridade=prioridade;
		  this.valor_causa=valor_causa;
		  this.assistencia_judiciaria=assistencia_judiciaria;
		  this.nivel_sigilo=nivel_sigilo;
		  this.data_ajuizamento=data_ajuizamento;
		  this.outro_parametro=outro_parametro;
		  this.polo=polo;
		  this.parte_nome=parte_nome;
		  this.parte_sexo=parte_sexo;
		  this.parte_nome_genitor=parte_nome_genitor;
		  this.parte_nome_genitora=parte_nome_genitora;
		  this.parte_data_nascimento=parte_data_nascimento;
		  this.parte_data_obito=parte_data_obito;
		  this.parte_numero_documento_principal=parte_numero_documento_principal;
		  this.parte_tipo_pessoa=parte_tipo_pessoa;
		  this.parte_cidade_natural=parte_cidade_natural;
		  this.parte_estado_natural=parte_estado_natural;
		  this.parte_nacionalidade=parte_nacionalidade;
		  this.parte_codigo_documento=parte_codigo_documento;
		  this.parte_emissor_documento=parte_emissor_documento;
		  this.parte_tipo_documento=parte_tipo_documento;
		  this.parte_nome_detentora=parte_nome_detentora;
		  this.parte_outro_nome=parte_outro_nome;
		  this.endereco_cep=endereco_cep;
		  this.endereco_logradouro=endereco_logradouro;
		  this.endereco_numero=endereco_numero;
		  this.endereco_complemento=endereco_complemento;
		  this.endereco_bairro=endereco_bairro;
		  this.endereco_cidade=endereco_cidade;
		  this.endereco_estado=endereco_estado;
		  this.endereco_pais=endereco_pais;
		  this.repres_processual_intimacao=repres_processual_intimacao;
		  this.repres_processual_nome=repres_processual_nome;
		  this.repres_processual_inscricao=repres_processual_inscricao;
		  this.repres_processual_numero_documento_principal=repres_processual_numero_documento_principal;
		  this.repres_processual_tipo_representante=repres_processual_tipo_representante;
		  this.assunto_processual_principal=assunto_processual_principal;
		  this.assunto_processual_codigo_nacional=assunto_processual_codigo_nacional;
		  this.assunto_processual_codigo_assunto=assunto_processual_codigo_assunto;
		  this.assunto_processual_codigo_pai_acional=assunto_processual_codigo_pai_acional;
		  this.assunto_processual_descricao=assunto_processual_descricao;
		  this.id_documento=id_documento;
		  this.id_documento_vinculado=id_documento_vinculado;
		  this.tipo_documento_consultapje=tipo_documento_consultapje;
		  this.data_hora_documento=data_hora_documento;
		  this.descricao_documento=descricao_documento;
		  this.hash_documento=hash_documento;
		  this.nivel_sigilo_documento=nivel_sigilo_documento;
		  this.tipo_documento=tipo_documento;
		  this.conteudo_documento=conteudo_documento;
		  this.mimetype_documento=mimetype_documento;
		  this.assinatura=assinatura;
		  this.algoritmo_hash_assinatura=algoritmo_hash_assinatura;
		  this.cadeia_certificado_assinatura=cadeia_certificado_assinatura;
		  this.codificacao_certificado_assinatura=codificacao_certificado_assinatura;
		  this.dataassinatura=dataassinatura;
		  this.signatariologin=signatariologin;
		  this.retorno_sucesso=retorno_sucesso;
		  this.retorno_mensagem=retorno_mensagem;
		  this.retorno_protocolo_recebimento=retorno_protocolo_recebimento;
		  this.retorno_data_operacao=retorno_data_operacao;
		  this.retorno_recibo=retorno_recibo;
		  this.sai_conteudo_retornado=sai_conteudo_retornado;
		  this.sai_data_atualizacao_registro=sai_data_atualizacao_registro;
		  this.sai_erro_sistema=sai_erro_sistema;
		  this.processoid=processoid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntra_status_processamento() {
		return entra_status_processamento;
	}

	public void setEntra_status_processamento(String entra_status_processamento) {
		this.entra_status_processamento = entra_status_processamento;
	}

	public String getId_manifestante() {
		return id_manifestante;
	}

	public void setId_manifestante(String id_manifestante) {
		this.id_manifestante = id_manifestante;
	}

	public String getSenha_manifestante() {
		return senha_manifestante;
	}

	public void setSenha_manifestante(String senha_manifestante) {
		this.senha_manifestante = senha_manifestante;
	}

	public Integer getClasse_processual() {
		return classe_processual;
	}

	public void setClasse_processual(Integer classe_processual) {
		this.classe_processual = classe_processual;
	}

	public Integer getCodigo_localidade() {
		return codigo_localidade;
	}

	public void setCodigo_localidade(Integer codigo_localidade) {
		this.codigo_localidade = codigo_localidade;
	}

	public Integer getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Integer competencia) {
		this.competencia = competencia;
	}

	public String getModalidade_vinculacao_processo() {
		return modalidade_vinculacao_processo;
	}

	public void setModalidade_vinculacao_processo(String modalidade_vinculacao_processo) {
		this.modalidade_vinculacao_processo = modalidade_vinculacao_processo;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Double getValor_causa() {
		return valor_causa;
	}

	public void setValor_causa(Double valor_causa) {
		this.valor_causa = valor_causa;
	}

	public Boolean getAssistencia_judiciaria() {
		return assistencia_judiciaria;
	}

	public void setAssistencia_judiciaria(Boolean assistencia_judiciaria) {
		this.assistencia_judiciaria = assistencia_judiciaria;
	}

	public BigInteger getNivel_sigilo() {
		return nivel_sigilo;
	}

	public void setNivel_sigilo(BigInteger nivel_sigilo) {
		this.nivel_sigilo = nivel_sigilo;
	}

	public String getData_ajuizamento() {
		return data_ajuizamento;
	}

	public void setData_ajuizamento(String data_ajuizamento) {
		this.data_ajuizamento = data_ajuizamento;
	}

	public String getOutro_parametro() {
		return outro_parametro;
	}

	public void setOutro_parametro(String outro_parametro) {
		this.outro_parametro = outro_parametro;
	}

	public String getPolo() {
		return polo;
	}

	public void setPolo(String polo) {
		this.polo = polo;
	}

	public String getParte_nome() {
		return parte_nome;
	}

	public void setParte_nome(String parte_nome) {
		this.parte_nome = parte_nome;
	}

	public String getParte_sexo() {
		return parte_sexo;
	}

	public void setParte_sexo(String parte_sexo) {
		this.parte_sexo = parte_sexo;
	}

	public String getParte_nome_genitor() {
		return parte_nome_genitor;
	}

	public void setParte_nome_genitor(String parte_nome_genitor) {
		this.parte_nome_genitor = parte_nome_genitor;
	}

	public String getParte_nome_genitora() {
		return parte_nome_genitora;
	}

	public void setParte_nome_genitora(String parte_nome_genitora) {
		this.parte_nome_genitora = parte_nome_genitora;
	}

	public String getParte_data_nascimento() {
		return parte_data_nascimento;
	}

	public void setParte_data_nascimento(String parte_data_nascimento) {
		this.parte_data_nascimento = parte_data_nascimento;
	}

	public String getParte_data_obito() {
		return parte_data_obito;
	}

	public void setParte_data_obito(String parte_data_obito) {
		this.parte_data_obito = parte_data_obito;
	}

	public BigInteger getParte_numero_documento_principal() {
		return parte_numero_documento_principal;
	}

	public void setParte_numero_documento_principal(BigInteger parte_numero_documento_principal) {
		this.parte_numero_documento_principal = parte_numero_documento_principal;
	}

	public String getParte_tipo_pessoa() {
		return parte_tipo_pessoa;
	}

	public void setParte_tipo_pessoa(String parte_tipo_pessoa) {
		this.parte_tipo_pessoa = parte_tipo_pessoa;
	}

	public String getParte_cidade_natural() {
		return parte_cidade_natural;
	}

	public void setParte_cidade_natural(String parte_cidade_natural) {
		this.parte_cidade_natural = parte_cidade_natural;
	}

	public String getParte_estado_natural() {
		return parte_estado_natural;
	}

	public void setParte_estado_natural(String parte_estado_natural) {
		this.parte_estado_natural = parte_estado_natural;
	}

	public String getParte_nacionalidade() {
		return parte_nacionalidade;
	}

	public void setParte_nacionalidade(String parte_nacionalidade) {
		this.parte_nacionalidade = parte_nacionalidade;
	}

	public String getParte_codigo_documento() {
		return parte_codigo_documento;
	}

	public void setParte_codigo_documento(String parte_codigo_documento) {
		this.parte_codigo_documento = parte_codigo_documento;
	}

	public String getParte_emissor_documento() {
		return parte_emissor_documento;
	}

	public void setParte_emissor_documento(String parte_emissor_documento) {
		this.parte_emissor_documento = parte_emissor_documento;
	}

	public String getParte_tipo_documento() {
		return parte_tipo_documento;
	}

	public void setParte_tipo_documento(String parte_tipo_documento) {
		this.parte_tipo_documento = parte_tipo_documento;
	}

	public String getParte_nome_detentora() {
		return parte_nome_detentora;
	}

	public void setParte_nome_detentora(String parte_nome_detentora) {
		this.parte_nome_detentora = parte_nome_detentora;
	}

	public String getParte_outro_nome() {
		return parte_outro_nome;
	}

	public void setParte_outro_nome(String parte_outro_nome) {
		this.parte_outro_nome = parte_outro_nome;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

	public String getEndereco_logradouro() {
		return endereco_logradouro;
	}

	public void setEndereco_logradouro(String endereco_logradouro) {
		this.endereco_logradouro = endereco_logradouro;
	}

	public String getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public String getEndereco_complemento() {
		return endereco_complemento;
	}

	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

	public String getEndereco_bairro() {
		return endereco_bairro;
	}

	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}

	public String getEndereco_cidade() {
		return endereco_cidade;
	}

	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}

	public String getEndereco_estado() {
		return endereco_estado;
	}

	public void setEndereco_estado(String endereco_estado) {
		this.endereco_estado = endereco_estado;
	}

	public String getEndereco_pais() {
		return endereco_pais;
	}

	public void setEndereco_pais(String endereco_pais) {
		this.endereco_pais = endereco_pais;
	}

	public Boolean getRepres_processual_intimacao() {
		return repres_processual_intimacao;
	}

	public void setRepres_processual_intimacao(Boolean repres_processual_intimacao) {
		this.repres_processual_intimacao = repres_processual_intimacao;
	}

	public String getRepres_processual_nome() {
		return repres_processual_nome;
	}

	public void setRepres_processual_nome(String repres_processual_nome) {
		this.repres_processual_nome = repres_processual_nome;
	}

	public String getRepres_processual_inscricao() {
		return repres_processual_inscricao;
	}

	public void setRepres_processual_inscricao(String repres_processual_inscricao) {
		this.repres_processual_inscricao = repres_processual_inscricao;
	}

	public String getRepres_processual_numero_documento_principal() {
		return repres_processual_numero_documento_principal;
	}

	public void setRepres_processual_numero_documento_principal(String repres_processual_numero_documento_principal) {
		this.repres_processual_numero_documento_principal = repres_processual_numero_documento_principal;
	}

	public String getRepres_processual_tipo_representante() {
		return repres_processual_tipo_representante;
	}

	public void setRepres_processual_tipo_representante(String repres_processual_tipo_representante) {
		this.repres_processual_tipo_representante = repres_processual_tipo_representante;
	}

	public Boolean getAssunto_processual_principal() {
		return assunto_processual_principal;
	}

	public void setAssunto_processual_principal(Boolean assunto_processual_principal) {
		this.assunto_processual_principal = assunto_processual_principal;
	}

	public Integer getAssunto_processual_codigo_nacional() {
		return assunto_processual_codigo_nacional;
	}

	public void setAssunto_processual_codigo_nacional(Integer assunto_processual_codigo_nacional) {
		this.assunto_processual_codigo_nacional = assunto_processual_codigo_nacional;
	}

	public Integer getAssunto_processual_codigo_assunto() {
		return assunto_processual_codigo_assunto;
	}

	public void setAssunto_processual_codigo_assunto(Integer assunto_processual_codigo_assunto) {
		this.assunto_processual_codigo_assunto = assunto_processual_codigo_assunto;
	}

	public Integer getAssunto_processual_codigo_pai_acional() {
		return assunto_processual_codigo_pai_acional;
	}

	public void setAssunto_processual_codigo_pai_acional(Integer assunto_processual_codigo_pai_acional) {
		this.assunto_processual_codigo_pai_acional = assunto_processual_codigo_pai_acional;
	}

	public String getAssunto_processual_descricao() {
		return assunto_processual_descricao;
	}

	public void setAssunto_processual_descricao(String assunto_processual_descricao) {
		this.assunto_processual_descricao = assunto_processual_descricao;
	}

	public String getId_documento() {
		return id_documento;
	}

	public void setId_documento(String id_documento) {
		this.id_documento = id_documento;
	}

	public String getId_documento_vinculado() {
		return id_documento_vinculado;
	}

	public void setId_documento_vinculado(String id_documento_vinculado) {
		this.id_documento_vinculado = id_documento_vinculado;
	}

	public String getTipo_documento_consultapje() {
		return tipo_documento_consultapje;
	}

	public void setTipo_documento_consultapje(String tipo_documento_consultapje) {
		this.tipo_documento_consultapje = tipo_documento_consultapje;
	}

	public String getData_hora_documento() {
		return data_hora_documento;
	}

	public void setData_hora_documento(String data_hora_documento) {
		this.data_hora_documento = data_hora_documento;
	}

	public String getDescricao_documento() {
		return descricao_documento;
	}

	public void setDescricao_documento(String descricao_documento) {
		this.descricao_documento = descricao_documento;
	}

	public String getHash_documento() {
		return hash_documento;
	}

	public void setHash_documento(String hash_documento) {
		this.hash_documento = hash_documento;
	}

	public Integer getNivel_sigilo_documento() {
		return nivel_sigilo_documento;
	}

	public void setNivel_sigilo_documento(Integer nivel_sigilo_documento) {
		this.nivel_sigilo_documento = nivel_sigilo_documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getConteudo_documento() {
		return conteudo_documento;
	}

	public void setConteudo_documento(String conteudo_documento) {
		this.conteudo_documento = conteudo_documento;
	}

	public String getMimetype_documento() {
		return mimetype_documento;
	}

	public void setMimetype_documento(String mimetype_documento) {
		this.mimetype_documento = mimetype_documento;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public String getAlgoritmo_hash_assinatura() {
		return algoritmo_hash_assinatura;
	}

	public void setAlgoritmo_hash_assinatura(String algoritmo_hash_assinatura) {
		this.algoritmo_hash_assinatura = algoritmo_hash_assinatura;
	}

	public String getCadeia_certificado_assinatura() {
		return cadeia_certificado_assinatura;
	}

	public void setCadeia_certificado_assinatura(String cadeia_certificado_assinatura) {
		this.cadeia_certificado_assinatura = cadeia_certificado_assinatura;
	}

	public String getCodificacao_certificado_assinatura() {
		return codificacao_certificado_assinatura;
	}

	public void setCodificacao_certificado_assinatura(String codificacao_certificado_assinatura) {
		this.codificacao_certificado_assinatura = codificacao_certificado_assinatura;
	}

	public String getDataassinatura() {
		return dataassinatura;
	}

	public void setDataassinatura(String dataassinatura) {
		this.dataassinatura = dataassinatura;
	}

	public String getSignatariologin() {
		return signatariologin;
	}

	public void setSignatariologin(String signatariologin) {
		this.signatariologin = signatariologin;
	}

	public Boolean getRetorno_sucesso() {
		return retorno_sucesso;
	}

	public void setRetorno_sucesso(Boolean retorno_sucesso) {
		this.retorno_sucesso = retorno_sucesso;
	}

	public String getRetorno_mensagem() {
		return retorno_mensagem;
	}

	public void setRetorno_mensagem(String retorno_mensagem) {
		this.retorno_mensagem = retorno_mensagem;
	}

	public BigInteger getRetorno_protocolo_recebimento() {
		return retorno_protocolo_recebimento;
	}

	public void setRetorno_protocolo_recebimento(BigInteger retorno_protocolo_recebimento) {
		this.retorno_protocolo_recebimento = retorno_protocolo_recebimento;
	}

	public String getRetorno_data_operacao() {
		return retorno_data_operacao;
	}

	public void setRetorno_data_operacao(String retorno_data_operacao) {
		this.retorno_data_operacao = retorno_data_operacao;
	}

	public String getRetorno_recibo() {
		return retorno_recibo;
	}

	public void setRetorno_recibo(String retorno_recibo) {
		this.retorno_recibo = retorno_recibo;
	}

	public String getSai_conteudo_retornado() {
		return sai_conteudo_retornado;
	}

	public void setSai_conteudo_retornado(String sai_conteudo_retornado) {
		this.sai_conteudo_retornado = sai_conteudo_retornado;
	}

	public String getSai_data_atualizacao_registro() {
		return sai_data_atualizacao_registro;
	}

	public void setSai_data_atualizacao_registro(String sai_data_atualizacao_registro) {
		this.sai_data_atualizacao_registro = sai_data_atualizacao_registro;
	}

	public String getSai_erro_sistema() {
		return sai_erro_sistema;
	}

	public void setSai_erro_sistema(String sai_erro_sistema) {
		this.sai_erro_sistema = sai_erro_sistema;
	}

	public Integer getProcessoid() {
		return processoid;
	}

	public void setProcessoid(Integer processoid) {
		this.processoid = processoid;
	}

}
