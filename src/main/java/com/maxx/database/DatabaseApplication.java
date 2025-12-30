package com.maxx.database;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.spring.autoconfigure.firestore.GcpFirestoreAutoConfiguration;
import com.maxx.database.configs.FireBaseConfig;
import com.maxx.database.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
@RequiredArgsConstructor
@SpringBootApplication
public class DatabaseApplication {
	private UserInfoService userInfoService;


    public static void main(String[] args) {

		SpringApplication.run(DatabaseApplication.class, args)	;



	}

}
