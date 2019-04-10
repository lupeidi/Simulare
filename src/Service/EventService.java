package Service;

import Domain.Event;
import Repository.InMemoryRepository;

import java.util.List;

public class EventService {

    private InMemoryRepository repository;

    public EventService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public void insert (String id, String name, String day, int duration, String time) {
        Event event = new Event(id, name, day, duration, time);
        repository.insert(event);
    }

    public List<Event> getAll() {
        return repository.getAll();
    }
}
