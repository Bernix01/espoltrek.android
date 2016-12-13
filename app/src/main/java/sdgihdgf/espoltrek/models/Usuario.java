package sdgihdgf.espoltrek.models;

/**
 * Created by belen on 28/11/16.
 */

public class Usuario {
    private final String email;
    private String nombres,apellidos,nickname,contrasenia;
    private int id;

    public Usuario(){
        nombres="";
        apellidos="";
        nickname="";
        contrasenia="";
        email = "";
    }

    public Usuario(String nombres, String apellidos, String nickname, String contrasenia, int id, String email) {
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email = email;
        this.nickname=nickname;
        this.contrasenia=contrasenia;
        this.id=id;
    }

    public Usuario(String mEmail, String mPassword) {
        this.email = mEmail;
        this.contrasenia = mPassword;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
