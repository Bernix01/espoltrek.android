package sdgihdgf.espoltrek.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sdgihdgf.espoltrek.models.Usuario;

/**
 * Created by gbern on 12/12/16.
 */

public class ETRest {
    private static ETRest singleton = null;
    private Retrofit rest;
    private EspolTrekInterface sosRestService;
    private Usuario currentUser;
    protected ETRest() {
        rest = new Retrofit.Builder()
                .baseUrl("http://192.168.189.2:8000/")
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

    public synchronized boolean isLoggedIn() {
        return this.currentUser != null;
    }

    public synchronized void logout() {
        this.currentUser = null;
    }

    public void setActiveUser(Usuario u) {
        this.currentUser = u;
    }

    public synchronized Usuario getCurrentUser() {
        return this.currentUser;
    }

    public EspolTrekInterface service() {
        return sosRestService;
    }
}
