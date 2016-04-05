
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

    private final static QName _TicketReservAndPay_QNAME = new QName("http://services.business.apcb.com/", "ticketReservAndPay");
    private final static QName _ConsultTicket_QNAME = new QName("http://services.business.apcb.com/", "consultTicket");
    private final static QName _TicketAirAvail_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvail");
    private final static QName _TicketAirAvailResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvailResponse");
    private final static QName _ConsultTicketResponse_QNAME = new QName("http://services.business.apcb.com/", "consultTicketResponse");
    private final static QName _TicketReservAndPayResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketReservAndPayResponse");
    private final static QName _TicketAirPriceResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketAirPriceResponse");
    private final static QName _ConsultReserv_QNAME = new QName("http://services.business.apcb.com/", "consultReserv");
    private final static QName _TicketAirPrice_QNAME = new QName("http://services.business.apcb.com/", "ticketAirPrice");
    private final static QName _ConsultReservResponse_QNAME = new QName("http://services.business.apcb.com/", "consultReservResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apcb.business.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketAirAvailResponse }
     * 
     */
    public TicketAirAvailResponse createTicketAirAvailResponse() {
        return new TicketAirAvailResponse();
    }

    /**
     * Create an instance of {@link TicketAirAvail }
     * 
     */
    public TicketAirAvail createTicketAirAvail() {
        return new TicketAirAvail();
    }

    /**
     * Create an instance of {@link ConsultTicket }
     * 
     */
    public ConsultTicket createConsultTicket() {
        return new ConsultTicket();
    }

    /**
     * Create an instance of {@link TicketReservAndPay }
     * 
     */
    public TicketReservAndPay createTicketReservAndPay() {
        return new TicketReservAndPay();
    }

    /**
     * Create an instance of {@link ConsultReservResponse }
     * 
     */
    public ConsultReservResponse createConsultReservResponse() {
        return new ConsultReservResponse();
    }

    /**
     * Create an instance of {@link TicketAirPrice }
     * 
     */
    public TicketAirPrice createTicketAirPrice() {
        return new TicketAirPrice();
    }

    /**
     * Create an instance of {@link ConsultReserv }
     * 
     */
    public ConsultReserv createConsultReserv() {
        return new ConsultReserv();
    }

    /**
     * Create an instance of {@link TicketAirPriceResponse }
     * 
     */
    public TicketAirPriceResponse createTicketAirPriceResponse() {
        return new TicketAirPriceResponse();
    }

    /**
     * Create an instance of {@link TicketReservAndPayResponse }
     * 
     */
    public TicketReservAndPayResponse createTicketReservAndPayResponse() {
        return new TicketReservAndPayResponse();
    }

    /**
     * Create an instance of {@link ConsultTicketResponse }
     * 
     */
    public ConsultTicketResponse createConsultTicketResponse() {
        return new ConsultTicketResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultTicket")
    public JAXBElement<ConsultTicket> createConsultTicket(ConsultTicket value) {
        return new JAXBElement<ConsultTicket>(_ConsultTicket_QNAME, ConsultTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvail")
    public JAXBElement<TicketAirAvail> createTicketAirAvail(TicketAirAvail value) {
        return new JAXBElement<TicketAirAvail>(_TicketAirAvail_QNAME, TicketAirAvail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvailResponse")
    public JAXBElement<TicketAirAvailResponse> createTicketAirAvailResponse(TicketAirAvailResponse value) {
        return new JAXBElement<TicketAirAvailResponse>(_TicketAirAvailResponse_QNAME, TicketAirAvailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultTicketResponse")
    public JAXBElement<ConsultTicketResponse> createConsultTicketResponse(ConsultTicketResponse value) {
        return new JAXBElement<ConsultTicketResponse>(_ConsultTicketResponse_QNAME, ConsultTicketResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirPriceResponse")
    public JAXBElement<TicketAirPriceResponse> createTicketAirPriceResponse(TicketAirPriceResponse value) {
        return new JAXBElement<TicketAirPriceResponse>(_TicketAirPriceResponse_QNAME, TicketAirPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultReserv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultReserv")
    public JAXBElement<ConsultReserv> createConsultReserv(ConsultReserv value) {
        return new JAXBElement<ConsultReserv>(_ConsultReserv_QNAME, ConsultReserv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirPrice")
    public JAXBElement<TicketAirPrice> createTicketAirPrice(TicketAirPrice value) {
        return new JAXBElement<TicketAirPrice>(_TicketAirPrice_QNAME, TicketAirPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultReservResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "consultReservResponse")
    public JAXBElement<ConsultReservResponse> createConsultReservResponse(ConsultReservResponse value) {
        return new JAXBElement<ConsultReservResponse>(_ConsultReservResponse_QNAME, ConsultReservResponse.class, null, value);
    }

}
