package sdgihdgf.espoltrek.models;

import java.io.Serializable;
import java.util.ArrayList;



public class Lugar implements Serializable {

    private float lat, lng;
    private String nombre, descripcion;
    private ArrayList<String> tags;

    public Lugar(float lat, float lng, String nombre, String descripcion, ArrayList<String> tags) {
        this.lat = lat;
        this.lng = lng;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tags = tags;
    }

    public Lugar() {
        this.lat = 0.0f;
        this.lng = 0.0f;
        this.nombre = null;
        this.descripcion = null;
        this.tags = null;

    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }


}
