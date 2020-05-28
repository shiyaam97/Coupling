package model;

public class CouplingValues {
	
	public static int wR = 2;  	//Weight of recursive call
	public static int wMcms = 2;  //Weight of regular method calling regular method same file
	public static int wMcmd = 3;  //Weight of regular method calling another regular method in a different file
	public static int wMcrms = 3; //Weight of regular method calling a recursive method in the same file
	public static int wMcrmd = 4; //Weight of regular method calling a recursive method in the same file
	public static int wRmcrms = 4;//Weight of recursive method calling another recursive method in the same file
	public static int wRmcrmd = 5;//Weight of recursive method calling another recursive method in a different file
	public static int wRmcms = 3; //Weight of recursive method calling a regular method in the same file
	public static int wRmcmd = 4; //Weight of recursive method calling a regular method in a different file
	public static int wMrgvs = 1; //Weight of regular method referencing a global variable in the same file
	public static int wMrgvd = 2; //Weight of regular method referencing a global variable in a different file
	public static int wRmrgvs = 1;//Weight of recursive method referencing a global variable in the same file
	public static int wRmrgvd = 2;//Weight of recursive method referencing a global variable in a different file
	public static int ccp = 0; ///Total value of coupling

}
