
package interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
build a to-do list
1) add task
2) mark task as completed
*/

class task{
	String name;
	boolean completed;
	Date duedate;
	
	public task(String tname, Date tduedate){
		this.name = tname;
		this.duedate = tduedate;
		this.completed = false;
	}
}

class todoList{
	private Map<Long,List<task>> todolist = new HashMap<Long,List<task>>();
	
	public void addtask(String tname, String tduedate) throws ParseException{
		
		Date tduedateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(tduedate);
		Date keyduedateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(tduedate);
		
		long keydate = keyduedateFormat.getTime();
		
		task t = new task(tname,tduedateFormat);
		
		if(!todolist.containsKey(keydate)){
			List<task> templist = new ArrayList<task>();
			templist.add(t);
			todolist.put(keydate,templist);
		}
		else{
			List<task> templist = new ArrayList<task>();
			templist.addAll(todolist.get(keydate));
			templist.add(t);
			todolist.put(keydate,templist);
		}
		
	}
	
	public void markCompleted(String tname, String tduedate) throws ParseException{ //assume this tduedate does not have hour and minutes but just the day, month and year for key
		
		Date keyduedateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(tduedate);
		long keydate = keyduedateFormat.getTime();
		
		List<task> alltask = new ArrayList<task>();
		alltask.addAll(todolist.get(keydate));
		
		for(int i=0;i<alltask.size();i++){
			task theTask = alltask.get(i);
			String taskname = theTask.name;
			if(taskname.equals(tname)){
				theTask.completed = true;
			}
		}
	}
	
	public List<task> sortStatus(String tduedate) throws ParseException{ //assume this tduedate does not have hour and minutes but just the day, month and year for key
		
		Date keyduedateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(tduedate);
		long keydate = keyduedateFormat.getTime();
		
		List<task> alltask = new ArrayList<task>();
		alltask.addAll(todolist.get(keydate));
		
		Collections.sort(alltask, new Comparator<task>(){
			public int compare(task t1, task t2){
				return (Boolean.valueOf(t1.completed)).compareTo(Boolean.valueOf(t2.completed));
			}
		});
		return alltask;
	}
	
	public String toString(task t){
		return (t.name+" : "+t.completed +" : "+t.duedate);
	}
	
}

public class practice{
		public static void main(String[] args) throws ParseException{
			todoList obj = new todoList();
			
			obj.addtask("task1","3/6/2018 13:52");
			obj.addtask("task2","3/6/2018 15:52");
			obj.markCompleted("task1","3/6/2018");
			
			List<task> output  = new ArrayList<task>();
			output.addAll(obj.sortStatus("3/6/2018"));
			
			for(int i=0;i<output.size();i++){
				System.out.println(obj.toString(output.get(i)));
			}
		}
}
