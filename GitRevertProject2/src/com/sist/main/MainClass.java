package com.sist.main;

/*
 * 	cd c:\users\...\git\web_study
 * 	
 * 	git log --oneline -n 3
 * 
 * 	-- (HEAD)
 * 	-- 			// -1
 * 	--			// -2
 * 
 * 	git format-patch -1 (f3a93b9)
 * 	git revert HEAD
 */

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Revert Commit -1");
		System.out.println("Hello Revert Commit -2");
	}

}
