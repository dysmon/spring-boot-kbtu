package kz.kbtu.dependencyinjection.model;

public class Engine {

    private final String type;
    private final int volume;

    public Engine(String type, int volume) {
        this.type = type;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("%s %d", type, volume);
    }
}