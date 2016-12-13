package sdgihdgf.espoltrek.server;

/**
 * Created by belen on 28/11/16.
 *
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sdgihdgf.espoltrek.models.Lugar;
import sdgihdgf.espoltrek.models.Usuario;


public interface EspolTrekInterface {
    @GET("lugar")
    Call<List<Lugar>>getLugares();

    @GET("lugar/{id_lugar}")
    Call<Lugar>getLugarPorId(@Query("id_lugar")int idLugar);

    @GET("user/{id_usuario}")
    Call<Usuario>getUsuarioPorId(@Query("id_usuario")int idUsuario);
    
}
