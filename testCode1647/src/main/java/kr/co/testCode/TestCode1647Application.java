package kr.co.testCode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TestCode1647Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestCode1647Application.class, args);
	}

	@Autowired ApplicationContext context;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		log.info("BBBB");
		
		List<String> list = new ArrayList();
		
		list.add("CCC");
		
		log.info("list = {}", list.get(0));
		
//		Corn<String> corn = new Corn();
//		corn.set("콘");
//		log.info(corn.get());
		
		Corn<String> corn = context.getBean("corn", Corn.class);
		corn.set("콘");
		log.info(corn.get());
		
		
		Corn<String> corn2 = context.getBean("corn", Corn.class);
		log.info(corn.get());
		
	//	net.logstash.logback.marker.Markers.append("myCustomField", "hello");
		
		log.info(net.logstash.logback.marker.Markers.append("myCustomField", "hello"), "add key to log json");
		
		log.info(net.logstash.logback.marker.Markers.append("myCustomField", 
				net.logstash.logback.marker.Markers.append("myCustomField2", "2")
				), "add key to log json");
		
	}

}
