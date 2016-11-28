package sdgihdgf.espoltrek.server;

/**
 * Created by belen on 28/11/16.
 *
 */
import sdgihdgf.espoltrek.models.*;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EspolTrekInterface {
    @GET("ListarLugares.php?")
    Call<List<Lugar>>getLugares();

    @GET("MostrarLugarPorId.php?")
    Call<Lugar>getLugarPorId(@Query("id_lugar")int idLugar);

    @Get("ObtenerUsuarioPorId")
    Call<Usuario>getUsuarioPorId(@Query("id_usuario")int idUsuario);
    
}
