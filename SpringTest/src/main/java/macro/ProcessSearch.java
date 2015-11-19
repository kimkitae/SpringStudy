package macro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class ProcessSearch {
	public static List listRunningProcesses(String processName) {
  List processes = new ArrayList();
  try {
	  String line;
	   StringTokenizer temp;
	   Process p = Runtime.getRuntime().exec("tasklist.exe /FI \"IMAGENAME eq \""+processName+" /NH");
	   BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	   while ((line = input.readLine()) != null) {
	    if (!line.trim().equals("")) {
	    
	      processes.add(line.substring(0, line.indexOf(" ")));
	     }
	    
	   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return processes;
	 }
	
	public static boolean result(){
		  List processes = listRunningProcesses("EXCEL.EXE");
		
		return processes.get(0).equals("EXCEL.EXE");
	}
	 public static void main(String[] args) {
	
if(result() == true){
	System.out.println("���� ���α׷��� ���� ���Դϴ�.");
}else{
	System.out.println("���� ���α׷��� �߷� �Ǿ����ϴ�.");
}

	}}