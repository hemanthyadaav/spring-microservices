package com.springboot.microservices.socialmedia.models;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private long id;

   @Size(min = 2, max = 20, message = "Size should be between 2 and 20")
   private String userName;

   @PastOrPresent(message = "Birth Date cannot be from the future")
   private LocalDate birthDate;
}
