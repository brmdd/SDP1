// MovieSchedule interface
interface MovieSchedule extends Cloneable {
    MovieSchedule clone();
    void setMovie(Movie movie);
    Movie getMovie();
    void setTime(String time);
    String getTime();
}

// Concrete class implementing Prototype pattern
class StandardSchedule implements MovieSchedule {
    private Movie movie;
    private String time;

    @Override
    public MovieSchedule clone() {
        try {
            return (MovieSchedule) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie; // Return the associated movie
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}