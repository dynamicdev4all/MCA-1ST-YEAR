import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Exp {
    public static void main(String[] args) {
        // Object --> this is God Class
        // -> Error --> JVM, JDK, Env, OS
        // -> Exceptions
        // -> Compile time
        // -> Run time

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // try {
        // int c = a / b ; // in case the denominator is zero an exception will occur
        // knows as Arithmetic Excpetion or Divide by zero exception.
        // } catch(ArithmeticException ax){

        // }catch (Exception euyfjyfhtfd) {
        // // TODO: handle exception
        // }

        // try {
        // new PrintStream("D:\\MCA-1st-Year\\demo.txt").println("this statement uses no
        // system class");
        // } catch(ArithmeticException akhdfghaef){

        // }
        // catch (RuntimeException e) {
        // // TODO: handle exception
        // }catch(Exception dfg){

        // }

        // try {
        // new PrintStream("D:\\MCA-1st-Year\\demo.txt").println("this statement uses no
        // system class");
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }finally{

        // }

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // try {
        // int c = a / b ; // in case the denominator is zero an exception will occur knows as Arithmetic Excpetion or Divide by zero exception.
        // } catch(ArithmeticException ax){

        // }catch (Exception euyfjyfhtfd) {
        // // TODO: handle exception
        // }finally{
        // // sc.close();
        // }

        try (Scanner sc = new Scanner(System.in);) {
            int a = sc.nextInt();
            int b = sc.nextInt();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

