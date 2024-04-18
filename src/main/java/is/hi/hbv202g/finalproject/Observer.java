package is.hi.hbv202g.finalproject;

/**
 * This interface represents an observer in the observer design pattern.
 * Classes that need to be notified of changes by an Observable class implement this interface.
 */
public interface Observer {

    /**
     * This method is called whenever the observed object is changed.
     * An application calls an Observable object's notifyObservers method to have all the object's observers notified of the change.
     *
     * @param message the message to be passed to the observer
     */
    void update(String message);
}
