/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.interfaceWeb.services;

import com.apcb.business.services.APCBBusinessServices;
import com.apcb.utils.entities.Message;

import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.apcb.utils.entities.ServiceGenerator;
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
    private static final Logger logger = LogManager.getLogger(APCBInterfaceWebServices.class);
    private final Gson gson = new Gson(); 
    
    @WebMethod(operationName = "test")
    public String test(@WebParam(name = "strRequest") String strRequest) {
        logger.debug("request:"+strRequest);
        Request request = gson.fromJson(strRequest, Request.class);
        Response response = null;
        try {
            APCBBusinessServices sBusiness = ServiceGenerator.ServiceGenerator(APCBBusinessServices.class);
            request.setMessage(new Message(MessagesTypeEnum.Ok));
            response = gson.fromJson(sBusiness.test(gson.toJson(request)), Response.class);
            
        } catch (Exception e) {
            logger.error("Error.. ", e);
         }
        logger.debug("response:"+gson.toJson(response));
        return gson.toJson(response);
    }
    
}
