
package com.apcb.business.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.apcb.business.services package. 
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

    private final static QName _ConsultReservOrTicketResponse_QNAME = new QName("http://services.business.apcb.com/", "consultReservOrTicketResponse");
    private final static QName _TicketReservAndPay_QNAME = new QName("http://services.business.apcb.com/", "ticketReservAndPay");
    private final static QName _TicketAirAvailAndPrice_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvailAndPrice");
    private final static QName _TicketAirAvailAndPriceResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvailAndPriceResponse");
    private final static QName _TicketReservAndPayResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketReservAndPayResponse");
    private final static QName _ConsultReservOrTicket_QNAME = new QName("http://services.business.apcb.com/", "consultReservOrTicket");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apcb.business.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultReservOrTicketResponse }
     * 
     */
    public ConsultReservOrTicketResponse createConsultReservOrTicketResponse() {
        return new ConsultReservOrTicketResponse();
    }

    /**
     * Create an instance of {@link TicketReservAndPay }
     * 
     */
    public TicketReservAndPay createTicketReservAndPay() {
        return new TicketReservAndPay();
    }

    /**
     * Create an instance of {@link ConsultReservOrTicket }
     * 
     */
    public ConsultReservOrTicket createConsultReservOrTicket() {
        return new ConsultReservOrTicket();
    }

    /**
     * Create an instance of {@link TicketReservAndPayResponse }
     * 
     */
    public TicketReservAndPayResponse createTicketReservAndPayResponse() {
        return new TicketReservAndPayResponse();
    }

    /**
     * Create an instance of {@link TicketAirAvailAndPriceResponse }
     * 
     */
    public TicketAirAvailAndPriceResponse createTicketAirAvailAndPriceResponse() {
        return new TicketAirAvailAndPriceResponse();
    }

    /**
     * Create an instance of {@link TicketAirAvailAndPrice }
     * 
     */
    public TicketAirAvailAndPrice createTicketAirAvailAndPrice() {
        return new TicketAirAvailAndPrice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultReservOrTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultReservOrTicketResponse")
    public JAXBElement<ConsultReservOrTicketResponse> createConsultReservOrTicketResponse(ConsultReservOrTicketResponse value) {
        return new JAXBElement<ConsultReservOrTicketResponse>(_ConsultReservOrTicketResponse_QNAME, ConsultReservOrTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketReservAndPay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketReservAndPay")
    public JAXBElement<TicketReservAndPay> createTicketReservAndPay(TicketReservAndPay value) {
        return new JAXBElement<TicketReservAndPay>(_TicketReservAndPay_QNAME, TicketReservAndPay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvailAndPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvailAndPrice")
    public JAXBElement<TicketAirAvailAndPrice> createTicketAirAvailAndPrice(TicketAirAvailAndPrice value) {
        return new JAXBElement<TicketAirAvailAndPrice>(_TicketAirAvailAndPrice_QNAME, TicketAirAvailAndPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvailAndPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvailAndPriceResponse")
    public JAXBElement<TicketAirAvailAndPriceResponse> createTicketAirAvailAndPriceResponse(TicketAirAvailAndPriceResponse value) {
        return new JAXBElement<TicketAirAvailAndPriceResponse>(_TicketAirAvailAndPriceResponse_QNAME, TicketAirAvailAndPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketReservAndPayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketReservAndPayResponse")
    public JAXBElement<TicketReservAndPayResponse> createTicketReservAndPayResponse(TicketReservAndPayResponse value) {
        return new JAXBElement<TicketReservAndPayResponse>(_TicketReservAndPayResponse_QNAME, TicketReservAndPayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultReservOrTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultReservOrTicket")
    public JAXBElement<ConsultReservOrTicket> createConsultReservOrTicket(ConsultReservOrTicket value) {
        return new JAXBElement<ConsultReservOrTicket>(_ConsultReservOrTicket_QNAME, ConsultReservOrTicket.class, null, value);
    }

}
