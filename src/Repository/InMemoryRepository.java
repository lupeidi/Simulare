package Repository;

import Domain.Event;
import Domain.EventValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, Event> storage = new HashMap<>();
    private EventValidator validator;

    public InMemoryRepository (EventValidator validator) {
        this.validator = validator;
    }

    public void insert (Event event) {
        if (storage.containsKey(event.getId())) {
            throw new RepositoryException("There is already an event with that id.");
        }
        if (storage.containsKey(event.getTime()) && storage.containsKey(event.getDay())) {
            throw new RepositoryException("There is already an event planned for that time.");
        }

        validator.validate(event);
        storage.put(event.getId(), event);
    }

    public List<Event> getAll() {
        return new ArrayList<>(storage.values());
    }
}
