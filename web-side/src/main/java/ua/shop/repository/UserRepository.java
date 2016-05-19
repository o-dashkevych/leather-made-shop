package ua.shop.repository;

import ua.shop.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * @author Oleg Dashkevych.
 */
public class UserRepository {

	private final List<User> users = new ArrayList<>();

	public boolean add(User user) {
		return users.add(user);
	}

	public User get(String id) {
		try {
			return getUserStreamById(id).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean contains(User user) {
		return users.contains(user);
	}

	public boolean remove(String id) {
		try {
			return users.remove(getUserStreamById(id).findFirst().get());
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean update(User updatedUser) {
		User foundUser = get(updatedUser.getId());
		if (foundUser != null) {
			updateUserAttributes(foundUser, updatedUser);
			return true;
		} else return false;
	}

	private Stream<User> getUserStreamById(String id) {
		return users.stream().filter(user -> id.equals(user.getId()));
	}

	private void updateUserAttributes(User user, User newUser) {
		user.setName(newUser.getName());
		user.setSurname(newUser.getSurname());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
	}
}
