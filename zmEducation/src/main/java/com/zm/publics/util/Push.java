package com.zm.publics.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class Push {

	protected Integer id;
	protected String ids;
	protected Page page;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void push(Object object,HttpServletRequest req,HttpServletResponse res) throws Exception {
		
		
		String text = object.toString();
		
		try {
   			res.getWriter().write(text);
   			System.out.println("Ajax返回数据�?" + text);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
