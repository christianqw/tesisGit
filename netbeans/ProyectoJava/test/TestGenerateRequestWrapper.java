/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import serverPackages.*;

/**
 *
 * @author Chris
 */
public final class TestGenerateRequestWrapper {
    
    private static String getString () {
        /*
        para testear emulamos el mensaje que manda la web al server, a partir de este,
        se genera la instancia de modelo a evaluar. 
        */
        String s;
        s = "{\n" +
"                  \"elements\":[\n" +
"                    {\"tipo\":\"tipo1\",\"dominio\":\"animal\",\"att1\":\"Chico\",\"att2\":\"Despierto\",\"nombre\":\"e1\",\"zona\":\"bosque\",\"img\":\"images/icon_chancho.png\",\"left\":62,\"top\":146,\"id\":\"1327578c-34d4-8c0c-95b5-2fea3670c64d\"},\n" +
"                    {\"tipo\":\"tipo3\",\"dominio\":\"animal\",\"att1\":\"Chico\",\"att2\":\"Despierto\",\"nombre\":\"e2\",\"zona\":\"bosque\",\"img\":\"images/icon_pato.png\",\"left\":205,\"top\":140,\"id\":\"d22f5b75-eff1-ff50-0f4c-8497aa3f8870\"}\n" +
"                            ],\n" +
"                  \"sentens\": [\n" +
"                    {\"nombre\":\"form_X\",\"valor\":\"@ x (Asd(x)  | Despierto (x))\",\"estado\":\"\",\"mensaje\":\"\",\"id\":\"2a2beaa5-8513-bd27-ea29-b150247a4f1f\"},\n" +
                       " {\"nombre\":\"form_01\",\"valor\":\"@ x (Asd(e1)  | Despierto (x))\",\"estado\":\"\",\"mensaje\":\"\",\"id\":\"2a2beaa5-8513-bd27-ea29-b150247a4f1f\"},\n" +
"                    {\"nombre\":\"form_02\",\"valor\":\"@ x (Dormido(x)  | Despierto (x))\",\"estado\":\"\",\"mensaje\":\"\",\"id\":\"afc8524b-51d9-3ef9-2d9b-e8b265b2a1c0\"}\n" +
"                  ]\n" +
"                }"; 
        return s;
    }
    
    private  static ElementoPost getE(JSONObject j){
        ElementoPost e = new ElementoPost();
        //seteamos;
        
        e.setAtt1((String) j.get("att1"));
        e.setAtt2((String) j.get("att2"));
        e.setId((String) j.get("id"));
        e.setImg((String) j.get("img"));
        e.setLeft(((Long)j.get("left")).intValue());
        e.setNombre((String) j.get("nombre"));
        e.setDominio((String) j.get("dominio"));
        e.setTipo((String) j.get("tipo"));
        e.setTop(((Long)j.get("top")).intValue());
        e.setZona((String) j.get("zona"));
        
        return e;
    }
    
    private static Sentencia getS(JSONObject j){
        Sentencia s = new  Sentencia();
        
        //seteamos;
        s.setEstado((String) j.get("estado"));
        s.setId((String) j.get("id"));
        s.setMensaje((String) j.get("mensaje"));
        s.setNombre((String) j.get("nombre"));
        s.setValor((String) j.get("valor")); 
        
        return s;
    }
    
    public static RequestWrapper getFalsoPost () throws ParseException{
        String mensaje = getString();
        
        RequestWrapper rw = new RequestWrapper();
        List<ElementoPost> listE = new ArrayList<>();
        List<Sentencia> listS = new ArrayList<>();
        
        JSONParser p = new JSONParser(); 
        JSONObject objJson = (JSONObject) p.parse(mensaje);
        
        JSONArray arrE;
        arrE = (JSONArray) objJson.get("elements");
        arrE.stream().forEach(( arrE1) -> {
            listE.add(getE((JSONObject) arrE1));
        });
        
        JSONArray arrS = (JSONArray) objJson.get("sentens");
        arrS.stream().forEach(( arrS1) -> {
            listS.add(getS((JSONObject) arrS1));
        });
    
        rw.setListaE(listE);
        rw.setListaS(listS);
        
        return rw;
    }

}
