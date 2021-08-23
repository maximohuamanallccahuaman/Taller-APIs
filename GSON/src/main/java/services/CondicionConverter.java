package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "condicionConverter")
public class CondicionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    //ESTADO DE EXPEDIENTE M: MOVIDO A: ACEPTADO R: RECHAZADO C = EN CURSO
        //CONDICION DE EXPEDIENTE R: REVISION D: DERIVADO F:FINALIZADO 
        String condicion = null;
               if (value != null) {
            condicion = (String) value;
            switch (condicion) {
                case "R":

                    condicion = "Revisión";
                    break;
                case "D":

                    condicion = "Derivado";
                    break;
                case "F":

                    condicion = "Finalizado";
                    break;
                 case "E":

                    condicion = "Devuelto";
                    break;    
               
            }
        }
        return condicion;
    }
    

   

}
