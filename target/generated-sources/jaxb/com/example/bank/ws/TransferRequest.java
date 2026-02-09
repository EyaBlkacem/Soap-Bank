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
 *         &lt;element name="fromAccountId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="toAccountId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
    "fromAccountId",
    "toAccountId",
    "amount"
})
@XmlRootElement(name = "TransferRequest")
public class TransferRequest {

    @XmlElement(required = true)
    protected String fromAccountId;
    @XmlElement(required = true)
    protected String toAccountId;
    @XmlElement(required = true)
    protected BigDecimal amount;

    /**
     * Obtient la valeur de la propriété fromAccountId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * Définit la valeur de la propriété fromAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromAccountId(String value) {
        this.fromAccountId = value;
    }

    /**
     * Obtient la valeur de la propriété toAccountId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAccountId() {
        return toAccountId;
    }

    /**
     * Définit la valeur de la propriété toAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAccountId(String value) {
        this.toAccountId = value;
    }

    /**
     * Obtient la valeur de la propriété amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Définit la valeur de la propriété amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

}
