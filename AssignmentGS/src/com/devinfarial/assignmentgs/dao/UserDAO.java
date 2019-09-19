package com.devinfarial.assignmentgs.dao;
import java.util.List;

import com.devinfarial.assignmentgs.model.*;

public interface UserDAO {
	public int save(User user);
	public int update(User user);
	public User get(Integer id);
	public int delete(Integer id);
	public List<User> list();
	public User validateUser(User user);

}
