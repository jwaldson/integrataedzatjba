package br.com.edza.cjus.task;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.edza.cjus.enums.ParametroEnum;
import br.com.edza.cjus.model.ParametroSistema;
import br.com.edza.cjus.service.ParametroSistemaService;
import br.com.edza.cjus.service.PjeEdzaService;


@Configuration
public class PJePagtoEdzaTask {

    @Autowired
    private PjeEdzaService service;
    
	@Autowired
	private ParametroSistemaService parametroSistemaService;
	
	private Logger log = LoggerFactory.getLogger(PJePagtoEdzaTask.class);
	
	public static final String MASK_DH = "dd-MM-yyyy HH:mm:ss";	

	private static final DateTimeFormatter dateTimeFormatter_log = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
    @Scheduled(cron = "*/50 * * ? * *")
    public void jobPJE() {
		if (isServidorAtivo("PjeEdza_pje", 
							ParametroEnum.PJE__SERVIDOR_EM_EXECUCAO_16, 
							ParametroEnum.PJE_HABILITADO_13, 
							ParametroEnum.PJE_INTERVALO_EXECUCAO_14, 
							ParametroEnum.PJE_ULTIMA_EXECUCAO_15)) { 
	         service.processaInsereAltera();
	         atualizaProcesso(ParametroEnum.PJE_ULTIMA_EXECUCAO_15);
		} 

    }
        
    private boolean isServidorAtivo(String job, 
    								ParametroEnum servidor,
    								ParametroEnum habilitado,
    								ParametroEnum intervalo, 
    								ParametroEnum ultimaExecucao) {

    	boolean result = false;
    	try {
    		ParametroSistema parametro = null;
    		parametro = consultaParametroPeloCodigo(habilitado);
    		if (parametro !=null && Boolean.parseBoolean(parametro.getConteudo())) { // Verifica se o Serviço está habilitado
	    		InetAddress localHost = null;	
	    		localHost = InetAddress.getLocalHost();
	    		
	    		parametro = consultaParametroPeloCodigo(ultimaExecucao);
	    		if (parametro !=null) {
	    			Calendar dhUltimaExecucao=null;
	    	        if (parametro.getConteudo()!=null) { 
	    	        	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
	    	    		TimeZone.setDefault(tz);
		   			    dhUltimaExecucao = new GregorianCalendar(tz);
		    			SimpleDateFormat formdata= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    	        	dhUltimaExecucao.setTime(formdata.parse(parametro.getConteudo()));
	    	        }	
	   	    		parametro = consultaParametroPeloCodigo(intervalo);
	    			
	   			    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	   			    Calendar dataHoraIntervalo = Calendar.getInstance();
					Calendar dhCarencia = Calendar.getInstance();

					int intervaloExecucao = Integer.parseInt(parametro.getConteudo());
	   			    dataHoraIntervalo.add(Calendar.MINUTE, -intervaloExecucao);
	   			    dhCarencia.add(Calendar.MINUTE, -2*intervaloExecucao);
	   			   // System.out.println(dhCarencia.getTime());
	
	    			if (dhUltimaExecucao != null && dhUltimaExecucao.before(dhCarencia)) {  // Verifica se o serviço está supostamente parado
			    		parametro = consultaParametroPeloCodigo(servidor);
						parametro.setConteudo(null);
						try {
							this.parametroSistemaService.alterar(parametro);
						} catch (Exception ex) {
							this.log.info("Falha ao consultar parametro.  - Host: " + localHost.getHostName() + ex.getMessage());
						}
	    			} else if (dhUltimaExecucao != null && dhUltimaExecucao.before(dataHoraIntervalo)) { // Verifica se o serviço está dentro do prazo de execução
	    				return false;
	    			}
	    			
	    		}
	    		
	    		parametro = consultaParametroPeloCodigo(servidor);
	    		
				if (parametro != null) {
					String conteudo = parametro.getConteudo();
					if (conteudo == null) {
						conteudo = localHost.getHostName();
						parametro.setConteudo(conteudo);
						try {
							this.parametroSistemaService.alterar(parametro);
						} catch (Exception ex) {
							this.log.info("Falha ao consultar parametro.  - Host: " + localHost.getHostName() + ex.getMessage());
						}
					}		 	
					if (localHost.getHostName().equals(conteudo)) { // Verifica se é o servidor que deve executar.
						result = true;
					}
				}
    		}	
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
		return result;
    }
    
    private void atualizaProcesso(ParametroEnum ultimaExecucao) {
 		try {
		  	ParametroSistema consultaParametroPeloCodigo = consultaParametroPeloCodigo(ultimaExecucao);
	    	consultaParametroPeloCodigo.setConteudo(dateTimeFormatter_log.format(LocalDateTime.now()));
			this.parametroSistemaService.alterar(consultaParametroPeloCodigo);
		} catch (Exception ex) {   		
			this.log.info("Falha ao alterar parametro.  - " + ex.getMessage());
		}

    }
    
    private ParametroSistema consultaParametroPeloCodigo(ParametroEnum param) throws Exception {
        return consultaParametroPeloCodigo(param.getId());
    }
    
    private ParametroSistema consultaParametroPeloCodigo(Integer param) throws Exception {
        ParametroSistema result = null;
        try {
            result = parametroSistemaService.consultarParametroPeloCodigo(param);
        } catch (Exception ex) {
            this.log.info(ex.getMessage());
            throw ex;
        }
        return result;
    }
    
}
