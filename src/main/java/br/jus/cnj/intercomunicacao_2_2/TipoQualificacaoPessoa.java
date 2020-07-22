
package br.jus.cnj.intercomunicacao_2_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoQualificacaoPessoa.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoQualificacaoPessoa"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="fisica"/&gt;
 *     &lt;enumeration value="juridica"/&gt;
 *     &lt;enumeration value="autoridade"/&gt;
 *     &lt;enumeration value="orgaorepresentacao"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipoQualificacaoPessoa")
@XmlEnum
public enum TipoQualificacaoPessoa {

    @XmlEnumValue("fisica")
    FISICA("fisica"),
    @XmlEnumValue("juridica")
    JURIDICA("juridica"),
    @XmlEnumValue("autoridade")
    AUTORIDADE("autoridade"),
    @XmlEnumValue("orgaorepresentacao")
    ORGAOREPRESENTACAO("orgaorepresentacao");
    private final String value;

    TipoQualificacaoPessoa(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoQualificacaoPessoa fromValue(String v) {
        for (TipoQualificacaoPessoa c: TipoQualificacaoPessoa.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
