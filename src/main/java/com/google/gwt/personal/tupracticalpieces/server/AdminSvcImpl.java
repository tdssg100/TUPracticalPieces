package com.google.gwt.personal.tupracticalpieces.server;

//import com.google.appengine.api.utils.SystemProperty;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.personal.tupracticalpieces.client.common.AdminSvc;
import com.google.gwt.personal.tupracticalpieces.client.common.ResultSvc;
//import com.google.gwt.personal.tupracticalpieces.database.mileage;
//import com.google.gwt.personal.tupracticalpieces.database.MileageDataUtils;
//import java.net.MalformedURLException;
//import java.net.URL;
/*
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
 */
import java.util.logging.Logger;//TODO when deploy, change loglevel in log.properties
import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.net.URLEncoder;
/**
 * 20130508 Grid
 * The RPC of AdminSvc for the server-side.
 * 20141216 modify coresponding servlet from rpc 
 */
@SuppressWarnings("serial")
public class AdminSvcImpl extends RemoteServiceServlet implements AdminSvc {

	private static final Logger log = Logger.getLogger(AdminSvcImpl.class.getName());

	private ResultSvc ret;

	public ResultSvc dispatchMileageData(int startRow, int rowCount)  {
		//mileage tmp;
		//String tmp="";
		int i = startRow;
		int j = startRow + rowCount;
		ret = new ResultSvc(rowCount);

		//for (int i = startRow; i < startRow + rowCount; i++) {
		//MileageDataUtils tm = new MileageDataUtils();
		//tmp = tm.selectByOrder(i);
		String url = "";
		String respStr = "";
		HttpURLConnection uc = null;
		BufferedReader reader = null;
		try {
			//log.info("tupp rpc svr entered.");
			/* fetch Mileage Data From JDO */
			// MileageDataUtils tm = new MileageDataUtils();
			// String s = tm.selectAll();
//			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//				url = "http://tupracticalpieces.appspot.com/mileagedatautils?op=selectByOrder&startindx=" + String.valueOf(i) + "&endindx=" + String.valueOf(j);
//			} else {
//				url = "http://localhost:8888/mileagedatautils?op=selectByOrder&startindx=" + String.valueOf(i) + "&endindx=" + String.valueOf(j);
//			}
			url = getRequestModuleBasePath() + "/mileagedatautils?op=selectByOrder&startindx=" + String.valueOf(i) + "&endindx=" + String.valueOf(j);
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
			log.info("rpc http read mileagedatautils?op=selectByOrder&indx=" + String.valueOf(i) + "-" + String.valueOf(j) + " " + respStr);
			if (respStr.length() == 0) {
				log.severe("rpc http cannot read mileagedatautils?op=selectByOrder&indx=" + String.valueOf(i)  + "-" + String.valueOf(j));
				if (i == startRow) {							
					ret.setNumber(0);
				} else {
					ret.setNumber(i - startRow);
				}
				return ret;
			}
			String tmpStrArr[] = respStr.split("@");
			for (int k = 0; k < tmpStrArr.length; k++) {
				ret.setRec(k, tmpStrArr[k]);
			}
			ret.setNumber(tmpStrArr.length);
		} catch (Exception e) {
			log.severe("rpc mileagedatautils?op=selectByOrder&indx=" + String.valueOf(i) + "-" + String.valueOf(j)+ "exception:"
					+ e.toString());
			if (i == startRow) {
				ret.setNumber(0);
			} else {
				ret.setNumber(i - startRow);
			}
			return ret;
		}
		//}
		return ret;
	}
}
/*
		try {
			HTTPHeader hh = new HTTPHeader("Content-Type","text/plain");
			URL url = new URL("mileagedatautils?op=selectByOrder&indx=" + String.valueOf(i));
			HTTPRequest locRequest = new HTTPRequest(url, HTTPMethod.GET);
			locRequest.setHeader(hh);
			HTTPResponse locResponse = URLFetchServiceFactory.getURLFetchService().fetch(locRequest);
			if ( locResponse.getResponseCode() < 200 || locResponse.getResponseCode() >= 300) {
			    	log.severe("mileagedatautils&selectByOrder&param=" + i + " cannot obtain data from geonames.org" + locResponse.getResponseCode());
					//appendMessage("mileagedatautils&selectByOrder&param=" + i + " cannot obtain data from geonames.org" + locResponse.getResponseCode());
					return ret;
		    }
			tmp = new String(locResponse.getContent());
			if (tmp == null) {
				ret.setNumber(i - startRow);
				log.info("rpc:server cannot retrieve data from db utility." );
				return ret;
			}
 */
/*
			} catch(Exception e) {
				log.info("http request e:" + e.toString() );
				if (i == startRow) {
					ret.setNumber(0);
				} else {
					ret.setNumber(i - startRow -1);
				}
				return ret;
			}
 */
//String tmpArr[] = tmp.split(",");
//ret.setRec(i - startRow, respStr);
//new java.util.Date(Long.parseLong(tmpArr[0])), tmpArr[1],
//		String.format("%d", tmp.getUnitPrice()), String.format("%d", tmp.getTotalPrice()),
//		String.format("%.1f", tmp.getBsMileage()), String.format("%.1f", tmp.getTotalMileage()));

