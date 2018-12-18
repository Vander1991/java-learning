package szu.vander.generic.question;

//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 因为擦除会将Payable<Employee>和Payable<Hourly>简化为相同的类Payable
 * 				有趣的是，这里如果把两个Payable的泛型参数去掉就可以编译的
 */
interface Payable<T> {
}

class Employee implements Payable<Employee> {
}

// 编译错误
//class Hourly extends Employee implements Payable<Hourly> {
//}
