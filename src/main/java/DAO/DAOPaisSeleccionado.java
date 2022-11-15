/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Pais;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author dcc_s
 */
public class DAOPaisSeleccionado {

    public Pais getByName(String localePais) throws FileNotFoundException, IOException {
        
        //DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(codigo[0]));
        StringBuilder ficheroPath = new StringBuilder();
        ficheroPath.append("diccionario/").append(localePais).append(".properties");
        Properties prop = accederArchivoTraductor(ficheroPath.toString());
        Pais paisSeleccionado = null;
        if (!prop.isEmpty()) {
            paisSeleccionado = new Pais();
            paisSeleccionado.setNombre(prop.getProperty("nombre"));
            paisSeleccionado.setCodigo(localePais);
            paisSeleccionado.setHusosHorarios(prop.getProperty("husosHorarios"));
            paisSeleccionado.setSaludo(prop.getProperty("saludo"));
            paisSeleccionado.setDespedida(prop.getProperty("despedida"));
            paisSeleccionado.setGmt(establecerZonaHoraria(localePais));
        }

        return paisSeleccionado;
    }

    public Properties accederArchivoTraductor(String path) throws FileNotFoundException, IOException {
        URL uri = getClass().getClassLoader().getResource(path);
        Properties prop = new Properties();
        if (uri != null) {
            prop.load(new FileInputStream(uri.getFile()));
        }
        return prop;
    }

    public String establecerZonaHoraria(String codigo) throws FileNotFoundException, IOException {
        URL uri = getClass().getClassLoader().getResource("gmt/gmt.properties");
        Properties prop = new Properties();
        prop.load(new FileInputStream(uri.getFile()));
        String gmt = prop.getProperty(codigo);
        return gmt;
    }
}

