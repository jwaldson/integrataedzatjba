package br.com.edza.cjus.conf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.jus.cnj.servico_intercomunicacao_2_2_2.ServicoIntercomunicacao222;

@Component
public class ClientConfig  { 

    private Logger log = LoggerFactory.getLogger(ClientConfig.class);
    
    private static final int CONNECT_TIMEOUT = 3000;
    private static final int READ_TIMEOUT = 3000;

    @Bean
    public ServicoIntercomunicacao222 getServicoIntercomunicacao() {
        JaxWsProxyFactoryBean jaxws = new JaxWsProxyFactoryBean();
        jaxws.setAddress("https://pje1g-integracao.tjba.jus.br/pje-web/intercomunicacao");
        jaxws.setServiceClass(ServicoIntercomunicacao222.class);
        ServicoIntercomunicacao222 result = (ServicoIntercomunicacao222)jaxws.create();
          
        log.info("client Servico Intercomunicação CJUS instanciado: " + " https://pje1g-integracao.tjba.jus.br/pje-web/intercomunicacao" );
        return result;
    }

    
}