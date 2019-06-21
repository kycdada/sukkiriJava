/**
 *
 */
package com.etc.polimo;

/**
 * このモデルでは病欠日数によってボーナスを変える。
 * 病欠が5日より少ない場合は10％上乗せする。
 *
 * @author user2
 *
 */
final class IncentivePayModel implements PayModel {

    @Override
    public float calcEmployeeCost(Employee emp) {
        float salary = emp.getSalary();
        float calcAnnualBonus = emp.calcAnnualBonus();
        int sickDate = emp.getDayoffSick();

        float totalCost = salary;
        if (sickDate < 5) {
            totalCost += calcAnnualBonus * 1.1;
        } else if (sickDate > 10) {
            totalCost += calcAnnualBonus * 0.9;
        }

        return totalCost;
    }

}
