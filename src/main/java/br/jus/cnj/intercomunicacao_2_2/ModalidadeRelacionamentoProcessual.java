
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadeRelacionamentoProcessual.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadeRelacionamentoProcessual"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CP"/&gt;
 *     &lt;enumeration value="RP"/&gt;
 *     &lt;enumeration value="TF"/&gt;
 *     &lt;enumeration value="AT"/&gt;
 *     &lt;enumeration value="AS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadeRelacionamentoProcessual")
@XmlEnum
public enum ModalidadeRelacionamentoProcessual {

    CP,
    RP,
    TF,
    AT,
    AS;

    public String value() {
        return name();
    }

    public static ModalidadeRelacionamentoProcessual fromValue(String v) {
        return valueOf(v);
    }

}
