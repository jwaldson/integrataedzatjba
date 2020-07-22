
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadeVinculacaoProcesso.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadeVinculacaoProcesso"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CX"/&gt;
 *     &lt;enumeration value="CT"/&gt;
 *     &lt;enumeration value="DP"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *     &lt;enumeration value="RR"/&gt;
 *     &lt;enumeration value="RG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadeVinculacaoProcesso")
@XmlEnum
public enum ModalidadeVinculacaoProcesso {

    CX,
    CT,
    DP,
    AR,
    CD,
    OR,
    RR,
    RG;

    public String value() {
        return name();
    }

    public static ModalidadeVinculacaoProcesso fromValue(String v) {
        return valueOf(v);
    }

}
