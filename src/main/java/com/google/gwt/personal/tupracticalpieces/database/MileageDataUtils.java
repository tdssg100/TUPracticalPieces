/* Copyright (c) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* rename AddressBook to MileageDate, and change attributes. 2012 T.Uesugi 
 */

package com.google.gwt.personal.tupracticalpieces.database;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import java.util.Properties;
//import com.google.appengine.api.utils.SystemProperty;
//import com.google.gwt.personal.tupracticalpieces.database.EMF;
//import com.google.gwt.personal.tupracticalpieces.database.Mileage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
@NamedQueries( {
	@NamedQuery(name="CacheInitMileage", query="select m from Mileage m"),
})

*/


//@PersistenceContext(unitName="TUPPDB")
public class MileageDataUtils extends HttpServlet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6217361340L;
	// cached mileage
	// private mileage mileage;
	//final static EntityManager cm = EMF.get().createEntityManager();
	//private static final EntityManagerFactory emfInstance 
	//= Persistence.createEntityManagerFactory("TUPPDB");
	//public static final EntityManager cm = Persistence.createEntityManagerFactory("TUPPDB").createEntityManager();

//	static EntityManager cm = EMF.get().createEntityManager();

	//private static Properties prop = new Properties();

	/*
	 * prop.setProperty("jakarta.persistence.jdbc.user","viewer");
	 * prop.setProperty("jakarta.persistence.jdbc.password","viewer15963");
	 */
	/*
	private MileageDataUtils() {
	}
	 */
	private static final Logger log = Logger.getLogger(MileageDataUtils.class
			.getName());

	public void init() {
		/* caching */
		//@SuppressWarnings("unused")
//		String tmp = selectAll();
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("init no db.");
//			return;
//		}
		/* Effective for Development 20201029
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
			log.info("init db not implemented.");
			return;
		}
		*/

		//log.info("db init:" + this.getServletConfig().getServletContext().toString());
		// if genuin appengine then retrun because there is no local db.
		EntityManager cm = null;
		try {
			EMF emf = new EMF();
		//if (emf.get() == null) {
		//	log.info("db init fail.");
		//	return;
		//}
			cm= emf.get().createEntityManager();
//			tx.begin();
			//Query query = TaskDataUtils.cm.createQuery("select m from Mileage m where supplyDate='" + id + "'");
//			Query query = TaskDataUtils.cm.createQuery("select m from Task m where id=" + id); 
			Query query = cm.createQuery("select m from Mileage m");
			List<Mileage> md = (List<Mileage>) query.getResultList();

/*
				List<Mileage> md = emf.createNamedQuery("CacheInitMileage")
						.setFirstResult(0)
						.setMaxResults(1)
						.getResultList();
*/
			log.info("db cache initilized. mileage:" + md.size());
		} catch (Exception e) { 
			log.severe("JPA cache init: " + e.toString());				
		} finally {
//			cm.close();
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("db util servlet not available because of Production.");
//			return;
//		}
		
		resp.setContentType("text/html");
		String op = req.getParameter("op");
		if (op == null || op.isEmpty()) {
			resp.getWriter().print("op is empty");
			return;
		}
		if (op.equals("insertNew")) { // obsolete, no more used.
			//public static String insertNew(String supplyDateStr, float quantity,
			//int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
			String insertKey = "";
			try {
				String param = req.getParameter("param");
				log.info(param);
				String[] paras = param.split(",");
				String supplyDateStr = paras[0];
				log.info(supplyDateStr);
				
				String quantity = paras[1];
				String unitPrice = paras[2];
				String totalPrice = paras[3];
				String bsMileage = paras[4];
				String totalMileage = paras[5];
//				insertKey = insertNew(supplyDateStr, Float.valueOf(quantity), Integer.parseInt(unitPrice),
//						Integer.parseInt(totalPrice),Float.valueOf(bsMileage), Float.valueOf(totalMileage));
				insertKey = insertNew(supplyDateStr, new BigDecimal(quantity),
						Integer.parseInt(unitPrice), Integer.parseInt(totalPrice),
						new BigDecimal(bsMileage), new BigDecimal(totalMileage));
			} catch (Exception e) {
				resp.getWriter().print("InserNew: occur exception:" + e.toString());
				return;
			}
			resp.getWriter().print(insertKey);
			return;
		}
		if (op.equals("totalCount")) {
			//public static int totalCount() {
			int n = totalCount();			
			resp.getWriter().print(n);
			return;
		}
		if (op.equals("selectAll")) {
			//public static String selectAll() {
			String retJson = selectAll();			
			resp.getWriter().print(retJson);
			return;
		}
		if (op.equals("selectByOrder")) {
			//public static mileage selectByOrder(int indx) {
			String startindx;
			String endindx;
			try {
				startindx = req.getParameter("startindx");
				endindx = req.getParameter("endindx");
			} catch (NumberFormatException e) {
				resp.getWriter().print("Eorror:startindx,endindx were not specified.");
				return;
			}
			String mileageStr = selectByOrder(Integer.parseInt(startindx), Integer.parseInt(endindx));			
			resp.getWriter().print(mileageStr);
			return;
		}
		if (op.equals("selectOne")) {
			//public static mileage selectOne(string) {
			String supplydatestr = req.getParameter("supplydate");
			Date supplydate = java.sql.Date.valueOf(supplydatestr);
			String mileageStr = selectOne(supplydate);			
			resp.getWriter().print(mileageStr);
			return;
		}
		if (op.equals("testmethod")) {
			//public static mileage selectOne(string) {
			String methodstr = req.getParameter("m");
			if (methodstr.equals("findAllMileages")) {
				try {
				List<Mileage> md = (List<Mileage>) Mileage.findAllMileages();
				} catch (Exception e) {
					resp.getWriter().print("err." + e.toString());			
				}
				resp.getWriter().print("executed.");			
				return;
//				String retJson;
//				try {
//					List<Mileage> md = (List<Mileage>) Mileage.findAllMileages();
//					retJson = "{supplyDetail : [";
//					for (int i = 0; i < md.size(); i++) {
//						retJson += String
//								.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
//										+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
//										md.get(i).getSupplyDate(), md.get(i).getQuantity(),
//										md.get(i).getUnitPrice(), md.get(i).getTotalPrice(),
//										md.get(i).getBsMileage(), md.get(i).getTotalMileage());
//						if (i < md.size() - 1) {
//							retJson += ",";
//						}
//					}
//					retJson += "]}";
//				} catch (Exception e) {
//					resp.getWriter().print("Error occurred when JPA method. " + e.toString());
//					return;
//				}
//				resp.getWriter().print(retJson);
//				return;
		    }
			// otherwise	
			resp.getWriter().print("method invalid" + methodstr);			
			return;
			
		}
			
		// otherwise	
		resp.getWriter().print("op invalid" + op);			
		return;
	}

// obsolete
//	public static String insertNew(String supplyDateStr, float quantity,
//			int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
	public static String insertNew(String supplyDateStr, BigDecimal quantity,
			int unitPrice, int totalPrice, BigDecimal bsMileage, BigDecimal totalMileage) {
		//EntityManager cm = EMF.get().createEntityManager();
//		EntityTransaction tx = cm.getTransaction();
//		tx.begin();
//		Date supplyDate=null;
//		String insertKey = "";
		//log.info("insertNew entered." + insertKey);
		String supplyDateStrCont = "";
		EntityManager cm= EMF.get().createEntityManager();

		try {
			supplyDateStrCont = supplyDateStr.substring(1,11);
//			try {
//				supplyDate=java.sql.Date.valueOf(supplyDateStrCont);
//			} catch (Exception exc) {
//				log.info("The ID cannot parse: " + supplyDateStrCont + ",reason:" + exc.toString());
//				throw exc;      // Rethrow the exception.
//			}
//			Mileage entry = new Mileage(supplyDate, quantity, unitPrice,
//					totalPrice, bsMileage, totalMileage);
			Mileage entry = new Mileage(supplyDateStrCont, quantity, unitPrice,
					totalPrice, bsMileage, totalMileage);
			//insertKey = entry.getId().toString();
//			insertKey = Float.toString(entry.getId());
			log.info("The entity gets persist. ID of the new entry is: " + supplyDateStrCont);
			cm.persist(entry);
//			tx.commit();
		} catch (Exception e) {
//			tx.rollback();
			//e.printStackTrace();
			log.severe("Count SQL error: " + e.toString());
			//} finally {
			//	cm.close();
		}
		return supplyDateStrCont;
	}

	/*
	 */
	public static int totalCount() {
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("init no db.");
//			return 0;
//		}
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
//			log.info("init db not implemented.");
//			return 0;
//		}
		int ret = 0;
		/* Map<String, String> map = new HashMap<String, String>(properties); */
		//EntityManager cm = EMF.get().createEntityManager();
//		EntityTransaction tx = cm.getTransaction();
//		tx.begin();
		EntityManager cm= EMF.get().createEntityManager();

		Query query = cm.createQuery("select m.supplyDate from Mileage m");
		try {
			@SuppressWarnings("unchecked")
			List<java.sql.Date> md = (List<java.sql.Date>) query.getResultList();
			ret = md.size();
//			tx.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			log.severe("Count SQL error:" + e.toString());
			ret = 0;
//			tx.rollback();
			//} finally {
			//	cm.close();
		}
		return ret;
	}

	/*	public static void deleteAll() throws Exception {
		log.info("JPA util: deleteAll entered");
		 do noting 
	}
	 */
	public static String selectAll() {
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("init no db.");
//			return "";
//		}
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
//			log.info("init db not implemented.");
//			return "";
//		}
		String retJson;
		//EntityManager cm = EMF.get().createEntityManager();
//		EntityTransaction tx = cm.getTransaction();
//		tx.begin();
		EntityManager cm= EMF.get().createEntityManager();

		Query query = cm.createQuery("select m from Mileage m order by m.supplyDate DESC");
		/*
		 * if there is no data, hung.
		 * 
		 * @SuppressWarnings("unchecked") Collection<mileage> allProducts =
		 * (Collection<mileage>) query.execute(); Iterator<mileage> iter =
		 * allProducts.iterator(); retJson = "{supplyDetail : ["; while
		 * (iter.hasNext()) { mileage md = (mileage)iter.next(); retJson +=
		 * String.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
		 * + "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
		 * md.getSupplyDate(),md.getQuantity(), md.getUnitPrice(),
		 * md.getTotalPrice(), md.getBsMileage(), md.getTotalMileage()); if
		 * (iter.hasNext()) { retJson += ","; } }
		 */
		try {
			@SuppressWarnings("unchecked")
			List<Mileage> md = (List<Mileage>) query.getResultList();
			retJson = "{supplyDetail : [";
			for (int i = 0; i < md.size(); i++) {
				retJson += String
						.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
								+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
								md.get(i).getSupplyDate(), md.get(i).getQuantity(),
								md.get(i).getUnitPrice(), md.get(i).getTotalPrice(),
								md.get(i).getBsMileage(), md.get(i).getTotalMileage());
				if (i < md.size() - 1) {
					retJson += ",";
				}
			}
			retJson += "]}";
//			tx.commit();
		} catch (Exception e) {
			retJson = "{supplyDetail : []}"; 
			//e.printStackTrace();
			log.severe("retrieve data error:" + e.toString());
//			tx.rollback();
			//} finally {
			//cm.close();
		}
		return retJson;
	}

	/*
	 * public static boolean isExist(String key) { }
	 */
	/* 20130508 Grid */
	public String selectByOrder(int startIndx, int endIndx) {
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("init no db.");
//			return "";
//		}
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
//			log.info("init db not implemented.");
//			return "";
//		}
		//public static mileage selectByOrder(int indx) {
		//mileage ret;
		String retStr = "";
		//EntityManager cm = EMF.get().createEntityManager();
//		EntityTransaction tx = cm.getTransaction();
//		tx.begin();
		EntityManager cm= EMF.get().createEntityManager();

		Query query = cm
				.createQuery("select m from Mileage m order by m.supplyDate DESC");
		try {
			@SuppressWarnings("unchecked")
			List<Mileage> md = (List<Mileage>) query.getResultList();
			
			if (startIndx < md.size()) {
				if (endIndx > md.size()) {
					endIndx = md.size();
				}
				for (int indx = startIndx; indx < endIndx; indx++) {
					//ret = md.get(indx);
				//retStr = Float.toString(ret.getSupplyDate().getTime()) + "," + ret.getQuantity().toString();
				//retStr += "," + ret.getUnitPrice() +  "," + ret.getTotalPrice();
				//retStr += "," + ret.getBsMileage().toString() +  "," + ret.getTotalMileage().toString();
					if (indx != startIndx) {
						retStr += "@";
					}
					retStr += String
						.format("%s,%.2f,%d,%d,%.1f,%.1f",
								md.get(indx).getSupplyDate(), md.get(indx).getQuantity(),
								md.get(indx).getUnitPrice(), md.get(indx).getTotalPrice(),
								md.get(indx).getBsMileage(), md.get(indx).getTotalMileage());
				}
			} else {
				log.info("JPA util: selectByOrder size=" + md.size()
						+ ",startIndx= " + startIndx + ",endIndx= " + endIndx);
				retStr = null;
			}
			
//			tx.commit();
		} catch (Exception e) {
			retStr = ""; 
			//e.printStackTrace();
			log.severe("Select by order error:" + e.toString());
//			tx.rollback();
			//} finally {
			//	cm.close();
		}
		return retStr;
	}
	
	public static String selectOne(Date id) {
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			log.info("init no db.");
//			return "";
//		}
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
//			log.info("init db not implemented.");
//			return "";
//		}
			String retJson;
			//EntityManager cm = EMF.get().createEntityManager();
//			EntityTransaction tx = cm.getTransaction();
//			tx.begin();
			EntityManager cm= EMF.get().createEntityManager();

			Query query = cm.createQuery("select m from Mileage m where supplyDate='" + id.toString() + "'");
			try {
				@SuppressWarnings("unchecked")
				List<Mileage> md = (List<Mileage>) query.getResultList();
				retJson = "{supplyDetail : [";
				for (int i = 0; i < md.size(); i++) {
//					retJson += String.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
//							+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
//							md.get(i).getSupplyDate(), md.get(i).getQuantity(),
//							md.get(i).getUnitPrice(), md.get(i).getTotalPrice(), 
//							md.get(i).getBsMileage(), md.get(i).getTotalMileage());
//					retJson += String.format("{id: %d, supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
//									+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
//									md.get(i).getId(), 
//									md.get(i).getSupplyDate(), md.get(i).getQuantity(),
//									md.get(i).getUnitPrice(), md.get(i).getTotalPrice(), 
//									md.get(i).getBsMileage(), md.get(i).getTotalMileage());
					retJson += String.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
					+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
					md.get(i).getSupplyDate(), md.get(i).getQuantity(),
					md.get(i).getUnitPrice(), md.get(i).getTotalPrice(), 
					md.get(i).getBsMileage(), md.get(i).getTotalMileage());
					if (i < md.size() - 1) {
						retJson += ",";
					}
				}
				retJson += "]}";
//				tx.commit();
			} catch (Exception e) {
				retJson = "{supplyDetail : []}";
				//e.printStackTrace();
				log.severe("retrieve data error:" + e.toString());
//				tx.rollback();
				//} finally {
				//cm.close();
			}
			return retJson;	  }	
}















/*public class MileageDataUtils {
	// cached mileage
	// private mileage mileage;
	//final static EntityManager cm = EMF.get().createEntityManager();
	@PersistenceContext(unitName="TUPPDB")
	static EntityManager cm = EMF.get().createEntityManager();
	//static EntityManager cm = EMF.get().createEntityManager();

	//private static Properties prop = new Properties();


 * prop.setProperty("jakarta.persistence.jdbc.user","viewer");
 * prop.setProperty("jakarta.persistence.jdbc.password","viewer15963");


	private MileageDataUtils() {
	}


	private static final Logger log = Logger.getLogger(MileageDataUtils.class
			.getName());

	public static String insertNew(String supplyDateStr, float quantity,
			int unitPrice, int totalPrice, Float bsMileage, Float totalMileage) {
		//EntityManager cm = EMF.get().createEntityManager();
		EntityTransaction tx = cm.getTransaction();
		tx.begin();
		Date supplyDate=null;
		String insertKey = "";
		//log.info("insertNew entered." + insertKey);
		try {
			String supplyDateStrCont = supplyDateStr.substring(1,11);
			try {
				supplyDate=java.sql.Date.valueOf(supplyDateStrCont);
			} catch (Exception exc) {
				log.info("The ID cannot parse: " + supplyDateStrCont + ",reason:" + exc.toString());
				throw exc;      // Rethrow the exception.
			}
			mileage entry = new mileage(supplyDate, quantity, unitPrice,
					totalPrice, bsMileage, totalMileage);
			insertKey = entry.getId().toString();
			log.info("The ID of the new entry is: " + insertKey);
			cm.persist(entry);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			//e.printStackTrace();
			log.severe("Count SQL error: " + e.toString());
		//} finally {
		//	cm.close();
		}
		return insertKey;
	}



	public static int totalCount() {
		int ret = 0;
		 Map<String, String> map = new HashMap<String, String>(properties); 
		//EntityManager cm = EMF.get().createEntityManager();
		EntityTransaction tx = cm.getTransaction();
		tx.begin();
		Query query = cm.createQuery("select m.supplyDate from mileage m");
		try {
			@SuppressWarnings("unchecked")
			List<java.sql.Date> md = (List<java.sql.Date>) query.getResultList();
			ret = md.size();
			tx.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			log.severe("Count SQL error:" + e.toString());
			ret = 0;
			tx.rollback();
		//} finally {
		//	cm.close();
		}
		return ret;
	}

	public static void deleteAll() throws Exception {
		log.info("JPA util: deleteAll entered");
		 do noting 
	}

	public static String selectAll() {
		String retJson;
		//EntityManager cm = EMF.get().createEntityManager();
		EntityTransaction tx = cm.getTransaction();
		tx.begin();
		Query query = cm.createQuery("select m from mileage m order by m.supplyDate DESC");

 * if there is no data, hung.
 * 
 * @SuppressWarnings("unchecked") Collection<mileage> allProducts =
 * (Collection<mileage>) query.execute(); Iterator<mileage> iter =
 * allProducts.iterator(); retJson = "{supplyDetail : ["; while
 * (iter.hasNext()) { mileage md = (mileage)iter.next(); retJson +=
 * String.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
 * + "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
 * md.getSupplyDate(),md.getQuantity(), md.getUnitPrice(),
 * md.getTotalPrice(), md.getBsMileage(), md.getTotalMileage()); if
 * (iter.hasNext()) { retJson += ","; } }

		try {
			@SuppressWarnings("unchecked")
			List<mileage> md = (List<mileage>) query.getResultList();
			retJson = "{supplyDetail : [";
			for (int i = 0; i < md.size(); i++) {
				retJson += String
						.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
								+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
								md.get(i).getSupplyDate(), md.get(i)
										.getQuantity().floatValue(), md.get(i)
										.getUnitPrice(), md.get(i)
										.getTotalPrice(), md.get(i)
										.getBsMileage().floatValue(), md.get(i)
										.getTotalMileage().floatValue());
				if (i < md.size() - 1) {
					retJson += ",";
				}
			}
			retJson += "]}";
			tx.commit();
		} catch (Exception e) {
			retJson = "{supplyDetail : []}";
			//e.printStackTrace();
			log.severe("retrieve data error:" + e.toString());
			tx.rollback();
		//} finally {
			//cm.close();
		}
		return retJson;
	}


 * public static boolean isExist(String key) { }

	 20130508 Grid 
	public static mileage selectByOrder(int indx) {
		mileage ret;
		EntityTransaction tx = cm.getTransaction();
		tx.begin();
		Query query = cm
				.createQuery("select m from mileage m order by m.supplyDate DESC");
		try {
			@SuppressWarnings("unchecked")
			List<mileage> md = (List<mileage>) query.getResultList();
			if (indx < md.size()) {
				ret = md.get(indx);
			} else {
				log.info("JPA util: selectByOrder size=" + md.size()
						+ ",indx= " + indx);
				ret = null;
			}
			tx.commit();
		} catch (Exception e) {
			ret = null;
			//e.printStackTrace();
			log.severe("Select by order error:" + e.toString());
			tx.rollback();
		//} finally {
		//	cm.close();
		}
		return ret;
	}
}
 */
