/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.interfaceWeb.services;

import com.apcb.interfaceWeb.process.APCBInterfaceWebProcess;
import com.apcb.utils.entities.Message;

import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.conection.ServiceGenerator;
import com.apcb.utils.ticketsHandler.Enums.MessagesTypeEnum;
import com.google.gson.Gson;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
@WebService(serviceName = "APCBInterfaceWebServices")
public class APCBInterfaceWebServices {
    private static final Logger log = LogManager.getLogger(APCBInterfaceWebServices.class);
    private final Gson gson = new Gson(); 
    
    @WebMethod(operationName = "test")
    public String test(@WebParam(name = "strRequest") String strRequest) {
        Response response = new Response();
        try {
            Request request = new Request(strRequest); 
            APCBInterfaceWebProcess process = new APCBInterfaceWebProcess();
            response = process.webTicketAirAvailAndPrice(request);
        } catch (Exception e) {
            response.setMessage(new Message(MessagesTypeEnum.AplicationErrorNotHandler));
            log.error(response.getMessage().getMsgDesc(), e);
        }
        return gson.toJson(response);
    }
    
}
