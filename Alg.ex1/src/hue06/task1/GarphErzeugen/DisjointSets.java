/**
 * 
 */
package hue06.task1.GarphErzeugen;

import java.util.ArrayList;

/**
 * @author Elisabeth
 *
 */
public class DisjointSets {
	/**
	 *  A disjoint sets ADT.  Performs union-by-rank and path compression.
	 *  Implemented using arrays.  There is no error checking whatsoever.
	 *  By adding your own error-checking, you might save yourself a lot of time
	 *  finding bugs in your application code for Project 3 and Homework 9.
	 *  Without error-checking, expect bad things to happen if you try to unite
	 *  two elements that are not roots of their respective sets, or are not
	 *  distinct.
	 *
	 *  Elements are represented by ints, numbered from zero.
	 *
	 *  
	 **/

	

	  private ArrayList<Integer> array;

	  /**
	   *  Construct a disjoint sets object.
	   *
	   *  @param amountOfVertices the initial number of elements--also the initial
	   *  number of disjoint sets, since every element is initially in its own set.
	   **/
	  public DisjointSets(int amountOfVertices) {
	    array = new ArrayList<>();
	    for (int i = 0; i < array.size(); i++) {
	      array.add(i, -1);
	    }
	  }

	  /**
	   *  union() unites two disjoint sets into a single set.  A union-by-rank
	   *  heuristic is used to choose the new root.  This method will corrupt
	   *  the data structure if root1 and root2 are not roots of their respective
	   *  sets, or if they're identical.
	   *
	   *  @param referen the root of the first set.
	   *  @param root2 the root of the other set.
	   **/
	  public void union(int referen, int root2) {
	    if (array.get(root2) < array.get(referen)) {
	    	array.add(referen, root2);
	                 // root2 is taller; make root2 new root
	    } else {
	      if (array.get(referen).equals(root2)){
	    	  int x = array.get(referen);
	    	  array.remove(referen);
	    	  array.add(referen, x--);// Both trees same height; new one is taller
	      }
	      array.add(root2, referen);
	            // root1 equal or taller; make root1 new root
	    }
	  }

	  /**
	   *  find() finds the (int) name of the set containing a given element.
	   *  Performs path compression along the way.
	   *
	   *  @param rootOfTheTree the element sought.
	   *  @return the set containing x.
	   **/
	  public int findSets(int rootOfTheTree) {
	    if (array.get(rootOfTheTree) < 0) {
	      return rootOfTheTree;                         // x is the root of the tree; return it
	    } else {
	      // Find out who the root is; compress path by making the root x's parent.
	      array.add(rootOfTheTree, findSets(array.get(rootOfTheTree)));
	      return array.get(rootOfTheTree);                                       // Return the root
	    }
	  }

	/**
	 * @return the array
	 */
	public ArrayList<Integer> getArray() {
		return array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(ArrayList<Integer> array) {
		this.array = array;
	}
	}


