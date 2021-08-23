package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "estadoConverter")
public class estadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String estado = "";
        if (value != null) {
            estado = (String) value;
            switch (estado) {
                case "R":

                    estado = "Revisado";
                    break;
                case "A":

                    estado = "Ayuda";
                    break;
                case "F":

                    estado = "Finalizado";
                    break;
                case "P":

                    estado = "Pendiente";
                    break;
                case "E":
                    estado = "Emitido";
                    break;
                case "C":
                    estado = "Concluido";
                    break;
                default:
                    estado = "Se ha colado";
            }
        }
        return estado;
    }

}
