package mediator;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import observable.event.ObservableEvent;
import subject.ObservableSubject;

public class EventMediator extends ObservableSubject implements Observer {
	
	private static volatile EventMediator moderator;
	
	public static synchronized EventMediator getInstance(){
		if(moderator == null){
			moderator = new EventMediator();
		}
		
		return moderator;
	}
	
	private EventMediator() {}

	private ConcurrentHashMap<String, Set<Observer>> observerEvents = new ConcurrentHashMap<String, Set<Observer>>();
	
	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}
	
	public synchronized void addObserver(Observer o, ObservableEvent observableEvent) {
		String observableEventName = observableEvent.getEventName();
		if(observerEvents.contains(observableEventName)){
			observerEvents.get(observableEventName).add(o);
		}
		else{
			Set<Observer> observers = new HashSet<Observer>();
			observers.add(o);
			observerEvents.put(observableEventName, observers);
		}
	}
	
	public synchronized void removeObserver(Observer o, ObservableEvent observableEvent) {
		String observableEventName = observableEvent.getEventName();
		if(observerEvents.contains(observableEventName)){
			observerEvents.get(observableEventName).remove(o);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("I am here");
	}
}
