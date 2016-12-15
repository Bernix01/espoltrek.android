package sdgihdgf.espoltrek.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;



public class Lugar implements Parcelable {

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

    protected Lugar(Parcel in) {
        lat = in.readFloat();
        lng = in.readFloat();
        nombre = in.readString();
        descripcion = in.readString();
        tags = in.createStringArrayList();
    }

    public static final Creator<Lugar> CREATOR = new Creator<Lugar>() {
        @Override
        public Lugar createFromParcel(Parcel in) {
            return new Lugar(in);
        }

        @Override
        public Lugar[] newArray(int size) {
            return new Lugar[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(lat);
        parcel.writeFloat(lng);
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeStringList(tags);
    }
}
