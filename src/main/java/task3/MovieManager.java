package task3;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private static final String FILE_NAME = "C:\\Users\\d.gulenkova\\IdeaProjects\\unit5\\collection_of_films.txt";

    private FilmSerializer filmSerializer;
    private List<Actor> actorList;
    private List<Film> collectionFilm;

    public MovieManager(FilmSerializer filmSerializer) {
        this.filmSerializer = filmSerializer;
        createCollectionFilms();
    }

    public void restoreCollectionFilms() {
        filmSerializer.deserialize(FILE_NAME);
    }

    public void modifyCollectionFilms(List<Film> newFilms) {
        collectionFilm.addAll(newFilms);
        saveCollectionFilms(collectionFilm);
        restoreCollectionFilms();
    }

    public void saveCollectionFilms(List<Film> collectionFilm) {
        System.out.println();
        filmSerializer.serialize(FILE_NAME, collectionFilm);
    }

    public List<Film> getCollectionFilm() {
        return collectionFilm;
    }

    public List<Actor> createActors() {
        actorList = new ArrayList<>();
        actorList.add(new Actor("Александр Невский"));
        actorList.add(new Actor("Николас Кейдж"));
        actorList.add(new Actor("Джим Керри"));
        actorList.add(new Actor("Томми Вайсо"));

        return actorList;
    }

    public List<Film> createCollectionFilms() {
        collectionFilm = new ArrayList<>();

        List<Actor> actorList = createActors();
        collectionFilm.add(new Film("Разборка в Маниле", actorList.get(0)));
        collectionFilm.add(new Film("Черная роза", actorList.get(0)));
        collectionFilm.add(new Film("Максимальный удар", actorList.get(0)));
        collectionFilm.add(new Film("Без лица", actorList.get(1)));
        collectionFilm.add(new Film("Воздушная тюрьма", actorList.get(1)));
        collectionFilm.add(new Film("Плетеный человек", actorList.get(1)));
        collectionFilm.add(new Film("Шоу Трумана", actorList.get(2)));
        collectionFilm.add(new Film("Комната", actorList.get(3)));

        return collectionFilm;
    }

}
