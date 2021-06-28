//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.06.18 a las 09:56:06 AM CST 
//


package com.personal.scul;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.personal.scul package. 
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

    private final static QName _RemoveEmployeeResponse_QNAME = new QName("http://personal.com/scul", "RemoveEmployeeResponse");
    private final static QName _RemoveEmployeeRequest_QNAME = new QName("http://personal.com/scul", "RemoveEmployeeRequest");
    private final static QName _GetEmployeeRequest_QNAME = new QName("http://personal.com/scul", "GetEmployeeRequest");
    private final static QName _GetAllEmployeeRequest_QNAME = new QName("http://personal.com/scul", "GetAllEmployeeRequest");
    private final static QName _GetEmployeeResponse_QNAME = new QName("http://personal.com/scul", "GetEmployeeResponse");
    private final static QName _GetAllEmployeeResponse_QNAME = new QName("http://personal.com/scul", "GetAllEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.personal.scul
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveEmployeeResponse }
     * 
     */
    public RemoveEmployeeResponse createRemoveEmployeeResponse() {
        return new RemoveEmployeeResponse();
    }

    /**
     * Create an instance of {@link GetAllEmployeeResponse }
     * 
     */
    public GetAllEmployeeResponse createGetAllEmployeeResponse() {
        return new GetAllEmployeeResponse();
    }

    /**
     * Create an instance of {@link GetAllEmployeeRequest }
     * 
     */
    public GetAllEmployeeRequest createGetAllEmployeeRequest() {
        return new GetAllEmployeeRequest();
    }

    /**
     * Create an instance of {@link GetEmployeeResponse }
     * 
     */
    public GetEmployeeResponse createGetEmployeeResponse() {
        return new GetEmployeeResponse();
    }

    /**
     * Create an instance of {@link GetEmployeeRequest }
     * 
     */
    public GetEmployeeRequest createGetEmployeeRequest() {
        return new GetEmployeeRequest();
    }

    /**
     * Create an instance of {@link RemoveEmployeeRequest }
     * 
     */
    public RemoveEmployeeRequest createRemoveEmployeeRequest() {
        return new RemoveEmployeeRequest();
    }

    /**
     * Create an instance of {@link EmployeeDetails }
     * 
     */
    public EmployeeDetails createEmployeeDetails() {
        return new EmployeeDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "RemoveEmployeeResponse")
    public JAXBElement<RemoveEmployeeResponse> createRemoveEmployeeResponse(RemoveEmployeeResponse value) {
        return new JAXBElement<RemoveEmployeeResponse>(_RemoveEmployeeResponse_QNAME, RemoveEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "RemoveEmployeeRequest")
    public JAXBElement<RemoveEmployeeRequest> createRemoveEmployeeRequest(RemoveEmployeeRequest value) {
        return new JAXBElement<RemoveEmployeeRequest>(_RemoveEmployeeRequest_QNAME, RemoveEmployeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "GetEmployeeRequest")
    public JAXBElement<GetEmployeeRequest> createGetEmployeeRequest(GetEmployeeRequest value) {
        return new JAXBElement<GetEmployeeRequest>(_GetEmployeeRequest_QNAME, GetEmployeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployeeRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "GetAllEmployeeRequest")
    public JAXBElement<GetAllEmployeeRequest> createGetAllEmployeeRequest(GetAllEmployeeRequest value) {
        return new JAXBElement<GetAllEmployeeRequest>(_GetAllEmployeeRequest_QNAME, GetAllEmployeeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "GetEmployeeResponse")
    public JAXBElement<GetEmployeeResponse> createGetEmployeeResponse(GetEmployeeResponse value) {
        return new JAXBElement<GetEmployeeResponse>(_GetEmployeeResponse_QNAME, GetEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personal.com/scul", name = "GetAllEmployeeResponse")
    public JAXBElement<GetAllEmployeeResponse> createGetAllEmployeeResponse(GetAllEmployeeResponse value) {
        return new JAXBElement<GetAllEmployeeResponse>(_GetAllEmployeeResponse_QNAME, GetAllEmployeeResponse.class, null, value);
    }

}
