package com.ers.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Looks ups and cache the ERS Database
 * @author bcant
 *
 */
public class ServiceLocator {
	private static DataSource ers;
	private static Properties env;
	
	// Load properties from application.properties in env
	static{
		InputStream stream = ServiceLocator.class.getClassLoader()
							.getResourceAsStream("jndi.properties");
		env = new Properties();
		
		try{
			env.load(stream);	
		}catch(IOException e) {}
	}
	
	public synchronized static DataSource getErsDatabase(){
		if( ers == null )
			ers = lookupErs();
		
		return ers;
	}
	
	// Find the data source from the application.properties file
	private static DataSource lookupErs(){
		try{
			Context ctxt = new InitialContext();
			DataSource ds = (DataSource) ctxt.lookup(env.getProperty("ersdb"));
			return ds;
		}catch(NamingException e){
			e.printStackTrace();
			return null;
		}
	}
}
