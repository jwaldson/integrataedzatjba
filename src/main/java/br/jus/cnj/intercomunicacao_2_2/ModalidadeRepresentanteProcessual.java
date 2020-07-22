
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadeRepresentanteProcessual.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadeRepresentanteProcessual"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadeRepresentanteProcessual")
@XmlEnum
public enum ModalidadeRepresentanteProcessual {

    A,
    E,
    M,
    D,
    P;

    public String value() {
        return name();
    }

    public static ModalidadeRepresentanteProcessual fromValue(String v) {
        return valueOf(v);
    }

}
