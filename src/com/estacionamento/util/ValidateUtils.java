package com.estacionamento.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Daniel Souza de lima e-mail:daniesouza@gmail.com
 * 
 * Classe responsavel Validacoes Em GERAL
 *
 */
public class ValidateUtils {

	/**
	 * valida se o CEP digitado � VALIDO para realizar a Busca
	 * @param {@link String cep}
	 * @return  {@link Boolean} true para valido e false para invalido
	 * 	  
	 */
    public static boolean ValidaCepBrasil(String cep)
    {
    	String cepTest = cep.replace("-", "");
    	
    	if(cepTest.length() != 8){
    		return false;
    	}
 
        Pattern pattern = Pattern.compile("[0-9]{5}[0-9]{3}");
        Matcher matcher = pattern.matcher(cepTest);
 
        return  matcher.find();
    }
}
