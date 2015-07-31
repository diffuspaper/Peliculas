package windropple.peliculas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Andres Lopez on 31/07/2015.
 */
public class SettingsActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().add(android.R.id.content, new SettingsFragment()).commit();
    }
}
