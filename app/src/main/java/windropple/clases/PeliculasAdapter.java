package windropple.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import windropple.peliculas.R;

/**
 * Created by Sistemas on 30/07/2015.
 */
public class PeliculasAdapter extends ArrayAdapter<Pelicula>{

    private Context mContext;
    private int mResource;
    private List<Pelicula> mObjects;

    public PeliculasAdapter(Context context, int resource, List<Pelicula> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.mObjects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = new ViewHolder();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(mResource, null, false);
            holder.tvTituloPelicula = (TextView)view.findViewById(R.id.tvTituloPelicula);
            holder.tvFechaEstreno = (TextView)view.findViewById(R.id.tvFechaEstreno);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        Pelicula mPelicula = mObjects.get(position);
        holder.tvTituloPelicula.setText(mPelicula.getTitulo());
        holder.tvFechaEstreno.setText(mPelicula.getFechaEstreno());
        view.setTag(holder);
        return view;
    }

    static class ViewHolder{
        TextView tvTituloPelicula;
        TextView tvFechaEstreno;
    }
}
