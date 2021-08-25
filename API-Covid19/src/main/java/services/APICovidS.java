package services;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Pais;

public class APICovidS {

    public static void buscarPais(Pais pas) throws Exception {
        String pais = pas.getPais();
//        String token = "3ecfdf9f85737cfa6b154f24a0bbe2462362b0324965eb9f45ef73cbd310f5f5";
        String enlace = "https://covid-api.mmediagroup.fr/v1/cases?country/" + pais;
        try {
            URL url = new URL(enlace);
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            if (root.isJsonObject()) {
                JsonObject rootobj = root.getAsJsonObject();
//                String Confirmado = rootobj.get("confirmado").getAsString();
//                String Recuperado = rootobj.get("recuperado").getAsString();
//                String Muerto = rootobj.get("muerto").getAsString();
                String country = rootobj.get("pais").getAsString();
//                String Poblacion = rootobj.get("poblacion").getAsString();
//                String Area = rootobj.get("area").getAsString();
//                String Vida = rootobj.get("vida").getAsString();
//                String Mar = rootobj.get("mar").getAsString();
                String continent = rootobj.get("continente").getAsString();
//                String Abreviatura = rootobj.get("abreviatura").getAsString();
//                String Locacion = rootobj.get("locacion").getAsString();
//                String Capital = rootobj.get("capital").getAsString();

                System.out.println("Resultado\n");
                System.out.println(country + "\n" + continent);

//                pas.setConfirmado(Confirmado);
//                pas.setRecuperado(Recuperado);
//                pas.setMuerto(Muerto);
                pas.setPais(country);
//                pas.setPoblacion(Poblacion);
//                pas.setArea(Area);
//                pas.setVida(Vida);
//                pas.setMar(Mar);
                pas.setContinente(continent);
//                pas.setAbreviatura(Abreviatura);
//                pas.setLocacion(Locacion);
//                pas.setCapital(Capital);
            }
        } catch (JsonIOException | JsonSyntaxException | IOException ex) {
            System.out.println(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "PAIS no encontrado"));
        }
    }

    public static void main(String[] args) throws Exception {
        Pais pas = new Pais();
        pas.setPais("Peru");
        buscarPais(pas);
    }
}
