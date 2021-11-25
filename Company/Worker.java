package com.company;

public class Worker {
    private int qualification;
    private int salary;

    public Worker(){
        qualification=0;
        salary=0;
    }
    public Worker(int qualification, int salary){
        setQualification(qualification);
        setSalary(salary);
    }

    public void setQualification(int qualification) {
        if(qualification>0&&qualification<4)this.qualification = qualification;
    }
    public void setSalary(int salary) {
        if(salary>=0)this.salary = salary;
    }

    public int getQualification() {
        return qualification;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "qualification=" + qualification +
                ", salary=" + salary +
                '}';
    }
}
