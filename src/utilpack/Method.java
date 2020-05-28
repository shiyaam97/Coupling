package utilpack;
import java.util.ArrayList;
import java.util.List;

public class Method {
	
	String methodName;
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	List<Method> callingMethods = new ArrayList<Method>();
	public List<Method> getCallingMethods() {
		return callingMethods;
	}
	public void setCallingMethods(List<Method> callingMethods) {
		this.callingMethods = callingMethods;
	}
	List<String> callingVariables = new ArrayList<>();
	String methodSegment;
	String variable ;
	
	int nR = 0;  	//Number of recursive call
	int nMcms = 0;  //Number of regular method calling regular method same file
	int nMcmd = 0;  //Number of regular method calling another regular method in a different file
	int nMcrms = 0; //Number of regular method calling a recursive method in the same file
	int nMcrmd = 0; //Number of regular method calling a recursive method in the same file
	int nRmcrms = 0;//Number of recursive method calling another recursive method in the same file
	int nRmcrmd = 0;//Number of recursive method calling another recursive method in a different file
	int nRmcms = 0; //Number of recursive method calling a regular method in the same file
	int nRmcmd = 0;//Number of recursive method calling a regular method in a different fi
	int nMrgvs = 0; //Number of regular method referencing a global variable in the same file
	int nMrgvd = 0; //Number of regular method referencing a global variable in a different file
	int nRmrgvs = 0;//Number of recursive method referencing a global variable in the same file
	int nRmrgvd = 0;//Number of recursive method referencing a global variable in a different file
	int ccp = 0; /// Total value of coupling
	
	public int getnR() {
		return nR;
	}
	public void setnR(int nR) {
		this.nR = nR;
	}
	public int getnMcms() {
		return nMcms;
	}
	public void setnMcms(int nMcms) {
		this.nMcms = nMcms;
	}
	public int getnMcmd() {
		return nMcmd;
	}
	public int getCcp() {
		return ccp;
	}
	public void setCcp(int ccp) {
		this.ccp = ccp;
	}
	public void setnMcmd(int nMcmd) {
		this.nMcmd = nMcmd;
	}
	public int getnMcrms() {
		return nMcrms;
	}
	public void setnMcrms(int nMcrms) {
		this.nMcrms = nMcrms;
	}
	public int getnMcrmd() {
		return nMcrmd;
	}
	public void setnMcrmd(int nMcrmd) {
		this.nMcrmd = nMcrmd;
	}
	public int getnRmcrms() {
		return nRmcrms;
	}
	public void setnMmcrms(int nRmcrms) {
		this.nRmcrms = nRmcrms;
	}
	public int getnRmcrmd() {
		return nRmcrmd;
	}
	public void setnRmcrmd(int nRmcrmd) {
		this.nRmcrmd = nRmcrmd;
	}
	public int getnRmcms() {
		return nRmcms;
	}
	public void setnRmcms(int nRmcms) {
		this.nRmcms = nRmcms;
	}
	public int getnRmcmd() {
		return nRmcmd;
	}
	public void setnRmcmd(int nRmcmd) {
		this.nRmcmd = nRmcmd;
	}
	public int getnMrgvs() {
		return nMrgvs;
	}
	public void setnMrgvs(int nMrgvs) {
		this.nMrgvs = nMrgvs;
	}
	public int getnMrgvd() {
		return nMrgvd;
	}
	public void setnMrgvd(int nMrgvd) {
		this.nMrgvd = nMrgvd;
	}
	public int getnRmrgvs() {
		return nRmrgvs;
	}
	public void setnRmrgvs(int nRmrgvs) {
		this.nRmrgvs = nRmrgvs;
	}
	public int getnRmrgvd() {
		return nRmrgvd;
	}
	public void setnRmrgvd(int nRmrgvd) {
		this.nRmrgvd = nRmrgvd;
	}
	
	
	public String getvariableSegment() {
		return methodSegment;
	}	
	public String getMethodSegment() {
		return methodSegment;
	}
	public void setMethodSegment(String methodSegment) {
		this.methodSegment = methodSegment;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	
	
}
