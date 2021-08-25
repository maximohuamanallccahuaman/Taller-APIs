package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.Pais;
import services.APICovidS;

@Data
@Named(value = "paisC")
@SessionScoped
public class PaisC implements Serializable {

    Pais pais;

    public PaisC() {
        pais = new Pais();
    }

    public void buscarPAIS() {
        try {
            APICovidS.buscarPais(pais);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "PAIS no encontrado"));
            System.out.println("error en Busqueda de PAIS" + e.getMessage());
        }
    }

}
