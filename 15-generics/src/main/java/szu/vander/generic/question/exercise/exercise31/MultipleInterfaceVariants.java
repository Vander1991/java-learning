package szu.vander.generic.question.exercise.exercise31;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 从MultipleInterfaceVariants.java移除所有泛型，并修改代码，使得它可以编译
 */
interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}
