package io.github.alfrad.cringemdb;

import io.github.alfrad.cringemdb.services.SearchService;
import lombok.Data;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Data
public class Cringemdb {

	public static final String API_HOST = "cringemdb.com";
	public static final String API_URL = "https://" + API_HOST + "/";
	public static final String API_URL_FULL = API_URL + "movie/";

	private OkHttpClient okHttpClient;
	private Retrofit retrofit;

	protected Retrofit.Builder retrofitBuilder() {
		return new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create())
				.client(okHttpClient());
	}

	protected synchronized OkHttpClient okHttpClient() {
		if (okHttpClient == null) {
			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			okHttpClient = builder.build();
		}
		return okHttpClient;
	}

	protected Retrofit getRetrofit() {
		if (retrofit == null)
			retrofit = retrofitBuilder().build();
		return retrofit;
	}

	public SearchService searchService() {
		return getRetrofit().create(SearchService.class);
	}

}
