package ua.shop.entity;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class Newsletter {

	private String id;

	private String name;

	private List<User> subscribers;

	public Newsletter() {
	}

	public Newsletter(String id, String name, List<User> subscribers) {
		this.id = id;
		this.name = name;
		this.subscribers = subscribers;
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

	public List<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<User> subscribers) {
		this.subscribers = subscribers;
	}
}
