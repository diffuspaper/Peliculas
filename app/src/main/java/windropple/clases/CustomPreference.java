package windropple.clases;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import windropple.peliculas.R;

/**
 * Created by Andres Lopez on 31/07/2015.
 */
public class CustomPreference extends Preference {

    public static final int DEFAULT_PROGRESS = 75;

    private int currentProgress;
    public CustomPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        currentProgress = DEFAULT_PROGRESS;
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.preference_volume, parent, false);
    }

    @Override
    protected void onBindView(View view) {
        SeekBar bar = (SeekBar)view.findViewById(R.id.seekBar);
        bar.setProgress(currentProgress);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                persistInt(currentProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        if(restorePersistedValue){
            currentProgress = getPersistedInt(DEFAULT_PROGRESS);
        }else{
            currentProgress = (Integer)defaultValue;
            persistInt(currentProgress);
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return  a.getInt(index, DEFAULT_PROGRESS);
    }
}
