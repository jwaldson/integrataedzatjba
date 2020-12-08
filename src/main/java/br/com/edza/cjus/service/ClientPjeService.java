package br.com.edza.cjus.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.edza.cjus.model.cjus.Processo;
import br.com.edza.cjus.repository.ProcessoRepository;
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
import br.jus.cnj.intercomunicacao_2_2.TipoParametro;
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
    private ProcessoRepository repository;

 
    private final static String TIMESTAMP_PATTERN = "yyyy-MM-dd";
    private final static DateFormat TIMESTAMP_FORMATTER = new SimpleDateFormat(TIMESTAMP_PATTERN);
    private final static TimeZone IST_TIMEZONE = TimeZone.getTimeZone("IST");

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dateTimeFormatter_yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    
    
    public void entregarManifestacaoProcessual() {
    	
   	   	List<Processo> processos = repository.consultaRegistrosProcessar();
   	   	for (Processo processo : processos) {

   	   		TipoEntregarManifestacaoProcessual manifestaaoProcessual = new TipoEntregarManifestacaoProcessual();

   	   		LocalDateTime now = LocalDateTime.now();
			try {
	   	   		manifestaaoProcessual.setDataEnvio(new SimpleDateFormat("yyyyMMddHHmmss").format(Timestamp.valueOf(now)));
	   	   		manifestaaoProcessual.setIdManifestante(processo.getId_manifestante());
//	   	   		String numeroProcesso = processo.getNumeroProcesso();

//	   	   		tienmap.setNumeroProcesso(numeroProcesso);
	   	   		String senhaManifestante = processo.getSenha_manifestante();
				if (senhaManifestante==null) {
	   	   			throw new Exception("Paramentos autenticação insuficientes! Senha null.");
	   	   		}
	   	   		manifestaaoProcessual.setSenhaManifestante(senhaManifestante);

	    		TipoCabecalhoProcesso cabecalhoProcesso = new TipoCabecalhoProcesso();
	    		Integer classeProcessual = processo.getClasse_processual();
				cabecalhoProcesso.setClasseProcessual(classeProcessual!=null?classeProcessual:null);
	    		Integer codigoLocalidade = processo.getCodigo_localidade();
				cabecalhoProcesso.setCodigoLocalidade(codigoLocalidade!=null?codigoLocalidade.toString():null);
	    		Double valorCausa = processo.getValor_causa();
				cabecalhoProcesso.setValorCausa(valorCausa!=null?valorCausa:null);
   	   		
   	   	    	Integer id = processo.getId();

   	   	    	TipoDocumento tpDocumento = new TipoDocumento();
   	    		String conteudoDocumento = processo.getConteudo_documento();
   	    		if (conteudoDocumento!=null) {
//   	    			ByteArrayDataSource ds = new ByteArrayDataSource(conteudoDocumento.getBytes(),"text/plain");
   	    			tpDocumento.setConteudo(conteudoDocumento);
   	    		}	
   	    		Integer idDoc = 1;
   	    		tpDocumento.setIdDocumento(idDoc.toString());
   	    		tpDocumento.setMovimento(0);
   	    		String dataHoraDocumento = processo.getData_hora_documento();
	   	   	    if (dataHoraDocumento !=null) {
	   	   	    	tpDocumento.setDataHora(dataHoraDocumento);
	   	   	    }	
   	    		String descricaoDocumento = processo.getDescricao_documento();
				tpDocumento.setDescricao(descricaoDocumento!=null?descricaoDocumento:null);
   	    		String hashDocumento = processo.getHash_documento();
				tpDocumento.setHash(hashDocumento!=null?hashDocumento:null);
   	    		String documentoIdVinculado = processo.getId_documento_vinculado();
   	    		tpDocumento.setIdDocumentoVinculado(documentoIdVinculado!=null?documentoIdVinculado:null);
	   	   	    String mimetypeDocumento = processo.getMimetype_documento();
				tpDocumento.setMimetype(mimetypeDocumento!=null?mimetypeDocumento:null);
	   	   	    Integer nivelSigiloDocumento = processo.getNivel_sigilo_documento();
				tpDocumento.setNivelSigilo(nivelSigiloDocumento!=null?nivelSigiloDocumento:null);
	   	   	    String tipoDocumento = processo.getTipo_documento();
				tpDocumento.setTipoDocumento(tipoDocumento!=null?tipoDocumento:null);
   	   	    	TipoAssinatura tpAssinatura = new TipoAssinatura();
   	   	    	String algoritmoHashAssinatura = processo.getAlgoritmo_hash_assinatura();
				tpAssinatura.setAlgoritmoHash(algoritmoHashAssinatura!=null?algoritmoHashAssinatura:null);
     			String assinatura = processo.getAssinatura();
				tpAssinatura.setAssinatura(assinatura!=null?assinatura:null);
    			String cadeiaCertificadoAssinatura = processo.getCadeia_certificado_assinatura();
				tpAssinatura.setCadeiaCertificado(cadeiaCertificadoAssinatura!=null?cadeiaCertificadoAssinatura:null);
    			String codificacaoCertificadoAssinatura = processo.getCodificacao_certificado_assinatura();
				tpAssinatura.setCodificacaoCertificado(codificacaoCertificadoAssinatura!=null?codificacaoCertificadoAssinatura:null);
    			String dataAssinatura = processo.getDataassinatura();
    			if (dataAssinatura!=null) {
    				tpAssinatura.setDataAssinatura(dataAssinatura);
    			}	
    			tpDocumento.getAssinatura().add(tpAssinatura);
   	    		List<TipoDocumento> documento = manifestaaoProcessual.getDocumento();
				documento.add(tpDocumento);
	   	    	    	
  	    		TipoAssuntoProcessual tpAssuntoProcessual = new TipoAssuntoProcessual();
   	    		Integer codigoNacional = processo.getAssunto_processual_codigo_nacional();
				tpAssuntoProcessual.setCodigoNacional(codigoNacional!=null?codigoNacional:null);
   	    		tpAssuntoProcessual.setPrincipal(processo.getAssunto_processual_principal());
   	    		cabecalhoProcesso.getAssunto().add(tpAssuntoProcessual);

   	    		TipoPoloProcessual polo = new TipoPoloProcessual();
   	    		String modalidadeProcessual = processo.getPolo();
    			if (modalidadeProcessual!=null) {
    				polo.setPolo(ModalidadePoloProcessual.fromValue(modalidadeProcessual));
    			}	
    			String prioridade = processo.getPrioridade();
    			if (prioridade!=null) {
    				cabecalhoProcesso.getPrioridade().add(prioridade);
    			}	
    			
    			TipoParte parte = new TipoParte();
   				TipoRepresentanteProcessual adv = new TipoRepresentanteProcessual();
   				String inscricao = processo.getRepres_processual_inscricao();
   				adv.setIntimacao(processo.getRepres_processual_intimacao());
				adv.setInscricao(inscricao!=null?inscricao:null);
   				String nomeAdvogado = processo.getRepres_processual_nome();
				adv.setNome(nomeAdvogado!=null?nomeAdvogado:null);
   				String numeroDocumentoPrincipal = processo.getRepres_processual_numero_documento_principal();
				adv.setNumeroDocumentoPrincipal(numeroDocumentoPrincipal!=null?numeroDocumentoPrincipal:null);
   				String tipoRepresentante = processo.getRepres_processual_tipo_representante();
   				if (tipoRepresentante!=null && tipoRepresentante.length()>0 ) {
   					ModalidadeRepresentanteProcessual fromValue = ModalidadeRepresentanteProcessual.fromValue(tipoRepresentante);
   					adv.setTipoRepresentante(fromValue);
   				}
				TipoEndereco enderecoAdvogado = new TipoEndereco();
				
				//Verificar
   				String bairroAdv = "NOVA BRASILIA";
   				enderecoAdvogado.setBairro(bairroAdv!=null?bairroAdv:null);
				String cepAdv = "43820210";
				enderecoAdvogado.setCep(cepAdv!=null?cepAdv:null);
			    String cidadeAdv = "CANDEIAS";
				enderecoAdvogado.setCidade(cidadeAdv!=null?cidadeAdv:null);
				String complementoAdv = "";
				enderecoAdvogado.setComplemento(complementoAdv!=null?complementoAdv:null);
				String estadoAdv = "BA";
				enderecoAdvogado.setEstado(estadoAdv!=null?estadoAdv:null);
				String logradouroAdv = "RUA MIGUEL CALMON";
				enderecoAdvogado.setLogradouro(logradouroAdv!=null?logradouroAdv:null);
				String numeroAdv = "226";
				enderecoAdvogado.setNumero(numeroAdv!=null?numeroAdv:null);
				String paisAdv = "BRASIL";
				enderecoAdvogado.setPais(paisAdv!=null?paisAdv:null);
				adv.getEndereco().add(enderecoAdvogado);	
				
				TipoPessoa pessoa = new TipoPessoa();
				String cidadeNatural = processo.getParte_cidade_natural();
				pessoa.setCidadeNatural(cidadeNatural!=null?cidadeNatural:null);
				if (processo.getParte_data_nascimento()!=null) {
					pessoa.setDataNascimento(processo.getParte_data_nascimento());
				}	
				String estadoNatural = processo.getParte_estado_natural();
				pessoa.setEstadoNatural(estadoNatural!=null?estadoNatural:null);
				String nacionalidade = processo.getParte_nacionalidade();
				pessoa.setNacionalidade(nacionalidade!=null?nacionalidade:null);
				String nomeParte = processo.getParte_nome();
				pessoa.setNome(nomeParte!=null?nomeParte:null);
				String numeroDocumentoPrincipalParte = processo.getParte_numero_documento_principal();
				pessoa.setNumeroDocumentoPrincipal(numeroDocumentoPrincipalParte!=null?String.valueOf(numeroDocumentoPrincipalParte):null);
				//   	    	    				tpa.setPessoaVinculada(pessoaParte.get);
				if (processo.getParte_sexo()!=null) {
					ModalidadeGeneroPessoa fromValue = ModalidadeGeneroPessoa.fromValue(processo.getParte_sexo());
					pessoa.setSexo(fromValue);
				}	
				if (processo.getParte_tipo_pessoa()!=null) {
					TipoQualificacaoPessoa fromValue2 = TipoQualificacaoPessoa.fromValue(processo.getParte_tipo_pessoa());
					pessoa.setTipoPessoa(fromValue2);
				}		
				TipoEndereco endPessoaParte = new TipoEndereco(); 
				String bairro = processo.getEndereco_bairro();
				endPessoaParte.setBairro(bairro!=null?bairro:null);
				String cep = processo.getEndereco_cep();
				endPessoaParte.setCep(cep!=null?cep.toString():null);
				String cidade = processo.getEndereco_cidade();
				endPessoaParte.setCidade(cidade!=null?cidade:null);
				String complemento = processo.getEndereco_complemento();
				endPessoaParte.setComplemento(complemento!=null?complemento:null);
				String estado = processo.getEndereco_estado();
				endPessoaParte.setEstado(estado!=null?estado:null);
				String logradouro = processo.getEndereco_logradouro();
				endPessoaParte.setLogradouro(logradouro!=null?logradouro:null);
				String numero = processo.getEndereco_numero();
				endPessoaParte.setNumero(numero!=null?numero:null);
				String pais = processo.getEndereco_pais();
				endPessoaParte.setPais(pais!=null?pais:null);
				pessoa.getEndereco().add(endPessoaParte);	
				   	    	    					
				TipoDocumentoIdentificacao tdoci = new TipoDocumentoIdentificacao();
				String codigoDocumento = processo.getParte_codigo_documento();
				tdoci.setCodigoDocumento(codigoDocumento!=null?codigoDocumento:null);
				String emissorDocumento = processo.getParte_emissor_documento();
				tdoci.setEmissorDocumento(emissorDocumento!=null?emissorDocumento:null);
				tdoci.setNome(nomeParte);
				if (processo.getParte_tipo_documento() != null && processo.getParte_tipo_documento().length()>0) {
					tdoci.setTipoDocumento(ModalidadeDocumentoIdentificador.fromValue(processo.getParte_tipo_documento()));
				}	
				pessoa.getDocumento().add(tdoci);
				parte.setPessoa(pessoa);
				parte.getAdvogado().add(adv);
				
				polo.getParte().add(parte);
    			cabecalhoProcesso.getPolo().add(polo);
    			
    			//
    			String nomeParteReferencia="";
    			String nomeAdvReferencia="";
    			
    			List<Processo> processosViculados = repository.consultaRegistrosvinculados(processo.getProcessoid());
    			for (Processo processoVinculado : processosViculados) {
    				
    				// Documento Processo Vinculado
       	   	    	TipoDocumento tpDocumentoProcessoVinculado = new TipoDocumento();
       	    		String conteudoDocumentoProcessoVinculado = processoVinculado.getConteudo_documento();
       	    		if (conteudoDocumentoProcessoVinculado!=null) {
       	    			tpDocumentoProcessoVinculado.setConteudo(conteudoDocumentoProcessoVinculado);
       	    		}	
       	    		idDoc++;
       	    		tpDocumentoProcessoVinculado.setIdDocumento(idDoc.toString());
       	    		tpDocumentoProcessoVinculado.setMovimento(0);
       	    		String dataHoraDocumentoProcessoVinculado = processoVinculado.getData_hora_documento();
    	   	   	    if (dataHoraDocumentoProcessoVinculado !=null) {
    	   	   	    	tpDocumentoProcessoVinculado.setDataHora(dataHoraDocumentoProcessoVinculado);
    	   	   	    }	
       	    		String descricaoDocumentoProcessoVinculado = processoVinculado.getDescricao_documento();
    				tpDocumentoProcessoVinculado.setDescricao(descricaoDocumentoProcessoVinculado!=null?descricaoDocumentoProcessoVinculado:null);
       	    		String hashDocumentoProcessoVinculado = processoVinculado.getHash_documento();
    				tpDocumentoProcessoVinculado.setHash(hashDocumentoProcessoVinculado!=null?hashDocumentoProcessoVinculado:null);
       	    		String documentoIdVinculadoProcessoVinculado = processoVinculado.getId_documento_vinculado();
       	    		tpDocumentoProcessoVinculado.setIdDocumentoVinculado(documentoIdVinculadoProcessoVinculado!=null?documentoIdVinculadoProcessoVinculado:null);
    	   	   	    String mimetypeDocumentoProcessoVinculado = processoVinculado.getMimetype_documento();
    				tpDocumentoProcessoVinculado.setMimetype(mimetypeDocumentoProcessoVinculado!=null?mimetypeDocumentoProcessoVinculado:null);
    	   	   	    Integer nivelSigiloDocumentoProcessoVinculado = processoVinculado.getNivel_sigilo_documento();
    				tpDocumentoProcessoVinculado.setNivelSigilo(nivelSigiloDocumentoProcessoVinculado!=null?nivelSigiloDocumentoProcessoVinculado:null);
    	   	   	    String tipoDocumentoProcessoVinculado = processoVinculado.getTipo_documento();
    				tpDocumentoProcessoVinculado.setTipoDocumento(tipoDocumentoProcessoVinculado!=null?tipoDocumentoProcessoVinculado:null);
    				tpDocumentoProcessoVinculado.setTipoDocumentoLocal(tipoDocumentoProcessoVinculado!=null?tipoDocumentoProcessoVinculado:null);
       	   	    	TipoAssinatura tpAssinaturaProcessoVinculado = new TipoAssinatura();
       	   	    	String algoritmoHashAssinaturaProcessoVinculado = processoVinculado.getAlgoritmo_hash_assinatura();
    				tpAssinaturaProcessoVinculado.setAlgoritmoHash(algoritmoHashAssinaturaProcessoVinculado!=null?algoritmoHashAssinaturaProcessoVinculado:null);
         			String assinaturaProcessoVinculado = processoVinculado.getAssinatura();
    				tpAssinaturaProcessoVinculado.setAssinatura(assinaturaProcessoVinculado!=null?assinaturaProcessoVinculado:null);
        			String cadeiaCertificadoAssinaturaProcessoVinculado = processoVinculado.getCadeia_certificado_assinatura();
    				tpAssinaturaProcessoVinculado.setCadeiaCertificado(cadeiaCertificadoAssinaturaProcessoVinculado!=null?cadeiaCertificadoAssinaturaProcessoVinculado:null);
        			String codificacaoCertificadoAssinaturaProcessoVinculado = processoVinculado.getCodificacao_certificado_assinatura();
    				tpAssinaturaProcessoVinculado.setCodificacaoCertificado(codificacaoCertificadoAssinaturaProcessoVinculado!=null?codificacaoCertificadoAssinaturaProcessoVinculado:null);
        			String dataAssinaturaProcessoVinculado = processoVinculado.getDataassinatura();
        			if (dataAssinaturaProcessoVinculado!=null) {
        				tpAssinaturaProcessoVinculado.setDataAssinatura(dataAssinaturaProcessoVinculado);
        			}	
        			List<TipoAssinatura> assinatura2 = tpDocumentoProcessoVinculado.getAssinatura();
					assinatura2.add(tpAssinaturaProcessoVinculado);
       	    		documento.add(tpDocumentoProcessoVinculado);

    				// Polo
    				TipoPoloProcessual poloVinculado = new TipoPoloProcessual();
       	    		String modalidadeProcessualProcessoVinculado = processoVinculado.getPolo();
        			if (modalidadeProcessualProcessoVinculado!=null) {
        				poloVinculado.setPolo(ModalidadePoloProcessual.fromValue(modalidadeProcessualProcessoVinculado));
        			}	

        			//Advogado
        			TipoParte parteProcessoViculado = new TipoParte();
       				TipoRepresentanteProcessual advProcessoViculado = new TipoRepresentanteProcessual();

       				String inscricaoProcessoViculado = processoVinculado.getRepres_processual_inscricao();
       				advProcessoViculado.setInscricao(inscricaoProcessoViculado!=null?inscricaoProcessoViculado:null);

    				String nomeAdvogadoProcessoVinculado = processoVinculado.getRepres_processual_nome();
    				advProcessoViculado.setNome(nomeAdvogadoProcessoVinculado!=null?nomeAdvogadoProcessoVinculado:null);
       				
    				String numeroDocumentoPrincipalProcessoVinculado = processoVinculado.getRepres_processual_numero_documento_principal();
    				advProcessoViculado.setNumeroDocumentoPrincipal(numeroDocumentoPrincipalProcessoVinculado!=null?numeroDocumentoPrincipalProcessoVinculado:null);

    				String tipoRepresentanteProcessoVinculado = processoVinculado.getRepres_processual_tipo_representante();
       				if (tipoRepresentanteProcessoVinculado!=null && tipoRepresentanteProcessoVinculado.length()>0 ) {
       					ModalidadeRepresentanteProcessual fromValue = ModalidadeRepresentanteProcessual.fromValue(tipoRepresentanteProcessoVinculado);
       					advProcessoViculado.setTipoRepresentante(fromValue);
       				}
    				TipoEndereco enderecoAdvogadoProcessoVinculado = new TipoEndereco();
    				
    				// Pessoa
    				TipoPessoa pessoaProcessoVinculado = new TipoPessoa();
    				
    				String cidadeNaturalProcessoVinculado = processoVinculado.getParte_cidade_natural();
    				pessoaProcessoVinculado.setCidadeNatural(cidadeNaturalProcessoVinculado!=null?cidadeNaturalProcessoVinculado:null);
    				
    				if (processoVinculado.getParte_data_nascimento()!=null) {
    					pessoaProcessoVinculado.setDataNascimento(processoVinculado.getParte_data_nascimento());
    				}
    				
    				String estadoNaturalProcessoVinculado = processoVinculado.getParte_estado_natural();
    				
    				pessoaProcessoVinculado.setEstadoNatural(estadoNaturalProcessoVinculado!=null?estadoNaturalProcessoVinculado:null);
    				
    				String nacionalidadeProcessoVinculado = processoVinculado.getParte_nacionalidade();
    				pessoaProcessoVinculado.setNacionalidade(nacionalidadeProcessoVinculado!=null?nacionalidadeProcessoVinculado:null);
    				String nomeParteProcessoVinculado = processoVinculado.getParte_nome();
    				pessoaProcessoVinculado.setNome(nomeParteProcessoVinculado!=null?nomeParteProcessoVinculado:null);
    				String numeroDocumentoPrincipalParteProcessoVinculado = processoVinculado.getParte_numero_documento_principal();
    				pessoaProcessoVinculado.setNumeroDocumentoPrincipal(numeroDocumentoPrincipalParteProcessoVinculado!=null?String.valueOf(numeroDocumentoPrincipalParteProcessoVinculado):null);
    				//   	    	    				tpa.setPessoaVinculada(pessoaParte.get);
    				if (processoVinculado.getParte_sexo()!=null) {
    					ModalidadeGeneroPessoa fromValue = ModalidadeGeneroPessoa.fromValue(processoVinculado.getParte_sexo());
    					pessoaProcessoVinculado.setSexo(fromValue);
    				}	
    				if (processoVinculado.getParte_tipo_pessoa()!=null) {
    					TipoQualificacaoPessoa fromValue2 = TipoQualificacaoPessoa.fromValue(processoVinculado.getParte_tipo_pessoa());
    					pessoaProcessoVinculado.setTipoPessoa(fromValue2);
    				}		
    				TipoEndereco endPessoaParteProcessoVinculado = new TipoEndereco(); 

    				String bairroProcessoVinculado = processoVinculado.getEndereco_bairro();
    				endPessoaParteProcessoVinculado.setBairro(bairroProcessoVinculado!=null?bairroProcessoVinculado:null);

    				String cepProcessoVinculado = processoVinculado.getEndereco_cep();
    				endPessoaParteProcessoVinculado.setCep(cepProcessoVinculado!=null?cepProcessoVinculado.toString():null);

    				String cidadeProcessoVinculado = processoVinculado.getEndereco_cidade();
    				endPessoaParteProcessoVinculado.setCidade(cidadeProcessoVinculado!=null?cidadeProcessoVinculado:null);

    				String complementoProcessoVinculado = processoVinculado.getEndereco_complemento();
    				endPessoaParteProcessoVinculado.setComplemento(complementoProcessoVinculado!=null?complementoProcessoVinculado:null);

    				String estadoProcessoVinculado = processoVinculado.getEndereco_estado();
    				endPessoaParteProcessoVinculado.setEstado(estadoProcessoVinculado!=null?estadoProcessoVinculado:null);

    				String logradouroProcessoVinculado = processoVinculado.getEndereco_logradouro();
    				endPessoaParteProcessoVinculado.setLogradouro(logradouroProcessoVinculado!=null?logradouroProcessoVinculado:null);

    				String numeroProcessoVinculado = processoVinculado.getEndereco_numero();
    				endPessoaParteProcessoVinculado.setNumero(numeroProcessoVinculado!=null?numeroProcessoVinculado:null);

    				String paisProcessoVinculado = processoVinculado.getEndereco_pais();
    				endPessoaParteProcessoVinculado.setPais(paisProcessoVinculado!=null?paisProcessoVinculado:null);
    				pessoaProcessoVinculado.getEndereco().add(endPessoaParteProcessoVinculado);	
    				   	    	    					
    				TipoDocumentoIdentificacao tdociProcessoVinculado = new TipoDocumentoIdentificacao();

    				String codigoDocumentoProcessoVinculado = processoVinculado.getParte_codigo_documento();

    				tdociProcessoVinculado.setCodigoDocumento(codigoDocumentoProcessoVinculado!=null?codigoDocumentoProcessoVinculado:null);

    				String emissorDocumentoProcessoVinculado = processoVinculado.getParte_emissor_documento();
    				tdociProcessoVinculado.setEmissorDocumento(emissorDocumentoProcessoVinculado!=null?emissorDocumentoProcessoVinculado:null);
    				
    				tdociProcessoVinculado.setNome(nomeParteProcessoVinculado);

    				if (processoVinculado.getParte_tipo_documento() != null && 
    					processoVinculado.getParte_tipo_documento().length()>0) {
    					tdociProcessoVinculado.setTipoDocumento(ModalidadeDocumentoIdentificador.fromValue(processoVinculado.getParte_tipo_documento()));
    				}	

    				pessoaProcessoVinculado.getDocumento().add(tdociProcessoVinculado);
    				parteProcessoViculado.setPessoa(pessoaProcessoVinculado);
    				
    				// Parametros
        			if (!processoVinculado.getTipo_documento().equals("58") ) {
	    				TipoParametro tp4 = new TipoParametro();
	        			String numeroCda = processoVinculado.getNumeroCda();
	        			if (numeroCda != null) {
	    	    			tp4.setNome("Nº da CDA");
	    	    			tp4.setValor(numeroCda);
	    	    			manifestaaoProcessual.getParametros().add(tp4);
	        			}	
        			} else {	
	        			TipoParametro tp5 = new TipoParametro();
	        			String dataConstituicaoCredito = processoVinculado.getDataConstituicaoCredito();
	        			if (dataConstituicaoCredito!=null) {
	    	     			tp5.setNome("Data da Constituição Definitiva do Crédito");
	    	    			tp5.setValor(dataConstituicaoCredito);
	    	    			manifestaaoProcessual.getParametros().add(tp5);
	        			}	
        			}

       	   			if (!nomeParteReferencia.equals(pessoaProcessoVinculado.getNome())) {
       	   				poloVinculado.getParte().add(parteProcessoViculado);
       	   				cabecalhoProcesso.getPolo().add(poloVinculado);
       	   			}	
       	   			nomeParteReferencia=pessoaProcessoVinculado.getNome();
       	   			nomeAdvReferencia=advProcessoViculado.getNome();
       	   		
    			}
    			// Parametros
    			if (!processo.getTipo_documento().equals("58") ) {
	    			TipoParametro tp1 = new TipoParametro();
	    			String numeroCda = processo.getNumeroCda();
	    			if (numeroCda != null) {
		    			tp1.setNome("Nº da CDA");
		    			tp1.setValor(numeroCda);
		    			manifestaaoProcessual.getParametros().add(tp1);
	    			}	
    			} else {
	    			TipoParametro tp2 = new TipoParametro();
	    			String dataConstituicaoCredito = processo.getDataConstituicaoCredito();
	    			if (dataConstituicaoCredito!=null) {
		     			tp2.setNome("Data da Constituição Definitiva do Crédito");
		    			tp2.setValor(dataConstituicaoCredito);
		    			manifestaaoProcessual.getParametros().add(tp2);
	    			}	
    			}
    			TipoParametro tp3 = new TipoParametro();
    			tp3.setNome("mni:pje:identificadorExterno");
    			tp3.setValor(new SimpleDateFormat("yyyyMM").format(Timestamp.valueOf(now)) + String.format("%06d", processo.getId()));
    			manifestaaoProcessual.getParametros().add(tp3);
    			
    			cabecalhoProcesso.setNumero("00000000000000000000");
    			cabecalhoProcesso.setCompetencia(6);
    			cabecalhoProcesso.setIntervencaoMP(false);
   				manifestaaoProcessual.setDadosBasicos(cabecalhoProcesso);
   				
	   	
   	   	    	TipoEntregarManifestacaoProcessualResposta entregarManifestacaoProcessual = pjeService.entregarManifestacaoProcessual(manifestaaoProcessual);
   	   	    	String protocoloRecebimento=null;
   	   	    	if (entregarManifestacaoProcessual!=null) {
					boolean sucesso = entregarManifestacaoProcessual.isSucesso();
					if (sucesso) {
						processo.setEntra_status_processamento("01");
					} else {
						String mensageRetornada = entregarManifestacaoProcessual.getMensagem();
						if (mensageRetornada!=null) {
							int indexOf = mensageRetornada.indexOf("Número do processo: ");
							if (indexOf>-1 && mensageRetornada.length()> (indexOf+46)) {
								processo.setRetorno_protocolo_recebimento(
										mensageRetornada.substring(indexOf+20,indexOf+46));
							}
						}
						processo.setEntra_status_processamento("03");
					}
	   	    	    processo.setSai_data_atualizacao_registro(new SimpleDateFormat("yyyyMMddHHmmss").format(Timestamp.valueOf(now)));
					processo.setRetorno_sucesso(sucesso);
	   	   	    	protocoloRecebimento = entregarManifestacaoProcessual.getProtocoloRecebimento();
	   	   	    	if (protocoloRecebimento!=null) {
	   	   	    		processo.setRetorno_protocolo_recebimento(protocoloRecebimento);
	   	   	    	}	
	   	   	    	String dataOperacao = entregarManifestacaoProcessual.getDataOperacao();
	   	   	    	if (dataOperacao != null) {
	   	   	    		processo.setRetorno_data_operacao(dataOperacao);
	   	   	    	}	
	   	   	    	String mensagem = entregarManifestacaoProcessual.getMensagem();
	   	   	    	if (mensagem !=null) {
	   	   	    		processo.setRetorno_mensagem(mensagem);
	   	   	    	}	
	   	   	    	String recibo = entregarManifestacaoProcessual.getRecibo();
   	   	    		processo.setRetorno_recibo(recibo);
	   	 	       	processo.setSai_erro_sistema(null);
	   	 	       	
		       		String conteudoRetornado = null;
	    			try {
	    				conteudoRetornado = retornoToString(entregarManifestacaoProcessual);
	    				processo.setSai_conteudo_retornado(conteudoRetornado);
	    			} catch (JAXBException ex){
	    				System.out.println("Converção retorno para String não realizada!\n");
	    				ex.printStackTrace();
	    			}

   	 	       	}
	   	 	    else {
	   	 	    	processo.setEntra_status_processamento("02");
	   	 	    	processo.setSai_erro_sistema("Serviço não retornado");
	   	 	    }
	   	    	    
   	    	    processo.setSai_data_atualizacao_registro(new SimpleDateFormat("yyyyMMddHHmmss").format(Timestamp.valueOf(now)));
	   	   	    	
   	   	    	repository.save(processo);
   	   	    	repository.flush();
    		    if (protocoloRecebimento!=null) {
    		    	System.out.println("Registro atualizado no Banco. Protocolo: " + protocoloRecebimento);
    		    }
	         }  
			catch (SocketTimeoutException ex) {
   	 	       	StringWriter errors = new StringWriter();
   	 	       	ex.printStackTrace(new PrintWriter(errors));
   	 	       	int tentativa=1;
   	 	       	String sai_erro_sistema = processo.getSai_conteudo_retornado();
       			processo.setEntra_status_processamento("00");
				if (sai_erro_sistema !=null && sai_erro_sistema.indexOf("Timeout Tentativa:") > -1) {
   	 	       		tentativa = Integer.parseInt(sai_erro_sistema.substring(sai_erro_sistema.indexOf("Timeout Tentativa:")+19))+1;
   	 	       		if (tentativa>9) {
   	    	    	    processo.setEntra_status_processamento("98");
   	 	       		}
				}
   	 	       	processo.setSai_conteudo_retornado("Timeout Tentativa: " + tentativa);
   	    	    processo.setRetorno_sucesso(false);
   	    	    processo.setSai_data_atualizacao_registro(new SimpleDateFormat("yyyyMMddHHmmss").format(Timestamp.valueOf(now)));
    		    repository.save(processo);
    		    repository.flush();
			}
   	   	   	catch (Exception ex) {
   	 	       	StringWriter errors = new StringWriter();
   	 	       	ex.printStackTrace(new PrintWriter(errors));
   	 	       	if (errors.toString().indexOf("Timeout")>-1) {
   	   	 	       	int tentativa=1;
   	   	 	       	String sai_erro_sistema = processo.getSai_conteudo_retornado();
   	       			processo.setEntra_status_processamento("00");
   					if (sai_erro_sistema !=null && sai_erro_sistema.indexOf("Timeout Tentativa:") > -1) {
   	   	 	       		tentativa = Integer.parseInt(sai_erro_sistema.substring(sai_erro_sistema.indexOf("Timeout Tentativa:")+19))+1;
   	   	 	       		if (tentativa>9) {
   	   	    	    	    processo.setEntra_status_processamento("98");
   	   	 	       		}
   					}
   	   	 	       	processo.setSai_conteudo_retornado("Timeout Tentativa: " + tentativa);
   	 	       	} else {
	   	 	       	processo.setSai_erro_sistema(errors.toString());
	   	    	    processo.setEntra_status_processamento("99");
   	 	       	}   
   	    	    processo.setRetorno_sucesso(false);
   	    	    processo.setSai_data_atualizacao_registro(new SimpleDateFormat("yyyyMMddHHmmss").format(Timestamp.valueOf(now)));
    		    repository.save(processo);
    		    repository.flush();
   	 	    }
   	   	}
    }    

    private String  retornoToString(TipoEntregarManifestacaoProcessualResposta servicoSaida) throws JAXBException {
    	JAXBContext jaxbContext = JAXBContext.newInstance(TipoEntregarManifestacaoProcessualResposta.class);
    	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    	StringWriter sw = new StringWriter();
    	jaxbMarshaller.marshal(servicoSaida, sw);
    	return  sw.toString();
    	
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
}
		
