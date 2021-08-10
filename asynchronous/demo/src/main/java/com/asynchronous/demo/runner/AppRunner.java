package com.asynchronous.demo.runner;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.asynchronous.demo.model.User;
import com.asynchronous.demo.service.GitHubLookupService;

@Component
public class AppRunner {
	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final GitHubLookupService gitHubLookupService;

	public AppRunner(GitHubLookupService gitHubLookupService) {
		this.gitHubLookupService = gitHubLookupService;
	}

	public void run(String... args) throws Exception {
		// start the clock
		long start = System.currentTimeMillis();
		
		// kick of multiple, asynchronous lookups
		CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotSoftware");
		
		CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
		
		CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
		
		// wait until they are all done
		CompletableFuture.allOf(page1, page2, page3).join();
		
		// print results, including elapsed time
		logger.info("Elapsed time : " +
				(System.currentTimeMillis() - start));
		
		logger.info("--> " + page1.get());
		logger.info("--> " + page2.get());
		logger.info("--> " + page3.get());
	}
	
}
