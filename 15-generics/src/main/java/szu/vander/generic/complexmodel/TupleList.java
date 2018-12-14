package szu.vander.generic.complexmodel;

//: generics/TupleList.java
// Combining generic types to make complex generic types.
import java.util.ArrayList;

import szu.vander.generic.simple.tuple.TupleTest;
import szu.vander.util.Amphibian;
import szu.vander.util.FourTuple;
import szu.vander.util.Vehicle;

public class TupleList<A,B,C,D>
extends ArrayList<FourTuple<A,B,C,D>> {
  public static void main(String[] args) {
    TupleList<Vehicle, Amphibian, String, Integer> tl =
      new TupleList<Vehicle, Amphibian, String, Integer>();
    tl.add(TupleTest.h());
    tl.add(TupleTest.h());
    for(FourTuple<Vehicle,Amphibian,String,Integer> i: tl) {
    	System.out.println(i);
    }
  }
}
