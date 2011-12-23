package net.paxcel.zk.fscroll;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;

/**
 * Encapsulates the container-track/handle-content div to wrap a fancy scroll
 * around the content.
 * 
 * Make change to width and height proportion or use hflex/vflex if scroll doesn't come
 * currently(or cutting at edges).
 * 
 * @author deepak
 * 
 */
public class FancyScrollDiv extends Div {
	private Component comp;
	private Div container;
	private Div track;
	private Div handle;
	private Div content;

	public FancyScrollDiv(Component comp) {
		this.comp = comp;
		initDivs();
	}

	private void initDivs() {
		container = new Div();
		track = new Div();
		handle = new Div();
		content = new Div();

		container.setSclass("scrollbar_container");
		track.setSclass("scrollbar_track");
		handle.setSclass("scrollbar_handle");
		content.setSclass("scrollbar_content");

		Object obj = Executions.getCurrent().getDesktop().getAttribute("scrl");
		int id = 1;
		if (obj != null) {
			id = (Integer) obj;
			id++;
			Executions.getCurrent().getDesktop().setAttribute("scrl", id);
		} else {
			Executions.getCurrent().getDesktop().setAttribute("scrl", 1);
		}
		container.setId("scrollbar_container" + id);
		track.setId("scrollbar_track" + id);
		handle.setId("scrollbar_handle" + id);
		content.setId("scrollbar_content" + id);

		if (comp.getParent() != null) {
			comp.getParent().appendChild(container);
		} else {

		}

		track.appendChild(handle);
		content.appendChild(comp);

		container.appendChild(track);
		container.appendChild(content);

		callScrollJs();
	}

	private void callScrollJs() {
		Clients.evalJavaScript("create('" + content.getUuid() + "','"
				+ track.getUuid() + "')");
	}

	public void refresh() {
		Clients.evalJavaScript("reDrawScroll()");
	}

	public Div getContent() {
		return content;
	}
}
