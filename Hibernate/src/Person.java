import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //aus javax.persistence
@Table(name="PERSON") //optional
public class Person {

	@Column
	private String lname;
	@Column
	private String fname;
	@Column
	private Integer salary;
	@Id
	private int persno;
	
	public Person() {
		
	}
	
	public Person(String lname, String fname, int salary, int persno){
		setLname(lname);
		setFname(fname);
		set_salary(salary);
		set_persno(persno);
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int get_salary() {
		return salary;
	}

	public void set_salary(int salary) {
		this.salary = salary;
	}

	public int get_persno() {
		return persno;
	}

	public void set_persno(int persno) {
		this.persno = persno;
	}
	
	public String toString() {
		return persno + " " + fname + " " + lname;
	}
}
