package moderator;

import java.util.Observable;

import observable.event.*;
import observer.Observer;

public class Moderator extends Observable implements Observer {

	private static Moderator instance;
	
	public static Moderator getInstance(){
		if (instance==null)
			instance = new Moderator();
		
		return instance;
	}
	
	/**
	 * Private to prevent outside instantiations
	 */
	private Moderator(){
		
	}
	
	@Override
	public void update(Observable observable, ObservableEventBase event) {
		// TODO Auto-generated method stub
		
	}

}
