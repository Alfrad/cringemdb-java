package br.com.kek.cringemdb.services;

import java.util.List;

import br.com.kek.cringemdb.entities.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Hello world!
 *
 */
public interface SearchService {

	@GET("search")
	Call<List<Movie>> search(@Query("term") String term);

}
