

package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.UserRepo;
import com.example.Yoga.Models.UserYoga;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements  BaseService<UserYoga>{

    private UserRepo jpaRepository;

    public UserService(UserRepo jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<UserYoga> findAll() {
        return jpaRepository.findAll();


    }

    @Override
    public UserYoga findById(int id) {
        Optional<UserYoga> userOptional = jpaRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<UserYoga> saveAll(List<UserYoga> users) {
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