package com.example.weatherforecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.example.weatherforecast.model.dataclass.WeatherForecast;
import com.example.weatherforecast.model.repository.WeatherRepository;
import com.example.weatherforecast.model.repository.networking.ApiClient;
import com.example.weatherforecast.model.repository.networking.RestApiImpl;
import com.example.weatherforecast.viewmodel.WeatherViewModel;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class RepoTest {

    @Mock
    RestApiImpl restapi;
    @Mock
    ApiClient client;
    @Mock
    WeatherViewModel viewModel;
    @Mock
    Observable<WeatherForecast> observer;
    @Mock
    LiveData<WeatherForecast> livedata;

    @Mock
    Observer<WeatherForecast> observe;
    @Mock
    WeatherRepository repo;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testNull() {

        when(repo.getWeatherForecastData(12, 72)).thenReturn(livedata);
        verify(restapi, atLeastOnce());

    }
}
