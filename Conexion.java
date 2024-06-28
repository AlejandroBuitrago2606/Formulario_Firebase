package com.mycompany.FirebaseEjercicio;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class Conexion {

    public static Firestore db;

    public static void ConectarFirebase() {
        try {
            FileInputStream fl = new FileInputStream("firebase.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(fl))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Exito al conectar");
        } catch (IOException e) {
            System.err.println("Error:" + e.getMessage());
        }

    }

}
