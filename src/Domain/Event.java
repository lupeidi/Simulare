package Domain;

public class Event {

    private String id;
    private String name;
    private String day;
    private int duration;
    private String time;

    public Event(String id, String name, String day, int duration, String time) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.duration = duration;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

