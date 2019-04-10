package Domain;

public class EventException extends RuntimeException {

        public EventException(String s) {
            super("Event Exception: " + s);
        }
}
