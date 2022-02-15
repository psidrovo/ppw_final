package ec.edu.ups.ppw_final.ppw_final.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class ConfirmView {

	/**
	 * Este metodo se utiliza para confirmar si un procedimiento se realizo correctamente o no
	 */
    public void confirm() {
        addMessage("Confirmed", "You have accepted");
    }

    /**
     * este metodo se utiliza para confirmar se se ha 
     * eliminado correctamente
     */
    public void delete() {
        addMessage("Confirmed", "Record deleted");
    }

    /**
     * este metodo se utiliza para poder urilizarlo y crear un mensaje de informacion. recibe 
     * dos objetos en su parametro de tipo String.
     * @param summary
     * @param detail
     */
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}