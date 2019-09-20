/**
 * 
 */
package com.softvision.bean;

/**
 * @author ramesh.vasantula
 *
 */
public class HelloWorld {

	private int id;
	private String name;
	protected HelloWorld() {
		
	}
	
	public HelloWorld(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
	@Override
	public String toString() {
		return "HelloWorld [id=" + id + ", name=" + name + "]";
	}
	
}
