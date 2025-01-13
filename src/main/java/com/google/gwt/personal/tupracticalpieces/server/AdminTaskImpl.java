package com.google.gwt.personal.tupracticalpieces.server;

/*
 import com.google.appengine.api.urlfetch.HTTPHeader;
 import com.google.appengine.api.urlfetch.HTTPMethod;
 import com.google.appengine.api.urlfetch.HTTPRequest;
 import com.google.appengine.api.urlfetch.HTTPResponse;
 import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
 */
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminTask;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultFetch;
import com.google.gwt.personal.tupracticalpieces.database.MileageDataUtils;

import java.util.logging.Logger;//TODO when deploy, change loglevel in log.properties
import jakarta.servlet.http.HttpServletRequest;
//import com.google.gwt.user.server.rpc.AbstractRemoteServiceServlet;
import jakarta.servlet.http.HttpSession;
//import java.net.URLEncoder;

/**
 * The implemenation of the RPC service which runs on the server.
 */
@SuppressWarnings("serial")
public class AdminTaskImpl extends RemoteServiceServlet implements AdminTask {
	/*
	 */
	private static final Logger log = Logger.getLogger(AdminTaskImpl.class
			.getName());

	private static OAuthTokenDao oauthTokenDao = new OAuthTokenDaoMemoryImpl();

	private ResultFetch ret = new ResultFetch();


	public ResultFetch fetchMileageData(String postParam) {
		ret.setResult(true);
		ret.setText( MileageDataUtils.selectAll() );
/********************************
		HttpServletRequest req = getThreadLocalRequest();
		String url = req.getRequestURL().substring(0,req.getRequestURL().length() - req.getServletPath().length() + 1) + "mileagedatautils?op=selectAll";
//		String url = "mileagedatautils?op=selectAll";
		url = url.replace("https", "http");
		url = url.replace("8443", "8888");
		String respStr = "";
		HttpURLConnection uc = null;
//		HttpsURLConnection uc = null;
		BufferedReader reader = null;
		try {
			//log.info("tupp rpc svr entered.");
			// fetch Mileage Data From JDO
			// MileageDataUtils tm = new MileageDataUtils();
			// String s = tm.selectAll();
//			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//				url = "http://tupracticalpieces.appspot.com/mileagedatautils?op=selectAll";
//			} else {
//				url = "http://localhost:8888/mileagedatautils?op=selectAll";
//			}
//			url = getRequestModuleBasePath() + "mileagedatautils?op=selectAll";
			try {
				URL u = new URL(url);
				uc = (HttpURLConnection) u.openConnection();
//				uc = (HttpsURLConnection) u.openConnection();
				uc.setRequestMethod("GET");
				uc.setRequestProperty("Content-Type", "text/plain");
				uc.setRequestProperty("Accept-Charset", "UTF-8");
				uc.setConnectTimeout(5000);
				uc.setReadTimeout(5000);
				uc.setDoOutput(true);
				reader = new BufferedReader(new InputStreamReader(
						uc.getInputStream(), "UTF-8"));
				for (String line; (line = reader.readLine()) != null;) {
					respStr += line;
				}
				ret.setText(respStr);
				log.info("RPC server have retreived data str="
						+ respStr.substring(0, 20));
			} catch (Exception e) {
				log.severe("rpc mileagedatautils?op=selectAll exception:"
						+ e.toString() + "%%" + url);
				ret.setText("rpc mileagedatautils?op=selectAll exception:"
						+ e.toString() + "%%" + url);
				ret.setResult(false);
				return ret;
//			} finally {
//				if (reader != null) {
//					try {
//						reader.close();
//					} catch (Exception e) {
//						log.warning("rpc mileagedatautils?op=selectAll reader.close exception:"
//								+ e.toString());
//						ret.setText("rpc mileagedatautils?op=selectAll reader.close exception:"
//								+ e.toString());
//						ret.setResult(false);
//						return ret;
//					}
//				}
			}
**************************************/

			/*
			 * cannot use HTTPRequest because of prevent recursive call.
			 * HTTPHeader hh = new HTTPHeader("Content-Type","text/plain"); URL
			 * url = new URL("mileagedatautils?op=selectAll"); HTTPRequest
			 * locRequest = new HTTPRequest(url, HTTPMethod.GET);
			 * locRequest.setHeader(hh); HTTPResponse locResponse =
			 * URLFetchServiceFactory.getURLFetchService().fetch(locRequest); if
			 * ( locResponse.getResponseCode() < 200 ||
			 * locResponse.getResponseCode() >= 300) {
			 * log.severe("mileagedatautils?op=selectAll" +
			 * " cannot obtain data " + locResponse.getResponseCode());
			 * ret.setText("mileagedatautils?op=selectAll" +
			 * " cannot obtain data " + locResponse.getResponseCode());
			 * ret.setResult(false); return ret; } String s = new
			 * String(locResponse.getContent());
			 */
/**************************
		} catch (Exception e) {
			ret.setText("[Catch the exception in obtaining JDO at RPC serve]"
					+ e.toString());
			ret.setResult(false);
		}
******************************/
		return ret;
	}

	public ResultFetch saveJobName(String jobName) {
		log.info("enterd saveJobName (RPC)");
		ret.setResult(true);
		try {
			log.info("before task name store, name=" + jobName);
			if (jobName.length() >= 12
					&& "ConsentCheck".equals(jobName.substring(0, 12))) {				
				// create session and store userid
				//AbstractRemoteServiceServlet request = this.getThreadLocalRequest();
				HttpServletRequest request = (HttpServletRequest) this.getThreadLocalRequest();
				HttpSession session = request.getSession(true);
				session.setAttribute("UserID", 1);
				log.info("..session id=" + session.getId());
				String[] tmp = oauthTokenDao.getPropMesg().split(",");
				ret.setText(tmp[0] + "," + tmp[1] + "," + tmp[2] + "," + session.getId());
				oauthTokenDao.saveJob(jobName);
				return ret;
			}
			if (jobName.length() >= 12
					&& "ConsentLogin".equals(jobName.substring(0, 12))) {				
				ret.setText("Consult google account.");
				oauthTokenDao.saveJob(jobName);
				return ret;
			}
			if (jobName.length() >= 14
					&& "ConsentTimeOut".equals(jobName.substring(0, 14))) {				
				ret.setText("Login TimeOut Occurred.");
				oauthTokenDao.saveJob(jobName);
				return ret;
			}
//			if (jobName.length() >= 9  //Obsolete. no more used.
//					&& "InsertSQL".equals(jobName.substring(0, 9))) {
//				String url = "";
//				String respStr = "";
//				HttpURLConnection uc = null;
//				BufferedReader reader = null;
//				try {
////					if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
////						url = "http://tupracticalpieces.appspot.com/mileagedatautils?op=insertNew&param=" + jobName.substring(10);
////					} else {
////						url = "http://localhost:8888/mileagedatautils?op=insertNew&param=" + jobName.substring(10);
////					}
//					url = getRequestModuleBasePath() + "/mileagedatautils?op=insertNew&param=" + jobName.substring(10);
//					URL u = new URL(url);
//					try {
//						uc = (HttpURLConnection) u.openConnection();
//						uc.setRequestMethod("GET");
//						uc.setRequestProperty("Content-Type", "text/plain");
//						uc.setRequestProperty("Accept-Charset", "UTF-8");
//						uc.setConnectTimeout(5000);
//						uc.setReadTimeout(5000);
//						uc.setDoOutput(true);
//						reader = new BufferedReader(new InputStreamReader(
//								uc.getInputStream(), "UTF-8"));
//						for (String line; (line = reader.readLine()) != null;) {
//							respStr += line;
//						}
//					} catch (Exception e) {
//						log.severe("On inserting to Cloud SQL, error occurred in setting para or connecting." + e.toString());
//						ret.setText("On inserting to Cloud SQL, error occurred in setting para or connecting." + e.toString());
//						ret.setResult(false);
//						return ret;
//					} finally {
//						if (reader != null) {
//							try {
//								reader.close();
//							} catch (Exception e) {
//								log.warning("On inserting to Cloud SQL, error occurred in setting para or connecting. reader.close exception:" + e.toString());
//								ret.setText("On inserting to Cloud SQL, error occurred in setting para or connecting. reader.close exception:" + e.toString());
//								ret.setResult(false);
//								return ret;
//							}
//						}
//					}
//				} catch (Exception e) {
//					log.severe("On inserting to Cloud SQL, error occurred in setting para or connecting." + e.toString());
//					ret.setText("On inserting to Cloud SQL, error occurred in setting para or connecting." + e.toString());
//					ret.setResult(false);
//					return ret;
//				}
//				ret.setText(oauthTokenDao.getPropMesg() 
//						+ "Completed adding the data into Database. key:"
//						+ respStr);
//				return ret;
//			}
		} catch (Exception e) {
			ret.setText("<ol style='list-style-type: disc'><li>"
					+ "[SET JOB NAME]" + e.toString() + "</li></ol>");
			ret.setResult(false);
			//e.printStackTrace();
		}
		return ret;
	}

	// 202406	
	public ResultFetch getJobName(String jobName) {
		log.info("enterd getJobName (RPC)");
		ret.setResult(true);
		try {
			log.info("before task name store, name=" + jobName);
			String[] tmp = oauthTokenDao.getPropMesg().split(",");
//			ret.setText(tmp[0] + "," + tmp[1] + "," + tmp[2] + "," + session.getId());
			ret.setText(tmp[0] + "," + tmp[1] + "," + tmp[2]);
			return ret;
		} catch (Exception e) {
			ret.setText("<ol style='list-style-type: disc'><li>"
					+ "[SET JOB NAME]" + e.toString() + "</li></ol>");
			ret.setResult(false);
			//e.printStackTrace();
		}
		return ret;
	}	
}
