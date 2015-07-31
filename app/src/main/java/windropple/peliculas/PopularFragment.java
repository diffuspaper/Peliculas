package windropple.peliculas;


import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import windropple.clases.Pelicula;
import windropple.clases.PeliculasAdapter;

/**
 * Created by Sistemas on 30/07/2015.
 */
public class PopularFragment extends ListFragment {

    boolean dualPane;
    ArrayList<Pelicula> peliculas;
    PeliculasAdapter peliculasAdapter;
    long currentIdPelicula = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_populares, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(0, 0, "", "Batman","2015-08-01", "270", "Batman es un tio muy malo","6.7","",""));
        peliculas.add(new Pelicula(0, 0, "", "Ant-Man","2015-07-21", "170", "Ant es un tio muy malo","6.7","",""));
        peliculas.add(new Pelicula(0, 0, "", "Superman","2015-06-20", "240", "Man es un tio muy malo","6.7","",""));
        peliculas.add(new Pelicula(0, 0, "", "Batman v Superman","2015-08-01", "270", "Superman es un tio muy malo","6.7","",""));
        peliculasAdapter = new PeliculasAdapter(this.getActivity(), R.layout.populares, peliculas);

        View detallePelicula = getActivity().findViewById(R.id.framePelicula);
        dualPane = detallePelicula != null && detallePelicula.getVisibility() == View.VISIBLE;
        if(dualPane){
            Display display = getActivity().getWindowManager().getDefaultDisplay();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((display.getWidth()/3) * 2, display.getHeight());
            detallePelicula.setLayoutParams(params);
            showDetail(currentIdPelicula);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setListAdapter(peliculasAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetail(position);
    }

    public void showDetail(long idPelicula){
        currentIdPelicula = idPelicula;

        PeliculaFragment peliculaFragment = (PeliculaFragment)getFragmentManager().findFragmentById(R.id.framePelicula);
        if(dualPane) {
            if (peliculaFragment == null || peliculaFragment.getIdShowPelicula() != currentIdPelicula) {
                Log.i("TAGDEBUG", "Actualizaremos el fragmento");
                peliculaFragment = PeliculaFragment.newInstance(currentIdPelicula);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framePelicula, peliculaFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            }
        }else{
            Log.i("TAGDEBUG", "Lanzaremos Activity");
            Intent intent = new Intent(getActivity(), PeliculaActivity.class);
            intent.putExtra("idPelicula", currentIdPelicula);
            startActivity(intent);
        }
    }
}
