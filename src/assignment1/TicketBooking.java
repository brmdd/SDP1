class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    // Private constructor
    private TicketBooking() {}

    // Getters
    public String getMovieTitle() {
        return movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSnackCombo() {
        return snackCombo;
    }

    // Builder class
    public static class TicketBookingBuilder {
        private TicketBooking ticketBooking;

        public TicketBookingBuilder() {
            ticketBooking = new TicketBooking();
        }

        public TicketBookingBuilder setMovieTitle(String movieTitle) {
            ticketBooking.movieTitle = movieTitle;
            return this;
        }

        public TicketBookingBuilder setSeatNumber(String seatNumber) {
            ticketBooking.seatNumber = seatNumber;
            return this;
        }

        public TicketBookingBuilder setSnackCombo(String snackCombo) {
            ticketBooking.snackCombo = snackCombo;
            return this;
        }

        public TicketBooking build() {
            return ticketBooking;
        }
    }
}