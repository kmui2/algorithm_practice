/* Detecting Fraud


Problem StatementIntroductionBackgroundA company that relies heavily on contractors suspects that some of those contractors areunder-reporting the time taken to complete a job. They caught one manager bribing acontractor to falsify when they started a job in order to increase the efficiency of theirdepartment. The company needs help automatically identifying similar cases of fraud.Billing & Reporting ProcessThe company has separate systems for job tracking and billing:Contractors indicate when they start working on a job by submitting a job start notice tothe job tracking system.During the job, they enter a single invoice into the billing system. The billing system thengives back a unique, increasing numeric invoice ID.Upon completion, contractors submit their invoice IDs to job tracking, which records thatthe jobs were completed. A contractor must complete and submit all open jobs together.ObjectiveConnection attempt failed.Detecting Contractor Fraud01h : 14m : 16sto test end
28/11/2017Detecting Contractor Fraud :: powered by HackerRankhttps://www.hackerrank.com/tests/5trognjk2cp/questions/cm3t1o17lqf2/8You have the job system’s log of job start events and job completion events, along with theinvoice IDs submitted with each completion event. Your goal is to develop an algorithm thatreads events from the job tracking system and indicates if any contractors have submittedfraudulent records.InputYou will receive a string array of at most 300,000 strings, where each string corresponds to oneevent. These events are already sorted in terms of time, and take one of two forms:1. Job start eventsTake the form <CONTRACTOR_NAME>;STARTThe CONTRACTOR_NAME is a unique identifier for the contractor, and is guaranteed notto contain a semicolon.2. Job completion eventsTake the form <CONTRACTOR_NAME>;<INVOICE_ID>(,<INVOICE_ID>)*The CONTRACTOR_NAME is the same unique identifier for the contractor as before.INVOICE_ID 's are integer values, guaranteed to fit within the value of a signed 64-bit long.If a contractor has multiple jobs started, then they will complete and submit invoiceIDs for all started jobs as a single job completion event. These invoice IDs will becomma-delimited, one invoice ID per job start event. These are referred to as "batchjob completions".For example, if a contractor has started three jobs, then the next job completionfrom that contractor is guaranteed to consist of three distinct invoice IDs.We do not know which invoice number corresponds to which job start event.You may assume that the input will always be well-formed and contain no extra characters orwhitespace.Note that we will represent input and output string arrays as lines of text, where each linerefers to one string in the array (in order). For example,JeremyTomNickLeahmeans the string array [Jeremy, Tom, Nick, Leah] (in that order).Detecting FraudThere are two kinds of fraudulent submissions you need to detect: shortened jobs andsuspicious batches. It is recommended that you first work on detecting shortened jobs beforetackling suspicious batches.Shortened JobsConnection attempt failed.Detecting Contractor Fraud01h : 14m : 16sto test end
28/11/2017Detecting Contractor Fraud :: powered by HackerRankhttps://www.hackerrank.com/tests/5trognjk2cp/questions/cm3t1o17lqf3/8These are job start events which, given their later submitted invoice ID, must have beensubmitted artificially late -- that is, jobs with an invoice ID smaller than any invoice IDsubmitted before their start.For example, consider this event log:David;STARTDavid;24Evil;STARTEvil;18According to the log, first David starts a job, gets an invoice ID of 24, and then submits a jobcompletion with invoice ID 24. Evil later does the same, with a invoice ID of 18.However, Evil could not have started his job after David finished his, because Evil's smallerinvoice ID implies he must have gotten his invoice ID before David, and invoice IDs cannot begotten before job start.Therefore, Evil's job start event on the third line is a shortened job.Suspicious BatchesThese are batch job completions which, given their invoice IDs and their associated startevents, must contain at least one shortened job.If it is clear that a given start job event within a batch must have been reported late (the jobwas shortened), then it is both part of a suspicious batch and is itself a shortened job.For example, consider this event log:Leah;START Leah;10 Alice;STARTAlice;STARTAlice;8,14According to the log, first Leah started and completed a job with an invoice ID of 10.Then Alice starts 2 jobs, gets invoice IDs 8 and 14 for the two jobs, and finally submits a batchjob completion with the invoice IDs.Except Alice's must have gotten an invoice for one of her jobs before Leah, otherwise Alicecouldn't submit to an invoice ID of 8 to job tracking.Therefore, Alice's batch job completion on the fifth line is a suspicious batch, because at leastone of the start events should have been before Leah's job completion.We can't identify which one of Alice's two job start events was the one that was shortened, sowe cannot mark either of them as shortened jobs. If both IDs were below 10, then we wouldalso mark both start events as shortened jobs.Note that, when checking a given job completion event and its associated job starts forviolations, you may assume previous events were submitted correctly, even if those previousConnection attempt failed.Detecting Contractor Fraud01h : 14m : 16sto test end
28/11/2017Detecting Contractor Fraud :: powered by HackerRankhttps://www.hackerrank.com/tests/5trognjk2cp/questions/cm3t1o17lqf4/8events generated violations when they in turn were checked.OutputYour algorithm should return a string array that can be used by downstream systems whichindicates the set of submissions that are possibly fraudulent.For each suspicious behavior identified, the string array you return should contain a line of theform <LINE_NUMBER>;<CONTRACTOR_NAME>;<VIOLATION_TYPE>.LINE_NUMBER is a (one-indexed) line number from the input.For SUSPICIOUS_BATCH, this is the line on which the batch job completion occurred.For SHORTENED_JOB, this is the line on which the job start occurred.CONTRACTOR_NAME is the unique identifier of the offending the contractor.VIOLATION_TYPE is a string that matches either SHORTENED_JOB orSUSPICIOUS_BATCH. This indicates which pattern we have identified, following the rulesabove.You may present violations in any order.TestsThe tests are split into three sections, labeled as Easy, Medium and Hard tests.Tests 1-11 verify that your solution is able to identify shortened jobs correctly andscaleably.Tests 12-15 verify that your solution handles batch submissions and can correctly identifysuspicious batches. Identifying shortened jobs within shortened batches is not required.Tests 16-22 verify that your solution can correctly identify shortened jobs within suspiciousbatches, handle complex interactions between fraudulent submissions correctly, andscales.You do not need to pass all of the tests to pass the challenge.Sample Test ExplanationsThere are seven test cases which you will be able to see the input and your output for.Explanations three of them are given below:Testcase 1:InputAlice;STARTBob;STARTBob;1Carson;STARTAlice;15Carson;6David;STARTDavid;24Evil;STARTEvil;24Evil;STARTConnection attempt failed.Detecting Contractor Fraud01h : 14m : 16sto test end
28/11/2017Detecting Contractor Fraud :: powered by HackerRankhttps://www.hackerrank.com/tests/5trognjk2cp/questions/cm3t1o17lqf5/8Evil;18Fiona;STARTOutput11;Evil;SHORTENED_JOBExplanation"Bob;1" is certainly valid."Alice;15" is valid.It does not matter here that Alice started first; she started before Bob finished."Carson;6" is also valid.Carson started his job after Bob finished, but his invoice number wasn't smaller thanBob's.Carson did *not* start his job after Alice finished, so we can't identify this as aSHORTENED_JOB on the basis of that."David;24" is valid."Evil;24" is valid.This seems unusual, but is permitted (e.g. if they worked together on the job)."Evil;18" is not valid.Evil started its job after David's job which had invoice 24 finished; this is aSHORTENED_JOB.This should be logged as "11;Evil;SHORTENED_JOB", because Evil STARTed this job online 11 and only submitted one job.Fiona had not finished her job (or at least, had not reported it to job tracking) at the timethe data-source was read, but that's perfectly legitimate.Testcase 2:InputTom;STARTJeremy;STARTDana;STARTJeremy;4Dana;2James;STARTLeah;STARTJames;5Nick;STARTTom;1Nick;6Leah;3Output1Connection attempt failed.Detecting Contractor Fraud01h : 14m : 16sto test end
28/11/2017Detecting Contractor Fraud :: powered by HackerRankhttps://www.hackerrank.com/tests/5trognjk2cp/questions/cm3t1o17lqf6/87;Leah;SHORTENED_JOBExplanation"Leah;START" is invalid.When Leah started her job, Jeremy and Dana had finished their jobs, with the highestinvoice number being 4. This is higher than the invoice Leah ultimately submitted, soshe must have shortened her job.All other jobs were valid.Testcase 12:InputNick;STARTJeremy;STARTLeah;STARTNick;10Jeremy;STARTJeremy;STARTLeah;15Jeremy;8,14,9Output8;Jeremy;SUSPICIOUS_BATCHExplanation"Nick;10" and "Leah;15" are valid, because no one started any jobs before Nick or Leahstarted."Jeremy;8,14,9" is not valid.This is a suspicious batch, because Jeremy submitted two jobs after Nick finished thejob with invoice number 10. One of these jobs must have had an invoice number ofeither 8 or 9 (definitely less than 10), and must thus have been shortened.However, because each job might have had the valid invoice number of 14, none ofthe actual jobs can uniquely be identified as shortened.

*/

package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class practice {

	public String[] detecting_fraud(String[] jobs){
		
		//store name and start index of contractors
		HashMap<String,Integer> start_index = new HashMap<String, Integer>();
		
		//store name and end index of contractors
		HashMap<String,Integer> end_index = new HashMap<String, Integer>();
		
		//store name and invoice ids of contractors
		HashMap<String,Integer> invoice_id = new HashMap<String,Integer>();
		
		ArrayList<String> result_list = new ArrayList<String>();
		
		for(int i=0;i<jobs.length;i++){
			
			//line number
			int line_number =i+1;
			
			//split input
			String[] a_job = jobs[i].split(";");
			
			//get 1st part of string i.e: name
			String name = a_job[0];
			
			//get 2nd part of string
			String second_part = a_job[1]; 
			
			//if 2nd part ==START,
			if(second_part.equals("START")){
				//see if this name is in end_index hashmap.if exist, this index i is SHORTENED_JOB. remove from start_index and end_index hashmap
					if(end_index.containsKey(name)){
						String shortened_job = line_number+";"+name+";"+"SHORTENED_JOB";
						result_list.add(shortened_job);
						
						start_index.remove(name);
						end_index.remove(name);
					}
				//if this name is not in end_index hashmap, insert in start_index hashmap
					else{
						start_index.put(name,line_number);
					}
				
			}
			
			//if 2nd part !=START i.e: numbers for invoice id and start_index still contains the name(i.e: it was not removed in logic above when 2nd part is START)
			else if(start_index.containsKey(name)){
				//convert this invoice id into Integer.
				int second_part_int = Integer.parseInt(second_part);
				
				//insert in end_index hashmap
				end_index.put(name,line_number);
				
				//loop through invoice_id hashmap
				Iterator it = invoice_id.entrySet().iterator();
				boolean flag_error = false;
				while(it.hasNext()){
					Map.Entry<String,Integer> pair = (Map.Entry)it.next();
					
					//if any invoice id > this invoice id, find start index for this name, find the end index for that found invoice id name
					if(pair.getValue()>second_part_int){
						int temp_start_index = start_index.get(name);
						int temp_end_index = end_index.get(pair.getKey());
									
						//if current start index > end index found, current job is SHORTENED_JOB. Remove this name from all 3 hashmaps. flag the error and break the loop
						if(temp_start_index>temp_end_index)	{
							String shortened_job = temp_start_index+";"+name+";"+"SHORTENED_JOB";
							result_list.add(shortened_job);
							
							start_index.remove(name);
							end_index.remove(name);
							
							flag_error=true;
							
							break;
						}
							
							//if there are multiple invoice_id, current job is SUSPICIOUS_JOB. Remove this name from all 3 hashmaps.
					}
				}	
					//else insert in invoice_id hashmap
					if(!flag_error){
						invoice_id.put(name,second_part_int);
					}
				
			}  //end of if(!=START)
			
			
		}
			
		//convert result_list to String[] and return this
		String[] result = result_list.toArray(new String[result_list.size()]);
		return result;
		
	}


	public static void main(String[] args){
		practice obj = new practice();
		String[] input_data = {"Tom;START","Jer;START","Dana;START","Jer;4","Dana;2","James;START","Leah;START","James;5","Nick;START","Tom;1","Nick;6","Leah;3"};
		
		String[] output= obj.detecting_fraud(input_data);
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i]);
		}
	}
	
	}
























