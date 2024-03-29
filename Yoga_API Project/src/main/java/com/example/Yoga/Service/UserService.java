

package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.UserRepo;
import com.example.Yoga.Models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements  BaseService<Users>{

    private UserRepo jpaRepository;

    public UserService(UserRepo jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Users> findAll() {
        return jpaRepository.findAll();


    }

    @Override
    public Users findById(int id) {
        Optional<Users> userOptional = jpaRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<Users> saveAll(List<Users> users) {
        return  jpaRepository.saveAll(users);

    }

}

/*
{
first_name: "Mostafa"
  last_name: "Hussien"
  phone: "01006332994"
  email: "Mostafadfrg@gmail.com"
  nationality: UK
  date_of_birth: 2000-11-10
}
 */