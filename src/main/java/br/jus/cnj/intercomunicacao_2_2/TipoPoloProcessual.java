
package br.jus.cnj.intercomunicacao_2_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo destinado a permitir a identificação do polo
 * 				ocupado por uma determinada parte no processo judicial.
 * 
 * <p>Classe Java de tipoPoloProcessual complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoPoloProcessual"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parte" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}tipoParte" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="polo" type="{http://www.cnj.jus.br/intercomunicacao-2.2.2}modalidadePoloProcessual" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoPoloProcessual", propOrder = {
    "parte"
})
public class TipoPoloProcessual {

    @XmlElement(required = true)
    protected List<TipoParte> parte;
    @XmlAttribute(name = "polo")
    protected ModalidadePoloProcessual polo;

    /**
     * Gets the value of the parte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoParte }
     * 
     * 
     */
    public List<TipoParte> getParte() {
        if (parte == null) {
            parte = new ArrayList<TipoParte>();
        }
        return this.parte;
    }

    /**
     * Obtém o valor da propriedade polo.
     * 
     * @return
     *     possible object is
     *     {@link ModalidadePoloProcessual }
     *     
     */
    public ModalidadePoloProcessual getPolo() {
        return polo;
    }

    /**
     * Define o valor da propriedade polo.
     * 
     * @param value
     *     allowed object is
     *     {@link ModalidadePoloProcessual }
     *     
     */
    public void setPolo(ModalidadePoloProcessual value) {
        this.polo = value;
    }

}
