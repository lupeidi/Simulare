package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventValidator {
    public void validate( Event event){

        SimpleDateFormat format = new SimpleDateFormat("dd.MM");
        try {
            format.parse(event.getDay());
        } catch (ParseException pe) {
            throw new EventException("Date does not respect format (dd.MM).");
        }

        SimpleDateFormat formatTime = new SimpleDateFormat("hh.MM");
        try {
            formatTime.parse(event.getDay());
        } catch (ParseException pe) {
            throw new EventException("Date does not respect format (hh.MM).");
        }

        if (event.getDuration() < 0 ) throw new EventException("Duration must be positive.");

    }
}
