package com.example.weatherforecast;

import android.util.Log;
import androidx.lifecycle.LiveData;
import com.example.weatherforecast.model.dataclass.WeatherForecast;
import com.example.weatherforecast.model.repository.WeatherRepository;
import com.example.weatherforecast.model.repository.networking.ApiClient;
import com.example.weatherforecast.model.repository.networking.RestApiImpl;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class ApiTest {
    @Mock
    RestApiImpl restapi;
    @Mock
    ApiClient client;
    @Mock
    OkHttpClient okclient;
    @Mock
    WeatherRepository repo;
    @Mock
    LiveData<WeatherForecast> livedata;
    @Mock
    Observable<WeatherForecast> observer;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public void urlTest() {
        when(client.connectToApi()).thenReturn(restapi);
        verify(restapi, never()).getApiClient();
        verify(restapi,never()).setApiClient(null);




    }




}
