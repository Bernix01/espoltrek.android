package sdgihdgf.espoltrek.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gbern on 12/12/16.
 */

public class ETRest {
    private static ETRest singleton = null;
    private Retrofit rest;
    private EspolTrekInterface sosRestService;

    protected ETRest() {
        rest = new Retrofit.Builder()
                .baseUrl("http://sos-se-solidario.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sosRestService = rest.create(EspolTrekInterface.class);
    }

    public static synchronized ETRest get() {
        if (singleton == null) {

            singleton = new ETRest();
        }
        return singleton;
    }

    public EspolTrekInterface service() {
        return sosRestService;
    }
}
