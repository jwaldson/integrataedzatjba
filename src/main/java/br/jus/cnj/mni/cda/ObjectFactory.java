
package br.jus.cnj.mni.cda;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.jus.cnj.mni.cda package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.jus.cnj.mni.cda
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipoDividaAtiva }
     * 
     */
    public TipoDividaAtiva createTipoDividaAtiva() {
        return new TipoDividaAtiva();
    }

    /**
     * Create an instance of {@link TipoCertidao }
     * 
     */
    public TipoCertidao createTipoCertidao() {
        return new TipoCertidao();
    }

    /**
     * Create an instance of {@link ValorDivida }
     * 
     */
    public ValorDivida createValorDivida() {
        return new ValorDivida();
    }

    /**
     * Create an instance of {@link TipoDevedorPrincipal }
     * 
     */
    public TipoDevedorPrincipal createTipoDevedorPrincipal() {
        return new TipoDevedorPrincipal();
    }

    /**
     * Create an instance of {@link TipoDevedorAlternativo }
     * 
     */
    public TipoDevedorAlternativo createTipoDevedorAlternativo() {
        return new TipoDevedorAlternativo();
    }

}
