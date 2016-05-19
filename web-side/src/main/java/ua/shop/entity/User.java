package ua.shop.entity;

/**
 * @author Oleg Dashkevych.
 */
public class User {

	private String id;

	private String name;

	private String surname;

	private String password;

	private String email;

	public User() {
	}

	public User(String id, String name, String surname, String password, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (!getName().equals(user.getName())) return false;
		if (!getSurname().equals(user.getSurname())) return false;
		if (!getPassword().equals(user.getPassword())) return false;
		return getEmail().equals(user.getEmail());

	}

	@Override
	public int hashCode() {
		int result = getName().hashCode();
		result = 31 * result + getSurname().hashCode();
		result = 31 * result + getPassword().hashCode();
		result = 31 * result + getEmail().hashCode();
		return result;
	}
}
