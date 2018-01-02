package rental_management.publics.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class Push {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Integer id;
	protected String ids;
	protected Page page;

	public void push(Object object) throws Exception {
		
		
		String text = object.toString();
		System.out.println("Ajax返回数据：" + text);

		try {
			response.getWriter().write(text);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
