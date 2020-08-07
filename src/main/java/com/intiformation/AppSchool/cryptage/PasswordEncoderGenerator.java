package com.intiformation.AppSchool.cryptage;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * permet de crypter le MdP utilisation de la classe spring security
 * "BcryptPasswordEncoder" pour le cryptage
 * 
 * @author anais
 *
 */
public class PasswordEncoderGenerator {

	public static String cryptageMdP(String MOT_DE_PASSE) {

		// objet pour le cryptage
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// cryptage du MdP avec la methode encode()
		String hashedMotDePasse = passwordEncoder.encode(MOT_DE_PASSE);

		// affichage du mot de passe crypté
		System.out.println("Mot de passe crypté :" + hashedMotDePasse);

		return hashedMotDePasse;

	}// end cryptageMdP

	

}// end class
