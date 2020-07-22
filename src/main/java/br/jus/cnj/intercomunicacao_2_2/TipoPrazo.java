
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoPrazo.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoPrazo"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HOR"/&gt;
 *     &lt;enumeration value="DIA"/&gt;
 *     &lt;enumeration value="MES"/&gt;
 *     &lt;enumeration value="ANO"/&gt;
 *     &lt;enumeration value="DATA_CERTA"/&gt;
 *     &lt;enumeration value="SEMPRAZO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipoPrazo")
@XmlEnum
public enum TipoPrazo {

    HOR,
    DIA,
    MES,
    ANO,
    DATA_CERTA,
    SEMPRAZO;

    public String value() {
        return name();
    }

    public static TipoPrazo fromValue(String v) {
        return valueOf(v);
    }

}
