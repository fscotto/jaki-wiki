/*
 * Copyright 2016 Fabio Scotto di Santolo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.jee_book.jakiwiki.integration.mail;

import it.jee_book.jakiwiki.model.Pagina;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Fabio Scotto di Santolo
 */
@Stateless
public class EmailIntegratorImplementation implements EmailIntegrator {

    public void sendEmail(String mittente, String destinatario, String commento, Pagina pagina) {
        Properties prop = new Properties();

        Authenticator auth = new PasswordAuthenticator();
        Session session = Session.getDefaultInstance(prop, auth);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(mittente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(pagina.getTitolo());
            message.setText(pagina.getContenuto());
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class PasswordAuthenticator extends Authenticator {

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("utente", "password");
        }

    }

}
