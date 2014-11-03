package observer;

import java.util.Observable;

import observable.event.ObservableEventBase;


public interface Observer {
	
	public void update(Observable observable,  ObservableEventBase event);

}