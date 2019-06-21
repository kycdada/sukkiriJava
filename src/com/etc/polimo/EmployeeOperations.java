/**
 *
 */
package com.etc.polimo;

import java.util.List;

/**
 * 従業員リストを受け取って合計金額を返す
 *
 * @author user2
 *
 */
public class EmployeeOperations {
    private static float totalCost = 0F;

    static float calcCostOfEmployees(List<Employee> empList, PayModel payModel) {
        empList.stream().forEach(emp -> {
            totalCost += payModel.calcEmployeeCost(emp);
        });
        return totalCost;
    }
}
