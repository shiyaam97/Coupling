package utilpack;
import java.util.HashMap;
import java.util.List;

public class CheckingFile {

	String name;
	HashMap<String, Method> methods;
	List<String> globalVariables;
	
	public boolean isVariableExist(String variable) {
		return globalVariables.contains(variable);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Method> getMethods() {
		return methods;
	}

	public void setMethods(HashMap<String, Method> methods) {
		this.methods = methods;
	}

	public List<String> getGlobalVariables() {
		return globalVariables;
	}

	public void setGlobalVariables(List<String> globalVariables) {
		this.globalVariables = globalVariables;
	}
	
		
}
