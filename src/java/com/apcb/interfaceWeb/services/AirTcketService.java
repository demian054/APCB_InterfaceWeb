/*
   ServiceResource.java
   Sample RESTful Java Web Service 

   ------------------------------------------

   Copyright © 2015 [Vic Hargrave - http://vichargrave.com]
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   
       http://www.apache.org/licenses/LICENSE-2.0
   
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.apcb.interfaceWeb.services;
 
import com.apcb.interfaceWeb.process.APCBInterfaceWebProcess;
import com.apcb.utils.entities.Message;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.enums.LocationEnum;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
import com.apcb.utils.ticketsHandler.enums.PassangerTypeEnum;
import com.apcb.utils.ticketsHandler.entities.APCB_Itinerary;
import com.apcb.utils.ticketsHandler.entities.APCB_Passenger;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.apcb.utils.ticketsHandler.enums.UniqueIDTypeEnum;
import com.google.gson.Gson;
import java.util.Calendar;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
 
@Path("airTcket")
public class AirTcketService {
    private Logger log = LogManager.getLogger(AirTcketService.class);
    private Gson gson = new Gson();
 /*
    @Context
    private UriInfo context;*/
 
    public AirTcketService() {
        /*GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Beam.class, new Beam.BeamSerializer());
        gson = gsonBuilder.create();*/
    }
 
    @GET
    @Produces("text/html")
    //@Path("/getAirTicket")
    public String getAirTicket(//@PathParam("request") String strRequest
        @DefaultValue("0") @QueryParam("sesionId") String sesionId,
        @DefaultValue("true") @QueryParam("withReturn") boolean withReturn,
        @DefaultValue("") @QueryParam("departure_airport") String departure_airport,
        @DefaultValue("") @QueryParam("arrival_airport") String arrival_airport,
        @DefaultValue("") @QueryParam("departure_date") String departure_date,
        @DefaultValue("0") @QueryParam("passengers_ADT") Integer passengers_ADT,
        @DefaultValue("0") @QueryParam("passengers_CNN") Integer passengers_CNN,
        @DefaultValue("0") @QueryParam("passengers_INF") Integer passengers_INF,
        @DefaultValue("ECO") @QueryParam("CabinType") String CabinType,
        @DefaultValue("12") @QueryParam("transactionId") Integer transactionId){
        log.info("AirTcketService -> getAirTicket ini");
        
        Response response;
        Request request = new Request();
        try { 
            APCB_Travel travel = new APCB_Travel();
            
            travel.setTransactionId(transactionId);

            travel.setCabin(CabinTypeEnum.getByCode(CabinType));
            travel.setDirectFlightsOnly(true);
            
            APCB_Itinerary itinerary = new APCB_Itinerary();
            Calendar calendar = Calendar.getInstance();
            try{
                String[] fecha = departure_date.split("-");
                calendar.set(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[0]),0,0,0);
            }catch(Exception e){
                e.printStackTrace();
                response = new Response(request.getSesionId());
                response.setMessage(new Message(MessagesTypeEnum.ErrorValidate_DateFormatIncorrect));
                return gson.toJson(response).replace("\\", "");
            }
            itinerary.setDepartureDateTime(calendar);
            itinerary.setOriginLocationCode(LocationEnum.getByCode(departure_airport));
            
            itinerary.setDestinationLocationCode(LocationEnum.getByCode(arrival_airport));
            travel.putItinerary(itinerary);
            
            APCB_Passenger passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Adulto);
            passanger.setPassangerQuantity(passengers_ADT);
            travel.putPassangers(passanger);
            
            passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Niño);
            passanger.setPassangerQuantity(passengers_CNN);
            travel.putPassangers(passanger);
            
            passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Infante);
            passanger.setPassangerQuantity(passengers_INF);
            travel.putPassangers(passanger);
            
            
            request.setSesionId(sesionId);
            log.info(gson.toJson(request.getSesionId()));
            request.setMessage(new Message(MessagesTypeEnum.Ok));
            log.info(gson.toJson(request.getMessage()));
            //request.setBeam(gson.toJson(itinerary), Itinerary.class);
            request.setTravelInfo(travel);
            
            log.info(gson.toJson(request));
            
            //request = new Request(strRequest); 
            //log.info(gson.toJson(request.getBeam()));
            log.info("requestTotal getAirTicket->"+gson.toJson(request));
            APCBInterfaceWebProcess process = new APCBInterfaceWebProcess();
            response = process.webTicketAirAvailAndPrice(request);
            log.info("responseTotal getAirTicket->"+gson.toJson(request));
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        log.info("AirTcketService -> getAirTicket end");
        return gson.toJson(response).replace("\\", "");
    }
 
    @GET
    //@Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    @Path("/getTicketReservAndPay")
    public String getTicketReservAndPay(@QueryParam("strRequest") String strRequest) {
        Request request = new Request();
        Response response;
        try {
            request = new Request(strRequest);
            /*APCB_Travel travel = new APCB_Travel();
             Calendar calendar = Calendar.getInstance();

            travel.setCabin(CabinTypeEnum.Economy);
            travel.setDirectFlightsOnly(true);
            
            travel.setTransactionId(1000);
            
            APCB_Itinerary itinerary = new APCB_Itinerary();
            
            APCB_ItineraryOption itineraryOptionIDA = new APCB_ItineraryOption();
            itineraryOptionIDA.setCabin(CabinTypeEnum.Economy);
            
            itineraryOptionIDA.setFlightNumber("301");
            
            calendar.set(5, 05, 2016 ,9,40,0);
            itineraryOptionIDA.setDepartureDateTime(calendar);
            
            calendar.set(5, 05, 2016 ,10,40,0);
            itineraryOptionIDA.setArrivalDateTime(calendar);
            
            itineraryOptionIDA.setDepartureLocationCode(LocationEnum.CCS);
            itineraryOptionIDA.setArrivalLocationCode(LocationEnum.PMV);
            
            itinerary.putItineraryOption(itineraryOptionIDA);
            
            APCB_ItineraryOption itineraryOptionREG = new APCB_ItineraryOption();
            itineraryOptionREG.setCabin(CabinTypeEnum.Economy);
            itineraryOptionREG.setFlightNumber("303");
            
            calendar.set(5, 05, 2016 ,9,40,0);
            itineraryOptionREG.setDepartureDateTime(calendar);
            
            calendar.set(5, 05, 2016 ,10,40,0);
            itineraryOptionREG.setArrivalDateTime(calendar);
            
            itineraryOptionREG.setDepartureLocationCode(LocationEnum.CCS);
            itineraryOptionREG.setArrivalLocationCode(LocationEnum.PMV);
            
            itinerary.putItineraryOption(itineraryOptionREG);
            
            travel.putItinerary(itinerary);
            

            APCB_Passenger passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Adulto);
            passanger.setPassangerQuantity(2);
            
            APCB_PassengerDetail passengerDetailADT1 = new APCB_PassengerDetail();
            passengerDetailADT1.setName("PEPEa");
            passengerDetailADT1.setSurname("TRUEnoa");
            passengerDetailADT1.setDocumentType(DocumentTypeEnum.Cedula);
            passengerDetailADT1.setDocumentID("123123123");
            passengerDetailADT1.setEmail("Ergue@bito.com");
            
            passanger.putPassengersDetail(passengerDetailADT1);
            
            APCB_PassengerDetail passengerDetailADT2 = new APCB_PassengerDetail();
            passengerDetailADT2.setName("PEPEb");
            passengerDetailADT2.setSurname("TRUEnob");
            passengerDetailADT2.setDocumentType(DocumentTypeEnum.Pasaporte);
            passengerDetailADT2.setDocumentID("SAA123124");
            passengerDetailADT2.setEmail("Ergue@bito2.com");
            
            passanger.putPassengersDetail(passengerDetailADT2);

            travel.putPassangers(passanger);
            
            passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Infante);
            passanger.setPassangerQuantity(2);
            
            APCB_PassengerDetail passengerDetailINF1 = new APCB_PassengerDetail();
            passengerDetailINF1.setName("PEPEaa");
            passengerDetailINF1.setSurname("TRUEnoa");
            passengerDetailINF1.setDocumentType(DocumentTypeEnum.Cedula);
            passengerDetailINF1.setDocumentID("123123123");
            passengerDetailINF1.setEmail("Ergue@bito.com");
            
            passanger.putPassengersDetail(passengerDetailINF1);
            
            APCB_PassengerDetail passengerDetailINF2 = new APCB_PassengerDetail();
            passengerDetailINF2.setName("PEPEba");
            passengerDetailINF2.setSurname("TRUEnob");
            passengerDetailINF2.setDocumentType(DocumentTypeEnum.Cedula);
            passengerDetailINF2.setDocumentID("SAA123124");
            passengerDetailINF2.setEmail("Ergue@bito2.com");
            
            passanger.putPassengersDetail(passengerDetailINF2);

            travel.putPassangers(passanger);
            
            passanger = new APCB_Passenger();
            passanger.setPassangerType(PassangerTypeEnum.Niño);
            passanger.setPassangerQuantity(1);
            
            APCB_PassengerDetail passengerDetailNIN1 = new APCB_PassengerDetail();
            passengerDetailNIN1.setName("PEPEnin");
            passengerDetailNIN1.setSurname("TRUEnoa");
            passengerDetailNIN1.setDocumentType(DocumentTypeEnum.Cedula);
            passengerDetailNIN1.setDocumentID("123123123");
            passengerDetailNIN1.setEmail("Ergue@bito.com");
            
            passanger.putPassengersDetail(passengerDetailNIN1);
            
            travel.putPassangers(passanger);
     
            request.setSesionId("123");
            log.info(gson.toJson(request.getSesionId()));
            request.setMessage(new Message(MessagesTypeEnum.Ok));
            log.info(gson.toJson(request.getMessage()));
            //request.setBeam(gson.toJson(itinerary), Itinerary.class);
            request.setTravelInfo(travel);
            
            APCB_PayMain payMainInfo = new APCB_PayMain();
            payMainInfo.setAmount(new Double("10.00"));
            payMainInfo.setDescription("Prueba");
            payMainInfo.setCardHolder("Demian Bolivar");
            payMainInfo.setCardHolderID("17498122");
            payMainInfo.setCardNumber(new Long("4111111111111111"));
            payMainInfo.setCVC(new Integer("123"));

            payMainInfo.setExpirationDate("10-20");

            
            payMainInfo.setIP("192.168.1.108");

            payMainInfo.setOrderNumber(2);
            
            // ---------------------------
            
                        
            payMainInfo.setPaymentType(PaymentTypeEnum.TarjetaCredito);
            payMainInfo.setTaxesAmount(new Double("0"));

            request.setPayMainInfo(payMainInfo);*/
            log.info("requestTotal ticketReservAndPay->"+gson.toJson(request));
             
            APCBInterfaceWebProcess process = new APCBInterfaceWebProcess();
            
            response = process.webTicketReservAndPay(request);
            log.info("responseTotal ticketReservAndPay->"+gson.toJson(request));
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        /*log.info("AirTcketService -> getAirTicket end");
        return gson.toJson(response).replace("\\", "");  
        */
        
        log.info("postHandler");
        return gson.toJson(response);
    }
    
    @GET
    @Produces("text/plain")
    @Path("/getConsultReservOrTicket")
    public String getConsultReservOrTicket(@QueryParam("type") String strType, @QueryParam("code") String strCode) {
        Request request = new Request();
        Response response;
        try {

            APCB_Travel travel = new APCB_Travel();
            if (strType.equalsIgnoreCase(UniqueIDTypeEnum.TicketNumber.getDescription())){
                travel.setTicket(strCode);
            } else if (strType.equalsIgnoreCase(UniqueIDTypeEnum.BookingReferenceID.getDescription())){
                travel.setBookingReferenceID(strCode);
            } else {
               log.error("Error en tipo de consulta");
            }
            //Request request = new Request(strRequest);
            log.info("requestTotal ConsultReservOrTicket->"+gson.toJson(request));
            APCBInterfaceWebProcess process = new APCBInterfaceWebProcess();
            response = process.webConsultReservOrTicket(request);
            log.info("responseTotal ConsultReservOrTicket->"+gson.toJson(request));
        } catch (Exception e) {
            response = new Response(request.getSesionId());
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        log.info("postHandler");
        return gson.toJson(response);
    }
}