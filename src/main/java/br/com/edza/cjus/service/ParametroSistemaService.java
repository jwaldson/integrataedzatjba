package  br.com.edza.cjus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.edza.cjus.model.ParametroSistema;
import br.com.edza.cjus.repository.ParametroSistemaRepository;
@Component
public class ParametroSistemaService  {
	
	
	@Autowired
	private ParametroSistemaRepository parametroSistemaRepository;
	
    public ParametroSistema consultarParametroPeloNome(String nome) throws Exception {
    	ParametroSistema result = parametroSistemaRepository.consultarParametroPeloNome(nome);
    	return result;
    }
    public ParametroSistema consultarParametroPeloCodigo(Integer param) throws Exception {
        Optional<ParametroSistema> result = parametroSistemaRepository.findById(param);
        return result.get();
    }
    
    public void alterar(ParametroSistema parametro) throws Exception {
    	parametroSistemaRepository.save(parametro);
    	parametroSistemaRepository.flush();
    }
    

}
