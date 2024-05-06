import java.util.HashMap;

public class Student {
	String name;
	int stNum;
	public Student(String pname,int pstNum) {
		this.name = pname;
		this.stNum = pstNum;	
	}
	@Override
	public String toString(){
		return name + stNum;
	}
	
	
	

}
