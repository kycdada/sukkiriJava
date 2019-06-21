/**
 *
 */
package com.etc.polimo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author user2
 *
 */
/**
 * @author user2
 *
 */
public class Polimo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Employee emp = new FatCatEmployee("14", 0, 0);
        Employee emp2 = new LowPaidEmployee("!15", 5, 4);
        // singleDispatch
        polimoMethod.polimo(emp);

        // dobleDispatch
        List<Employee> demp = new ArrayList<>();
        demp.add(emp);
        demp.add(emp2);

        PayModel pm1 = new SimplePayModel();
        PayModel pm2 = new IncentivePayModel();

        float cost1 = EmployeeOperations.calcCostOfEmployees(demp, pm1);
        float cost2 = EmployeeOperations.calcCostOfEmployees(demp, pm2);

        System.out.println(cost1);
        System.out.println(cost2);
    }

}

/**
 * @author user2
 *
 */
final class polimoMethod {

    /**
     * @param emp
     * @value エンプロイ総称的に関数実行
     */
    static void polimo(Employee emp) {
        List<Employee> empList = new ArrayList<>();
        empList.add(emp);
        empList.stream().forEach(employ -> {
            employ.calcAnnualBonus();
        });
        ;
    }
}

interface Employee {
    public String getName();

    public float getSalary();

    public float calcAnnualBonus();

    public int getDayoffSick();
}

abstract class AbstractEmployee implements Employee {
    private String name_;
    private float salary_;
    private int sickdays;

    AbstractEmployee(String who, float sal, int days_sick) {
        name_ = who;
        salary_ = sal;
        sickdays = days_sick;
    }

    /**
     * @return name_
     */
    @Override
    public final String getName() {
        return this.name_;
    }

    /**
     * @return salary_
     */
    @Override
    public final float getSalary() {
        return this.salary_;
    }

    /**
     * @return sickdays
     */
    @Override
    public final int getDayoffSick() {
        return this.sickdays;
    }
}

// 以下インスタンスパターン
class FatCatEmployee extends AbstractEmployee {

    public FatCatEmployee(String who, float sal, int days_sick) {
        super(who, sal, days_sick);
    }

    @Override
    public float calcAnnualBonus() {
        float loadsOfMoney = 0F;
        System.out.println("FatCatEmployee.calcBonus");

        return loadsOfMoney;
    }

}

class LowPaidEmployee extends AbstractEmployee {
    public LowPaidEmployee(String who, float sal, int days_sick) {
        super(who, sal, days_sick);
    }

    @Override
    public float calcAnnualBonus() {
        float loadsOfMoney = 0F;
        System.out.println("FatCatEmployee.calcBonus");

        return loadsOfMoney;
    }

}