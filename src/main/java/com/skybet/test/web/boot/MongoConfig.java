package com.skybet.test.web.boot;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
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
        	String host = System.getenv("MONGODB_HOST");
        	Integer port = Integer.parseInt(System.getenv("MONGODB_PORT"));
        	log.log(Level.INFO, "Setted as MongoDB address: " + host + ":" + port);
    		MongoCredential credential = MongoCredential.createScramSha1Credential(System.getenv("MONGODB_USER"), System.getenv("MONGODB_DB"), System.getenv("MONGODB_PASS").toCharArray());
    		MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
    		optionsBuilder.maxWaitTime(Integer.MAX_VALUE);
    		optionsBuilder.connectTimeout(Integer.MAX_VALUE);
    		optionsBuilder.socketTimeout(Integer.MAX_VALUE);
    		MongoClientOptions options = optionsBuilder.build();
    		return new MongoClient(new ServerAddress(host, port), Arrays.asList(credential), options);
    	}catch (Exception e) {
    		throw new ConfigException("Env vars REACTJS_HOST_DB or REACTJS_HOST_PORT not present", e);
		}
    }
    
}
