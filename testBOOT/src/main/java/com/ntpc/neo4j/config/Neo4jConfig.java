package com.ntpc.neo4j.config;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.ntpc.neo4j.repository")
@EnableTransactionManagement
//@ComponentScan("com.ntpc.neo4j")
public class Neo4jConfig extends Neo4jConfiguration {
	
	@Autowired Environment env;

    @Override
    public SessionFactory getSessionFactory() {
    	
        return new SessionFactory("com.ntpc.neo4j.domain");
    }

    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://neo4j:compaq123@localhost:7474");
    }

    
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }

}
