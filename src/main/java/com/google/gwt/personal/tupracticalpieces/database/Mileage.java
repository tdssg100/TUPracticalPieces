package com.google.gwt.personal.tupracticalpieces.database;

//import java.io.Serializable;
import java.math.BigDecimal;
//import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Basic;
import javax.validation.constraints.Digits;
//import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Query;
import java.sql.Date;

//import com.google.gwt.personal.tupracticalpieces.server.domain.EMF;
//import com.google.gwt.personal.tupracticalpieces.server.domain.Query; 
//import com.google.gwt.personal.tupracticalpieces.server.domain.Task;
/*
*/


@Entity


@NamedQueries( {
	@NamedQuery(name="AllMileage", query="select m from Mileage m order by m.supplyDate DESC"),
	@NamedQuery(name="LookUpMileage", query="select m from Mileage m where m.id = :id")
})


//public class Mileage implements Serializable{
@Table(name = "mileage")
public class Mileage {

	/*
	@Converter(autoApply=true)
	private class DatetoStringConverter implements AttributeConverter<java.sql.Date, String>
	{
	    @Override
	    public String convertToDatabaseColumn(Date arg0) {
	        return arg0.toString();
	    }

	    @Override
	    public Date convertToEntityAttribute(String arg0) {
	        try {
	            return  Date.valueOf(arg0);
	        } catch (IllegalArgumentException  e) {
	            return null;
	        }
	    }
	}	
	*/
	
	private static final Logger log = Logger.getLogger(Mileage.class.getName());
	
	  @Id //JPA
	  @GeneratedValue( strategy = GenerationType.IDENTITY )
	  @Column(name = "id")
	  private Long id;
	  @Column(name = "supplyDate") 
//	  @Convert(converter=DatetoStringConverter.class)
	  @NotNull
	  private String supplyDate;
	  @Basic //JPA
	  @NotNull
//	  private float quantity;
	  @Digits(integer=2, fraction=2)
	  @Column(name = "quantity")
	  private BigDecimal quantity;

	  @Basic //JPA
	  @NotNull
	  @Column(name = "unitPrice")
	  private int unitPrice;
	  @Basic //JPA
	  @NotNull
	  @Column(name = "totalPrice")
	  private int totalPrice;
	  @Basic //JPA
	  @NotNull
//	  private float bsMileage;
	  @Digits(integer=3, fraction=1)
	  @Column(name = "bsMileage")	  
	  private BigDecimal bsMileage;
	  @Basic //JPA
	  @NotNull
//	  private float totalMileage;
	  @Digits(integer=6, fraction=0)
	  @Column(name = "totalMileage")
//	  private int totalMileage;
	  private BigDecimal totalMileage;

	  public Mileage() {
		  /* empty */
	  }
	  
//	  public Mileage(Date supplyDate, float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) { 
//	  public Mileage(String supplyDate, float quantity, int unitPrice, int totalPrice, float bsMileage, float totalMileage) {
	  public Mileage(String supplyDate, BigDecimal quantity, int unitPrice, 
			  int totalPrice, BigDecimal bsMileage, BigDecimal totalMileage) {
		  super();
		  this.supplyDate = supplyDate;
	      this.quantity = quantity;
	      this.unitPrice = unitPrice;
	      this.totalPrice = totalPrice;
	      this.bsMileage = bsMileage;
	      this.totalMileage = totalMileage;
	  }
	  
	  
//	  public Date getSupplyDate() {
	  public String getSupplyDate() {
		  return this.supplyDate;
	  }
	  
//	  public float getQuantity() {
	  public BigDecimal getQuantity() {
		  return this.quantity;
	  }
	  
	  public int getUnitPrice() {
		  return this.unitPrice;
	  }
	  
	  public int getTotalPrice() {
		  return this.totalPrice;
	  }
	  
//	  public float getBsMileage() {
	  public BigDecimal getBsMileage() {
		  return this.bsMileage;
	  }
	  
//	  public int getTotalMileage() {
	  public BigDecimal getTotalMileage() {
		  return this.totalMileage;
	  }

	  public void setSupplyDate(String supplyDate) {
		  this.supplyDate = supplyDate;
	  }
	  
//	  public void setQuantity(float quantity) {
	  public void setQuantity(BigDecimal quantity) {
		  this.quantity = quantity;
	  }
	  
	  public void setUnitPrice(int unitPrice) {
		  this.unitPrice = unitPrice;
	  }
	  
	  public void setTotalPrice(int totalPrice) {
		  this.totalPrice = totalPrice;
	  }
	  
//	  public void setBsMileage(float bsMileage) {
	  public void setBsMileage(BigDecimal bsMileage) {
		  this.bsMileage = bsMileage;
	  }
	  
//	  public void setTotalMileage(float totalMileage) {
//	  public void setTotalMileage(int totalMileage) {
	  public void setTotalMileage(BigDecimal totalMileage) {
		  this.totalMileage = totalMileage;
	  }

//	  public Date getId() {
//	    return this.supplyDate;
//	  }
	  public Long getId() {
		    return this.id;
		  }
	  
	  public static Mileage findMileage(Long id) {
	    return findEntity(id);
	  }
	  
//	  public static Mileage findMileage(String id) {
//		    return findEntity(id);
//	  }

	  public static Mileage findEntity(Long id) {
//	  public static Mileage findEntity(String id) {
//			EntityTransaction tx = MileageDataUtils.cm.getTransaction();
		    EntityManager emf = EMF.get().createEntityManager();

			try {
//				tx.begin();
				//Query query = MileageDataUtils.cm.createQuery("select m from Mileage m where supplyDate='" + id + "'");
//				Query query = MileageDataUtils.cm.createQuery("select m from Mileage m where id=" + id.toString() );
//				Query query = emf.createNamedQuery("select m from Mileage m where id="  + id.toString() );
//				List<Mileage> md = (List<Mileage>) query.getResultList();
				List<Mileage> md = emf.createNamedQuery("LookUpMileage")
						.setParameter("id", id)
						.setFirstResult(0)
						.setMaxResults(1)
						.getResultList();
	//		    return new Mileage(md.get(0).supplyDate, md.get(0).quantity , md.get(0).unitPrice, 
	//		    		md.get(0).totalPrice, md.get(0).bsMileage, md.get(0).totalMileage);			
//				tx.commit();
				return md.get(0);
			} catch (IllegalArgumentException e) {
//				tx.rollback();
				//e.printStackTrace();
				log.severe("Count SQL error: " + e.toString());				
			} finally {
				emf.close();
			}
			return null;
	  }

	  /**
	   * Persist this object in the data store.
	   */
	  public void persist()  throws Exception {
//	  public void persist() {
			EntityManager emf = EMF.get().createEntityManager();
			//EntityTransaction tx = MileageDataUtils.cm.getTransaction();
			EntityTransaction tx = emf.getTransaction();
			tx.begin();
		    //EntityManager emf = EMF.get().createEntityManager();

			try {
//				MileageDataUtils.cm.persist(this);
//				emf.persist(this);
				emf.merge(this);
				tx.commit();
			} catch (IllegalArgumentException e) {
				tx.rollback();
				e.printStackTrace();
				log.severe("JPA persist error: " + e.toString());
				//} finally {
				//	cm.close();
//				throw e;
			} finally {
				emf.close();
			}

		}
	  /**
	   * Remove this object in the data store.
	   */
	  public void remove()  throws Exception {
//	  public void remove() {
			EntityManager emf = EMF.get().createEntityManager();
			EntityTransaction tx = emf.getTransaction();
			tx.begin();
		    //EntityManager emf = EMF.get().createEntityManager();
			try {
//				MileageDataUtils.cm.remove(this);
//				emf.remove(this);
				Mileage attached = emf.find(Mileage.class, this.id);
				emf.remove(attached);
				tx.commit();
			} catch (IllegalArgumentException e) {
				tx.rollback();
				e.printStackTrace();
				log.severe("JPA remove SQL error: " + e.toString());
				//} finally {
				//	cm.close();
//				throw e;
			} finally {
				emf.close();
			}
 
 /*
		Mileage attached = emf.find(Mileage.class, this.id);
		emf.remove(attached);
		emf.flush();
*/
		}
	  /**
	   * Find all tasks for the current user.
	   */
//	  @SuppressWarnings("unchecked")
//	  public static List<mileage> findAllTasks() {
	  @SuppressWarnings("unchecked")
//	  public static List<Mileage>  findAllMileages() throws Exception {
	  public static List<Mileage>  findAllMileages() {
		    EntityManager emf = EMF.get().createEntityManager();
			//String retJson;
			//EntityManager cm = EMF.get().createEntityManager();
			List<Mileage> md = null;
//			EntityTransaction tx = MileageDataUtils.cm.getTransaction();
//			tx.begin();
//			Query query = MileageDataUtils.cm.createQuery("select m from Mileage m order by m.supplyDate DESC");
//			Query query = emf.createQuery("select m from Mileage m order by m.supplyDate DESC");
			Query query = emf.createNamedQuery("AllMileage");
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
				md = (List<Mileage>) query.getResultList();
//				retJson = "{supplyDetail : [";
//				for (int i = 0; i < md.size(); i++) {
//					retJson += String
//							.format("{supplyDate : '%s', quantity : %.2f, unitPrice : %d, "
//									+ "totalPrice : %d, bsMileage : %.1f, totalMileage : %.1f }",
//									md.get(i).getSupplyDate(), md.get(i)
//									.getQuantity().floatValue(), md.get(i)
//									.getUnitPrice(), md.get(i)
//									.getTotalPrice(), md.get(i)
//									.getBsMileage().floatValue(), md.get(i)
//									.getTotalMileage().floatValue());
//					if (i < md.size() - 1) {
//						retJson += ",";
//					}
//				}
//				retJson += "]}";
				log.info("RequestFactory MileageRequest findALLMileage(): counts=" + md.size() + ".");
//				tx.commit();
			} catch (IllegalStateException e) {
//				retJson = "{supplyDetail : []}";
//				//e.printStackTrace();
				log.severe("retrieve data error:" + e.toString());
//				tx.rollback();
//				throw e;
				//} finally {
				//cm.close();
			} finally {
				emf.close();
			}
			//return retJson;
			return md;
		}

	  public long getVersion() {
		return 28193440015135l; //"gwt2.8GAE1.9.34datanuclues4.0.0mysql5.1.35";  
	  }
	}
