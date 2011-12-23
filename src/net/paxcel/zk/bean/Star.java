package net.paxcel.zk.bean;

public class Star {
	int year;
	long count;
	public Star(int year, long count) {
		this.year = year;
		this.count = count;
	}
	public int getYear() {
		return year;
	}
	public long getCount() {
		return count;
	}
}