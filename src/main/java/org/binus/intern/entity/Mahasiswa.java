package org.binus.intern.entity;

import java.io.Serializable;

public class Mahasiswa implements Serializable {
	
	private String nim;
	private Integer age;
	private String name;

	
	public Mahasiswa() {//String nim, Integer age, String name) {
//		super();
//		this.nim = nim;
//		this.age = age;
//		this.name = name;
	}
	
	// untuk JUnitTest
	public Mahasiswa(String nim, Integer age, String name) {
		super();
		this.nim = nim;
		this.age = age;
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nim
	 */
	public String getNim() {
		return nim;
	}
	/**
	 * @param nim the nim to set
	 */
	public void setNim(String nim) {
		this.nim = nim;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nim == null) ? 0 : nim.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mahasiswa other = (Mahasiswa) obj;
		if (nim == null) {
			if (other.nim != null)
				return false;
		} else if (!nim.equals(other.nim))
			return false;
		return true;
	}

	
}