package task3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MovieManager manager = new MovieManager(new FilmSerializer());
        manager.saveCollectionFilms(manager.getCollectionFilm());
        manager.restoreCollectionFilms();

        List<Film> newFilms = new ArrayList<>();
        newFilms.add(new Film("Акулий Торнадо", new Actor("Тара Рид")));
        manager.modifyCollectionFilms(newFilms);
    }


}
