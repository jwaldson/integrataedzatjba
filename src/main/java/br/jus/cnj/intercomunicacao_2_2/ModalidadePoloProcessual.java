
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadePoloProcessual.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadePoloProcessual"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AT"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="TC"/&gt;
 *     &lt;enumeration value="FL"/&gt;
 *     &lt;enumeration value="TJ"/&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="VI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadePoloProcessual")
@XmlEnum
public enum ModalidadePoloProcessual {

    AT,
    PA,
    TC,
    FL,
    TJ,
    AD,
    VI;

    public String value() {
        return name();
    }

    public static ModalidadePoloProcessual fromValue(String v) {
        return valueOf(v);
    }

}
