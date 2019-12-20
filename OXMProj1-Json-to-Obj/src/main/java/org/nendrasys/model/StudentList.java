package org.nendrasys.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class StudentList {
	//Wrapper class for student
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

	@Override
	public String toString() {
		return "StudentList [students=" + students + "]";
	}
    
}
