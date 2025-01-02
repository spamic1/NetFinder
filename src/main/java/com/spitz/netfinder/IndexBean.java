package com.spitz.netfinder;

import com.spitz.netfinder.service.PersonService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class IndexBean {
    private String message= "Hello";
    @Inject
    PersonService personService;

 public String getMessage() {
   String firstName = "not found";

   try {
       firstName = personService.findPerson(1).getFirstname();
   }
   catch (Exception e) {
       message = e.getMessage();
   }
   return message + firstName;
 }
}