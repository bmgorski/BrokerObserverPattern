package observer;

import java.util.Observable;
import java.util.Observer;

import errors.IncompatibleObject;
import observable.event.ObservableEvent;
import subject.ObservableSubject;

public abstract class StockObserver implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ObservableSubject && arg instanceof ObservableEvent){
			update(o, arg);
		}
		else{
			try {
				throw new IncompatibleObject();
			} catch (IncompatibleObject e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void update(ObservableSubject subject, ObservableEvent observableEvent);
}