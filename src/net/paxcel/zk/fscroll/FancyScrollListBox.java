package net.paxcel.zk.fscroll;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;

/**
 *	<listbox use="net.paxcel.zk.fscroll.FancyScrollListbox">
 *	Shows a fancy scroll around the listbox. Works only if you have model defined because
 *	otherwise unable to get the event to know the client model is changed.
 *	
 * @author deepak
 *
 */
public class FancyScrollListBox extends Listbox {
	FancyScrollDiv fancyDiv;

	/**
	 * Calls super() and then add an ON_CREATE event to make fancy div it's parent.
	 */
	public FancyScrollListBox() {
		super();
		addEventListener(Events.ON_CREATE, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				fancyDiv = new FancyScrollDiv(FancyScrollListBox.this);
			}
		});
	}
	

	/**
	 * Currently, if model of the listbox is changed then scroll will be
	 * re-rendered.
	 */
	@Override
	public void onInitRender() {
		super.onInitRender();
		if (null != getModel()) {
			if (getModel().getSize() == 0) {
				//Show an empty image inside listbox
				fancyDiv.getContent().setSclass("nodata");
			} else {
				//Show Fancy Scroll
				fancyDiv.getContent().setSclass("scrollbar_content");
			}
		}
		fancyDiv.refresh();
	}
}
