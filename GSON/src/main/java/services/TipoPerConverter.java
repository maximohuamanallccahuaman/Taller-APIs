package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoperConverter")
public class TipoPerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String tiper = "";
        if (value != null) {
            tiper = (String) value;
            switch (tiper) {
                case "J":
                    tiper = "Persona Juridica";
                    break;
                case "F":
                    tiper = "Funcionario";
                    break;
                case "C":
                    tiper = "Colaborador";
                    break;
                case "A":
                    tiper = "Administrador";
                    break;
                case "N":
                    tiper = "Persona Natural";
                    break;
                default:
                    tiper = "Hacker";
            }
        }
        return tiper;
    }

}
