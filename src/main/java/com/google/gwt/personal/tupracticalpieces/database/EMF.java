package com.google.gwt.personal.tupracticalpieces.database;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.google.appengine.api.utils.SystemProperty;

public final class EMF {
    private static final int singleton = 1;
    private static EntityManagerFactory emfInstance;
//     =   Persistence.createEntityManagerFactory("TUPPDB" );

    EMF() {
    	
//        <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.GoogleDriver" />
//        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://130.211.201.236/Trifle?useSSL%3Dfalse"/>
//        <property name="javax.persistence.jdbc.user" value="root" />
//        <property name="javax.persistence.jdbc.password" value="identmysql5656" />

//        <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
//        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://192.168.3.3:3306/Trifle" />
//        <property name="javax.persistence.jdbc.user" value="tad" />
//        <property name="javax.persistence.jdbc.password" value="identmysql555" />
    	
    	
    	
    	
    	
//    	Properties props = new Properties();
//		
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			props.setProperty("javax.persistence.jdbc.driver","com.mysql.jdbc.GoogleDriver");
//			props.setProperty("javax.persistence.jdbc.url","jdbc:google:rdbms://tupracticalpieces:accumulation2/Trifle");
//			props.setProperty("javax.persistence.jdbc.user","root");
//			props.setProperty("javax.persistence.jdbc.password","identmysql5656");
//		} else {
//			props.setProperty("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
//			props.setProperty("javax.persistence.jdbc.url","jdbc:mysql://192.168.3.3:3306/Trifle");
//			props.setProperty("javax.persistence.jdbc.user","tad");
//			props.setProperty("javax.persistence.jdbc.password","identmysql555");
////			props.setProperty("javax.persistence.jdbc.url","jdbc:mysql://192.168.3.3:3306/Trifle");
////			props.setProperty("javax.persistence.jdbc.user","root");
////			props.setProperty("javax.persistence.jdbc.password","identmysql5656");
//		}
//		emfInstance = Persistence.createEntityManagerFactory("TUPPDB", props);

    
		emfInstance = Persistence.createEntityManagerFactory("TUPPDB");
    
    
    
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}	

