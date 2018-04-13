package com.demo.bankapp.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PSCodeConstraintValidator implements ConstraintValidator<PSCode, String> {

    private String codePrefix;

   public void initialize(PSCode code) {
       codePrefix = code.value();
   }

   public boolean isValid(String code, ConstraintValidatorContext context) {

       boolean result = true;

       if (code != null) {
           result = code.startsWith(codePrefix);
       }

      return result;
   }
}
