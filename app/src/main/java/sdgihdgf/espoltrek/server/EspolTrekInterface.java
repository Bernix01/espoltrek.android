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
    @GET("ListarLugares.php?")
    Call<List<Lugar>>getLugares();

    @GET("MostrarLugarPorId.php?")
    Call<Lugar>getLugarPorId(@Query("id_lugar")int idLugar);

    @GET("ObtenerUsuarioPorId")
    Call<Usuario>getUsuarioPorId(@Query("id_usuario")int idUsuario);
    
}
