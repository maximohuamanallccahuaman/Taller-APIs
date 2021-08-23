
package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String tipo = "";
        if (tipo != null) {
            tipo = (String)value;
            switch (tipo) {
                case "C":
                        tipo = "Colaborador";
                    break;            
                case "A":
                        tipo = "Administrador";
                    break;          
                default:
                    throw new AssertionError();
            }
        }
        return tipo;
        
       }
    
}
