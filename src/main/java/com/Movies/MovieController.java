package com.Movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    String route = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/now-playing")
    public String nowPlaying(Model model){
        List<Movie> movieList = getMovies(route);
        model.addAttribute("movieList", movieList);
        return "now-playing";
    }

    @RequestMapping("/medium-popular-long-name")
    public String mediumPopularLongName(Model model){
        List<Movie> mediumPopularLongName = getMovies(route).stream()
            .filter(movie -> movie.getTitle().length() >= 10)
            .filter(movie -> movie.getPopularity() >= 30 && movie.getPopularity() <= 80)
            .collect(Collectors.toList());

        model.addAttribute("movieList", mediumPopularLongName);
        return "medium-popular-long-name";
    }

    @RequestMapping("/overview-mashup")
    public String overviewMashup(Model model){
        List<Movie> movies = getMovies(route);
        while (movies.size() > 5){movies.remove(movies.size() -1);}

        List<String[]> splitDescriptions = new ArrayList<>();
        for (Movie mov : movies){
            splitDescriptions.add(mov.getOverview().split("//."));
        }

        String mashupString = "";
        for (String[] splitDesc : splitDescriptions){
            Random rand = new Random();
            mashupString = mashupString + splitDesc[rand.nextInt(splitDesc.length)] + " ";
        }

        model.addAttribute("mashupString", mashupString);
        return "overview-mashup";
    }

    public static List<Movie> getMovies(String route){
        RestTemplate temp = new RestTemplate();
        return temp.getForObject(route, ResultsPage.class).getResults();
    }
}
