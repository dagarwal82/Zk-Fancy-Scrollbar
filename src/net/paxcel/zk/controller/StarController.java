package net.paxcel.zk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.paxcel.zk.bean.Star;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;

public class StarController extends GenericForwardComposer {
	private List<Star> stars = new ArrayList<Star>();
	private Listbox lb;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Random random = new Random(12L);
		for (int i = 1970; i < 2011; i++) {
			stars.add(new Star(i, Math.abs(random.nextLong())));
		}
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}
}
