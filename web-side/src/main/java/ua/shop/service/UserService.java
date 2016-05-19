package ua.shop.service;

import ua.shop.entity.User;
import ua.shop.repository.UserRepository;

/**
 * @author Oleg Dashkevych.
 */
public class UserService {

	private final UserRepository userRepository = new UserRepository();

	public boolean add(User user) {
		return !userRepository.contains(user) && userRepository.add(user);
	}

	public boolean remove(String id) {
		return userRepository.remove(id);
	}

	public User get(String id) {
		return userRepository.get(id);
	}

	public boolean update(User updatedUser) {
		return userRepository.update(updatedUser);
	}
}
