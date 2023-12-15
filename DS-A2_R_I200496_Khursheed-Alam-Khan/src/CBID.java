/* Name: Khursheed Alam Khan					      Assignment 2: Implementation of Citizen Database
 * Roll# 20i-0496
 * Section: SE-R
 */


//Citizens Basic Information Database (CBID)

public class CBID
{
	CCID cc = new CCID(0, null, null, null, null);
	
	private int cnic;
	private String name;
	private String fName;
	private String gender;
	private int age;
	private String address;
	private String nation;
	
	// getter and setter
	public int getCnic() 
	{
		return cnic;
	}
	public void setCnic(int cnic) 
	{
		this.cnic = cnic;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getfName()
	{
		return fName;
	}
	public void setfName(String fName) 
	{
		this.fName = fName;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getNation() 
	{
		return nation;
	}
	public void setNation(String nation) 
	{
		this.nation = nation;
	}
	//
	
	CBID(int cnic, String name, String fName, String gender, int age, String address, String nation)
	{
		this.cnic=cnic;
		this.name=name;
		this.fName=fName;
		this.gender=gender;
		this.age=age;
		this.address=address;
		this.nation=nation;
	}
	//
	
	@Override 
	public String toString()
	{
		return (this.cnic+" "+this.name+" "+this.fName+" "+this.gender+" "+this.age+" "+this.address+" "+this.nation);
	}
}
