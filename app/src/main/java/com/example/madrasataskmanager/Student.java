package com.example.madrasataskmanager;

//public class Student {
//
//        private int rollNo;
//        private String name;
//        private String className;
//        private int age;
//
//        public Student(int rollNo, String name, String className, int age) {
//            this.rollNo = rollNo;
//            this.name = name;
//            this.className = className;
//            this.age = age;
//        }
//
//
//        // Getter and setter methods
//        public int getRollNo() {
//            return rollNo;
//        }
//
//    public void setRollNo(int rollNo) {
//        this.rollNo = rollNo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//
//}
public class Student {
    private String name;
    private String rollNo;
    private String Class;

    public Student(String name, String rollNo, String Class) {
        this.name = name;
        this.rollNo = rollNo;
        this.Class = Class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getclass() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", Class=" + Class + "]";
    }

}
