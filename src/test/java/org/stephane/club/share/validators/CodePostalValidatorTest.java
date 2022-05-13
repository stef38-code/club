package org.stephane.club.share.validators;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.BDDAssertions.then;

@DisplayName("Test du Validator de code postal")
class CodePostalValidatorTest {
    ValidatorFactory factory;
    Validator validator;


    @BeforeEach
    void setUp() {
        //
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Quand le code postal est vide")
    void codePostal_Est_Non_Valide_Quand_Il_contient_Vide() {
        MyClass bean = new MyClass();
        bean.setValue("");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Quand le code postal contient 1c")
    void codePostal_Est_Non_Valide_Quand_Il_contient_1c() {
        MyClass bean = new MyClass();
        bean.setValue("1");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Quand le code postal contient 3c")
    void codePostal_Est_Non_Valide_Quand_Il_contient_3c() {
        MyClass bean = new MyClass();
        bean.setValue("1aé");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Quand le code postal contient 6c")
    void codePostal_Est_Non_Valide_Quand_Il_contient_6c() {
        MyClass bean = new MyClass();
        bean.setValue("123456");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Quand le code postal ne contient pas de chiffre")
    void codePostal_Est_Non_Valide_Quand_Il_contient_pas_chiffres() {
        MyClass bean = new MyClass();
        bean.setValue("EAZRT");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Quand le code postal contient de alpha numéric")
    void codePostal_Est_Non_Valide_Quand_Il_contient_AlphaNumeric() {
        MyClass bean = new MyClass();
        bean.setValue("38ERTY");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSizeGreaterThan(0);
    }

    /**
     * Method under test: {@link CodePostalValidator#isValid(String, javax.validation.ConstraintValidatorContext)}
     */
    @Test
    @DisplayName("Quand un vrai code postal  ")
    void codePostal_Est_Valide_Quand_Il_correcte() {
        MyClass bean = new MyClass();
        bean.setValue("38160");
        Set<ConstraintViolation<MyClass>> constraintViolations = validator.validate(bean);
        then(constraintViolations).hasSize(0);
    }


    private class MyClass {
        @CodePostal
        @Getter
        @Setter
        private String value;

    }
}

