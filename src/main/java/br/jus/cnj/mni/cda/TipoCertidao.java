
package br.jus.cnj.mni.cda;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoCertidao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tipoCertidao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="devedorPrincipal" type="{http://www.cnj.jus.br/mni/cda}tipoDevedorPrincipal" maxOccurs="unbounded"/&gt;
 *         &lt;element name="devedorAlternativo" type="{http://www.cnj.jus.br/mni/cda}tipoDevedorAlternativo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="valor" type="{http://www.cnj.jus.br/mni/cda}valorDivida" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoCertidao", propOrder = {
    "devedorPrincipal",
    "devedorAlternativo",
    "valor"
})
public class TipoCertidao {

    @XmlElement(required = true)
    protected List<TipoDevedorPrincipal> devedorPrincipal;
    protected List<TipoDevedorAlternativo> devedorAlternativo;
    @XmlElement(required = true)
    protected List<ValorDivida> valor;

    /**
     * Gets the value of the devedorPrincipal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the devedorPrincipal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevedorPrincipal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoDevedorPrincipal }
     * 
     * 
     */
    public List<TipoDevedorPrincipal> getDevedorPrincipal() {
        if (devedorPrincipal == null) {
            devedorPrincipal = new ArrayList<TipoDevedorPrincipal>();
        }
        return this.devedorPrincipal;
    }

    /**
     * Gets the value of the devedorAlternativo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the devedorAlternativo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevedorAlternativo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoDevedorAlternativo }
     * 
     * 
     */
    public List<TipoDevedorAlternativo> getDevedorAlternativo() {
        if (devedorAlternativo == null) {
            devedorAlternativo = new ArrayList<TipoDevedorAlternativo>();
        }
        return this.devedorAlternativo;
    }

    /**
     * Gets the value of the valor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValorDivida }
     * 
     * 
     */
    public List<ValorDivida> getValor() {
        if (valor == null) {
            valor = new ArrayList<ValorDivida>();
        }
        return this.valor;
    }

}
