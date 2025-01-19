package com.google.gwt.personal.tupracticalpieces.database;

import java.util.Properties;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//import com.google.appengine.api.utils.SystemProperty;

public final class EMF {
    private static final int singleton = 1;
    private static EntityManagerFactory emfInstance;
//     =   Persistence.createEntityManagerFactory("TUPPDB" );

    EMF() {
    	
//        <property name="jakarta.persistence.jdbc.driver" value="com.mysql.jdbc.GoogleDriver" />
//        <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://130.211.201.236/Trifle?useSSL%3Dfalse"/>
//        <property name="jakarta.persistence.jdbc.user" value="root" />
//        <property name="jakarta.persistence.jdbc.password" value="identmysql5656" />

//        <property name="jakarta.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
//        <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://192.168.3.3:3306/Trifle" />
//        <property name="jakarta.persistence.jdbc.user" value="tad" />
//        <property name="jakarta.persistence.jdbc.password" value="identmysql555" />
    	
    	
    	
    	
    	
//    	Properties props = new Properties();
//		
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			props.setProperty("jakarta.persistence.jdbc.driver","com.mysql.jdbc.GoogleDriver");
//			props.setProperty("jakarta.persistence.jdbc.url","jdbc:google:rdbms://tupracticalpieces:accumulation2/Trifle");
//			props.setProperty("jakarta.persistence.jdbc.user","root");
//			props.setProperty("jakarta.persistence.jdbc.password","identmysql5656");
//		} else {
//			props.setProperty("jakarta.persistence.jdbc.driver","com.mysql.jdbc.Driver");
//			props.setProperty("jakarta.persistence.jdbc.url","jdbc:mysql://192.168.3.3:3306/Trifle");
//			props.setProperty("jakarta.persistence.jdbc.user","tad");
//			props.setProperty("jakarta.persistence.jdbc.password","identmysql555");
////			props.setProperty("jakarta.persistence.jdbc.url","jdbc:mysql://192.168.3.3:3306/Trifle");
////			props.setProperty("jakarta.persistence.jdbc.user","root");
////			props.setProperty("jakarta.persistence.jdbc.password","identmysql5656");
//		}
//		emfInstance = Persistence.createEntityManagerFactory("TUPPDB", props);

    
		emfInstance = Persistence.createEntityManagerFactory("TUPPDB");
    
    
    
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}	

