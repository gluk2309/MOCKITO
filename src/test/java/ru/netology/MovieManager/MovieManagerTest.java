package ru.netology.MovieManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void testNoFilms() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingleFilms() {

        MovieManager manager = new MovieManager();
        manager.addMovie("Movie I");

        String[] expected = {"Movie I"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSeveralFilms() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Movie I");
        manager.addMovie("Movie II");
        manager.addMovie("Movie III");
        manager.addMovie("Movie IV");
        manager.addMovie("Movie V");
        manager.addMovie("Movie VI");


        String[] expected = {"Movie I", "Movie II", "Movie III", "Movie IV", "Movie V", "Movie VI"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testInReverseOrder() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Movie I");
        manager.addMovie("Movie II");
        manager.addMovie("Movie III");
        manager.addMovie("Movie IV");
        manager.addMovie("Movie V");


        String[] expected = {"Movie V", "Movie IV", "Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimit() {
        MovieManager manager = new MovieManager(3);

        manager.addMovie("Movie I");
        manager.addMovie("Movie II");
        manager.addMovie("Movie III");


        String[] expected = {"Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLessThanTheLimit() {
        MovieManager manager = new MovieManager(4);

        manager.addMovie("Movie I");
        manager.addMovie("Movie II");
        manager.addMovie("Movie III");


        String[] expected = {"Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testZeroAtLimit() {
        MovieManager manager = new MovieManager(4);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOverLimit() {
        MovieManager manager = new MovieManager(4);

        manager.addMovie("Movie I");
        manager.addMovie("Movie II");
        manager.addMovie("Movie III");
        manager.addMovie("Movie IV");
        manager.addMovie("Movie V");
        manager.addMovie("Movie VI");


        String[] expected = {"Movie VI", "Movie V", "Movie IV", "Movie III"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
