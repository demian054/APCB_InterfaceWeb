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
import com.apcb.utils.entities.Beam;
import com.apcb.utils.entities.Message;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.Enums.CabinTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.LocationEnum;
import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;
import com.apcb.utils.ticketsHandler.Enums.PassangerTypeEnum;
import com.apcb.utils.ticketsHandler.entities.Itinerary;
import com.apcb.utils.ticketsHandler.entities.Travel;
import com.apcb.utils.ticketsHandler.entities.Passanger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
 
@Path("airTcket")
public class AirTcketService {
    private static final Logger log = LogManager.getLogger(AirTcketService.class);
    private Gson gson = new Gson();
 
    @Context
    private UriInfo context;
 
    public AirTcketService() {
        /*GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Beam.class, new Beam.BeamSerializer());
        gson = gsonBuilder.create();*/
    }
 
    @GET
    @Produces("text/html")
    @Path("/{request}")
    public String getAirTicket(@PathParam("request") String strRequest) {
         Response response = new Response();
        try {
            
            Request request = new Request(); 
            Travel travel = new Travel();

            travel.setCabin(CabinTypeEnum.Economy);
            travel.setDirectFlightsOnly(true);
            
            Itinerary itinerary = new Itinerary();
            Calendar calendar = Calendar.getInstance();
            calendar.set(2015, 11, 8);
            itinerary.setDepartureDateTime(calendar);
            itinerary.setDestinationLocationCode(LocationEnum.CUM);
            itinerary.setOriginLocationCode(LocationEnum.CCS);
            
            travel.putItinerary(itinerary);
            
            Passanger passanger = new Passanger();
            passanger.setPassangerType(PassangerTypeEnum.ADT);
            passanger.setPassangerQuantity(1);

            travel.putPassangers(passanger);
            request.setSesionId("1");
            log.info(gson.toJson(request.getSesionId()));
            request.setMessage(new Message(MessagesTypeEnum.Ok));
            log.info(gson.toJson(request.getMessage()));
            //request.setBeam(gson.toJson(itinerary), Itinerary.class);
            request.setBeam(new Beam(gson.toJson(travel), Travel.class.getSimpleName()));
            
            log.info(gson.toJson(request));
            
            //request = new Request(strRequest); 
            //log.info(gson.toJson(request.getBeam()));
            
            APCBInterfaceWebProcess process = new APCBInterfaceWebProcess();
            response = process.webTicketAirAvailAndPrice(request);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.Error_AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response).replace("\\", "");
    }
 
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public String postHandler(String content) {
        return content;
    }
}