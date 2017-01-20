package tools.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.TouristAttraction;

public class MathTools {
	public static double boundValue(double value, double min, double max) {
		return value < min ? min : value > max ? max : value;
	}

	public static double absoluteValue(double value) {
		return value = value < 0 ? -value : value;
	}

	public static List<Integer[]> allPermutation(int number, int size) {
		int[] tab = new int[size];
		for (int i = 0; i < size; i++)
			tab[i] = i;
		List list = new ArrayList<Integer[]>();
		list.add(tab);

		return null;
	}

	public static class Counter {
		private int size = 5;
		private int max = 5;
		private Integer[] tab = new Integer[size];

		public Counter(int size, int max) {
			this.size = size;
			this.max = max;
			this.tab = new Integer[size];
		}

		public void increment(int place, List<Integer[]> list) {
			if (place < size) {
				if ((place < size - 1) || (tab[place] != max)) {
					tab[place] = (tab[place] + 1) % max;
					list.add(cpyTab(tab));
					if (tab[place] == max)
						increment(place + 1, list);
					increment(place, list);
				}
			}
		}

		public String affichetab() {
			String el = "";
			for (int i = 0; i < size; i++)
				el += tab[i] + " ";
			return el;
		}

		public List<Integer[]> getComb() {
			init();
			List<Integer[]> list = new ArrayList<Integer[]>();
			boolean next = true;
			while (next) {
				if(tabUnicity(tab) && tabAsc(tab))list.add(cpyTab(tab));
				next = increment(0);
				}
			return list;
		}

		public boolean tabAsc(Integer[] tab) {
			for (int i = 0; i < tab.length - 1; i++)
				for (int j = i + 1; j < tab.length; j++)
					if (tab[i] > tab[j])
						return false;
			return true;
		}
		
		public boolean tabUnicity(Integer[] tab) {
			for (int i = 0; i < tab.length - 1; i++)
				for (int j = i + 1; j < tab.length; j++)
					if (tab[i] == tab[j])
						return false;
			return true;
		}

		public boolean increment(int place) {
			tab[place] = (tab[place] + 1) % max;
			if (tab[place] == 0)
				if (place + 1 < size)
					return increment(place + 1);
				else
					return false;
			return true;
		}

		public void init() {
			this.tab = new Integer[size];
			for (int i = 0; i < size; i++)
				tab[i] = new Integer(0);
		}

		public static Integer[] cpyTab(Integer[] tab3) {
			Integer[] tab2 = new Integer[tab3.length];
			for (int i = 0; i < tab3.length; i++)
				tab2[i] = tab3[i];
			return tab2;
		}

	}

}
