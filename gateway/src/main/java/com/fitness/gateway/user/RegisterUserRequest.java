package com.fitness.gateway.user;

import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.text.ParseException;

@Builder
public record RegisterUserRequest(
        @Email(message = "Invalid Email Format")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8,message = "Password must have AtLeast 8 Character")
        String password,

        String keycloakId,

        @NotBlank(message = "First Name is required")
        String firstname,

        @NotBlank(message = "Last Name is required")
        String lastname
) {
    public static RegisterUserRequest claimsToRequest(JWTClaimsSet claimsSet){
        try {
            return RegisterUserRequest.builder()
                    .email(claimsSet.getStringClaim("email"))
                    .keycloakId(claimsSet.getClaimAsString("sub"))
                    .lastname(claimsSet.getClaimAsString("family_name"))
                    .password("mustaali")
                    .firstname(claimsSet.getClaimAsString("given_name"))
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
