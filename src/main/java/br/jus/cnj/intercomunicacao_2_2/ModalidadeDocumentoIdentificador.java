
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modalidadeDocumentoIdentificador.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="modalidadeDocumentoIdentificador"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CI"/&gt;
 *     &lt;enumeration value="CNH"/&gt;
 *     &lt;enumeration value="TE"/&gt;
 *     &lt;enumeration value="CN"/&gt;
 *     &lt;enumeration value="CC"/&gt;
 *     &lt;enumeration value="PAS"/&gt;
 *     &lt;enumeration value="CT"/&gt;
 *     &lt;enumeration value="RIC"/&gt;
 *     &lt;enumeration value="CMF"/&gt;
 *     &lt;enumeration value="PIS_PASEP"/&gt;
 *     &lt;enumeration value="CEI"/&gt;
 *     &lt;enumeration value="NIT"/&gt;
 *     &lt;enumeration value="CP"/&gt;
 *     &lt;enumeration value="IF"/&gt;
 *     &lt;enumeration value="OAB"/&gt;
 *     &lt;enumeration value="RJC"/&gt;
 *     &lt;enumeration value="RGE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "modalidadeDocumentoIdentificador")
@XmlEnum
public enum ModalidadeDocumentoIdentificador {

    CI,
    CNH,
    TE,
    CN,
    CC,
    PAS,
    CT,
    RIC,
    CMF,
    PIS_PASEP,
    CEI,
    NIT,
    CP,
    IF,
    OAB,
    RJC,
    RGE;

    public String value() {
        return name();
    }

    public static ModalidadeDocumentoIdentificador fromValue(String v) {
        return valueOf(v);
    }

}
