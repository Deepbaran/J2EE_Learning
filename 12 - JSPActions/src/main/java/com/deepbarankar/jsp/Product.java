package com.deepbarankar.jsp;

// THIS IS A JAVA BEAN
public class Product {
	private int id;
	private String name;
	private String description;
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

// Every beans in Java that holds onto the data, typically has a public on it's class and all the fields are set as private with getters and setters.

/*
 * BEAN:
 * A Java Bean is a Java class that should follow the following conventions:
 * 1. It should have a no-arg constructor.
 * 2. It should be Serializable.
 * 3. It should provide methods to set and get the values of the properties, known as getter and setter methods.
 * Java Beans are mainly used to get and set values of fields.
 * According to Java white paper, it is a reusable software component. A bean encapsulates many objects into one object so that we can access this object from multiple places. 
 * Moreover, it provides easy maintenance.
 * Advantages:
 * 1. The JavaBean properties and methods can be exposed to another application.
 * 2. It provides an easiness to reuse the software components.
 * Disadvantages:
 * 1. JavaBeans are mutable. So, it can't take advantages of immutable objects.
 * 2. Creating the setter and getter method for each property separately may lead to boilerplate code.
 * Java Bean class is also an object class that encapsulates several objects into a single file ( Bean Class File).
 * 
 * POJO: [https://www.javatpoint.com/pojo-in-java]
 * POJO stands for, Plain Old Java Object. It is an ordinary object, which is not bound by any special restriction. The POJO file does not require any special classpath. 
 * It increases the readability & re-usability of a Java program. They are easy to read and write. A POJO class does not have any naming convention for properties and methods. 
 * It is not tied to any Java Framework; any Java Program can use it. Generally, a POJO class contains variables and their Getters and Setters.
 * The POJO classes are similar to Beans as both are used to define the objects to increase the readability and re-usability. 
 * The only difference between them that Bean Files have some restrictions but, the POJO files do not have any special restrictions.
 * POJO class is used to define the object entities. For example, we can create an Employee POJO class to define its objects.
 * Properties:
 * 1. The POJO class must be public.
 * 2. It must have a public default constructor.
 * 3. It may have the arguments constructor.
 * 4. All objects must have some public Getters and Setters to access the object values by other Java Programs.
 * 5. The object in the POJO Class can have any access modifiers such as private, public, protected. But, all instance variables should be private for improved security of the project.
 * 6. A POJO class should not extend predefined classes.
 * 7. It should not implement prespecified interfaces.
 * 8. It should not have any prespecified annotation.
 * Working:
 * The POJO class is an object class that encapsulates the Business logic. In an MVC architecture, the Controller interacts with the business logic, which contacts with POJO class to access the data.
 * Use:
 * The POJO class is created to use the objects in other Java Programs. The major advantage of the POJO class is that we will not have to create objects every time in other Java programs. 
 * Simply we can access the objects by using the get() and set() methods. To access the objects from the POJO class, follow the below steps:
 * 1. Create POJO class objects
 * 2. Set the value using the set() method
 * 3. Get the value using the get() method
 * 
 * POJO and BEAN:
 * 1. All the Bean files can be POJOs, but not all the POJOs are beans.
 * 2. All Bean files can implement a Serializable interface but, not all the POJOs can implement a Serializable interface.
 * 3. Both properties should be private to have complete control of fields.
 * 4. Properties must have the getters and setter to access them in other Java programs.
 * 5. The Bean class is a sub-set of the POJO class.
 * 6. There is no major disadvantage of using the POJO, but few disadvantages may be using the Bean class.
 * 7. The POJO is used when we want to provide full access to users and restrict our members. And, the Bean is used when we want to provide partial access to the members.
 */
