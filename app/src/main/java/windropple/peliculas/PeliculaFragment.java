package windropple.peliculas;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.util.*;


/**
 * Created by Sistemas on 30/07/2015.
 */
public class PeliculaFragment extends Fragment {


    public static PeliculaFragment newInstance(long idPelicula){
        PeliculaFragment peliculaFragment = new PeliculaFragment();
        Bundle args = new Bundle();
        args.putLong("idPelicula", idPelicula);
        peliculaFragment.setArguments(args);
        return peliculaFragment;
    }
    public long getIdShowPelicula(){
        return getArguments().getLong("idPelicula",0);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAGDEBUG", this.getIdShowPelicula() + "");
        return inflater.inflate(R.layout.descripcion, container, false);
    }
}
