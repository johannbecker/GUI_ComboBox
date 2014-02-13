package de.i3.test;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MeinItemListenerA implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
	}
	
}
