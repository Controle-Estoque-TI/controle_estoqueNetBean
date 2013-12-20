/**
 * ESTA É A CLASSE ABSTRATA  QUE CONTERÁ O BÁSICO PARA EFETUAR 
 * UMA CRIPTOGRAFIA CONTUDO ESSA CLASSE NÃO SERÁ RESPONSAVEL POR
 * DETERMINAR QUAL O TIPO DE ALGORITIMO QUE SERÁ UTILIZADO O METODO
 * A SER ESCOLHIDO DEVE SER IMPLEMENTADO NA CLASSE DESTINO COM A ASSINATURA
 * DA INTERFACE.
 */
package br.smagp.controle.estoque_ti.cryptonita;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import sun.misc.BASE64Encoder;


/**
 * @author AllexOnRails
 *
 */
public abstract class CryptographyGeneric{

    /**
     * 
     */
	
    private MessageDigest messageDigest;
    private BASE64Encoder encoder;

    public CryptographyGeneric() { /* TODO Auto-generated constructor stub */ }
	
    protected void useAlgorithm(String algorithm) throws NoSuchAlgorithmException {
        if (messageDigest == null || messageDigest.getAlgorithm() != algorithm)	{
                messageDigest = MessageDigest.getInstance(algorithm);
        }

        if (encoder == null){
                encoder = new BASE64Encoder(); 
        }
    }
	
    protected String encryptedByAlgorithm(String algorithm, String value) throws NoSuchAlgorithmException{
        if (value == null){
                throw new IllegalArgumentException("Este é um valor nulo!");
        }

        useAlgorithm(algorithm);

        byte[] hash = messageDigest.digest(value.getBytes());
        return encoder.encode(hash);
    }
}