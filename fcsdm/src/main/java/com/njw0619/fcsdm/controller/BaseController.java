package com.njw0619.fcsdm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.njw0619.fcsdm.model.FlashMessage;

public class BaseController {	
	
	protected HttpServletRequest getServletRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (sra == null || sra.getRequest() == null) {
            return null;
        }
        return sra.getRequest();
    }
	
	public void addFlashMessage(FlashMessage flash){
        HttpSession session = getServletRequest().getSession();

        List<FlashMessage> flashMessages = (List<FlashMessage>)session.getAttribute("flashMessages");
        if(flashMessages == null)
            flashMessages = new ArrayList<FlashMessage>();

        flashMessages.add(flash);

        session.setAttribute("flashMessages", flashMessages);
    }
}
