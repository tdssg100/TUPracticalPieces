/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.personal.tupracticalpieces.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import org.apache.amber.oauth2.common.utils 
//import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.google.appengine.labs.repackaged.org.json.JSONObject;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.google.appengine.labs.repackaged.org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;

//import com.google.gwt.json.client.JSONObject;
//import com.google.gwt.thirdparty.json.JSONException;
//import java.util.Map;
//import java.util.Set;

/**
 * Servlet handling the OAuth callback from the authentication service. We are
 * retrieving the OAuth code, then exchanging it for a refresh and an access
 * token and saving it.
 */
@SuppressWarnings("serial")
public class OAuthCodeCallbackHandlerServlet extends HttpServlet {

	private static final Logger log = Logger
			.getLogger(OAuthCodeCallbackHandlerServlet.class.getName());

	/** The name of the OAuth code URL parameter  */
	public static final String CODE_URL_PARAM_NAME = "code";

	/** The name of the OAuth error URL parameter */
	public static final String ERROR_URL_PARAM_NAME = "error";

	/** The URL suffix of the servlet */
	public static final String URL_MAPPING = "/oauth2callback";

	/**
	 * The URL to redirect the user to after handling the callback. Consider
	 * saving this in a cookie before redirecting users to the Google
	 * authorization URL if you have multiple possible URL to redirect people
	 * to.
	 */
	public static final String REDIRECT_URL = "/";

	private static OAuthTokenDao oauthTokenDao = new OAuthTokenDaoMemoryImpl();

	/**
	 * The OAuth Token DAO implementation. Consider injecting it instead of
	 * using a static initialization. Also we are using a simple memory
	 * implementation as a mock. Change the implementation to using your
	 * database system.
	 */
	/*
	 * public static OAuthTokenDao oauthTokenDao = new
	 * OAuthTokenDaoMemoryImpl();
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// Getting the "error" URL parameter
		//@@@@@@@@@  set singleton's state to loginfail.
		resp.setContentType("text/plain");
		/* 20141205 NG X-ref
		resp.setHeader("X-Frame-Options", "GOFORIT");
		*/
		log.info("oauth handler entered1.req\n" + req.getRequestURL());
		/*
	Map map_par=req.getParameterMap(); 
	Set map_ite1 = map_par.keySet( ); 
	Iterator i = map_ite1.iterator( ); 
	while (i.hasNext()) { 
	  String key = (String)i.next(); 
	  String val[]=(String[])map_par.get(key);
	  for (int j = 0; j < val.length; j++) {
        log.info("oauth handler entered2.key\n" + key + ":" + val[j]);
      }
	}
		 */ 
		log.info("oauth handler entered3.req\n" + req.toString());

		String[] error = req.getParameterValues(ERROR_URL_PARAM_NAME);

		// Checking if there was an error such as the user denied access
		if (error != null && error.length > 0) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "There was an error: \""+error[0]+"\".");
			return;
		}
		/*
    if (map_par.containsKey("code")) { 
        // Phase 1.
		 */
		// Getting the "code" URL parameter
		String[] code = req.getParameterValues(CODE_URL_PARAM_NAME);

		// Checking conditions on the "code" URL parameter
		if (code == null || code.length == 0) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "The \"code\" URL parameter is missing");
			return;
		}
		/*
	    // Construct incoming request URL
	    String requestUrl = getOAuthCodeCallbackHandlerUrl(req);

    // Exchange the code for OAuth tokens
    AccessTokenResponse accessTokenResponse = exchangeCodeForAccessAndRefreshTokens(code[0],
        requestUrl);
    String queryString = accessTokenResponse.toString();
		 */
		/*
	  String url = "http://localhost:8888/oauth2aftergrant";
		 */
		String url = "https://accounts.google.com/o/oauth2/token";
		String respStr = "";
		JSONObject jsonToken = null;
		URL u = new URL(url);
		HttpURLConnection uc = null;
//		BufferedReader reader = null;
		try {
			uc = (HttpURLConnection) u.openConnection();
	    	uc.setRequestMethod("POST");
			uc.setRequestProperty("Accept-Charset", "UTF-8");
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			uc.setDoOutput(true);
			try (OutputStream os = uc.getOutputStream() ) {
					
			
				PrintStream ps = new PrintStream(os);
				String postStr;
				//if (("http://tupracticalpieces.appspot.com/oauth2callback").equals(req.getRequestURL().toString())) {
					//			+ "&client_id=" + URLEncoder.encode("9571369657.apps.googleusercontent.com", "UTF-8") 
					//			+ "&client_secret=" + URLEncoder.encode("8ZNyNXhWQlcqBSkK49StjrEr", "UTF-8")
				if (("https://127.0.0.1:8443/oauth2callback").equals(req.getRequestURL().toString())
	 			 || ("https://localhost:8443/oauth2callback").equals(req.getRequestURL().toString())) {
					/* removed from Google API console
		      postStr = "code="+ code[0]
		         + "&client_id=" + URLEncoder.encode("142776700795.apps.googleusercontent.com", "UTF-8") 
		         + "&client_secret=" + URLEncoder.encode("Qg2cMtCQUjKV4Sjf_Y0rOZKZ", "UTF-8")
		         + "&redirect_uri=" + URLEncoder.encode(req.getRequestURL().toString(),  "UTF-8")
		         + "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8");
					 *
					 * add a new Oauth2 ID 20121215
					 * 
					postStr = "code="+ code[0]
							+ "&client_id=" + URLEncoder.encode("9571369657.apps.googleusercontent.com", "UTF-8") 
							+ "&client_secret=" + URLEncoder.encode("8ZNyNXhWQlcqBSkK49StjrEr", "UTF-8")
							+ "&redirect_uri=" + URLEncoder.encode(req.getRequestURL().toString(),  "UTF-8")
							+ "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8");
					 *
					 * add at 20240612
					 */
					postStr = "code="+ code[0]
							+ "&client_id=" + URLEncoder.encode("665228524445-n826p8nec0b91tk5mlg6iuu7ss9g3kl6.apps.googleusercontent.com", "UTF-8") 
							+ "&client_secret=" + URLEncoder.encode("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", "UTF-8")
							+ "&redirect_uri=" + URLEncoder.encode(req.getRequestURL().toString(),  "UTF-8")
							+ "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8");
	//			} else if (("tupracticalpices.appspot.com:8888/oauth2callback").equals(req.getRequestURL().toString())) {
				} else if (("http://127.0.0.1:8888/oauth2callback").equals(req.getRequestURL().toString())
				 			 || ("http://localhost:8888/oauth2callback").equals(req.getRequestURL().toString())) {
					postStr = "code="+ code[0]
							+ "&client_id=" + URLEncoder.encode("9571369657-3mqoa0q64gfer18q52gmhmul9gg5anus.apps.googleusercontent.com", "UTF-8") 
							+ "&client_secret=" + URLEncoder.encode("4cdJ0m8aeu_CVy2Kq4wKZo_4", "UTF-8")
							+ "&redirect_uri=" + URLEncoder.encode(req.getRequestURL().toString(),  "UTF-8")
							+ "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8");
				} else {
					postStr = "code="+ code[0]
							+ "&client_id=" + URLEncoder.encode("9571369657-0omq28sbvq94as3bl127ia3de85lf2l9.apps.googleusercontent.com", "UTF-8") 
							+ "&client_secret=" + URLEncoder.encode("V4Xp9cIxUvJHi1Pec1UpwLso", "UTF-8")
							+ "&redirect_uri=" + URLEncoder.encode(req.getRequestURL().toString(),  "UTF-8")
							+ "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8");
				}
				ps.print(postStr);
				ps.close();
				int responseCode = uc.getResponseCode();
				if (responseCode < 200) {
					log.info("oauth handler entered4. fail to comm " + responseCode);
					return; 
				} else if (responseCode < 300) {
	
				} else  {
	//				reader = new BufferedReader(new InputStreamReader(uc.getErrorStream(), "UTF-8"));
	//				for (String line; (line = reader.readLine()) != null;) {
	//					respStr += line;
	//				}
					try (
							BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getErrorStream(), "UTF-8"));
						) {
						for (String line; (line = reader.readLine()) != null;) {
							respStr += line;
						}
					}
					log.info("grant respCode :" + responseCode + postStr);
					log.info("grant resp(10chars) :" + respStr.substring(10));
					resp.getWriter().append("Authentication comm failed." + "\n\n");
					return; 
				}
				try (
					BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
				) {
					for (String line; (line = reader.readLine()) != null;) {
						respStr += line;
					}
				}
				log.info("grant resp :" + respStr);
				jsonToken = new JSONObject(respStr);
				uc.disconnect();
			}
		} catch (Exception e) {
			log.warning("grant-auth failed.");
			e.printStackTrace();
			resp.getWriter().append("Authentication failed." + "\n\n");
			return;
//		} finally {
//			if (reader != null) { 
//				try {
//					reader.close(); 
//				} catch (Exception e) {
//				}
//			}
		}

		if (jsonToken.has("error")) {
			try {
				resp.getWriter().append("<h2> Fail to get the access token. error:" + jsonToken.get("error") + "\n\n");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return;
		}
		// Phase 2.
		// Save the tokens
		String queryString = "";
		@SuppressWarnings("rawtypes")
		Iterator iToken = jsonToken.keys( ); 
		while (iToken.hasNext()) { 
			String key = (String)iToken.next(); 
			Object val = null;
			try {
				val = jsonToken.get(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			//log.info("oauth handler entered2.key :" + key + ":" + val.toString());
			queryString += key + "=" + val.toString();
			if (iToken.hasNext()) {
				queryString += "&";
			}
		} 
		/*
    oauthTokenDao.saveKeys("Authoauth", queryString);
		 */
		//log.info("getting token(5chars) :" + queryString.substring(5));
		/*
		 * resp.sendRedirect(REDIRECT_URL);
		 */
		//resp.setContentType("text/plain");
		//resp.getWriter().append("<h2> Succeed in obtaining the token...</h2>" + "\n\n");
		String message = "<h2> Succeed in obtaining the token...</h2>" + "\n\n";
		//log.info("Check user. jobname:" + oauthTokenDao.getJob());
		if ("ConsentLogin".equals(oauthTokenDao.getJob().substring(0,12))) {
		    /*
		     *  check whether the user is the owner.
		     */
		    try {
					url = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + jsonToken.get("access_token");
		    } catch (JSONException e2) {
					e2.printStackTrace();
					message += "check user: url invalid" + e2.toString();
					return;
		    }
		    u = new URL(url);
		    boolean retVal = false;
		    respStr = "";      
		    try {
		          uc = (HttpURLConnection) u.openConnection();
		          uc.setRequestMethod("GET");
		  	      uc.setRequestProperty("Content-Type", "application/json");
		  	      uc.setRequestProperty("Accept-Charset", "UTF-8");
		  	      uc.setDoOutput(true);
		         /*
		          uc.setRequestProperty("Content-Type", "multipart/form-data");
		          */
//		          reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
		  	      try ( BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));){
			          for (String line; (line = reader.readLine()) != null;) {
			            	  respStr += line;
			          }
		  	      }
		          if (respStr.equals("")) {
		            log.warning("isOwner resp: empty. Not retreive profile.");
		          } else {
		            //log.info("isOwner resp:" + respStr);
		          }
		          jsonToken = new JSONObject(respStr);
		          if (jsonToken.has("error")) {
		              //resp.getWriter().append("<h2> Fail to get the user's profile. error:" + jsonToken.get("error") + "\n\n");        	  
		              message += "<h2> Fail to get the user's profile. error:" + jsonToken.get("error") + "\n\n";        	  
		          }
		          String emailAdd = jsonToken.get("email").toString();
		          //log.info("f5951e64ba003a03ddb91bf579f6c513a0b6060e91c5bb56b8ead3254ebc5745 ubuntu");
//		          log.info("f6e96b66e2996b24b1bea05ff1b62386db31005c89a6d274f3657dcec0c134e5 coding" );
//		          log.info(DigestUtils.sha256Hex(emailAdd) + " digestUtils");
		          if (DigestUtils.sha256Hex(emailAdd)
		          		.equals("f6e96b66e2996b24b1bea05ff1b62386db31005c89a6d274f3657dcec0c134e5")) {
		             	  retVal = true;
		          } else {
		        	  log.info("email miss-match:" + jsonToken.get("email"));
		        	  //@@@@@
		              //resp.getWriter().append("<h2> Operation forbidden because the owner only can manage." + "\n\n");
		              message += "<h2> Operation forbidden because the owner only can manage." + "\n\n";
		          }
		    } catch (Exception e) {
		            //resp.getWriter().append();        	  
		    		message += "<h2> Fail to get the user's profile. exception:" + e.toString() + "\n\n";
		            return;
//		    } finally {
//		                if (reader != null) { 
//		                  try {
//		                    reader.close(); 
//		                  } catch (Exception e) {
//		                      //resp.getWriter().append("<h2> Fail to get the user's profile. exception(fin):" + e.toString() + "\n\n");        	  
//		                	  message += "<h2> Fail to get the user's profile. exception(fin):" + e.toString() + "\n\n";        	  
//		              	    return;
//		                  }
//		                }
		    }
		    if (retVal) {
		       //resp.getWriter().append("<h2> User admitted..." + "\n\n");
	    		message += "<h2> Google account admitted..." + "\n\n";
	    		oauthTokenDao.setSingletonState2OK(message);
		    } else {
		       //resp.getWriter().append("<h2> Operation forbidden because the owner only can manage." + "\n\n");
	    		message += "<h2> Operation forbidden because the owner only can manage." + "\n\n";
	    		oauthTokenDao.setSingletonState2NG(message);
		    }
    		log.info(message);
    		//resp.sendRedirect("/#!" + oauthTokenDao.getLocus());
    		resp.sendRedirect(oauthTokenDao.getLocus());
			return;
		}

		
		/*
		if (("CheckConsent").equals(oauthTokenDao.getJob())) {
			log.info("Check the consent. jobname:" + oauthTokenDao.getJob());
			resp.getWriter().append("<h2> Ready to submit." + "\n\n");
			return;
		}
		*/
		/*  administrative job
		 *  delete JDO entries.
		if (("DeleteJdo").equals(oauthTokenDao.getJob())) {
			log.info("delete JOD entries. jobname:" + oauthTokenDao.getJob());
		 */
			/* do nothing 20140504
			try {
				log.info("stored before num=" + MileageDataUtils.totalCount());
				MileageDataUtils.deleteAll();
				resp.getWriter().append("<ol style='list-style-type: disc'><li>" + "[LOAD DATA]" + "delete job completed." + "</li></ol>");
				log.info("stored after num=" + MileageDataUtils.totalCount());
			} catch (Exception e) {
				resp.getWriter().append("<ol style='list-style-type: disc'><li>" + "[LOAD DATA]" + e.toString() + "</li></ol>");
				return;   
			}
			//resp.getWriter().append("<h2> Delete Job completed." + "\n\n");
    		oauthTokenDao.setSingletonState2OK("<h2> Delete Job completed. No more effective." + "\n\n");	    
		    resp.sendRedirect("/#!CwUpdate");

			return;
		}
			*/
		/*  administrative job
		 *  load the data from Google Cloud SQL.
		 *  20141212 no more Authorative InsertSQL for each instruction. 
		 */
/*		if (("InsertSQL").equals(oauthTokenDao.getJob().substring(0,9))) {
			log.info("insert into Google Cloud SQL. jobname:" + oauthTokenDao.getJob().substring(0,8));
			
			Connection c = null;
			String insertStr = oauthTokenDao.getJob().substring(10);
			try {
				log.info("saveMileageRecordIntoCloud.");
				Properties token = new Properties();
				token.load( (InputStream) new ByteArrayInputStream(queryString.getBytes("UTF-8")));
				DriverManager.registerDriver(new AppEngineDriver());
				c = (com.google.cloud.sql.jdbc.Connection)DriverManager.getConnection(
						"jdbc:google:rdbms://tupracticalpieces2tutrial:tupp/Trifle", token);
				int success = c.createStatement().executeUpdate(
						"INSERT INTO mileage(supplyDate, quantity, unitPrice, totalPrice, bsMileage, totalMileage)"
								+ " values (" + insertStr + ");");
				if (success == 1) {
				} else { // (success == 0) 
					log.warning("error occurred in adding the record.");
					try {
						c.close();
					} catch (Exception e1) {
					}
					resp.getWriter().append("<h2>Error occurred in adding the records.</h2>" + "\n\n");
				} 
			} catch (Exception e) {
				log.warning("error occurred in connecting or inserting." + e.toString());
				try {
					c.close();
				} catch (Exception e1) {
				}
				resp.getWriter().append("<h2>Error occurred in setting para or connecting." + e.toString() + "</h2>" + "\n\n");
				return;
			}
			try {
				log.info("complete insert.");
				c.close();
			} catch (Exception e) {
			}
			resp.getWriter().append("<h2> Completed adding the data into Database.\n\n");
			return;
			 

			 change JPA2 20140504 
			 * 
			 
			try {
				log.info("Before adding the data into Database. count:" + MileageDataUtils.totalCount());
				resp.getWriter().append("<h2> Before adding the data into Database." + MileageDataUtils.totalCount() + "\n\n");
				String paraStr[] = oauthTokenDao.getJob().substring(10).split(",");
				//MileageDataUtils.insertNew(supplyDate, rs.getQuantity(),
				//		rs.getUnitPrice(), rs.getTotalPrice(), rs.getBsMileage(), rs.getTotalMileage());
				String key = MileageDataUtils.insertNew(paraStr[0], Float.parseFloat(paraStr[1]), 
						Integer.parseInt(paraStr[2]), Integer.parseInt(paraStr[3]) , Float.parseFloat(paraStr[4]), Float.parseFloat(paraStr[5]) );
				
				Properties token = new Properties();
				token.load( (InputStream) new ByteArrayInputStream(queryString.getBytes("UTF-8")));
				String insertSqlStr = "INSERT INTO mileage(supplyDate, quantity, unitPrice, totalPrice, bsMileage, totalMileage)"
						+ " values (" + oauthTokenDao.getJob().substring(10) + ");";
				EntityManager em = EMF.get().createEntityManager(token);
				EntityTransaction tx = em.getTransaction();
				try {
					tx.begin();
					Query query = em.createQuery(insertSqlStr);
					if (query.executeUpdate() != 1) {; // jdo:Execute()
					log.info("Cloud SQL data cannot be inserted.");
					resp.getWriter().append("<h2>Cloud SQL data cannot be inserted.</h2>" + "\n\n");
					tx.rollback();
					return;
					}
					tx.commit();
				} catch (Exception e) {
					log.warning("Rolling Back:" + e.toString());
					tx.rollback();
				} finally {
					em.close();
				}
				
			} catch (Exception e) {
				log.warning("On inserting to Cloud SQL, error occurred in setting para or connecting." + e.toString());
				resp.getWriter().append("<h2>On inserting to Cloud SQL, Error occurred in setting para or connecting." + e.toString() + "</h2>" + "\n\n");
				return;
			}
			log.info("Completed adding the data into Database. count:" + MileageDataUtils.totalCount());
			//resp.getWriter().append("<h2> Completed adding the data into Database." + MileageDataUtils.totalCount() + "\n\n");
    		oauthTokenDao.setSingletonState2OK("<h2> Completed adding the data into Database." + MileageDataUtils.totalCount() + "\n\n");  
		    resp.sendRedirect("/#!CwUpdate");
			return;
		}
*/		
		/*  administrative job
		 *  <old> load the data from Google Cloud SQL.
		 *  checking connecting Google Cloud SQL.
		 *  201212 no more issue.
		 */
/*		if (!(("LoadFromCloud").equals(oauthTokenDao.getJob()))) {
			log.warning("not administrative job:" + oauthTokenDao.getJob());
			//resp.getWriter().append("<h2> Nothing operated.</h2>" + "\n\n");
    		oauthTokenDao.setSingletonState2OK("<h2> Nothing operated.</h2>" + "\n\n"); 
		    resp.sendRedirect("/#!CwUpdate");
			return;
		}
*/		
		oauthTokenDao.setSingletonState2OK("<h2> Nothing operated.</h2>" + "\n\n"); 
		log.warning("not administrative job:" + oauthTokenDao.getJob());
		//resp.getWriter().append("<h2> Nothing operated.</h2>" + "\n\n");
		/* 20170419 I missed!!
		resp.sendRedirect("/#!CwUpdate");
		*/
		resp.sendRedirect(oauthTokenDao.getLocus());
	}
}

		/* 20140113 JPA implementation
		 * 20141212 no more issue
		 */
/*		log.info("LoadFromCloud do nothing.");
		//resp.getWriter().append("<h2> Nothing operated.</h2>" + "\n\n");
		oauthTokenDao.setSingletonState2OK("<h2> Nothing operated.</h2>" + "\n\n");
	    resp.sendRedirect("/#!CwUpdate");
		return;
*/		/*
		List<mileage> allProducts = null;
		try {
			log.info("loadMileageDataFromCloud start with OAuth.");
			Properties token = new Properties();
			token.load( (InputStream) new ByteArrayInputStream(queryString.getBytes("UTF-8")));
			EntityManager em = EMF.get().createEntityManager(token);
			try {
				Query query = em.createQuery("SELECT supplyDate, quantity, unitPrice, totalPrice, bsMileage, totalMileage from mileage order by supplyDate desc;");
				allProducts = query.getResultList(); // jdo:Execute()
				if (allProducts.size() == 0) {
					log.info("select result empty.");
					resp.getWriter().append("<h2>No data loaded from cloud.</h2>" + "\n\n");
					return;
				}
			} catch (Exception e) {
				log.severe("On selecting to Cloud SQL, error occurred." + e.toString());
				resp.getWriter().append("<h2>On selecting to Cloud SQL, error occurred." + e.toString() + "</h2>" + "\n\n");
				return;
			} finally {
				em.close();
			}
		} catch (Exception e) {
			log.warning("On selecting to Cloud SQL, error occurred." + e.toString());
			resp.getWriter().append("<h2>On selecting to Cloud SQL, error occurred." + e.toString() + "</h2>" + "\n\n");
			return;
		}
		*/
		/*
		Iterator<mileage>  rs_it= allProducts.iterator();
		mileage rs;
		int insCount = 0;
		while (true) {
			try {
				if (!(rs_it.hasNext())) {
					break;
				}
				rs = rs_it.next();
			} catch (Exception e) {
				log.warning("error occurred in retrieving the records.");
				resp.getWriter().append("<h2>Error occurred in retrieving the records.</h2>" + "\n\n");
				return;
			}
			Date supplyDate = null;
			try {
				try {
					java.util.Date wkDate = df.parse(rs.getSupplyDate());
					supplyDate = new java.sql.Date(wkDate.getTime());
				} catch (Exception e) {
					log.warning("add to JDO exception on Date:" + e.toString());
				}
				if ((MileageDataUtils.isExist(rs.getSupplyDate()))==false) {
					String id = MileageDataUtils.insertNew(supplyDate, rs.getQuantity(),
							rs.getUnitPrice(), rs.getTotalPrice(), rs.getBsMileage(), rs.getTotalMileage());
					insCount++;
					log.info("store to jdo. id=" + id);
				}
			} catch (Exception e) {
				log.warning("add to JDO exception." + e.toString());
			}
		} // while loop end
		log.info("Checking connecting Cloud SQL. maileage count:" + allProducts.size());
		resp.getWriter().append("<h2> Checking connecting Cloud SQL. maileage count:" + allProducts.size() + "<h2>\n\n");
		*/
