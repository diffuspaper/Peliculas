package windropple.peliculas;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.*;
/**
 * Created by Sistemas on 30/07/2015.
 */
public class PeliculaActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }*/

        if(savedInstanceState == null){
            Log.i("TAGDEBUG","Lanzo Activity");
            PeliculaFragment peliculaFragment = new PeliculaFragment();
            peliculaFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, peliculaFragment).commit();
        }
    }
}
