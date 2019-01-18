package DAO;

import java.util.Comparator;
import java.util.TreeMap;

public class TestOrdinaMappa {
	    public static void main(String[] args) {
	        TreeMap<String, Double> map = new TreeMap<String, Double>();
	        ValueComparator bvc = new ValueComparator(map);
	        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);

	        map.put("A", 99.5);
	        map.put("B", 67.4);
	        map.put("C", 68.4);
	        map.put("D", 67.3);

	        System.out.println("unsorted map: " + map);
	        sorted_map.putAll(map);
	        System.out.println("results: " + sorted_map);
	    }
	}

class ValueComparator implements Comparator<String> {
		TreeMap<String, Double> base;

	    public ValueComparator(TreeMap<String, Double> base) {
	        this.base = base;
	    }

	    
	    public int compare(String a, String b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } 
	    }
	}
