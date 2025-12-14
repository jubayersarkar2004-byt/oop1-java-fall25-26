
//one to one 
class Passport {

private String passportNum;
private String issueDate;
private String expireDate;


public void setPassportNum(String passportNum){

    this.passportNum = passportNum;
}

public void setIssueDate(String issueDate){

    this.issueDate=issueDate;
}


public void setExpireDate(String expireDate){

    this.expireDate = expireDate;
}
public String getPassportNum() {

    return passportNum;
}
public String getIssueDate(){

    return issueDate;
}
public String getExpireDate(){

    return expireDate;
}

// constructor
public Passport(String passportNum,String issueDate,String expireDate){

    this.passportNum = passportNum;
    this.issueDate =issueDate;
    this.expireDate = expireDate;
}

public void showPassport(){
    System.out.println("passport number:"+passportNum);
    System.out.println("Issue Date:"+ issueDate);
    System.out.println("Expire Date:" + expireDate );
}


}

class Person {

    private String name;
    private int age;
    private Passport pp;


    public void setName(String name){

        this.name=name;
    }
    public String getName(){

        return name;
    }

    public void setAge(int age){
   
        this.age=age;

    }
    public int getAge(){

        return age;

    }
         //constructor

    public Person(String name , int age, Passport pp){
   
        this.name=name;
        this.age = age ;
        this.pp=pp;
    }

    public void showPerson(){

        System.out.println("Persone name:" + name);
        System.out.println("Age:"+age);
        System.out.println("Passport Details:" + pp);

    }
 

}

// demonstarates classes via start
public class RelationshipPersonPassport {

  public static void main(String[] args){

//create object of passport

Passport obj1 = new Passport("A05341463", "11/2024", "6/2030");
obj1.showPassport();

Passport obj2 = new Passport("b9646546", "1/2012", "5/2020");
obj2.showPassport();


//exicute persone class 

Person p1 = new Person("Jubayer", 20, obj1);
p1.showPerson();;

Person p2 = new Person("sarkar,Abudllah", 25,  obj2);
p2.showPerson();



  }

    
}
