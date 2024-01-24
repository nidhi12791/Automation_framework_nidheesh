package practise_adv_auto;

public class GenericMethodPractice {

public static void main(String[] args) {
//hardcoded
int a=10;
int b=20;
int c=a+b;
System.out.println(c);

add(10,52);
int sum=add(122,52);
System.out.println(sum);

}

//generic method/reusable method
public static int add(int a,int b){//called method

int c=a+b;
return c;

}
}