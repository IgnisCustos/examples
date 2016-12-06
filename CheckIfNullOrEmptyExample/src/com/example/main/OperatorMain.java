package com.example.main;

import java.util.ArrayList;
import java.util.List;

public class OperatorMain
{

    public static void main(String[] args)
    {
	List<Integer> tmp1 = new ArrayList<>();
	checkIfNullOrEmpty(tmp1);

	
	List<Integer> tmp2 = null;
	checkIfNullOrEmpty(tmp2);

	List<Integer> tmp3 = new ArrayList<>();
	tmp3.add(1);
	checkIfNullOrEmpty(tmp3);

    
    }
    
    
    
    
    private static void checkIfNullOrEmpty(List list){
	if (list==null || list.size() ==0 ){
	    System.out.println("Empty oder null");
	} else {
	    System.out.println("You now can safe handle varible");
	}
    }
    
    

}
