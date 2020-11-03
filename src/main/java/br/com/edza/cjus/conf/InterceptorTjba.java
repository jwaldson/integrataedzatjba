package br.com.edza.cjus.conf;

import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.jus.cnj.servico_intercomunicacao_2_2_2.ServicoIntercomunicacao222;

@Component
public class InterceptorTjba  extends LoggingOutInterceptor { 
	//@Fiatures org.apache.cxf.feature.LoggingFeature
	public InterceptorTjba () {
		this.setLimit(-1);
	}
	
}