package ua.shop.service;

import ua.shop.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class UserService {

	private List<User> users = new ArrayList<>();

	/**
	 * Appends the specified element to the end of this list (optional
	 * operation).
	 * <p>
	 * <p>Lists that support this operation may place limitations on what
	 * elements may be added to this list.  In particular, some
	 * lists will refuse to add null elements, and others will impose
	 * restrictions on the type of elements that may be added.  List
	 * classes should clearly specify in their documentation any restrictions
	 * on what elements may be added.
	 *
	 * @param user element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @throws UnsupportedOperationException if the <tt>add</tt> operation
	 *                                       is not supported by this list
	 * @throws ClassCastException            if the class of the specified element
	 *                                       prevents it from being added to this list
	 * @throws NullPointerException          if the specified element is null and this
	 *                                       list does not permit null elements
	 * @throws IllegalArgumentException      if some property of this element
	 *                                       prevents it from being added to this list
	 */
	public boolean add(User user) {
		return users.add(user);
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
	 */
	public User get(int index) {
		return users.get(index);
	}
}
