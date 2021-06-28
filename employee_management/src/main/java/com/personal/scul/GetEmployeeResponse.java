//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.06.18 a las 09:56:06 AM CST 
//


package com.personal.scul;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetEmployeeResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetEmployeeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmployeeDetails" type="{http://personal.com/scul}EmployeeDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmployeeResponse", propOrder = {
    "employeeDetails"
})
public class GetEmployeeResponse {

    @XmlElement(name = "EmployeeDetails", required = true)
    protected EmployeeDetails employeeDetails;

    /**
     * Obtiene el valor de la propiedad employeeDetails.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeDetails }
     *     
     */
    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    /**
     * Define el valor de la propiedad employeeDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeDetails }
     *     
     */
    public void setEmployeeDetails(EmployeeDetails value) {
        this.employeeDetails = value;
    }

}
