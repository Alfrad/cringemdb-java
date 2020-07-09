package io.github.alfrad.cringemdb.services;

import java.util.List;

import io.github.alfrad.cringemdb.Cringemdb;
import io.github.alfrad.cringemdb.entities.Movie;
import io.github.alfrad.cringemdb.vo.CringemdbVO;
import lombok.SneakyThrows;
import retrofit2.Response;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

public class CringemdbService {
	
	private static CringemdbService instance;

	private CringemdbService() {
	}

	public static synchronized CringemdbService getInstance() {
		if (instance == null)
			instance = new CringemdbService();
		return instance;
	}

	@SneakyThrows
	public CringemdbVO getResumeFromCingemdb(String nameAndYearOfMovie) {
		SearchService searchService = new Cringemdb().searchService();
		Response<List<Movie>> execute = searchService.search(nameAndYearOfMovie).execute();
		Movie movie = extractResultFromResponse(execute);
		return getCringemdbVOFromMovie(movie);
	}

	private CringemdbVO getCringemdbVOFromMovie(Movie movie) {
		if (movie != null) {
			OOSpider<?> create = OOSpider.create(Site.me(), CringemdbVO.class);
			try {
				CringemdbVO cringemdb = create.get(Cringemdb.API_URL_FULL.concat(movie.getSlug()));
				return cringemdb;
			} finally {
				create.close();
			}
		}
		return null;
	}

	private Movie extractResultFromResponse(Response<List<Movie>> execute) {
		List<Movie> result = execute.isSuccessful() ? execute.body() : null;
		return extractFirstElement(result);
	}

	private Movie extractFirstElement(List<Movie> result) {
		return result != null ? result.stream().findFirst().orElse(null) : null;
	}

}
