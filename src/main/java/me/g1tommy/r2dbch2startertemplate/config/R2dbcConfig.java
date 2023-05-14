package me.g1tommy.r2dbch2startertemplate.config;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing
@Slf4j
public class R2dbcConfig {

	private Server webServer;

	@EventListener(ContextRefreshedEvent.class)
	public void start() throws SQLException {
		log.info("starting h2 console at port 8081");
		this.webServer = Server.createWebServer("-webPort", "8081", "-tcpAllowOthers").start();
	}

	@EventListener(ContextClosedEvent.class)
	public void stop() {
		log.info("stopping h2 console at port 8081");
		this.webServer.stop();
	}
}
