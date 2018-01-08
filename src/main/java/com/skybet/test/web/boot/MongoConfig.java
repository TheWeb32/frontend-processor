package com.skybet.test.web.boot;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.skybet.test.errors.ConfigException;

@Configuration
@ComponentScan({"com.skybet.test.web.repository", "com.skybet.test.web.controller"})
public class MongoConfig extends AbstractMongoConfiguration {
	
	private static Logger log = Logger.getLogger(MongoConfig.class.getCanonicalName());
	
    @Override
    protected String getDatabaseName() {
        return "skybet";
    }

    @Override
    public Mongo mongo() throws Exception {
    	try {
        	String host = System.getenv("REACTJS_HOST_DB");
        	Integer port = Integer.parseInt(System.getenv("REACTJS_HOST_PORT"));
        	log.log(Level.INFO, "Setted as MongoDB address: " + host + ":" + port);
            return new MongoClient(host, port);
    	}catch (Exception e) {
    		throw new ConfigException("Env vars REACTJS_HOST_DB or REACTJS_HOST_PORT not present", e);
		}
    }
    
}
