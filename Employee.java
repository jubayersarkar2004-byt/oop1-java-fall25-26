public class Employee {
    private String name;
    private int id;
    private int experience;

    //getter - setter

    public void setName(String name)
    {
        this.name =name;
    }
    public String getName()
    {
        return name;
    }

   public void setId(int id)
   {
    this.id = id ;
   }
   public int getId()
   {
    return id;
   }
   public void setExperience(int experience)
   {
    this.experience = experience;

   }
   public int  getExperience()
   {
     return experience;

   }
 //constructor

  public Employee(){  
     System.out.println("I am an empty constructor ");

  }

  public Employee(String name,int id, int experience)
  {

    this.name = name;
    this.id = id;
    this.experience= experience;
    System.out.println("I am a parameterized constructor ");

  }
public void showDetails()
{
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);
    System.out.println("Experience in Years: " + experience); }




}
