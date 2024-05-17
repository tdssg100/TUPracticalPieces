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
 * Proxy server. copied and modified. /agent8181?method=op
 * Invoke tutodayshotspot.appspot.com/method
 * implement a simple cache by 20 minutes.
 * @return 
 *  x op=location: retrun json array of news and locations.
 *  op=retrivenewscount: return news count table
 *  x op=blacklist&name=locName return whether succeed or not -- "OK" or "NG"
 */
public class NewsCountExcludeTransitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3034569183L;
	private static  Logger log = Logger
			.getLogger(NewsCountExcludeTransitServlet.class.getName());

	private static class SimpleCache {
		//@SuppressWarnings("unused")
		//private final static int s = 0;
		private String timeStampRounded = ""; 
		private String lastRespond = ""; 
		private void setTime(String time) {
			timeStampRounded = time;
		}
		private void setContent(String content) {
			lastRespond = content;
		}
		private String getContent() {
			return lastRespond;
		}
	}

	private static HashMap<String,SimpleCache> scache = new HashMap<String, SimpleCache>();
	//private SimpleCache cache = new SimpleCache();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// Getting the "error" URL parameter
//		url= "/agent8181?method=retrievenewscountrysum";
//	  	x url = "/proxy8181?method=location";
//	  	x url = "/proxy8181?method=blacklist&name=";
//	  	url += URL.encode(getLocNameInJava());

		String method = req.getParameter("method");
		if (!method.equals("location") 
				&& !method.equals("blacklist")
				&& !method.equals("retrievenewscountrysum")) {
			log.severe("tupp agent8181 method error. method:" + method);
			resp.setStatus(404);
			resp.getWriter().println("method not found");
			return;
		}
		/*
		cacheStamp.setSeconds(0);
		int n = cacheStamp.getMinutes() / 20;
		cacheStamp.setMinutes(n * 20);
		 */
		//java.util.Date cacheStamp = new java.util.Date();
		Calendar cacheStamp = Calendar.getInstance();
		int tmp = cacheStamp.get(Calendar.MINUTE) /  5;
		cacheStamp.set(cacheStamp.get(Calendar.YEAR), 
				cacheStamp.get(Calendar.MONTH),
				cacheStamp.get(Calendar.DAY_OF_MONTH),
				cacheStamp.get(Calendar.HOUR_OF_DAY),
				tmp * 5);
		String cacheStampStr = java.net.URLEncoder.encode(cacheStamp.toString(),"UTF-8");
		SimpleCache sctmp = scache.get(method);
		if (sctmp == null) {
			/* nothing */
		} else if (sctmp.timeStampRounded.equals(cacheStampStr) && (!method.equals("blacklist"))) {
			resp.setContentType("text/plain");
			resp.getWriter().print(sctmp.lastRespond);
			return;
		} else { // changed
			/* nothing */
		}
		String url = "";
		String respStr = "";
		HttpURLConnection uc = null;
		BufferedReader reader = null;		
		try {
			String paraStr = method;
			if (method.equals("blacklist")) {
				paraStr += "?name=" + java.net.URLEncoder.encode(req.getParameter("name"),"UTF-8");
		    }
			//url= "https://tutodayshotspot201802.appspot.com/" + paraStr;
			//log.info("http://localhost:8888/agent8181?method=retrievenewscountrysum???" + req.getRequestURL().toString());
			if (("http://localhost:8888/agent8181").equals(req.getRequestURL().toString())) {
				url= "http://localhost:8181/" + paraStr;
			} else {
				url= "https://tutodayshotspot201802.appspot.com/" + paraStr;
			}
			
//			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//				url= "http://tutodayshotspot.appspot.com/" + paraStr;
//			} else {
//				url= "http://localhost:8181/" + paraStr;
//			}
			URL u = new URL(url);
			respStr = "";
			uc = (HttpURLConnection) u.openConnection();
			uc.setRequestMethod("GET");
			uc.setRequestProperty("Content-Type", "text/plain");
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
			sctmp = new SimpleCache();
			sctmp.setTime(cacheStampStr);
			sctmp.setContent(respStr);
			scache.put(method,sctmp);
			log.info("tupp svr agent8181 on method:" + method + "-" + "succeed." + sctmp.getContent().length());
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().println("tupp svr agent8181: exception occurs.");
			log.severe("tupp svr agent8181 on method:" + method + "-" + e.toString());
		}
	}
}
