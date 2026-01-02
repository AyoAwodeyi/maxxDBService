package com.maxx.database.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.maxx.database.DTO.UserCreationDTO;
import com.maxx.database.models.Users;
import org.springframework.stereotype.Service;
import  lombok.*;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
public class UserInfoService {
private  final Firestore   firestore;

public void something() throws ExecutionException, InterruptedException {
  var docRef = firestore.collection("users");
  var future = docRef.get();
  var snapShot = future.get();
  System.out.println(snapShot);


}


public String create(@NonNull final UserCreationDTO userCreationDTO){
    final var user = new Users();
    user.setAge(userCreationDTO.getAge());
    user.setGoal(userCreationDTO.getGoal());
    user.setGender(userCreationDTO.getGender());
    user.setPreferredName(userCreationDTO.getPreferredName());
    user.setUID(userCreationDTO.getUID());


  try{
    DocumentReference documentReference = firestore.collection("users").add(user).get();
    return  documentReference.getId();
  } catch (ExecutionException  | InterruptedException e) {
    throw new RuntimeException();
  }

}
}

