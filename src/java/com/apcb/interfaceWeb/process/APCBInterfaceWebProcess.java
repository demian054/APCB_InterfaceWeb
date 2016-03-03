/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.interfaceWeb.process;

import com.apcb.business.services.APCBBusinessServices;
import com.apcb.utils.conection.ServiceGenerator;
import com.apcb.utils.entities.Message;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.ticketsHandler.enums.MessagesTypeEnum;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class APCBInterfaceWebProcess {
    private Logger log = LogManager.getLogger(APCBInterfaceWebProcess.class);
    private Gson gson = new Gson(); 

    public Response webTicketAirAvailAndPrice(Request request) throws IOException, Exception {
        log.info("APCBInterfaceWebProcess -> webTicketAirAvailAndPrice ini");
        Response response = new Response();
        APCBBusinessServices businessServices = ServiceGenerator.ServiceGenerator(APCBBusinessServices.class);
        if (businessServices==null){
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccess_Business));
            return response;
        }
        response = gson.fromJson(businessServices.ticketAirAvailAndPrice(gson.toJson(request)),Response.class);
        log.info("APCBInterfaceWebProcess -> webTicketAirAvailAndPrice end");
        return response;
    }
    
    public Response webTicketReservAndPay(Request request) throws IOException, Exception {
        log.info("APCBInterfaceWebProcess -> webTicketReservAndPay ini");
        Response response = new Response();
        APCBBusinessServices businessServices = ServiceGenerator.ServiceGenerator(APCBBusinessServices.class);
        if (businessServices==null){
            response.setMessage(new Message(MessagesTypeEnum.ErrorAccess_Business));
            return response;
        }
        response = gson.fromJson(businessServices.ticketReservAndPay(gson.toJson(request)),Response.class);
        log.info("APCBInterfaceWebProcess -> webTicketReservAndPay end");
        return response;
    }
    
}
