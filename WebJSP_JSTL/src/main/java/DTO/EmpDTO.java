package DTO;

import java.util.Date;

import lombok.Data;
@Data
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private Date hiredate;

}
