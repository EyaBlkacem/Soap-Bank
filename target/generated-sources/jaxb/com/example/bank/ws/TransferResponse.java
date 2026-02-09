//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.02.07 à 07:02:16 PM CET 
//


package com.example.bank.ws;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fromNewBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="toNewBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
    "fromNewBalance",
    "toNewBalance"
})
@XmlRootElement(name = "TransferResponse")
public class TransferResponse {

    @XmlElement(required = true)
    protected BigDecimal fromNewBalance;
    @XmlElement(required = true)
    protected BigDecimal toNewBalance;

    /**
     * Obtient la valeur de la propriété fromNewBalance.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFromNewBalance() {
        return fromNewBalance;
    }

    /**
     * Définit la valeur de la propriété fromNewBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFromNewBalance(BigDecimal value) {
        this.fromNewBalance = value;
    }

    /**
     * Obtient la valeur de la propriété toNewBalance.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getToNewBalance() {
        return toNewBalance;
    }

    /**
     * Définit la valeur de la propriété toNewBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setToNewBalance(BigDecimal value) {
        this.toNewBalance = value;
    }

}
