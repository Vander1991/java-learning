package szu.vander.typeinfo.nullobject.staff;

//: typeinfo/Position.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 这里你可能会想创建一个Position的空对象，但是在设计草案的初稿中母婴馆努力使用最简单且可以工作的事物
* 				直至程序的某个方面要求你添加额外的特性，而不是一开始就假设它是必须的
 */
class Position {
	private String title;
	private Person person;

	public Position(String jobTitle, Person employee) {
		title = jobTitle;
		person = employee;
		if (person == null)
			person = Person.NULL;
	}

	public Position(String jobTitle) {
		title = jobTitle;
		person = Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person newPerson) {
		person = newPerson;
		if (person == null) {
			person = Person.NULL;
		}
	}

	public String toString() {
		return "Position: " + title + " " + person;
	}
}
