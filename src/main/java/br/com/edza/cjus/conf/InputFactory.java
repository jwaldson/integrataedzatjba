package br.com.edza.cjus.conf;

import com.ctc.wstx.api.WstxInputProperties;
import com.ctc.wstx.stax.WstxInputFactory;

public class InputFactory extends WstxInputFactory {
	final String MAX_VALUE = "120000";
    public InputFactory() {
        super();
        setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, Integer.MAX_VALUE);
    }
}