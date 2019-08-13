package com.example.weatherforecast;

import androidx.lifecycle.LiveData;
import com.example.weatherforecast.model.dataclass.WeatherForecast;
import com.example.weatherforecast.model.repository.WeatherRepository;
import com.example.weatherforecast.viewmodel.WeatherViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class ViewModelTest {
    @Mock
    LiveData<WeatherForecast> livedata;
    @Mock
    WeatherViewModel viewModel;
    @Mock
    WeatherRepository repo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel.setRepo(repo);


    }

    @Test
    public void modeltest() {
        when(viewModel.getForecastDetails(12.0d, 72.0d)).thenReturn(livedata);
        verify(repo, atLeastOnce());



    }
}
