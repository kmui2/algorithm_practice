/*
methods to implement Alerter monitoring tool
*/
package interview;


public class practice{
	
	static boolean alert(int[] inputs, int windowSize, float allowedIncrease) {

	    boolean indivudualValueTest = indValTest(inputs, windowSize, allowedIncrease);	    
	    if(!indivudualValueTest)  {  
	        boolean windowTest =   windTest(inputs, windowSize, allowedIncrease);
	        if(windowTest) {
	            return true;
	        }
	        return false;
	    }
	    
	    
	    return true;

	}

	static boolean indValTest(int[] inputs, int windowSize, float allowedIncrease){
	    float allowedIncreasePercent = allowedIncrease*100 - 100;
	    int maxValue = findMaxValue(inputs);
	    float maxAverage = findAverage(inputs, windowSize,maxValue);
	    float allowedIncreasePercent_over_maxAverage = maxAverage + (allowedIncreasePercent/100)*maxAverage;
	    
	    System.out.println("maxValue= "+maxValue+" allowedIncreasePercent_over_maxAverage= "+allowedIncreasePercent_over_maxAverage);
	    
	    return (float)maxValue>allowedIncreasePercent_over_maxAverage;
	}

	static int findMaxValue(int[] inputs){
	    int max = inputs[0];
	    for(int i=1;i<inputs.length;i++){
	        if(inputs[i]>max){
	            max=inputs[i];
	        }
	    }
	    return max;
	}

	static float findAverage(int[] inputs, int windowSize, int maxValue){
	    float maxAvg = 0;
	    for(int i=0;i<inputs.length-windowSize;i=i+windowSize){
	        int sum=0; boolean compareMaxValue =false;
	        for(int j=0;j<windowSize;j++){
	            sum=sum+inputs[i+j];
	            if(maxValue == inputs[i+j]){
	                compareMaxValue=true;
	            }
	        }
	        if(compareMaxValue){
	            float avg = (float)sum/windowSize;
	            if(avg>maxAvg){
	                maxAvg = avg;
	            }
	        }
	    }
	    return maxAvg;
	}

	static boolean windTest(int[] inputs, int windowSize, float allowedIncrease){
	    float smallAvg = findSmallAvg(inputs, windowSize);
	    float largeAvg = findLargeAvg(inputs,windowSize);
	    
	    return largeAvg > allowedIncrease*smallAvg;
	}

	    static float findLargeAvg(int[] inputs, int windowSize){
	    float maxAvg = Float.MIN_VALUE;
	    for(int i=0;i<inputs.length-windowSize;i=i+windowSize){
	        int sum=0; 
	        for(int j=0;j<windowSize;j++){
	            sum=sum+inputs[i+j];
	         }

	            float avg = (float)sum/windowSize;
	            if(avg>maxAvg){
	                maxAvg = avg;
	            }
	        }
	    return maxAvg;
	}

	       static float findSmallAvg(int[] inputs, int windowSize){
	    float minAvg = Float.MAX_VALUE;
	    for(int i=0;i<inputs.length-windowSize;i=i+windowSize){
	        int sum=0; 
	        for(int j=0;j<windowSize;j++){
	            sum=sum+inputs[i+j];
	         }

	            float avg = (float)sum/windowSize;
	            if(avg<minAvg){
	                minAvg = avg;
	            }
	        }
	    return minAvg;
	}
	
	
	
	
		public static void main(String[] args){
			
			int[] inputs = {1,2,100,2,2};
			int windowSize = 2;
			float allowedIncrease = (float) 2.5;
			
			System.out.println(alert(inputs, windowSize, allowedIncrease));
		}
}
