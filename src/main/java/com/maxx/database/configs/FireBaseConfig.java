package com.maxx.database.configs;

import com.google.auth.oauth2.GoogleCredentials;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
      // Need to Send to Everyone
        InputStream serviceAccount = new ClassPathResource("maxx-backendmem-firebase-adminsdk-fbsvc-6c60ce164f.json").getInputStream();

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            System.out.println("Making New App");
            return  FirebaseApp.initializeApp(options);
        }else {
            return  FirebaseApp.getInstance();
        }
    }

    @Bean
    public Firestore firestore(FirebaseApp firebaseApp) {
        System.out.println("Creating DataBase bean");
        return FirestoreClient.getFirestore(firebaseApp);
    }
}
