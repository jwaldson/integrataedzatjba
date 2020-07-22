
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo de elemento que permite a indicação da realização
 * 				de um movimento existente na tabela unificada de que
 * 				trata a
 * 				Resolução 46.
 * 
 * <p>Classe Java de tipoMovimentoNacional complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoMovimentoNacional"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="complemento" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoComplemento" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="codigoNacional" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoMovimentoNacional", propOrder = {
    "complemento"
})
public class TipoMovimentoNacional {

    protected List<String> complemento;
    @XmlAttribute(name = "codigoNacional", required = true)
    protected int codigoNacional;

    /**
     * Gets the value of the complemento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complemento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplemento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComplemento() {
        if (complemento == null) {
            complemento = new ArrayList<String>();
        }
        return this.complemento;
    }

    /**
     * Obtém o valor da propriedade codigoNacional.
     * 
     */
    public int getCodigoNacional() {
        return codigoNacional;
    }

    /**
     * Define o valor da propriedade codigoNacional.
     * 
     */
    public void setCodigoNacional(int value) {
        this.codigoNacional = value;
    }

}
