package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "dfView")
public class DFView {

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life",
				"Echoes in eternity.");

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}