package tutorial.com.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by mlagrouh on 06/02/2017.
 */

public class TemperatureData extends BaseObservable{
    private String celsius;

    public TemperatureData(String celsius) {
        this.setCelsius(celsius);
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }
}
