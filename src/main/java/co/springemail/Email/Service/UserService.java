package co.springemail.Email.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.springemail.Email.Domain.User;
import co.springemail.Email.Repository.UserRepository;

	@Service
	public class UserService {
		
		@Autowired
		private UserRepository userRepository;

		public List<User> getAllUsers() {
			return userRepository.findAll();
		}

		public User getUserById(Integer id) throws Exception {
			Optional<User> user = userRepository.findById(id);
			if(user.isPresent()) {
				return user.get();
			} else {
				throw new Exception("User not found with id: " + id);
			}
		}

		public User createUser(User user) {
			return userRepository.save(user);
		}

		public User updateUser(Integer id, User updatedUser) throws Exception {
			Optional<User> user = userRepository.findById(id);
			if(user.isPresent()) {
				User existingUser = user.get();
				existingUser.setUserName(updatedUser.getUserName());
				existingUser.setOfficialEmail(updatedUser.getOfficialEmail());
				existingUser.setPersonalEmail(updatedUser.getPersonalEmail());
				existingUser.setContactNo(updatedUser.getContactNo());
				existingUser.setGender(updatedUser.getGender());
				existingUser.setDob(updatedUser.getDob());
				existingUser.setUserStatus(updatedUser.getUserStatus());
				existingUser.setUserRole(updatedUser.getUserRole());
				return userRepository.save(existingUser);
			} else {
				throw new Exception("User not found with id: " + id);
			}
		}

		public void deleteUser(Integer id) throws Exception {
			Optional<User> user = userRepository.findById(id);
			if(user.isPresent()) {
				userRepository.deleteById(id);
			} else {
				throw new Exception("User not found with id: " + id);
			}
		}

	}
