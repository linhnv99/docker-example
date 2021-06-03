package com.example.demo_docker.anotation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        // initialize annotation do something
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber == null || phoneNumber.isEmpty()) return true;

        Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");

        return pattern.matcher(phoneNumber).matches();
    }
}