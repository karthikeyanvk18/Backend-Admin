import java.util.ArrayList;
import java.util.HashMap;

public class LearnersAcademy {
    
    
    private ArrayList<String> subjects;
    private ArrayList<String> teachers;
    private ArrayList<String> classes;
    private HashMap<String, ArrayList<String>> classSubjects;
    private HashMap<String, ArrayList<String>> classTeachers;
    private HashMap<String, ArrayList<String>> classStudents;
    
    public LearnersAcademy() {
        
        subjects = new ArrayList<>();
        teachers = new ArrayList<>();
        classes = new ArrayList<>();
        classSubjects = new HashMap<>();
        classTeachers = new HashMap<>();
        classStudents = new HashMap<>();
    }
    
    
    public void addSubject(String subject) {
        subjects.add(subject);
    }
    
    public void addTeacher(String teacher) {
        teachers.add(teacher);
    }
    
    public void addClass(String className) {
        classes.add(className);
        classSubjects.put(className, new ArrayList<>());
        classTeachers.put(className, new ArrayList<>());
        classStudents.put(className, new ArrayList<>());
    }
    
    public void assignSubjectToClass(String className, String subject) {
        ArrayList<String> subjects = classSubjects.get(className);
        subjects.add(subject);
        classSubjects.put(className, subjects);
    }
    
    public void assignTeacherToClass(String className, String teacher, String subject) {
        ArrayList<String> teachers = classTeachers.get(className);
        teachers.add(teacher);
        classTeachers.put(className, teachers);
    }
    
    public void assignStudentToClass(String className, String student) {
        ArrayList<String> students = classStudents.get(className);
        students.add(student);
        classStudents.put(className, students);
    }

    public ArrayList<String> getClassStudents(String className) {
        return classStudents.get(className);
    }

    public ArrayList<String> getClassSubjects(String className) {
        return classSubjects.get(className);
    }

    public ArrayList<String> getClassTeachers(String className) {
        return classTeachers.get(className);
    }

    public void generateClassReport(String className) {
        ArrayList<String> students = getClassStudents(className);
        ArrayList<String> subjects = getClassSubjects(className);
        ArrayList<String> teachers = getClassTeachers(className);
        
        System.out.println("Class Report for " + className + ":");
        System.out.println("Students:");
        for (String student : students) {
            System.out.println("- " + student);
        }
        System.out.println("Subjects:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }
        System.out.println("Teachers:");
        for (String teacher : teachers) {
            System.out.println("- " + teacher);
        }
    }
    
    public static void main(String[] args) {
        
        LearnersAcademy academy = new LearnersAcademy();
        
        
        academy.addSubject("Java");
        academy.addSubject("Python");
        academy.addSubject("C++");
        academy.addSubject("C");
        academy.addTeacher("Mr. Karthi");
        academy.addTeacher("Mrs. Pavithra");
        academy.addTeacher("Mr. Keyan");
        academy.addTeacher("Mrs. Pavi");
        academy.addClass("Class A");
        academy.addClass("Class B");
        
        
        academy.assignSubjectToClass("Class A", "Java");
        academy.assignSubjectToClass("Class A", "Python");
        academy.assignSubjectToClass("Class B", "C++");
        academy.assignSubjectToClass("Class A", "C");
        
        academy.assignTeacherToClass("Class A", "Mr. Karthi","Java");
        academy.assignTeacherToClass("Class A", "Mrs. Pavithra", "Python");
        academy.assignTeacherToClass("Class B", "Mr. Karthi", "Java");
        academy.assignTeacherToClass("Class B", "Mrs. Pavi","C++");
        academy.assignTeacherToClass("Class B", "Mrs. Pavithra", "Python");
        academy.assignTeacherToClass("Class A", "Mr. Keyan", "C");
        
        academy.assignStudentToClass("Class A", "Mahi");
        academy.assignStudentToClass("Class A", "Virat");
        academy.assignStudentToClass("Class B", "ABD");
        academy.assignStudentToClass("Class A", "Kohli");
        academy.assignStudentToClass("Class B", "Joe Root");
        academy.assignStudentToClass("Class A", "Rohit Sharma");
        academy.assignStudentToClass("Class B", "Shakib Al Hasan");
        academy.assignStudentToClass("Class B", "Kane Williamson");
        academy.assignStudentToClass("Class B", "David Warner");
        
        // Generate class reports
        academy.generateClassReport("Class A");
        academy.generateClassReport("Class B");
    }
    
}

