package is.hi.hbv202g.finalproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that represents an observable object.
 * It can be subclassed to represent an object that the application wants to have observed.
 */
public abstract class Observable {

    /**
     * A list of observers to be notified of changes in this observable object.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer to the set of observers for this object.
     *
     * @param observer the observer to be added
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Removes an observer from the set of observers of this object.
     *
     * @param observer the observer to be removed
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Notifies all observers about a change by calling their update method with a message.
     *
     * @param message the message to be shown to all observers
     */
    public void notifyObservers(String message) {
        for (Observer observer : this.observers) {
            observer.update(message);
        }
    }
}