package szu.vander.generic.selfboundedtype.crgdemo;

//: generics/CuriouslyRecurringGeneric.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-28
* @description ：古怪的循环模板模式，将子类作为泛型参数
 */
class GenericType<T> {
}

public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {
}
