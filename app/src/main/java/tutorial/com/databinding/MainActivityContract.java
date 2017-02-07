package tutorial.com.databinding;

/**
 * Created by mlagrouh on 06/02/2017.
 */

public interface MainActivityContract {

    public interface Presenter {
        void onShowData(TemperatureData temperatureData);
    }

    public interface View {
        void showData(TemperatureData temperatureData);
    }
}
