/**
 *
 */
package com.etc.builder;

/**
 * @author user2
 *
 */
public class BuilderSampleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BuilderSample bs = new BuilderSample.Builder(45, 32).setCalories(54).build();
        System.out.println(bs);
    }

}
