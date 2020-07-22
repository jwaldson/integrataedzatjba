
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadesRelacionamentoPessoal.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadesRelacionamentoPessoal"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="AP"/&gt;
 *     &lt;enumeration value="SP"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadesRelacionamentoPessoal")
@XmlEnum
public enum ModalidadesRelacionamentoPessoal {

    P,
    AP,
    SP,
    T,
    C;

    public String value() {
        return name();
    }

    public static ModalidadesRelacionamentoPessoal fromValue(String v) {
        return valueOf(v);
    }

}
