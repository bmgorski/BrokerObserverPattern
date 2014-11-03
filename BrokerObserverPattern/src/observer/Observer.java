package observer;

import java.util.Observable;

import observable.event.ObservableEvent;


public interface Observer {
	
	public void update(Observable observable,  ObservableEvent event);

}