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

public Users something() throws ExecutionException, InterruptedException {
  var docRef = firestore.collection("users").document("demo2");
  var future = docRef.get();
  var snapShot = future.get();

  if(snapShot.exists()){
    return snapShot.toObject(Users.class);
  }else {
    return null;
  }
}


public String create(@NonNull final UserCreationDTO userCreationDTO){
    final var user = new Users();
    user.setAge(userCreationDTO.getAge());
    user.setGoal(userCreationDTO.getGoal());
    user.setGender(userCreationDTO.getGender());
    user.setPreferredName(userCreationDTO.getPreferredName());

  try{
    DocumentReference documentReference = firestore.collection("users").add(user).get();
    return  documentReference.getId();
  } catch (ExecutionException  | InterruptedException e) {
    throw new RuntimeException();
  }

}
}

