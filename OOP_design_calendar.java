/*
 * build a simple calendar
 * 1) add events
 * 2) retrieve events on a given day
 */
 
 
 package interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class event{
    
    String event_name;
    Date fd;
    public event(String en, Date fd){
        this.event_name = en;
        this.fd =fd;
    }
}

class calendar{
	 private Map<Long, ArrayList<event>> events = new HashMap<Long, ArrayList<event>>();	
	 
	 public void set_event(String event_name, String sd) throws ParseException{
		   
		   Date full_d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sd);
	       Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sd);

		   
	        long key_date = d.getTime();
	        event e = new event(event_name,full_d);
	        if(!events.containsKey(key_date)){
	            ArrayList<event> temp = new ArrayList<event>();
	            temp.add(e);
	            events.put(key_date,temp);
	        }
	        else{
	            ArrayList<event> temp = new ArrayList<event>();
	            temp.addAll(events.get(key_date));
	            temp.add(e);
	            events.put(key_date,temp);
	        }
	    }
	    
	    public List<event> get_event(String sd) throws ParseException{
	    	
	    	//Date full_d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sd);
	        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sd);

	    	
	        List<event> result = new ArrayList<event>();
	        long key_date = d.getTime();
	        result.addAll(events.get(key_date));
	        return result;
	    }       
	   
	    public String toString(event e) {
	    	return (e.event_name+" "+e.fd);
	    }
}

public class practice {
       
   public static void main(String args[] ) throws Exception {

       calendar obj = new calendar();
//       String sd = "3/6/2018 13:52";       
//       System.out.println("full date is:"+full_d);
//       System.out.println("date is:"+d);
       
       //date format: dd/MM/yyyy
       obj.set_event("Tech Seminar","3/6/2018 13:52");
       obj.set_event("Tech2 Seminar","3/6/2018 15:22");
       obj.set_event("Tech3 Seminar","16/3/2018 10:30");
       
       List<event> output = new ArrayList<event>();
	   output.addAll(obj.get_event("3/6/2018 13:52"));
		for(int i=0;i<output.size();i++){
			System.out.println(obj.toString(output.get(i)));
		}
       
   }
}