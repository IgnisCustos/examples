package com.example.main;

import java.util.ArrayList;
import java.util.List;
/**
 * Nullsafe check of List
 * @author Ignis
 *
 */
public class OperatorMain
{

    public static void main(String[] args)
    {
	
	System.out.println("-null ArrayList");
	List<Integer> tmp2 = null;
	checkIfNullOrEmpty(tmp2);
	
	System.out.println("-Empty ArrayList");
	List<Integer> tmp1 = new ArrayList<>();
	checkIfNullOrEmpty(tmp1);
	
	System.out.println("-Full ArrayList");
	List<Integer> tmp3 = new ArrayList<>();
	tmp3.add(1);
	checkIfNullOrEmpty(tmp3);

    
    }
    
    /**
     * Method for Checkin an list if its empty or null
     * @param list
     */
    private static void checkIfNullOrEmpty(List list){
	if (list==null || list.size()==0 ){
	    System.out.println("List is empty oder null\n");
	} else {
	    System.out.println("You now can safe handle varible\n");
	}
    }
    
    

}
