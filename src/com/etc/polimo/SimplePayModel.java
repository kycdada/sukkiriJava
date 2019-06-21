/**
 *
 */
package com.etc.polimo;

/**
 *
 * 給料にボーナス計算を行わず給与を15％増やす
 *
 * @author user2
 *
 */
final class SimplePayModel implements PayModel {

    @Override
    public float calcEmployeeCost(Employee emp) {
        return emp.getSalary() * 1.15F;
    }

}
