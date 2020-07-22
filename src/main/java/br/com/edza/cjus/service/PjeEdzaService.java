package  br.com.edza.cjus.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PjeEdzaService {	
	
    @Autowired
    ClientPjeService pjeService;
    
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    
    
    public void processaInsereAltera() {
    	pjeService.entregarManifestacaoProcessual(); 
    }
   
}
		
 