package sdgihdgf.espoltrek;

import android.app.Activity;
import android.os.Bundle;

public class LugarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);
//        savedInstanceState.get("lugar");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
