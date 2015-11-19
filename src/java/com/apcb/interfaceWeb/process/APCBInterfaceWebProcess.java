/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.interfaceWeb.process;

import com.apcb.business.services.APCBBusinessServices;
import com.apcb.utils.conection.ServiceGenerator;
import com.apcb.utils.entities.Request;
import com.apcb.utils.entities.Response;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class APCBInterfaceWebProcess {
    private static final Logger log = LogManager.getLogger(APCBInterfaceWebProcess.class);
    private final Gson gson = new Gson(); 

    public Response webTicketAirAvailAndPrice(Request request) throws IOException, Exception {
 
        APCBBusinessServices businessServices = ServiceGenerator.ServiceGenerator(APCBBusinessServices.class);
        Response response = gson.fromJson(businessServices.ticketAirAvailAndPrice(gson.toJson(request)),Response.class);

        return response;
    }
    
}
