package net.paxcel.zk.fscroll;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Grid;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;

/**
 * <grid use="net.paxcel.zk.fscroll.FancyScrollGrid">.
 * Shows a fancy scroll around the grid. Works only if 
 * you have model defined because otherwise
 * unable to get the event to know the client model is changed.
 * 
 * @author deepak
 * 
 */
public class FancyScrollGrid extends Grid {
	FancyScrollDiv fancyDiv;

	/**
	 * Calls super() and then add an ON_CREATE event to make fancy div it's
	 * parent.
	 */
	public FancyScrollGrid() {
		super();
		addEventListener(Events.ON_CREATE, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				fancyDiv = new FancyScrollDiv(FancyScrollGrid.this);
			}
		});
	}

	/**
	 * Currently, if model of the Grid is changed then scroll will be
	 * re-rendered.
	 */
	@Override
	public void onInitRender() {
		super.onInitRender();
		if (null != getModel()) {
			if (getModel().getSize() == 0) {
				// Show an empty image inside grid
				fancyDiv.getContent().setSclass("nodata");
			} else {
				// Show Fancy Scroll
				fancyDiv.getContent().setSclass("scrollbar_content");
			}
		}
		fancyDiv.refresh();
	}
}
