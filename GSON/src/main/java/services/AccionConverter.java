/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "accionConverter")
public class AccionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //ESTADO DE EXPEDIENTE M: MOVIDO A: ACEPTADO R: RECHAZADO C = EN CURSO
        //CONDICION DE EXPEDIENTE R: REVISION D: DERIVADO F:FINALIZADO 
        String accion = null;
        if (value != null) {
            accion = (String) value;
            switch (accion) {
                case "M":

                    accion = "Trasladado";
                    break;
                case "A":

                    accion = "Aceptado";
                    break;
                case "C":

                    accion = "En curso";
                    break;
                case "R":

                    accion = "Rechazado";
                    break;
                case "T":

                    accion = "Terminado";
                    break;
            }
        }
        return accion;
    }

}
