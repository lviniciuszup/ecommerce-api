package com.zup.ecommerce.services;

import java.util.regex.Pattern;

public class CpfValidator {

    private static final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    // Valida o formato do cpf
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
        // Verifica se tem numeros iguais
        if (cpf.matches("(.)\\1{10}")) {
            return false;
        }
        return true;
    }

    //Metodo que valida o CPF
    public static boolean isValid(String cpf) {
        //Primeiro se o formato e valido
        if (!isValidFormat(cpf)) {
            return false;
        }
        // Agora os digitos do cpf
        return isValidCpfDigits(cpf);
    }



}
