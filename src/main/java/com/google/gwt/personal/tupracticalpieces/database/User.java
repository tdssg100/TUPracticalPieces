package com.google.gwt.personal.tupracticalpieces.database;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.AttributeConverter;
import javax.persistence.Basic;
import javax.persistence.Table;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.persistence.Query;
import java.sql.Date;


@Entity

@NamedQueries( {
	@NamedQuery(name="AllUser", query="select u from User u order by u.name DESC"),
	@NamedQuery(name="LookUpUser", query="select u from User u where u.id = :id"),
	@NamedQuery(name="SearchDigest", query="select u.password from User u where u.name = :name")
	
})

@Table(name = "user")
public class User {

	private static final Logger log = Logger.getLogger(User.class.getName());
	
	  @Id //JPA
	  @GeneratedValue( strategy = GenerationType.IDENTITY )
	  @Column(name = "id")
	  private Long id;

	  @Column(name = "name") 
	  @NotNull
	  private String name;

	  @Basic //JPA
	  @NotNull
	  @Column(name = "password")
	  private String password;


	  public User() {
		  /* empty */
	  }
	  
	  public User(String name, String password) {
	      super();
	      this.name = name;
	      this.password = password;
	  }
	  	  
	  public String getName() {
		  return this.name;
	  }
	  
	  public String getPassword() {
		  return this.password;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }

	  public void setPassword(String password) {
		  this.password = password;
	  }
	  
	  public Long getId() {
		    return this.id;
		  }
	  
	  public static User findUser(Long id) {
	    return findEntity(id);
	  }
	  

	  public static User findEntity(Long id) {
		EntityManager emf = null;
		try {
			emf = EMF.get().createEntityManager();
			try {
				List<User> md = emf.createNamedQuery("LookUpUser")
					.setParameter("id", id.toString())
					.setFirstResult(0)
					.setMaxResults(1)
					.getResultList();
				return md.get(0);
			} catch (Exception e) {
				log.severe("findEntityerror: ");
				e.printStackTrace();	
				return new User();			
			}
		} catch (Exception e) {
			log.severe("findEntityerror: ");
			e.printStackTrace();
			return new User();			
		} finally {
			emf.close();
		}
		//return new User();
	  }

	  /**
	   * Persist this object in the data store.
	   */
	  public void persist() {
		EntityManager emf = null;
		try {
			emf = EMF.get().createEntityManager();
			try {
				emf.persist(this);
			} catch (Exception e) {
				log.severe("JPA persist error: ");
				e.printStackTrace();
			}
		} catch (Exception e) {
			log.severe("JPA persit EMF error: ");
			e.printStackTrace();	
			return;			
		} finally {
			emf.close();
		}
	  }
	  /**
	   * Remove this object in the data store.
	   */
	  public void remove() {
		EntityManager emf = null;
		try {
			emf = EMF.get().createEntityManager();
			try {
				User attached = emf.find(User.class, this.id);
				emf.remove(attached);
			} catch (Exception e) {
				log.severe("JPA remove  error: ");
				e.printStackTrace();
			}
		} catch (Exception e) {
			log.severe("JPA remove EMF error: ");
			e.printStackTrace();
		} finally {
				emf.close();
	  	}
	  }
	  /**
	   * Find all tasks for the current user.
	   */
	  @SuppressWarnings("unchecked")
	  public static User findUser(String name) {
		EntityManager emf = null;
		List<User> ud = null;
		try {
			emf = EMF.get().createEntityManager();
			try {
				ud = emf.createNamedQuery("LookUpUser")
					.setParameter("name", name)
					.setFirstResult(0)
					.setMaxResults(1)
					.getResultList();
				log.info("findUser(): counts=" + ud.size() + ".");
			} catch (Exception e) {
				log.severe("findUser error:");
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			log.severe("findUser error:");
			e.printStackTrace();
			return null;
		} finally {
			emf.close();
		}
		if (ud.size() == 0) {
			return null;
		}
		return ud.get(0);
	  }
	  /**
	   * Find all tasks for the current user.
	   */
	  @SuppressWarnings("unchecked")
	  public static List<User>  findAllUsers() {
		EntityManager emf = null;
		List<User> ud = null;
		try  {
			emf = EMF.get().createEntityManager();
			Query query = emf.createNamedQuery("AllMileage");
			try {
				ud = (List<User>) query.getResultList();
				log.info("findAllUsers(): counts=" + ud.size() + ".");
				return ud;
			} catch (Exception e) {
				log.severe("findAllUsers() error:");
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			log.severe("findAllUsers() error:");
			e.printStackTrace();
			return null;
		} finally {
			emf.close();
		}
		//return null;
	  }
	  /**
	   * Find digest the current user.
	   */
	  @SuppressWarnings("unchecked")
	  public static String findDigest(String name) {
		EntityManager emf = null;
		try {
			emf = EMF.get().createEntityManager();
			try {
				List<String> ud = emf.createNamedQuery("SearchDigest")
					.setParameter("name", name)
					.setFirstResult(0)
					.setMaxResults(1)
					.getResultList();
				return ud.get(0);
			} catch (Exception e) {
				log.severe("findDigest: ");
				 e.printStackTrace();
				return null;				
			}			
		} catch (Exception e) {
			log.severe("findDigest: ");
			e.printStackTrace();
			return null;				
		} finally {
			emf.close();
		}
		//return null;
	  }
	  
	  public long getVersion() {
		return 28193440015135l; //"gwt2.8GAE1.9.34datanuclues4.0.0mysql5.1.35";  
	  }
	}
