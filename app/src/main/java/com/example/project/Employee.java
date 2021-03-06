package com.example.project;

public class Employee {

    private long empId;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private int occRate;
    private String employeeType;
    private int cpb;
    private String vehicle;
    private String model;
    private String plate;
    private String sidecar;
    private String Color;


    public Employee(long empId, String firstName, String lastName, int age, double salary, int occRate, String employeeType, int cpb, String vehicle, String model, String plate, String sidecar, String color) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.occRate = occRate;
        this.employeeType = employeeType;
        this.cpb = cpb;
        this.vehicle = vehicle;
        this.model = model;
        this.plate = plate;
        this.sidecar = sidecar;
        this.Color = color;

    }

    public long getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public int getOccRate() {
        return occRate;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public int getCpb() {
        return cpb;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public String getSidecar() {
        return sidecar;
    }

    public String getColor() {
        return Color;
    }



    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setOccRate(int occRate) {
        this.occRate = occRate;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setCpb(int cpb) {
        this.cpb = cpb;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setSidecar(String sidecar) {
        this.sidecar = sidecar;
    }

    public void setColor(String color) {
        this.Color = color;
    }


}
