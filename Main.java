/*import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        int size=st.size();
        System.out.println("Size of Stack before popping: "+size);
        int top=st.peek();
        System.out.println("Element at top of the stack : "+top);

        while(st.size()>0){
            System.out.println(st.pop());
        }

        size=st.size();
        System.out.println("Size of Stack after popping: "+size);
    }
}*/


//----------------------------------------------------------------------------------------------------

// EXTRA BRACKETS

/*import java.util.*;

public class Main{

    public static boolean brackets(Stack<Character> st,String exp){
        int i=0;
        while(i<exp.length()){
            if(exp.charAt(i)==')' && st.peek()=='('){
                return true;
            }
            else if(exp.charAt(i)!=')'){
                st.push(exp.charAt(i));
                i++;
            }
            else{
                int j=i-1;
                while(exp.charAt(j)!='('){
                    st.pop();
                    j--;
                }
                st.pop();
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        Stack<Character> st=new Stack<>();
        String exp=scn.next();

        boolean bkt=brackets(st,exp);
        System.out.println(bkt);
    }
}*/

//----------------------------------------------------------------------------------------------------------

// BALENCE BRACKETS

/*import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static boolean balancedBrackets(Stack<Character> st,String exp){
        int i=0;
        while(i!=exp.length()){
            if(exp.charAt(i)=='(' || exp.charAt(i)=='[' || exp.charAt(i)=='{'){
                st.push(exp.charAt(i));
            }
            else{
                if(exp.charAt(i)==')'){
                    if(st.size()==0){
                        return false;
                    }
                    else{
                        if(st.peek()=='('){
                            st.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
                if(exp.charAt(i)==']'){
                    if(st.size()==0){
                        return false;
                    }
                    else{
                        if(st.peek()=='['){
                            st.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
                if(exp.charAt(i)=='}'){
                    if(st.size()==0){
                        return false;
                    }
                    else{
                        if(st.peek()=='{'){
                            st.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            i++;
        }
        if(st.size()!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String exp=scn.next();
        Stack<Character> st=new Stack<>();

        boolean bb=balancedBrackets(st,exp);
        System.out.println(bb);
    }
}*/

//-----------------------------------------------------------------------------------------------------------

// NEXT GREATER ELEMENT TO RIGHT

/*import java.util.*;

public class Main{

    public static int[] nextGreater(int[] arr,Stack<Integer> st){
        int n=arr.length;
        int[] ans=new int[n];
        st.push(arr[n-1]);
        ans[n-1]=-1;

        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && arr[i]>st.peek()){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }

            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st=new Stack<>();

        int[] ng=nextGreater(arr,st);
        for(int i=0;i< ng.length;i++){
            System.out.print(ng[i]+" ");
        }
    }
}*/

//-----------------------------------------------------------------------------------------------------------

// NEXT GREATER TO LEFT

/*import java.util.Scanner;
import java.util.Stack;

public class Main{

    public static int[] nextGreaterToLeft(Stack<Integer> st,int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        ans[0]=-1;
        st.push(arr[0]);

        for(int i=1;i<n;i++){
            while(st.size()!=0 && arr[i]>st.peek()){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st=new Stack<>();

        int[] ng=nextGreaterToLeft(st,arr);
        for(int i=0;i<n;i++){
            System.out.print(ng[i]+" ");
        }
    }
}*/

//-------------------------------------------------------------------------------------------------------

// NEXT SMALLER TO RIGHT

/*import java.util.*;

public class Main{

    public static int[] nextSmallerToRight(Stack<Integer> st,int[] arr){
        int n= arr.length;
        int[] ans=new int[n];
        ans[n-1]=-1;
        st.push(arr[n-1]);

        for(int i=n-2;i>=0;i--){
            while(st.size()!=0 && arr[i]<st.peek()){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st=new Stack<>();

        int[] ns=nextSmallerToRight(st,arr);
        for(int i=0;i<ns.length;i++){
            System.out.print(ns[i]+" ");
        }
    }
}*/

//-------------------------------------------------------------------------------------------------------

// STOCK SPAN

/*import java.util.*;

public class Main{

    public static int[] stockSpan(Stack<Integer> st,int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        ans[0]=1;
        st.push(0);

        for(int i=1;i<n;i++){
            while(st.size()!=0 && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;
            }
            else{
                ans[i]=i-st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st=new Stack<>();

        int[] sp=stockSpan(st,arr);
        for(int i=0;i<sp.length;i++){
            System.out.print(sp[i]+" ");
        }
    }
}*/

//------------------------------------------------------------------------------------------------------

// MAXIMUM AREA OF HISTOGRAM

import java.util.*;

public class Main{

    public static int[] nextSmallerToLeft(Stack<Integer> st,int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        ans[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()!=0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerToRight(Stack<Integer> st,int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        ans[n-1]=-1;
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(st.size()!=0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int histogramArea(Stack<Integer> st1,Stack<Integer> st2,int[] arr){
        int i=0;
        int[] ansL=nextSmallerToLeft(st1,arr);
//        for(int j=0;j<ansL.length;j++){
//            System.out.print(ansL[j]+" ");
//        }
//        System.out.println();
        int[] ansR=nextSmallerToRight(st2,arr);
//        for(int j=0;j<ansR.length;j++){
//            System.out.print(ansR[j]+" ");
//        }
//        System.out.println();
        int maxArea=Integer.MIN_VALUE;
        while(i<arr.length){
            if(ansL[i]==-1 && ansR[i]==-1){
                int wdt=ansL.length;
                int pArea=wdt*arr[i];
                if(maxArea<pArea){
                    maxArea=pArea;
                }
            }
            else if(ansL[i]==-1){
                int pArea=arr[i]*ansR[i];
                if(maxArea<pArea){
                    maxArea=pArea;
                }
            }
            else if(ansR[i]==-1){
                int wdt= ansL.length-1-ansL[i];
                int pArea=wdt*arr[i];
                if(maxArea<pArea){
                    maxArea=pArea;
                }
            }
            else{
                int wdt=ansR[i]-ansL[i]-1;
                int pArea=wdt*arr[i];
                if(maxArea<pArea){
                    maxArea=pArea;
                }
            }
            i++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();

        int h=histogramArea(st1,st2,arr);
        System.out.println(h);
    }
}




