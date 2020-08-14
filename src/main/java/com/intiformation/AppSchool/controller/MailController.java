package com.intiformation.AppSchool.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Mail;

@Controller
public class MailController {
	
	private final static String MAILER_VERSION = "Java";

	@RequestMapping(value = "/mail/send-mail-form", method = RequestMethod.GET)
	public ModelAndView AfficherFormulaireMailSTMP() {

		Mail mail = new Mail();
		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Mail", "mailToSend", mail);

	}// end AfficherFormulaireMailSTMP()
	

	@RequestMapping(value = "mail/send", method = RequestMethod.POST)
	public String envoyerMailSMTP(@ModelAttribute("mailToSend") Mail pMail) {
		String username = "superschoolinti@gmail.com"; // adresse mail GMAIL
		String password = "SuperSchool123"; // mot de passe 

			// Etape 1 : Création de la session
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.port","587");
			Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
			try {
				// Etape 2 : Création de l'objet Message
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(username));
				message.setSubject(pMail.getSubject());
				message.setText(pMail.getContent());
				// Etape 3 : Envoyer le message
				Transport.send(message);
				System.out.println("Message_envoye");
				return "redirect:/etudiant/liste";
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return "redirect:../index.jsp";
	
	}// end envoyerMailSMTP()


}// end class
