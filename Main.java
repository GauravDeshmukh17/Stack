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

import java.util.*;

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
}







