/**
 * 
 */
package com.google.gwt.personal.tupracticalpieces.server;

//import com.google.appengine.api.utils.SystemProperty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Proxy server. /proxy8181?method=op
 * Invoke tutodayshotspot.appspot.com/method
 * implement a simple cache by 20 minutes.
 * @return 
 *  op=location: retrun json array of news and locations.
 *  op=retrivenewscount: return news count table
 *  op=blacklist&name=locName return whether succeed or not -- "OK" or "NG"
 */
public class SurveillanceCameraProxyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3034569182L;
	private static  Logger log = Logger
			.getLogger(SurveillanceCameraProxyServlet.class.getName());

	//private static HashMap<String,SimpleCache> scache = new HashMap<String, SimpleCache>();
	//private SimpleCache cache = new SimpleCache();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String url = "";
		String respStr = "";
		HttpURLConnection uc = null;
		BufferedReader reader = null;		
		try {
//			String paraStr = method;
//			if (method.equals("blacklist")) {
//				paraStr += "?name=" + java.net.URLEncoder.encode(req.getParameter("name"),"UTF-8");
//		    }
			url= "http://192.168.3.3:8084/";
//			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//				url= "http://tutodayshotspot.appspot.com/" + paraStr;
//			} else {
//				url= "http://localhost:8181/" + paraStr;
//			}
			URL u = new URL(url);
			respStr = "";
			uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("Content-Type", "text/html");
			uc.setRequestProperty("Accept-Charset", "UTF-8");
			uc.setConnectTimeout(20000);
			uc.setReadTimeout(20000);					
			uc.setDoOutput(true);
			reader = new BufferedReader(new InputStreamReader(
					uc.getInputStream(), "UTF-8"));
			for (String line; (line = reader.readLine()) != null;) {
				respStr += line;
			}
			try {
				reader.close();
				uc.disconnect();
			} catch (Exception e) {
				/* do nothing */
			}
			resp.setContentType("text/plain");
			resp.getWriter().print(respStr);
			log.info("tupp proxy surveillancecamera succeed." + respStr.length());
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().println("tupp svr porxy8181: exception occurs.");
			log.severe("upp proxy surveillancecamera fail.:" + e.toString());
		}
	}
}
