/* Howard Szeto
 * tug of war */
import java.io.*;
import java.util.*;
class Main
{
  public static void main(String arg[])
  {
    Scanner sc = new Scanner (System.in);
    int numCases = sc.nextInt();
    for(int i=0;i<numCases;i++){
      int numPeople=sc.nextInt();
      int weights[]=new int[numPeople];
      for(int j=0;j<numPeople;j++){
        weights[j]=sc.nextInt();
      }
      computeSoln(numPeople,weights);
      if(i!=numCases-1)
        System.out.println();
    }
  }
  public static void computeSoln(int numPeople,int[] weights)
  { /* compute the problem */
    int sum=0;
    for(int i:weights)
      sum+=i;
    boolean possibleWeight[]=new boolean [45001];
    long people[]=new long[45001]; 
    //this array is used to keep track of how many people are needed to form weight k
    //if the i-th bit is turned on, it means that it is possible to form weight of k with i number of people
    //for example: if people[21]=0001 1110, it means that it is possible to form the weight of 21 with 1, 2, 3, or 4 people
    //since bit 1, 2, 3, and 4 are turned on.
    possibleWeight[0]=true; people[0]=1;
    
    for(int i=0;i<weights.length;i++){
      for(int j=possibleWeight.length-1;j>=0;j--){
        if(possibleWeight[j]){
          possibleWeight[j+weights[i]]=true;
          people[j+weights[i]]|=(people[j]<<1);
        }
      }
    }
    
    for(int i=sum/2;i>=0;i--){
      if(possibleWeight[i]){
        if(numPeople%2==0 && ((people[i]&((long)1<<(numPeople/2)))!=0)){
          System.out.println(""+i+" "+(sum-i)); return; 
        }else if(numPeople%2==1 && (((people[i]&((long)1<<(numPeople/2)))!=0)||
                                    ((people[i]&((long)1<<(numPeople/2+1)))!=0))){
          System.out.println(""+i+" "+(sum-i)); return;
        }
      }
    }
  }
}
