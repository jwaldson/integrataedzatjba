
package br.jus.cnj.mni.cda;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="certidao" type="{http://www.cnj.jus.br/mni/cda}tipoCertidao" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "certidao"
})
@XmlRootElement(name = "tipoDividaAtiva")
public class TipoDividaAtiva {

    @XmlElement(required = true)
    protected List<TipoCertidao> certidao;

    /**
     * Gets the value of the certidao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certidao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertidao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoCertidao }
     * 
     * 
     */
    public List<TipoCertidao> getCertidao() {
        if (certidao == null) {
            certidao = new ArrayList<TipoCertidao>();
        }
        return this.certidao;
    }

}
