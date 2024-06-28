package com.mycompany.FirebaseEjercicio;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;

public class PlantFuncionarios {
    
    CollectionReference reference;
    
    static Firestore db;
    
    public static boolean Guardar(String coleccion, String documento, Map<String, Object > data ){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado corectamente ");
            return true;
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return false;
    }
    
     public static boolean Actualizar(String coleccion, String documento, Map<String, Object > data ){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println("Actualizado corectamente ");
            return true;
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return false;
    }
     public static boolean Eliminar(String coleccion, String documento){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminado corectamente ");
            return true;
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return false;
    }
     public static boolean Consultar(String coleccion, String documento, Map<String, Object > data ){
        db = FirestoreClient.getFirestore();
        
        try{
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                data.putAll(document.getData());
                System.out.println("Datos obtenidos correctamente: " + document.getData());
                return true;
            } else {
                System.out.println("No se encontró el documento");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
     }
}

