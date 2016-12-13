package sdgihdgf.espoltrek.server;

/**
 * Created by belen on 28/11/16.
 *
 */

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sdgihdgf.espoltrek.models.Lugar;
import sdgihdgf.espoltrek.models.Usuario;


public interface EspolTrekInterface {
    @GET("lugar")
    Call<List<Lugar>>getLugares();

    @POST("login")
    Call<JsonElement> login(@Body Usuario usuario);

    @GET("lugar/{id_lugar}")
    Call<Lugar>getLugarPorId(@Query("id_lugar")int idLugar);

    @GET("user/{id_usuario}")
    Call<Usuario>getUsuarioPorId(@Query("id_usuario")int idUsuario);
    
}
