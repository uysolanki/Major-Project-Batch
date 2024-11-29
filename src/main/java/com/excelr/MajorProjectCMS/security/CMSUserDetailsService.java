package com.excelr.MajorProjectCMS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.MajorProjectCMS.entity.User;
import com.excelr.MajorProjectCMS.repository.UserRepository;

@Service
public class CMSUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userrepo.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User Does not Exist");
		}
		return new UserDecoration(user);
	}

}
