package com.zup.ecommerce.services;

import java.util.regex.Pattern;

public class CpfValidator {

    private static final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    private static boolean isValidFormat(String cpf) {
        if (cpf == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(CPF_REGEX);
        return pattern.matcher(cpf).matches();
    }

    private static boolean isValidCpfDigits(String cpf) {
        if (cpf.length() != 14) {
            return false;
        }
        if (cpf.matches("(.)\\1{10}")) {
            return false;
        }
        return true;
    }

    public static boolean isValid(String cpf) {
        if (!isValidFormat(cpf)) {
            return false;
        }
        return isValidCpfDigits(cpf);
    }



}
