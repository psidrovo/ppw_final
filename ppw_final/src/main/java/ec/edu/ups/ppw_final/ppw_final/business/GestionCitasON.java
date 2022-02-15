package ec.edu.ups.ppw_final.ppw_final.business;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ec.edu.ups.ppw_final.ppw_final.controlador.ControladorCitas;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsCita;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsPersona;
import ec.edu.ups.ppw_final.ppw_final.modelo.OsUsuario;


@Stateless
public class GestionCitasON {

	/**
	 * se inicializa el controlador Citas para poder realizar las gestiones dentro de la base de datos.
	 * 
	 */
	@Inject
	private ControladorCitas controladorC;
	
	/**
	 * este metodo recibe un objeto de tipo cita y pregunta dentro de la base de datos si es que existe.
	 * en caso de que exista solamente actualiza caso contrario crea uno nuevo.
	 * @param cita.
	 */
	public void guardarCita(OsCita cita) {
		OsCita u = controladorC.read(cita.getCtId());
		if(u==null) {
			controladorC.insert(cita);
			System.out.println("cita guardado con exito");
		}else {
			controladorC.update(cita);
			System.out.println("cita actualizado con exito");
		}
	}
	
	/**
	 * Este metodo elimina un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 */
	public void delete(int id) {
		controladorC.delete(id);
	}
	
	/**
	 * Este metodo busca un objeto dentro de la base de datos por medio 
	 * de la llave primaria
	 * @param id
	 * @return OsCita
	 */
	public OsCita read(int id) {
		return controladorC.read(id);
	}
	
	/**
	 * Este metodo devuele todo el listado de citas dentro de la base de datos.
	 * @return List<OsCita>
	 */
	public List<OsCita> findAll(){
		return controladorC.findAll();
	}

	public void enviarCorreo(OsCita cita, OsPersona persona, OsUsuario usuario) {

        String asunto = "Cita Odontologica";
        String mensa = "";
        String cuerpo = "Estimado " + persona.getPerNombre() + " " +persona.getPerApellido()+ " le recordamos que tiene una cita dental el dia " + cita.getCtFecha()
                +"\nSaludos Cordiales\nOdontologia OdontSoft";
   
        String remitente = "bioanaliselabora@gmail.com";
        String clave = "bio-analise2019";
        enviarConGMail(remitente, clave, usuario.getUsCorreo(), asunto, cuerpo);
		
	}
	
	private void enviarConGMail(String remitente, String clave, String destinatario, String asunto, String cuerpo) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            MimeMultipart multiParte = new MimeMultipart();

            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);
            multiParte.addBodyPart(texto);
           
                message.setContent(multiParte);
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, clave);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            
        } catch (MessagingException me) {
            System.out.println("ERROR al Enviar");
            System.err.println(me);
            me.printStackTrace();   //Si se produce un error
        }
	}
}
