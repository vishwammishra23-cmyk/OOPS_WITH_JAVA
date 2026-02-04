class Student {
    int rollNo;
    String name;
    int age;

    Student() {
        rollNo = 0;
        name = "Not Assigned";
        age = 0;
    }

    Student(int r, String n, int a) {
        rollNo = r;
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println();
    }

    
    public static void main(String[] args) {
        Student s1 = new Student();

        Student s2 = new Student(101, "Rahul", 20);

        s1.display();
        s2.display();
    }
}
