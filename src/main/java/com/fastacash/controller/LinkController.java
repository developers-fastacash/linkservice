package com.fastacash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastacash.entity.Link;
import com.fastacash.service.LinkService;

@RequestMapping(value = "/link")
public class LinkController {
	
	/*
	 *   Bad Request
	 *   Status : 400
	 *   body: {error: "Bad Request"}
	 *   
	 *  /link/create - creates a new link - post data is amount and currency, source, dest wallet 
	 *  				    response is json representation of the created link
	 *  /link/accept - changes state from pending to success. post data is link secureHash
	 *  					response is json with error/success message 
	 *                   {error: "Cannot accept the link"} 
	 *                   {state: "ok"}
	 */				
	
	@Autowired
	private LinkService linkService;

	
	@RequestMapping(value = "/create", method = {RequestMethod.POST})
	public Link createLink(HttpServletRequest request) {
		String amount = request.getParameter("amount");
		String currency = request.getParameter("currency");
		String walletSrcId = request.getParameter("wallet_source_id");
		String walletDestId = request.getParameter("wallet_dest_id");
		
//		if (amount == null || currency == null || walletSrcId == null || walletDestId == null) {
//			
//		}
		return linkService.create(Integer.parseInt(amount), currency, new Long(walletSrcId), new Long(walletDestId));	
	}
}
