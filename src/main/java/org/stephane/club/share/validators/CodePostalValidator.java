package org.stephane.club.share.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class CodePostalValidator implements ConstraintValidator<CodePostal,String> {
    @Override
    public void initialize(CodePostal constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return ! (value.isBlank() || value.length() != 5 || ! isNumeric(value)) ;
    }
}
