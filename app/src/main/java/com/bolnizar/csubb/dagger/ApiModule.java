package com.bolnizar.csubb.dagger;

import com.bolnizar.csubb.dagger.qualifiers.ApiRo;
import com.bolnizar.csubb.models.service.ApiService;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paul on 6/27/2016.
 */
public class ApiModule {

    private static final String ENDPOINT_RO = "http://rss2json.com/api.json?rss_url=http://www.cs.ubbcluj.ro/feed/";

    @ApiRo
    String provideRoUrl() {
        return ENDPOINT_RO;
    }

    @ApiRo
    @Singleton
    @Provides
    Retrofit provideRoRetrofit(@ApiRo String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @ApiRo
    @Singleton
    @Provides
    ApiService provideRoService(@ApiRo Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
