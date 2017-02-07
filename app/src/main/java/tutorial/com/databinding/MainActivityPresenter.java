package tutorial.com.databinding;

/**
 * Created by mlagrouh on 06/02/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {

        this.view = view;
    }

    @Override
    public void onShowData(TemperatureData temperatureData) {

    }
}
