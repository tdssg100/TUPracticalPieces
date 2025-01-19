package com.google.gwt.personal.tupracticalpieces.server;

import java.lang.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.Iterator;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//import com.google.gwt.personal.tupracticalpieces.database.EMF;
import com.google.gwt.personal.tupracticalpieces.database.User;

/**
 * Servlet handling the OAuth callback from the authentication service. We are
 * retrieving the OAuth code, then exchanging it for a refresh and an access
 * token and saving it.
 */
@SuppressWarnings("serial")
public class MessageDigestServlet extends HttpServlet {

	private static final Logger log = Logger
			.getLogger(MessageDigestServlet.class.getName());

	/** The name of the user name URL parameter  */
	public static final String USER_URL_PARAM_NAME = "name";

	/** The name of the usr digest URL parameter */
	public static final String DIGEST_URL_PARAM_NAME = "digest";

	/** The URL suffix of the servlet */
	public static final String URL_MAPPING = "/messagedigest";

	//public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		/* 20141205 NG X-ref
		resp.setHeader("X-Frame-Options", "GOFORIT");
		*/
		log.info("messagedigest handler entered1.req\n" + req.getRequestURL());
		log.info("oauth handler entered3.req\n" + req.toString());

		String user = req.getParameter(USER_URL_PARAM_NAME);
		String digest = req.getParameter(DIGEST_URL_PARAM_NAME);

		String respStr = "";
		
		if (user == null || user.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Parameter user not exist.");
			return;
		}
		if (digest == null || digest.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Parameter digest not exist.");
			return;
		}


		resp.setContentType("text/html");
		if (digest.equals(getStoredDigest(user))) {
			resp.getWriter().print("{\"match\":true}");
			log.info("MessageDigestServlet retrun {\"match\":true}");
			return;
		}
		resp.getWriter().print("{\"match\":false}");
		log.warning("MessageDigestServlet retrun false");
	}
	
	public static String getStoredDigest(String name) {
		/*
		EntityManager cm= EMF.get().createEntityManager();
		List<User> ud = null;
		try {
			ud = cm.createQuery("select password from User u where name='" + name + "'")
//			.setParameter("user", user)
			.setFirstResult(0)
			.setMaxResults(1)
			.getResultList();
		} catch (Exception e) {
			log.severe("retrieve data error:" + e.toString());
			return "";
		}
		if (ud.size() == 0) {
			return "";
		}
		return ud[0].get("password");
		*/
		
		return new com.google.gwt.personal.tupracticalpieces.database.User().findDigest(name);
	}

}


