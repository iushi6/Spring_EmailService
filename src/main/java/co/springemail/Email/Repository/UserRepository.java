package co.springemail.Email.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import co.springemail.Email.Domain.User;



@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

	 List<User> findByUserRoleAndUserStatus(String userRole, int status);
	  List<User> findByUserStatus(int status);
	
}