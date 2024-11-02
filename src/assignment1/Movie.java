// Movie interface
interface Movie {
    String getTitle();
    String getType();
    Movie getMovie();
}

// Concrete Movie classes
class RegularMovie implements Movie {
    private String title;

    public RegularMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "Regular";
    }

    @Override
    public Movie getMovie() {
        return this; // Return the current instance
    }
}

class IMAXMovie implements Movie {
    private String title;

    public IMAXMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "IMAX";
    }

    @Override
    public Movie getMovie() {
        return this; // Return the current instance
    }
}

// Abstract Factory class
abstract class MovieFactory {
    public abstract Movie createMovie(String title);
}

// Concrete Factories
class RegularMovieFactory extends MovieFactory {
    @Override
    public Movie createMovie(String title) {
        return new RegularMovie(title);
    }
}

class IMAXMovieFactory extends MovieFactory {
    @Override
    public Movie createMovie(String title) {
        return new IMAXMovie(title);
    }
}