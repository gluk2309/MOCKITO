package ru.netology.MovieManager;

public class MovieManager {
    private String[] movies = new String[0];
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String movie) {
        String[] temp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            temp[i] = movies[i];
        }
        temp[temp.length - 1] = movie;
        this.movies = temp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int arrayLength;

        if (movies.length < limit) {
            arrayLength = movies.length;
        } else {
            arrayLength = limit;
        }

        String[] last = new String[arrayLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = movies[movies.length - 1 - i];
        }
        return last;
    }
}
