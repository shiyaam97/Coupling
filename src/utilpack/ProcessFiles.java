package utilpack;

import java.io.*;
import java.lang.reflect.Array;
import java.security.acl.Group;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Package;
import javax.lang.model.element.VariableElement;


import servelt.CouplingServelt;

public class ProcessFiles {

	/* patterns */
	String patternMethod = "(?:(?:public)|(?:private)|(?:static)|(?:protected))((\\s*\\w*)*(\\((?:.*)*))";
	String patternVariable = "((?:(?:public)|(?:private)|(?:static)|(?:protected))|((\\s*)(\\w*))*(?:(=\\s*\\w*)|)(;))";// "((?:(?:public)|(?:private)|(?:static)|(?:protected))";
	String patternInmethod = "\\w*\\(\\)";
	String patternInVariable = "((=)|(\\+)|(\\-)|(\\/)|(\\*))";// "((?:=)|(?:\\+)|(?:\\-)|(?:\\/)|(?:\\*)|(?:\\(.*\\)))";
	String patternInVariableE = "(\\d+|\\\".*\\\"|\\+|\\-|\\/|\\*|\\=)|(\\w*\\(\\w+.*\\))";// "(\\d+|\\\".*\\\"|\\+|\\-|\\|\\*|\\=)";
	String patternInMVariableD = "(\\d+|\\\".*\\\")|(\\w*\\(\\w+.*\\))";

	/* compile the patterns */
	Pattern pattern = Pattern.compile(patternMethod);
	Pattern patternV = Pattern.compile(patternVariable);
	Pattern patternIM = Pattern.compile(patternInmethod);
	Pattern patternIV = Pattern.compile(patternInVariable);
	Pattern patternIVE = Pattern.compile(patternInVariableE);
	Pattern patternInMeD = Pattern.compile(patternInMVariableD);

	StringBuilder builder = new StringBuilder();
	public HashMap<String, Method> methodMap = new HashMap<String, Method>();
	ArrayList<String> variableArray = new ArrayList<>();
	// Method[] methods = new Method[] {};

	int openCount = 0;
	String methodName = "";
	String variableIName = "";
	boolean methodFound = false;
	boolean variableFound = false;

	public ProcessFiles() {

	}

	public void StartCalculate() throws IOException {

		try {
			processFile("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void processFile(String path) throws Exception {

//		Scanner input = new Scanner(new File("filereader.txt"));
		File file = new File("C:/Users/DELL/Desktop/akhilan/CouplingProject/src/filereader.txt"); // creates a new file
																									// instance
		FileReader fr = new FileReader(file); // reads the file
		BufferedReader reader = new BufferedReader(fr);

		String strCurrentLine;
//		Pattern patternC = Pattern.compile(patternClose);

		while ((strCurrentLine = reader.readLine()) != null) {

			findVariales(strCurrentLine);
			findMethods(strCurrentLine);

		}
		reader.close();
		findReferredMethod(methodMap);
		findReferredVariable(methodMap);
		findCoupling(methodMap);

	}

	private void findMethods(String strCurrentLine) {
		if (methodFound) {

			builder.append(strCurrentLine);
		}

		Matcher matcher = pattern.matcher(strCurrentLine);

		boolean matches = matcher.matches();
		if (matches) {
			openCount = 0;
			int bracketPosition = strCurrentLine.indexOf(")");
			if (bracketPosition > -1) {
				String s = strCurrentLine.substring(0, bracketPosition + 1);
				s = s.trim();
				methodName = s.substring(s.lastIndexOf(" ")).trim();
				Method method = new Method();
				method.setMethodName(methodName);
				System.out.println(methodName);
				methodMap.put(method.methodName, method);
//				builder.append(strCurrentLine);
				methodFound = true;
			}

		}
		if (strCurrentLine.indexOf("{") > -1) {
			++openCount;
		}
		if (strCurrentLine.indexOf("}") > -1) {
			--openCount;
		}

		if (openCount == 0 && methodMap.size() > 0) {
			String methodSegment = builder.toString();
//			System.out.println(methodSegment);
			methodMap.get(methodName).setMethodSegment(methodSegment);
			builder = new StringBuilder();
			methodFound = false;
			openCount = -1;
		}

	}

	private void findVariales(String strCurrentLine) {

		String variableName;
		Matcher matcherV = patternV.matcher(strCurrentLine);
		// System.out.println("LINE: " + strCurrentLine);
		boolean matchesV = matcherV.matches();

		if (matchesV) {
			if (strCurrentLine.contains("=")) {
				int indexofequalsign = strCurrentLine.indexOf("=");
				String variable = strCurrentLine.substring(0, indexofequalsign);
				/* System.out.println(variable); */
				variable = variable.trim();
				variableName = variable.substring(variable.lastIndexOf(" "));
				variableArray.add(variableName.trim());

			} else {
				int indexofsemicolon = strCurrentLine.indexOf(";");
				String variableS = strCurrentLine.substring(0, indexofsemicolon);
				variableS = variableS.trim();
				int lastIndex = variableS.lastIndexOf(" ");
				if (lastIndex > -1) {
					variableName = variableS.substring(lastIndex);

					variableArray.add(variableName.trim());

				}

			}
		}
	}

	/**
	 * Finds the referred methods for a given method
	 * 
	 * @param methods
	 */

	private void findReferredMethod(Map<String, Method> methods) {
		for (Method m : methods.values()) {
			System.out.println(methods);
			String[] lines = m.methodSegment.split(";");
			for (String line : lines) {
				line = line.trim();
				Matcher matcher = patternIM.matcher(line);
				if (matcher.matches()) {

					if (line.equals(m.methodName)) {
						// recursiveMethod
						m.type = "Recursive";
						int nR = m.nR++;

						System.out.println("recurive" + " " + line);

					} else {
						m.type = "Regular";

						Method callMethod = methodMap.get(line);
						m.callingMethods.add(callMethod);
//						System.out.println(callMethod);
					}

				}
			}

		}
	}

	/* Finds the referred variale for given method */
	private void findReferredVariable(Map<String, Method> methods) {
		for (Method m : methods.values()) {
			String[] lines = m.methodSegment.split(";");

			for (String line : lines) {
				line = line.trim();
				Matcher matcher = patternIVE.matcher(line);
				// boolean matches = matcher.matches();

				if (matcher.find()) {
					int bracketPosition = line.indexOf("(");
					if (bracketPosition > -1) {
						variableIName = line.substring(bracketPosition + 1, line.lastIndexOf(")"));
						String[] callVariable = variableIName.split(",");
						m.callingVariables.addAll(Arrays.asList(callVariable));
						System.out.println(Arrays.toString(callVariable));
						// m.callingVariables = Arrays.asList(callVariable);
						// m.callingVariables.add();
						// System.out.println(Arrays.toString(variableInMethod));
					} else {
						int indexofequalsign = line.indexOf("=");
						String variableInMethodL = line.substring(0, indexofequalsign);
						String variableInMethodR = line.substring(indexofequalsign + 1);
						variableInMethodL = variableInMethodL.trim();
						variableInMethodR = variableInMethodR.trim();
						// c = a + b;

						if (variableInMethodL.split(" ").length == 1)
							System.out.println(variableInMethodL);

						System.out.println(variableInMethodR);
						variableInMethodR = variableInMethodR.replace("(", "").replace("-", "").replace("+", "")
								.replace("*", "").replace("/", "").replace(")", "");

						System.out.println(variableInMethodR);

						Matcher matcherInMeD = patternInMeD.matcher(variableInMethodR);
						if (matcherInMeD.find()) {

							String removeMatcher = matcherInMeD.group();
							System.out.println("Remove" + " " + removeMatcher);
							variableInMethodR = variableInMethodR.replace(removeMatcher, "");

						}

//						variableInMethodR = variableInMethodR.replace(" ", "");
						String callVariable[] = variableInMethodR.split("\\s+");
						m.callingVariables.addAll(Arrays.asList(callVariable));
						System.out.println(Arrays.toString(callVariable));
					}

					// System.out.println("found");
					for (String array : variableArray) {
						System.out.println(array);
					}

				}

			}

		}

	}

	/* Find the Coupling */

	public void findCoupling(Map<String, Method> method) {
		for (Method m : method.values()) {
				for (Method callingMethod : m.callingMethods) {
				if (m.methodName.equals(callingMethod)) {
						if (callingMethod.type.equals("Recursive")) {
							m.nMcrms++;
							System.out.println("RRRRRRRRRRRR");
						} else {
							m.nMcms++;

						}
					}
				
				

				for (String callingVariable : m.callingVariables) {
					for (String localVariable : variableArray) {
						if (localVariable.equals(callingVariable)) {
							System.out.println("find a global variable" + " " + callingVariable);
							if (m.type.equals("Recursive")) {
								m.nRmrgvs++;

							} else if (m.type.equals("Regular")) {
								m.nMrgvs++;
							}

						}

					}

				}

			}
			m.ccp = (m.nR * CouplingServelt.wR) + (m.nMcrms * CouplingServelt.wMcrms)
					+ (m.nMcms * CouplingServelt.wMcms) + (m.nRmrgvs * CouplingServelt.wRmrgvs)
					+ (m.nMrgvs * CouplingServelt.wMrgvs);

			System.out.println(m.ccp);
		}

	}

}
