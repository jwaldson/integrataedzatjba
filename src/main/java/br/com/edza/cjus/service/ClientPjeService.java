package br.com.edza.cjus.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.TimeZone;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.edza.cjus.model.cjus.Advogado;
import br.com.edza.cjus.model.cjus.Assinatura;
import br.com.edza.cjus.model.cjus.AssuntoProcessual;
import br.com.edza.cjus.model.cjus.ConfiguracaoServico;
import br.com.edza.cjus.model.cjus.Documento;
import br.com.edza.cjus.model.cjus.ManifestacaoProcessual;
import br.com.edza.cjus.model.cjus.Pessoa;
import br.com.edza.cjus.model.cjus.Polo;
import br.com.edza.cjus.repository.AdvogadoRepository;
import br.com.edza.cjus.repository.AssinaturaRepository;
import br.com.edza.cjus.repository.AssuntoProcessualRepository;
import br.com.edza.cjus.repository.ConfiguracaoServicoRepository;
import br.com.edza.cjus.repository.DocumentoRepository;
import br.com.edza.cjus.repository.ManifestacaoProcessualRepository;
import br.com.edza.cjus.repository.PessoaRepository;
import br.com.edza.cjus.repository.PoloRepository;
import br.jus.cnj.intercomunicacao_2_2.ModalidadeDocumentoIdentificador;
import br.jus.cnj.intercomunicacao_2_2.ModalidadeGeneroPessoa;
import br.jus.cnj.intercomunicacao_2_2.ModalidadePoloProcessual;
import br.jus.cnj.intercomunicacao_2_2.ModalidadeRepresentanteProcessual;
import br.jus.cnj.intercomunicacao_2_2.TipoAssinatura;
import br.jus.cnj.intercomunicacao_2_2.TipoAssuntoProcessual;
import br.jus.cnj.intercomunicacao_2_2.TipoCabecalhoProcesso;
import br.jus.cnj.intercomunicacao_2_2.TipoDocumento;
import br.jus.cnj.intercomunicacao_2_2.TipoDocumentoIdentificacao;
import br.jus.cnj.intercomunicacao_2_2.TipoEndereco;
import br.jus.cnj.intercomunicacao_2_2.TipoParte;
import br.jus.cnj.intercomunicacao_2_2.TipoPessoa;
import br.jus.cnj.intercomunicacao_2_2.TipoPoloProcessual;
import br.jus.cnj.intercomunicacao_2_2.TipoQualificacaoPessoa;
import br.jus.cnj.intercomunicacao_2_2.TipoRepresentanteProcessual;
import br.jus.cnj.servico_intercomunicacao_2_2_2.ServicoIntercomunicacao222;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoEntregarManifestacaoProcessual;
import br.jus.cnj.tipos_servico_intercomunicacao_2_2.TipoEntregarManifestacaoProcessualResposta;

@Component
public class ClientPjeService {	
	
	
    @Autowired
    ServicoIntercomunicacao222 pjeService;
  
    @Autowired
    private ManifestacaoProcessualRepository repository;
    
    @Autowired
    private ConfiguracaoServicoRepository repositoryConfiguracaoServico;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AdvogadoRepository advRepository;
    
    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private DocumentoRepository documentoRepository;
    
    @Autowired
    private PoloRepository poloRepository;

    @Autowired
    private AssuntoProcessualRepository assuntoRepository;
    
    @Autowired                                                
    private ConfiguracaoServicoRepository configuracaoRepository;
 
    private final static String TIMESTAMP_PATTERN = "yyyy-MM-dd";
    private final static DateFormat TIMESTAMP_FORMATTER = new SimpleDateFormat(TIMESTAMP_PATTERN);
    private final static TimeZone IST_TIMEZONE = TimeZone.getTimeZone("IST");

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dateTimeFormatter_yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    
    
    public void entregarManifestacaoProcessual() {
    	//teste();
    	
   	   	List<ManifestacaoProcessual> processos = repository.consultaRegistrosProcessar();
   	   	for (ManifestacaoProcessual processo : processos) {

   	   		TipoEntregarManifestacaoProcessual tienmap = new TipoEntregarManifestacaoProcessual();

   	   		try {

	   	   		ConfiguracaoServico consultarconfiguracaoSistema = repositoryConfiguracaoServico.consultarconfiguracaoSistema(processo.getConfiguracaoid());
	   	   		if (consultarconfiguracaoSistema==null) {
	   	   			throw new Exception("Paramentos autenticação insuficientes! Processo Configuração Id: " + processo.getConfiguracaoid());
	   	   		}
	   	   		
	   	   		tienmap.setDataEnvio(new SimpleDateFormat("yyyyMMdd").format(processo.getDataEnvio()));
	   	   		tienmap.setIdManifestante(consultarconfiguracaoSistema.getIdManifestante());
	   	   		String numeroProcesso = processo.getNumeroProcesso();
				if (numeroProcesso==null) {
	   	   			throw new Exception("Paramentos autenticação insuficientes! Número do Processo null. Processo Configuração Id: " + processo.getConfiguracaoid());
	   	   		}
	   	   		tienmap.setNumeroProcesso(numeroProcesso);
	   	   		String senhaManifestante = consultarconfiguracaoSistema.getSenhaManifestante();
				if (senhaManifestante==null) {
	   	   			throw new Exception("Paramentos autenticação insuficientes! Senha null. Processo Configuração Id: " + processo.getConfiguracaoid());
	   	   		}
	   	   		tienmap.setSenhaManifestante(senhaManifestante);
	
	    		TipoCabecalhoProcesso tdb = new TipoCabecalhoProcesso();
	    		Integer classeProcessual = processo.getClasseProcessual();
				tdb.setClasseProcessual(classeProcessual!=null?classeProcessual:null);
	    		String codigoLocalidade = processo.getCodigoLocalidade();
				tdb.setCodigoLocalidade(codigoLocalidade!=null?codigoLocalidade:null);
	    		Double valorCausa = processo.getValorCausa();
				tdb.setValorCausa(valorCausa!=null?valorCausa:null);
   	   		
   	   	    	Integer id = processo.getId();
				List<Documento> documentosProcesso = documentoRepository.consultarDocumento(id);
				
				if (documentosProcesso!=null) {
	   	   	    	for (Documento documentoProcesso:documentosProcesso) {
	   	   	    		TipoDocumento td = new TipoDocumento();
	   	   	    		String conteudoDocumento = documentoProcesso.getConteudoDocumento();
	   	   	    		if (conteudoDocumento!=null) {
	   	   	    			ByteArrayDataSource ds = new ByteArrayDataSource(conteudoDocumento.getBytes(),"text/plain");
	   	   	    			td.setConteudo(new DataHandler(ds));
	   	   	    		}	
	   	   	    		Timestamp dataHoraDocumento = documentoProcesso.getDataHoraDocumento();
	   	   	    		if (dataHoraDocumento !=null) {
	   	   	    			td.setDataHora(new SimpleDateFormat("yyyyMMddHHmmss").format(dataHoraDocumento));
	   	   	    		}	
	   	   	    		String descricaoDocumento = documentoProcesso.getDescricaoDocumento();
						td.setDescricao(descricaoDocumento!=null?descricaoDocumento:null);
	   	   	    		String hashDocumento = documentoProcesso.getHashDocumento();
						td.setHash(hashDocumento!=null?hashDocumento:null);
	   	   	    		String documentoIdVinculado = documentoProcesso.getDocumentoIdVinculado();
						td.setIdDocumentoVinculado(documentoIdVinculado!=null?documentoIdVinculado:null);
	   	   	    		String mimetypeDocumento = documentoProcesso.getMimetypeDocumento();
						td.setMimetype(mimetypeDocumento!=null?mimetypeDocumento:null);
	   	   	    		Integer nivelSigiloDocumento = documentoProcesso.getNivelSigiloDocumento();
						td.setNivelSigilo(nivelSigiloDocumento!=null?nivelSigiloDocumento:null);
	   	   	    		String tipoDocumento = documentoProcesso.getTipoDocumento();
						td.setTipoDocumentoLocal(tipoDocumento!=null?tipoDocumento:null);
	   	   	    		Integer iddoc = documentoProcesso.getId();
	   	   	    		if (iddoc!=null) {
							List<Assinatura> assinaturasDocumentos = assinaturaRepository.consultarAssinatura(iddoc);
							if (assinaturasDocumentos!=null) {
			   	   	    		for (Assinatura assinaturaDocumento:assinaturasDocumentos) {
			   	   	    			TipoAssinatura ta = new TipoAssinatura();
			   	   	    			String algoritmoHashAssinatura = assinaturaDocumento.getAlgoritmoHashAssinatura();
									ta.setAlgoritmoHash(algoritmoHashAssinatura!=null?algoritmoHashAssinatura:null);
			   	   	    			String assinatura = assinaturaDocumento.getAssinatura();
									ta.setAssinatura(assinatura!=null?assinatura:null);
			   	   	    			String cadeiaCertificadoAssinatura = assinaturaDocumento.getCadeiaCertificadoAssinatura();
									ta.setCadeiaCertificado(cadeiaCertificadoAssinatura!=null?cadeiaCertificadoAssinatura:null);
			   	   	    			String codificacaoCertificadoAssinatura = assinaturaDocumento.getCodificacaoCertificadoAssinatura();
									ta.setCodificacaoCertificado(codificacaoCertificadoAssinatura!=null?codificacaoCertificadoAssinatura:null);
			   	   	    			Timestamp dataAssinatura = assinaturaDocumento.getDataAssinatura();
			   	   	    			if (dataAssinatura!=null) {
			   	   	    				ta.setDataAssinatura(new SimpleDateFormat("yyyyMMddHHmmss").format(dataAssinatura));
			   	   	    			}	
			   	   	    			td.getAssinatura().add(ta);
			   	   	    		}
							}	
	   	   	    		}
	   	   	    		tienmap.getDocumento().add(td);
	   	   	    	}
	   	    	    	
	   	    		List<AssuntoProcessual> assuntos = assuntoRepository.consultaRegistrosProcessar(id);
	   	    		if (assuntos != null) {
		   	    		for (AssuntoProcessual assunto:assuntos) {
		   	    	    		TipoAssuntoProcessual tap = new TipoAssuntoProcessual();
		   	    	    		Integer codigoNacional = assunto.getCodigoNacional();
								tap.setCodigoNacional(codigoNacional!=null?codigoNacional:null);
		   	    	    		tap.setPrincipal(assunto.getPrincipal()=="S"?true:false);
		   	    	    		tdb.getAssunto().add(tap);
		    	    	}
	   	    		}	   	    	    		
	    	    	List<Polo> polos = poloRepository.consultaRegistrosProcessar(id);
	    	    	if (polos!=null) {
		    	    	for (Polo polo:polos) {
	   	    	    		TipoPoloProcessual tp = new TipoPoloProcessual();
	   	    	    		String modalidadeProcessual = polo.getModalidadeProcessual();
	   	    	    		if (modalidadeProcessual!=null) { 
	   	    	    			tp.setPolo(ModalidadePoloProcessual.fromValue(modalidadeProcessual));
	   	    	    		}
	   	    	    		
	   	    	    		Integer poloId = polo.getId();
	   	    	    		if (poloId!=null) {
								List<Pessoa> pessoas = pessoaRepository.consultarPessoa(poloId);
								if (pessoas!=null) {
			   	    	    		for (Pessoa pessoa:pessoas) {
			   	    	    			TipoParte tpp = new TipoParte();
			   	    	    			Integer pessoaId = pessoa.getId();
			   	    	    			if (pessoaId!=null) {
											List<Advogado> advogados = advRepository.consultarAdvogado(pessoaId);
											if (advogados!=null) {
					   	    	    			for (Advogado advogado:advogados) {
					   	    	    				TipoRepresentanteProcessual adv = new TipoRepresentanteProcessual();
					   	    	    				String inscricao = advogado.getInscricao();
													adv.setInscricao(inscricao!=null?inscricao:null);
					   	    	    				String nome = advogado.getNome();
													adv.setNome(nome!=null?nome:null);
					   	    	    				String numeroDocumentoPrincipal = advogado.getNumeroDocumentoPrincipal();
													adv.setNumeroDocumentoPrincipal(numeroDocumentoPrincipal!=null?numeroDocumentoPrincipal:null);
					   	    	    				String tipoRepresentante = advogado.getTipoRepresentante();
					   	    	    				if (tipoRepresentante!=null) {
					   	    	    					ModalidadeRepresentanteProcessual fromValue = ModalidadeRepresentanteProcessual.fromValue(tipoRepresentante);
					   	    	    					adv.setTipoRepresentante(fromValue);
					   	    	    				}
					    	    					TipoEndereco enderecoAdvogado = new TipoEndereco(); 
					   	    	    				String bairro = advogado.getBairro();
													enderecoAdvogado.setBairro(bairro!=null?bairro:null);
					  	    	    				String cep = advogado.getCep();
													enderecoAdvogado.setCep(cep!=null?cep:null);
					   	    	    				String cidade = advogado.getCidade();
													enderecoAdvogado.setCidade(cidade!=null?cidade:null);
					   	    	    				String complemento = advogado.getComplemento();
													enderecoAdvogado.setComplemento(complemento!=null?complemento:null);
					  	    	    				String estado = advogado.getEstado();
													enderecoAdvogado.setEstado(estado!=null?estado:null);
					  	    	    				String logradouro = advogado.getLogradouro();
													enderecoAdvogado.setLogradouro(logradouro!=null?logradouro:null);
					   	    	    				String numero = advogado.getNumero();
													enderecoAdvogado.setNumero(numero!=null?numero:null);
					   	    	    				String pais = advogado.getPais();
													enderecoAdvogado.setPais(pais!=null?pais:null);
					   	    	    				adv.getEndereco().add(enderecoAdvogado);	
					   	    	    				tpp.getAdvogado().add(adv);
					   	    	    			}
											}	
				    	    				TipoPessoa tpa = new TipoPessoa();
				      	    				String cidadeNatural = pessoa.getCidadeNatural();
											tpa.setCidadeNatural(cidadeNatural!=null?cidadeNatural:null);
				      	    				if (pessoa.getDataNascimento()!=null) {
				      	    					tpa.setDataNascimento(new SimpleDateFormat("yyyyMMdd").format(pessoa.getDataNascimento()));
				      	    				}	
				    	    				String estadoNatural = pessoa.getEstadoNatural();
											tpa.setEstadoNatural(estadoNatural!=null?estadoNatural:null);
				    	    				String nacionalidade = pessoa.getNacionalidade();
											tpa.setNacionalidade(nacionalidade!=null?nacionalidade:null);
				    	    				String nome = pessoa.getNome();
											tpa.setNome(nome!=null?nome:null);
				    	    				String numeroDocumentoPrincipal = pessoa.getNumeroDocumentoPrincipal();
											tpa.setNumeroDocumentoPrincipal(numeroDocumentoPrincipal!=null?numeroDocumentoPrincipal:null);
				//   	    	    				tpa.setPessoaVinculada(pessoaParte.get);
				    	    				if (pessoa.getSexo()!=null) {
				    	    					ModalidadeGeneroPessoa fromValue = ModalidadeGeneroPessoa.fromValue(pessoa.getSexo());
				        	    				tpa.setSexo(fromValue);
				    	    				}	
				    	    				if (pessoa.getTipoPessoa()!=null) {
				    	    					TipoQualificacaoPessoa fromValue2 = TipoQualificacaoPessoa.fromValue(pessoa.getTipoPessoa());
				    	    					tpa.setTipoPessoa(fromValue2);
				    	    				}		
				   	   						TipoEndereco endPessoaParte = new TipoEndereco(); 
				   	   						String bairro = pessoa.getBairro();
											endPessoaParte.setBairro(bairro!=null?bairro:null);
				   	   						String cep = pessoa.getCep();
											endPessoaParte.setCep(cep!=null?cep:null);
				   	   						String cidade = pessoa.getCidade();
											endPessoaParte.setCidade(cidade!=null?cidade:null);
				   	   						String complemento = pessoa.getComplemento();
											endPessoaParte.setComplemento(complemento!=null?complemento:null);
				   	   						String estado = pessoa.getEstado();
											endPessoaParte.setEstado(estado!=null?estado:null);
				   	   						String logradouro = pessoa.getLogradouro();
											endPessoaParte.setLogradouro(logradouro!=null?logradouro:null);
				   	   						String numero = pessoa.getNumero();
											endPessoaParte.setNumero(numero!=null?numero:null);
				   	   						String pais = pessoa.getPais();
											endPessoaParte.setPais(pais!=null?pais:null);
				   	   						tpa.getEndereco().add(endPessoaParte);	
				   	    	    					
				   	   						TipoDocumentoIdentificacao tdoci = new TipoDocumentoIdentificacao();
				   	   						String codigoDocumento = pessoa.getCodigoDocumento();
											tdoci.setCodigoDocumento(codigoDocumento!=null?codigoDocumento:null);
				   	   						String emissorDocumento = pessoa.getEmissorDocumento();
											tdoci.setEmissorDocumento(emissorDocumento!=null?emissorDocumento:null);
				   	   						tdoci.setNome(nome);
				   	   						if (pessoa.getTipoDocumento() != null) {
				   	   							tdoci.setTipoDocumento(ModalidadeDocumentoIdentificador.fromValue(pessoa.getTipoDocumento()));
				   	   						}	
				   	   						tpa.getDocumento().add(tdoci);
				   	    	   					
				    	    				tpp.setPessoa(tpa);
			   	    	    			}	
			   	    	   			}
								}
							}
		   	    	   	}
	    	    	}
	   	    	 	tienmap.setDadosBasicos(tdb);
	   	    	   	
	   	
	   	   	    	TipoEntregarManifestacaoProcessualResposta entregarManifestacaoProcessual = pjeService.entregarManifestacaoProcessual(tienmap);
	   	   	    	if (entregarManifestacaoProcessual!=null) {
						processo.setRetornoSucesso(entregarManifestacaoProcessual.isSucesso());
		   	   	    	processo.setRetornoProtocoloRecebimento(entregarManifestacaoProcessual.getProtocoloRecebimento());
		   	   	    	processo.setRetornoDataOperacao(Timestamp.valueOf(entregarManifestacaoProcessual.getDataOperacao()));
		   	   	    	processo.setRetornoMensagem(entregarManifestacaoProcessual.getMensagem());
		   	   	    	DataHandler recibo = entregarManifestacaoProcessual.getRecibo();
						String ds = IOUtils.toString(recibo.getInputStream());
		   	   	    	processo.setRetornoRecibo(ds);
		   	 	       	processo.setMensagemStatus(null);
		   	 	       	}
		   	 	    else {
		   	 	    	processo.setStatusProcessamento(102);
		   	 	    	processo.setMensagemStatus("Serviço não retornado");
		   	 	    }
	   	    	    
	   	    	    processo.setDataStatus(Timestamp.valueOf(LocalDateTime.now()));
	   	   	    	
	   	   	    	repository.save(processo);
				}	
	         }  
   	   	   	catch (Exception ex) {
   	 	       	StringWriter errors = new StringWriter();
   	 	       	ex.printStackTrace(new PrintWriter(errors));
   	 	       	processo.setMensagemStatus(errors.toString());
   	    	    processo.setStatusProcessamento(199);
   	    	    processo.setRetornoSucesso(false);
   	    	    processo.setDataStatus(Timestamp.valueOf(LocalDateTime.now()));
    		    repository.save(processo);
    		    repository.flush();
   	 	    }
   	   	}
    }    
    
    private static String formatTimeStamp(XMLGregorianCalendar cal)
    {
        if (cal == null)
          return "";
       else
       {
          return TIMESTAMP_FORMATTER.format(cal.toGregorianCalendar(IST_TIMEZONE, Locale.US, null).getTime());
       }
    }
    
    private void teste() {
    	Random random = new Random();
    	ManifestacaoProcessual mp = new ManifestacaoProcessual();

    	ConfiguracaoServico cs = new ConfiguracaoServico();
    	cs.setId(random.nextInt(1000 - 0) + 0);
    	cs.setIdManifestante("75293730215");
    	cs.setSenhaManifestante("admin123");
    	cs.setAtivo("1");
    	cs.setClasse(12);
    	cs.setCodigocda("1234");
    	cs.setCodigonacionalassunto(233);
    	cs.setCodigopeticionalinicial("121333");
    	cs.setLocalidade("Brasilia");
    	cs.setNome("Nome teste");
    	cs.setUsuario("usurio");
    	configuracaoRepository.save(cs);
    	java.sql.Timestamp data = java.sql.Timestamp.valueOf("2005-04-06 09:01:10");
    	mp.setDataEnvio(data);
    	
    	mp.setConfiguracaoid(cs.getId());
    	mp.setId(random.nextInt(1000 - 0) + 0);
    	mp.setLoteid(random.nextInt(1000 - 0) + 0);
    	mp.setClasseProcessual(1680);
    	mp.setCodigoLocalidade("2");
    	
    	Polo polo = new Polo();
    	polo.setId(random.nextInt(1000 - 0) + 0);
    	polo.setModalidadeProcessual("PA");
    	polo.setProcessoid(mp.getId());
    	
    	Pessoa pessoa = new Pessoa();
    	pessoa.setId(random.nextInt(1000 - 0) + 0);
    	pessoa.setPoloid(polo.getId());
    	pessoa.setNome("Empresa X");
    	pessoa.setNumeroDocumentoPrincipal("51349633000140");
    	pessoa.setTipoPessoa(TipoQualificacaoPessoa.JURIDICA.value());
    	pessoa.setCodigoDocumento("51349633000140");
    	pessoa.setEmissorDocumento("SSP");
    	pessoa.setTipoDocumento(ModalidadeDocumentoIdentificador.CMF.value());
    	
    	pessoa.setCep("70091900");
    	pessoa.setLogradouro("Praça do Buriti, Lote 2, Sede do MPDFT");
    	pessoa.setNumero("2");
    	pessoa.setBairro("Eixo Monumental");
    	pessoa.setCidade("Brasília");
    	pessoa.setEstado("DF");
    	pessoa.setPais("BR");

    	if (polo.getPessoas()==null) polo.setPessoas(new ArrayList());
    	polo.getPessoas().add(pessoa);

    	Advogado adv = new Advogado();
    	adv.setId(random.nextInt(1000 - 0) + 0);
    	adv.setPessoaidadm(pessoa.getId());
    	adv.setNome("DIOGO SEIXAS CONDURU");
    	adv.setNumeroDocumentoPrincipal("75293730215");
    	adv.setTipoRepresentante("A");
    	
    	adv.setCep("70091900");
    	adv.setLogradouro("Praça do Buriti, Lote 2, Sede do MPDFT");
    	adv.setNumero("2");
    	adv.setBairro("Eixo Monumental");
    	adv.setCidade("Brasília");
    	adv.setEstado("DF");
    	adv.setPais("BR");

    	if (pessoa.getAdvogados()==null) pessoa.setAdvogados(new ArrayList());
    	pessoa.getAdvogados().add(adv);
    	
    	if (mp.getPolo()==null) mp.setPolo(new ArrayList());
    	mp.getPolo().add(polo);
    	
    	Polo polo2 = new Polo();
    	polo2.setId(random.nextInt(1000 - 0) + 0);
    	polo2.setProcessoid(mp.getId());
    	
    	polo2.setModalidadeProcessual("PA");
    	Pessoa pessoa2 = new Pessoa();
    	pessoa2.setId(random.nextInt(1000 - 0) + 0);
    	pessoa2.setPoloid(polo2.getId());
    	pessoa2.setNome("ABIMAEL MACHADO DA SILVA");
    	pessoa2.setSexo("M");
    	pessoa2.setNumeroDocumentoPrincipal("33575924368");
    	pessoa2.setTipoPessoa(TipoQualificacaoPessoa.FISICA.value());
    	
    	if (polo2.getPessoas()==null) polo2.setPessoas(new ArrayList());
    	polo2.getPessoas().add(pessoa2);
    	mp.getPolo().add(polo2);

    	AssuntoProcessual ass = new AssuntoProcessual();
    	ass.setId(random.nextInt(1000 - 0) + 0);
    	ass.setProcessoid(mp.getId());
    	ass.setCodigoNacional(10303);
    	ass.setPrincipal("S");
    	if (mp.getAssuntos()==null) mp.setAssuntos(new ArrayList());
    	mp.getAssuntos().add(ass);
    	
    	Documento doc = new Documento();
    	doc.setId(random.nextInt(1000 - 0) + 0);
    	doc.setProcessoid(mp.getId());
    	doc.setDataHoraDocumento(Timestamp.valueOf("1999-10-02 14:30:00"));
    	doc.setDescricaoDocumento("teste-anexo1.pdf");
    	doc.setHashDocumento("da748d31d4564012a417e664a0d7aecac908df4c712ab5125534d5b127d9a4d6");
    	doc.setMimetypeDocumento("application/pdf");
    	doc.setNivelSigiloDocumento(0);
    	doc.setTipoDocumento("58");
    	doc.setConteudoDocumento("JVBERi0xLjQNJeLjz9MNCjMyIDAgb2JqDTw8L0xpbmVhcml6ZWQgMS9MIDQ5MTM2L08gMzUvRSAzMTg4Mi9OIDIvVCA0ODQ0OS9IIFsgODc2IDI1OF0+Pg1lbmRvYmoNICAgICAgICAgICAgICAgICAgDQp4cmVmDQozMiAyOQ0KMDAwMDAwMDAxNiAwMDAwMCBuDQowMDAwMDAxMTM0IDAwMDAwIG4NCjAwMDAwMDEyODMgMDAwMDAgbg0KMDAwMDAwMTMxNyAwMDAwMCBuDQowMDAwMDAxNDk3IDAwMDAwIG4NCjAwMDAwMDE2MzcgMDAwMDAgbg0KMDAwMDAwMjE4MyAwMDAwMCBuDQowMDAwMDAyNTY4IDAwMDAwIG4NCjAwMDAwMDMwNDIgMDAwMDAgbg0KMDAwMDAwMzQ1NSAwMDAwMCBuDQowMDAwMDAzNDkwIDAwMDAwIG4NCjAwMDAwMDM5MDIgMDAwMDAgbg0KMDAwMDAwNDE5MiAwMDAwMCBuDQowMDAwMDA0NjQ1IDAwMDAwIG4NCjAwMDAwMDQ5OTQgMDAwMDAgbg0KMDAwMDAwNTA3MSAwMDAwMCBuDQowMDAwMDA2NjcyIDAwMDAwIG4NCjAwMDAwMDc4MDEgMDAwMDAgbg0KMDAwMDAwODg4OCAwMDAwMCBuDQowMDAwMDEwMTY2IDAwMDAwIG4NCjAwMDAwMTE1MzggMDAwMDAgbg0KMDAwMDAxMjgyMyAwMDAwMCBuDQowMDAwMDE0MjM3IDAwMDAwIG4NCjAwMDAwMTU0NzQgMDAwMDAgbg0KMDAwMDAxODE2NyAwMDAwMCBuDQowMDAwMDIyMjQzIDAwMDAwIG4NCjAwMDAwMjQzNjcgMDAwMDAgbg0KMDAwMDAyODkyMiAwMDAwMCBuDQowMDAwMDAwODc2IDAwMDAwIG4NCnRyYWlsZXINCjw8L1NpemUgNjEvUHJldiA0ODQzOC9Sb290IDMzIDAgUi9JbmZvIDMxIDAgUi9JRFs8Q0QwQzlBMDgyQUZEODVDNkFGRDMzNDkyMzgwMzJDOUQ+PEUzMjAzNTU5MTQ1RkM3NDZCMjM5NUFDRTQ1MUM1MTM3Pl0+Pg0Kc3RhcnR4cmVmDQowDQolJUVPRg0KICAgICAgICAgICAgIA0KNjAgMCBvYmoNPDwvTGVuZ3RoIDE2NS9FIDE1Ni9GaWx0ZXIvRmxhdGVEZWNvZGUvSSAxODgvTCAxNzIvUyA4ND4+c3RyZWFtDQp42mJgYOBkYGBhZGBlYNCWZeBnQAB+oBgrAwsDRwfDjCsMDDUIGXaHK6EzZ3lqZz9WAPM7OhpAVBqQBqkEAi4GhmVLgbQUEEuDRZQYeBkYVBquKDCsb3ugn8DIfcGB2U14g+iMmo4nsmoP/TqPhTlFruz96aHV63W76RrUJm4GhhVGQFoA6EZ9iFlrEoE0ExDbArE8A8NuRyDNCMSfAQIMAETmJSQNCmVuZHN0cmVhbQ1lbmRvYmoNMzMgMCBvYmoNPDwvUGFnZU1vZGUvVXNlTm9uZS9OYW1lcyAzNCAwIFIvTWV0YWRhdGEgMzAgMCBSL1BhZ2VzIDI5IDAgUi9PcGVuQWN0aW9uWzM1IDAgUi9YWVogbnVsbCBudWxsIG51bGxdL1R5cGUvQ2F0YWxvZy9QYWdlTGFiZWxzIDI3IDAgUj4+DWVuZG9iag0zNCAwIG9iag08PC9EZXN0cyAxMSAwIFI+Pg1lbmRvYmoNMzUgMCBvYmoNPDwvQ3JvcEJveFswIDAgNTM5IDc2NV0vUGFyZW50IDI5IDAgUi9Db250ZW50c1s0NyAwIFIgNDggMCBSIDQ5IDAgUiA1MCAwIFIgNTEgMCBSIDUyIDAgUiA1MyAwIFIgNTQgMCBSXS9Sb3RhdGUgMC9NZWRpYUJveFswIDAgNTM5IDc2NV0vUmVzb3VyY2VzIDM2IDAgUi9UeXBlL1BhZ2U+Pg1lbmRvYmoNMzYgMCBvYmoNPDwvQ29sb3JTcGFjZTw8L0NzNiA0MSAwIFI+Pi9Gb250PDwvRjEgMzcgMCBSL0YyIDM4IDAgUi9GMyAzOSAwIFIvRjQgNDAgMCBSPj4vUHJvY1NldFsvUERGL1RleHRdL0V4dEdTdGF0ZTw8L0dTMSA0NiAwIFI+Pj4+DWVuZG9iag0zNyAwIG9iag08PC9TdWJ0eXBlL1R5cGUxL0ZvbnREZXNjcmlwdG9yIDQyIDAgUi9MYXN0Q2hhciAxNjkvV2lkdGhzWzI3OCAwIDAgMCAwIDAgMCAwIDMxNCAzMTQgMCAwIDI3OCA0MDcgMjc4IDM3MCA1NTYgNTU2IDU1NiA1NTYgMCAwIDAgNTU2IDU1NiAwIDI3OCAyNzggMCAwIDAgMCAwIDc0MSA2MzAgNjg1IDc1OSA1NzQgNTU2IDAgMCAzMzQgMCA3MDQgNTU2IDkyNiA3OTYgNzYwIDU3NCAwIDY0OCA1OTMgNjY4IDc1OSAwIDAgMCA3MjIgMCAwIDAgMCAwIDAgMCA1NzQgNTkzIDUxOSA2MzAgNTU2IDM3MCAwIDY2NyAzMTQgMCA1OTMgMzE0IDEwMDAgNjY3IDU5NCA2MzAgMCA0MjYgNTAwIDM4OSAwIDU3NCAwIDU5MyA1NzQgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCA1MDAgMCAwIDAgMCAwIDAgMCAwIDAgMjc4IDAgMCAwIDAgMCAwIDAgMCA4MDBdL0Jhc2VGb250L0pPSEpNQitDYWVjaWxpYS1Sb21hbi9GaXJzdENoYXIgMzIvRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nL1R5cGUvRm9udD4+DWVuZG9iag0zOCAwIG9iag08PC9TdWJ0eXBlL1R5cGUxL0ZvbnREZXNjcmlwdG9yIDQzIDAgUi9MYXN0Q2hhciAxMjIvV2lkdGhzWzI5NiAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCA1OTIgNTkyIDU5MiA1OTIgMCAwIDAgMCAwIDAgMjk2IDAgMCAwIDAgMCAwIDAgNjQ4IDY4NSAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgNTkzIDAgNTAwIDAgNTc0IDM1MiAwIDAgMzMyIDAgMCAzMTQgMCA2ODUgNjEyIDY0OCAwIDQyNiA1MzcgMzcwIDY2NyAwIDAgMCA2MTEgNTU2XS9CYXNlRm9udC9KT0hKTUMrQ2FlY2lsaWEtSGVhdnkvRmlyc3RDaGFyIDMyL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZy9UeXBlL0ZvbnQ+Pg1lbmRvYmoNMzkgMCBvYmoNPDwvU3VidHlwZS9UeXBlMS9Gb250RGVzY3JpcHRvciA0NCAwIFIvTGFzdENoYXIgMTIxL1dpZHRoc1syNTAgMCAwIDAgMCA4MzMgNjY3IDI1MCAzMzMgMzMzIDAgMCAyNTAgMzMzIDI1MCAwIDUwMCA1MDAgNTAwIDUwMCA1MDAgNTAwIDUwMCA1MDAgNTAwIDUwMCAyNTAgMCAwIDUwMCAwIDAgMCA1NTYgNTU2IDU1NiA2MTEgNTAwIDQ0NCA2MTEgNjExIDI3OCAwIDU1NiA1MDAgNzc4IDYxMSA2MTEgNTU2IDAgNjExIDU1NiA1MDAgNjExIDAgODMzIDAgNTU2IDAgMCAwIDAgMCAwIDAgNDQ0IDUwMCA0NDQgNTAwIDQ0NCAyNzggNTAwIDUwMCAyMjIgMCA0NDQgMjIyIDc3OCA1MDAgNTAwIDUwMCA1MDAgMzMzIDQ0NCAyNzggNTAwIDQ0NCA2NjcgNDQ0IDQ0NF0vQmFzZUZvbnQvSk9ISk5EK0hlbHZldGljYS1Db25kZW5zZWQvRmlyc3RDaGFyIDMyL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZy9UeXBlL0ZvbnQ+Pg1lbmRvYmoNNDAgMCBvYmoNPDwvU3VidHlwZS9UeXBlMS9Gb250RGVzY3JpcHRvciA0NSAwIFIvTGFzdENoYXIgMTIxL1dpZHRoc1s2NjcgMCAzMzMgMzMzIDAgMCAwIDMzMyAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCA1NTYgNjExIDUwMCA1MDAgNjExIDYxMSAyNzggMCAwIDUwMCAwIDAgMCA1NTYgMCA2MTEgMCA1MDAgNjExIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCA1MDAgNTAwIDQ0NCA1MDAgNTAwIDI3OCA1MDAgNTAwIDI3OCAwIDQ0NCAyNzggNzc4IDUwMCA1MDAgNTAwIDAgMzMzIDQ0NCAyNzggNTAwIDQ0NCA2NjcgNDQ0IDQ0NF0vQmFzZUZvbnQvSk9ISk5FK0hlbHZldGljYS1Db25kZW5zZWQtQm9sZC9GaXJzdENoYXIgMzgvRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nL1R5cGUvRm9udD4+DWVuZG9iag00MSAwIG9iag1bL0lDQ0Jhc2VkIDU1IDAgUl0NZW5kb2JqDTQyIDAgb2JqDTw8L1N0ZW1WIDgyL0ZvbnROYW1lL0pPSEpNQitDYWVjaWxpYS1Sb21hbi9Gb250RmlsZTMgNTYgMCBSL0ZsYWdzIDM0L0Rlc2NlbnQgLTI1MS9Gb250QkJveFstMTY3IC0yNzAgMTEzNiA5MjZdL0FzY2VudCA3NjkvQ2FwSGVpZ2h0IDcwMC9YSGVpZ2h0IDUxNi9UeXBlL0ZvbnREZXNjcmlwdG9yL0l0YWxpY0FuZ2xlIDAvU3RlbUggNjMvQ2hhclNldCgvc3BhY2UvQy9PL1UvTi9UL1IvWS9TL0EvSS9ML1AvRi9FL2NvbG9uL0svQi9NL0QvZW5kYXNoL2NvcHlyaWdodC90d28vemVyby9vbmUvdGhyZWUvby92L2UvbS9iL3Ivc2VtaWNvbG9uL2gvdC9wL3NsYXNoL3BlcmlvZC9jL2QvaS9zL2wvYS9rL3gvbi95L2NvbW1hL3BhcmVubGVmdC9zZXZlbi9laWdodC9mL2h5cGhlbi9wYXJlbnJpZ2h0KT4+DWVuZG9iag00MyAwIG9iag08PC9TdGVtViAxNDAvRm9udE5hbWUvSk9ISk1DK0NhZWNpbGlhLUhlYXZ5L0ZvbnRGaWxlMyA1NyAwIFIvRmxhZ3MgMjYyMTc4L0Rlc2NlbnQgLTI1MS9Gb250QkJveFstMTcwIC0yNzcgMTE0NiA5NzBdL0FzY2VudCA3NjkvQ2FwSGVpZ2h0IDcwMC9YSGVpZ2h0IDUyMy9UeXBlL0ZvbnREZXNjcmlwdG9yL0l0YWxpY0FuZ2xlIDAvU3RlbUggMTAyL0NoYXJTZXQoL3NwYWNlL0Mvby91L24vdC9yL3kvcy9hL2kvYy9sL3AvZi9lL2NvbG9uL0Ivei90d28vemVyby9vbmUvdGhyZWUpPj4NZW5kb2JqDTQ0IDAgb2JqDTw8L1N0ZW1WIDc5L0ZvbnROYW1lL0pPSEpORCtIZWx2ZXRpY2EtQ29uZGVuc2VkL0ZvbnRGaWxlMyA1OCAwIFIvRmxhZ3MgMzIvRGVzY2VudCAtMTg5L0ZvbnRCQm94Wy0xNzQgLTI1MCAxMDcxIDk5MF0vQXNjZW50IDc1MC9DYXBIZWlnaHQgNzUwL1hIZWlnaHQgNTU2L1R5cGUvRm9udERlc2NyaXB0b3IvSXRhbGljQW5nbGUgMC9TdGVtSCA2Ny9DaGFyU2V0KC9zcGFjZS9VL24vaS90L3R3by96ZXJvL2ZpdmUvc2l4L3NldmVuL2VpZ2h0L25pbmUvb25lL0cvRC9QL3AvZS9yL2MvYS9TL3Uvcy90aHJlZS9mb3VyL3BlcmlvZC9vL2wvbS9wYXJlbmxlZnQvTi9JL3BhcmVucmlnaHQvSC9oL2QvYi9BL2cvdy9wZXJjZW50L1IvaHlwaGVuL3YvZi94L2NvbW1hL3kvY29sb24vVC9rL0UvQi9DL08vRi9NL0wvZXF1YWwvcXVvdGVzaW5nbGUvVy9xL0svWS9hbXBlcnNhbmQpPj4NZW5kb2JqDTQ1IDAgb2JqDTw8L1N0ZW1WIDEzMC9Gb250TmFtZS9KT0hKTkUrSGVsdmV0aWNhLUNvbmRlbnNlZC1Cb2xkL0ZvbnRGaWxlMyA1OSAwIFIvRmxhZ3MgMjYyMTc2L0Rlc2NlbnQgLTE4OS9Gb250QkJveFstMTY5IC0yNTAgMTA5MSA5OTFdL0FzY2VudCA3NTAvQ2FwSGVpZ2h0IDc1MC9YSGVpZ2h0IDU2NC9UeXBlL0ZvbnREZXNjcmlwdG9yL0l0YWxpY0FuZ2xlIDAvU3RlbUggMTAwL0NoYXJTZXQoL3NwYWNlL1Avci9vL2QvdS9jL3QvaS9uL2EvbS9lL0UvZy93L2gvcy9oeXBoZW4vdi9sL0cvZi9iL3gvcC9UL0YvcGFyZW5sZWZ0L0QvSS9wYXJlbnJpZ2h0L3kvQy9VL0wvay9SL2FtcGVyc2FuZC9IKT4+DWVuZG9iag00NiAwIG9iag08PC9PUE0gMS9PUCBmYWxzZS9vcCBmYWxzZS9UeXBlL0V4dEdTdGF0ZS9TQSBmYWxzZS9TTSAwLjAyPj4NZW5kb2JqDTQ3IDAgb2JqDTw8L0xlbmd0aCAxNTMwL0ZpbHRlci9GbGF0ZURlY29kZT4+c3RyZWFtDQpIiZxXzW4bNxC+6yl4KUACXYZ/y5/cHNtx06axYSuHIMlhI8m2CllraKWk6YP0HfqWnSG5kqys4pVgwJoZcjn/85EvLm4kuWsGr4aDF68lkWR4O7BEwJ8lygXuDdGKa20MGT4MBLkbcCEEbBshIQMZfht8pKeX798NmeeSXrNC8kA/kJvhyfDNDSsscGnpDStKYE5P3pKr68vXzG5kbyNznpgbpoF5SZgU9I8kOmcGRB/I8OTV2/Mb8vo6Hnj5J7k8Pz0j/5L/EqFEPEdq9nn4O/ijkj+BOxVdioT0gTihuHRGo0/oj0Z/RPalXqHSks4ZnLVcfCfNsmIycEWXrADRtFmiW4pOWQnsKJlYMe7ojDwumPTA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MCA0MDcgNDYzIDM1MiA1OTMgMCAwIDUzN10vQmFzZUZvbnQvSk9IS0JEK0NhZWNpbGlhLUl0YWxpYy9GaXJzdENoYXIgMzIvRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nL1R5cGUvRm9udD4+DWVuZG9iag0xMSAwIG9iag08PC9LaWRzWzEyIDAgUl0+Pg1lbmRvYmoNMTIgMCBvYmoNPDwvTGltaXRzWyhGKShQLjc3KV0vTmFtZXNbKEYpMTMgMCBSKEcxMDcwOTEwKTE0IDAgUihHODM3ODIwKTE1IDAgUihJMS44Mzc4MTUpMTYgMCBSKEkxLjgzNzgxNykxNyAwIFIoSTEuODM3ODIzKTE4IDAgUihJMS44Mzc4MjkpMTkgMCBSKEkxLjgzNzgzMSkyMCAwIFIoSTEuODM3ODM1KTIxIDAgUihMKTIyIDAgUihNOC5uZXdsaW5rLnB1YkFjcm9ueW0xOXB1YlllYXIyMDEzcHViTnVtYmVyVDAwNVRhYmxlMTEwMDM3QlJBVGFibGUwMzVlbikyMyAwIFIoTTkucHViQWNyb255bTE5cHViWWVhcjIwMTNwdWJOdW1iZXJUMDA1VGFibGUxMTAwMzdCUkFUYWJsZTAzNWVuKTI0IDAgUihQLjc2KTI1IDAgUihQLjc3KTI2IDAgUl0+Pg1lbmRvYmoNMTMgMCBvYmoNPDwvRFszNSAwIFIvWFlaIG51bGwgbnVsbCBudWxsXT4+DWVuZG9iag0xNCAwIG9iag08PC9EWzEgMCBSL1hZWiAzNiAzOCBudWxsXT4+DWVuZG9iag0xNSAwIG9iag08PC9EWzM1IDAgUi9YWVogMzYgNzA5IG51bGxdPj4NZW5kb2JqDTE2IDAgb2JqDTw8L0RbMzUgMCBSL1hZWiAzNiA3MDkgbnVsbF0+Pg1lbmRvYmoNMTcgMCBvYmoNPDwvRFszNSAwIFIvWFlaIDM2IDcwOSBudWxsXT4+DWVuZG9iag0xOCAwIG9iag08PC9EWzEgMCBSL1hZWiAxODMgMTk0IG51bGxdPj4NZW5kb2JqDTE5IDAgb2JqDTw8L0RbMSAwIFIvWFlaIDYxIDE3NSBudWxsXT4+DWVuZG9iag0yMCAwIG9iag08PC9EWzEgMCBSL1hZWiAyNDEgMTc1IG51bGxdPj4NZW5kb2JqDTIxIDAgb2JqDTw8L0RbMSAwIFIvWFlaIDMyMiAxNTggbnVsbF0+Pg1lbmRvYmoNMjIgMCBvYmoNPDwvRFsxIDAgUi9YWVogbnVsbCBudWxsIG51bGxdPj4NZW5kb2JqDTIzIDAgb2JqDTw8L0RbMzUgMCBSL1hZWiAzNiA3MDkgbnVsbF0+Pg1lbmRvYmoNMjQgMCBvYmoNPDwvRFszNSAwIFIvWFlaIDM2IDcwOSBudWxsXT4+DWVuZG9iag0yNSAwIG9iag08PC9EWzM1IDAgUi9YWVogbnVsbCBudWxsIG51bGxdPj4NZW5kb2JqDTI2IDAgb2JqDTw8L0RbMSAwIFIvWFlaIG51bGwgbnVsbCBudWxsXT4+DWVuZG9iag0yNyAwIG9iag08PC9OdW1zWzAgMjggMCBSXT4+DWVuZG9iag0yOCAwIG9iag08PC9TL0Q+Pg1lbmRvYmoNMjkgMCBvYmoNPDwvQ291bnQgMi9UeXBlL1BhZ2VzL0tpZHNbMzUgMCBSIDEgMCBSXT4+DWVuZG9iag0zMCAwIG9iag08PC9TdWJ0eXBlL1hNTC9MZW5ndGggMzYxMC9UeXBlL01ldGFkYXRhPj5zdHJlYW0NCjw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+Cjx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDQuMC1jMzIwIDQ0LjI4NDI5NywgU3VuIEFwciAxNSAyMDA3IDE3OjE5OjAwIj4KICAgPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6eGFwPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIj4KICAgICAgICAgPHhhcDpDcmVhdG9yVG9vbD5NaXJhbW8gOC41ICh3d3cubWlyYW1vLmNvbSk8L3hhcDpDcmVhdG9yVG9vbD4KICAgICAgICAgPHhhcDpNb2RpZnlEYXRlPjIwMTMtMTEtMTNUMTU6MzE6MjlaPC94YXA6TW9kaWZ5RGF0ZT4KICAgICAgICAgPHhhcDpDcmVhdGVEYXRlPjIwMTMtMTEtMTNUMTU6Mjc6NDJaPC94YXA6Q3JlYXRlRGF0ZT4KICAgICAgPC9yZGY6RGVzY3JpcHRpb24+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyI+CiAgICAgICAgIDxkYzpmb3JtYXQ+YXBwbGljYXRpb24vcGRmPC9kYzpmb3JtYXQ+CiAgICAgICAgIDxkYzp0aXRsZT4KICAgICAgICAgICAgPHJkZjpBbHQ+CiAgICAgICAgICAgICAgIDxyZGY6bGkgeG1sOmxhbmc9IngtZGVmYXVsdCI+Q291bnRyeSBzdGF0aXN0aWNhbCBwcm9maWxlOiBCcmF6aWwgMjAxMzwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpBbHQ+CiAgICAgICAgIDwvZGM6dGl0bGU+CiAgICAgICAgIDxkYzpjcmVhdG9yPgogICAgICAgICAgICA8cmRmOlNlcT4KICAgICAgICAgICAgICAgPHJkZjpsaT5PRUNELCBjb250YWN0QG9lY2Qub3JnPC9yZGY6bGk+CiAgICAgICAgICAgIDwvcmRmOlNlcT4KICAgICAgICAgPC9kYzpjcmVhdG9yPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6cGRmPSJodHRwOi8vbnMuYWRvYmUuY29tL3BkZi8xLjMvIj4KICAgICAgICAgPHBkZjpQcm9kdWNlcj5BY3JvYmF0IEVsZW1lbnRzIDguMC4wIChXaW5kb3dzKTwvcGRmOlByb2R1Y2VyPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6eGFwTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iPgogICAgICAgICA8eGFwTU06RG9jdW1lbnRJRD51dWlkOmJlZTQ0NDZkLTg4YmYtNDc0MC1hNGQxLWQ4YTIxMTk0MTNiNTwveGFwTU06RG9jdW1lbnRJRD4KICAgICAgICAgPHhhcE1NOkluc3RhbmNlSUQ+dXVpZDpjYzFhMjhjNC1kOGU4LTRiZWMtODk0Yy1kMDJiZjI0MTkyMjE8L3hhcE1NOkluc3RhbmNlSUQ+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgCjw/eHBhY2tldCBlbmQ9InciPz4NCmVuZHN0cmVhbQ1lbmRvYmoNMzEgMCBvYmoNPDwvQ3JlYXRpb25EYXRlKEQ6MjAxMzExMTMxNTI3NDJaKS9BdXRob3IoT0VDRCwgY29udGFjdEBvZWNkLm9yZykvQ3JlYXRvcihNaXJhbW8gOC41IFwod3d3Lm1pcmFtby5jb21cKSkvUHJvZHVjZXIoQWNyb2JhdCBFbGVtZW50cyA4LjAuMCBcKFdpbmRvd3NcKSkvTW9kRGF0ZShEOjIwMTMxMTEzMTUzMTI5WikvVGl0bGUoQ291bnRyeSBzdGF0aXN0aWNhbCBwcm9maWxlOiBCcmF6aWwgMjAxMyk+Pg1lbmRvYmoNeHJlZg0KMCAzMg0KMDAwMDAwMDAwMCA2NTUzNSBmDQowMDAwMDMxODgyIDAwMDAwIG4NCjAwMDAwMzIwNDEgMDAwMDAgbg0KMDAwMDAzMjE3NiAwMDAwMCBuDQowMDAwMDMyMzI5IDAwMDAwIG4NCjAwMDAwMzI0ODMgMDAwMDAgbg0KMDAwMDAzMjY0NCAwMDAwMCBuDQowMDAwMDMyNzkzIDAwMDAwIG4NCjAwMDAwNDAwMDkgMDAwMDAgbg0KMDAwMDA0MjU5NyAwMDAwMCBuDQowMDAwMDQyOTE5IDAwMDAwIG4NCjAwMDAwNDMzMTYgMDAwMDAgbg0KMDAwMDA0MzM1MCAwMDAwMCBuDQowMDAwMDQzNzIyIDAwMDAwIG4NCjAwMDAwNDM3NzIgMDAwMDAgbg0KMDAwMDA0MzgxNyAwMDAwMCBuDQowMDAwMDQzODY0IDAwMDAwIG4NCjAwMDAwNDM5MTEgMDAwMDAgbg0KMDAwMDA0Mzk1OCAwMDAwMCBuDQowMDAwMDQ0MDA1IDAwMDAwIG4NCjAwMDAwNDQwNTEgMDAwMDAgbg0KMDAwMDA0NDA5OCAwMDAwMCBuDQowMDAwMDQ0MTQ1IDAwMDAwIG4NCjAwMDAwNDQxOTQgMDAwMDAgbg0KMDAwMDA0NDI0MSAwMDAwMCBuDQowMDAwMDQ0Mjg4IDAwMDAwIG4NCjAwMDAwNDQzMzggMDAwMDAgbg0KMDAwMDA0NDM4NyAwMDAwMCBuDQowMDAwMDQ0NDIzIDAwMDAwIG4NCjAwMDAwNDQ0NDggMDAwMDAgbg0KMDAwMDA0NDUwNyAwMDAwMCBuDQowMDAwMDQ4MTk1IDAwMDAwIG4NCnRyYWlsZXINCjw8L1NpemUgMzI+Pg0Kc3RhcnR4cmVmDQoxMTYNCiUlRU9GDQo=");
    	
    	Assinatura assina = new Assinatura();
    	assina.setId(random.nextInt(1000 - 0) + 0);
    	assina.setDocumentoid(doc.getId());
    	assina.setAlgoritmoHashAssinatura("SHA256withRSA");
    	assina.setAssinatura("fnI69IEWFkZUriAtm47PyOYKAFxAo0MSkJTumH7LWULw4ATuD05OFCz59kUmtrbgHg/e63OBiyPjMg6SRUQvVhbMhTEP7IjF9dAg2a0IlNjWhdYTzO3L2b1W44V5CmekdeGRuAOGgJ/LReIQQY70lsrES+CSbClnRCVLiCP63s3/9zpVYnbFUrDK9B7Sb8XOFpUyCfs2D/Gj0K12GisUEkwYZiRIqE9/+u3S4W7DGhHdPwiNG0tsX+tcCDe5ovBUo+7SELHmIhb3X8EvuKXuxMioGuhZb51iEgD1jBwTQUTXdJBtG2qjriU3pSQkn73eDCQnmuAKFPzH+3WYhbpzaQ=="); 
    	assina.setCadeiaCertificadoAssinatura("-----BEGIN CERTIFICATE----- MIIIcTCCBlmgAwIBAgIQeAiTIxjXt4AnzR9ThNvt6zANBgkqhkiG9w0BAQsFADB3 MQswCQYDVQQGEwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE1MDMGA1UECxMsQXV0 b3JpZGFkZSBDZXJ0aWZpY2Fkb3JhIGRhIEp1c3RpY2EgLSBBQy1KVVMxHDAaBgNV BAMTE0FDIENlcnRpc2lnbi1KVVMgRzMwHhcNMTQwNTIyMDAwMDAwWhcNMTcwNTIw MjM1OTU5WjCB6DELMAkGA1UEBhMCQlIxEzARBgNVBAoTCklDUC1CcmFzaWwxNTAz BgNVBAsULEF1dG9yaWRhZGUgQ2VydGlmaWNhZG9yYSBkYSBKdXN0aWNhIC0gQUMt SlVTMSQwIgYDVQQLFBtDZXJ0LUpVUyBJbnN0aXR1Y2lvbmFsIC0gQTMxKTAnBgNV BAsUIENvbnNlbGhvIE5hY2lvbmFsIGRlIEp1c3RpY2EtQ05KMREwDwYDVQQLFAhT ZXJ2aWRvcjEpMCcGA1UEAxMgQUxFWEFOREVSIERBIENPU1RBIE1PTlRFSVJPOjE3 NTQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDLE3qKvwZ7kysdCWdB He8W2QjE7mLxc//oFdWtAP/Ttb22avqMs1ZFDo2ObnAh6j1uajROBsxtV+dPYt/4 6njgDszWiU34J9MKPJVibGnCGTiVgEW+fJtq0HZLHxWXG3Hk2Pibjjr7aHxMxNrx FCbOYKYeq9oBZQVShQx6jDErYsny7l5lcjiYb1cLCEI3QiU49eFIr8OOg9JpTN5d RwLvvdtEyErTR+neAdqxnPIr+/yZ+DTSVuWEvjYH/Vm6VWcc1k8p+kRE9GBc0602 pGdQqbYcl9gnn1joQWEt8zz5J+GR1p4l1YsfgJ+l8VMZiZRnTsAwOAGZbrclTkUE rTQBAgMBAAGjggOFMIIDgTCB2wYDVR0RBIHTMIHQoD0GBWBMAQMBoDQEMjA5MTIx OTgxOTA2NjczODcxNTMwMDAwMDAwMDAwMDAwMDAwMDAwMTg1OTU4MFNTUERGoBcG BWBMAQMGoA4EDDAwMDAwMDAwMDAwMKAoBgVgTAEDBaAfBB0wMTcwMDAxMDIwNjIw MTQwMDkxQlJBU0lMSUFERoEdYWxleGFuZGVyLm1vbnRlaXJvQGNuai5qdXMuYnKg LQYKKwYBBAGCNxQCA6AfDB1hbGV4YW5kZXIubW9udGVpcm9AY25qLmp1cy5icjAJ BgNVHRMEAjAAMA4GA1UdDwEB/wQEAwIF4DAfBgNVHSMEGDAWgBRtb4AaJMQHKbMn aBDISblu5sIlwjCCARkGA1UdHwSCARAwggEMMFigVqBUhlJodHRwOi8vaWNwLWJy YXNpbC5jZXJ0aXNpZ24uY29tLmJyL3JlcG9zaXRvcmlvL2xjci9BQ0NlcnRpc2ln bi1KVVNHMy9MYXRlc3RDUkwuY3JsMFegVaBThlFodHRwOi8vaWNwLWJyYXNpbC5v dXRyYWxjci5jb20uYnIvcmVwb3NpdG9yaW8vbGNyL0FDQ2VydGlzaWduLUpVU0cz L0xhdGVzdENSTC5jcmwwV6BVoFOGUWh0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFz aWwuZ292LmJyL2xjci9DZXJ0aXNpZ24vQUNDZXJ0aXNpZ24tSlVTRzMvTGF0ZXN0 Q1JMLmNybDB/BgNVHSAEeDB2MHQGBmBMAQIDFTBqMGgGCCsGAQUFBwIBFlxodHRw Oi8vaWNwLWJyYXNpbC5jZXJ0aXNpZ24uY29tLmJyL3JlcG9zaXRvcmlvL2RwYy9B Q19DZXJ0aXNpZ25fSlVTL0RQQ19BQ19DZXJ0aVNpZ24tSlVTLnBkZjApBgNVHSUE IjAgBggrBgEFBQcDBAYIKwYBBQUHAwIGCisGAQQBgjcUAgIwgZsGCCsGAQUFBwEB BIGOMIGLMF8GCCsGAQUFBzAChlNodHRwOi8vaWNwLWJyYXNpbC5jZXJ0aXNpZ24u Y29tLmJyL3JlcG9zaXRvcmlvL2NlcnRpZmljYWRvcy9BQ19DZXJ0aXNpZ25fSlVT X0czLnA3YzAoBggrBgEFBQcwAYYcaHR0cDovL29jc3AuY2VydGlzaWduLmNvbS5i cjANBgkqhkiG9w0BAQsFAAOCAgEAQoaiWUsayh0YtkJVthXu1qRg6w7vxjyzdEQc uwRv2goLEI1Ge6pwzhplBzEGw5tzFdUNbgXJi8PZeUrks5iujQAO3oEHW3sfSZrl lLFzy9flQfZI6tchGRep/EwePke0IRG5cieYubQznLRNfB3QLXrwNbBjZqxMwtxE s9+p7TEcOMLOX7NMjU2lGHP1tvk5BTMlfIJ5u4JZbjw7VxE7vbiTe/YPG01IJesc B48kj7LJA7lJlg4oKvFur7zxkAHxBG4oFwV1hZmrWrk+vI1Ao9wmBv9spPG9FE64 oA9i8izmuz9k8KZCs8sPRKjA+OhuUqnFVzT/i9114Au7CUoY+c+ramKARsfTQsPe 3IdE8lRnMWyK/E4QYtfJUYc6ViOQmZ4uwU5uVpl36VCC5ENCGdb8rAanPjdq+6nE sh4lvqpsC2L6jjTZfRnKdIE5AX0/+fjgAm+LSnJgdc9uOw9aPjgCikF7IjbPeuG0 auO6zbFZA4vjr8T9KDrouTcSXx5bwDrlaFEStIjNise5Jhezokl9nLLUad0LIbJc lZ0e4k9viHFLOR6A1mPOWUz75u+muZ0k4a7vPzXaa+NGPavxp85FovZTz6QNC+uh CLbLaNBkS9KqPIPr9El78jr2JqmEKyxWUSKf87LibOl+JGngQ02WLGB4UynUJBVb 4Z9Pltk= -----END CERTIFICATE-----");
    	assina.setCodificacaoCertificadoAssinatura("PEM");
    	assina.setDataAssinatura(Timestamp.valueOf("2016-11-22 17:22:03"));
    	if (doc.getAssinatura()==null) doc.setAssinatura(new ArrayList());
    	doc.getAssinatura().add(assina);

    	if (mp.getDocumentos()==null) mp.setDocumentos(new ArrayList());
    	mp.getDocumentos().add(doc);
    	mp.setStatusProcessamento(188);
   	    mp.setDataStatus(Timestamp.valueOf(LocalDateTime.now()));
   	    mp.setDataGravacao(Timestamp.valueOf(LocalDateTime.now()));
    	
    	repository.save(mp);
    }
    
}
		
