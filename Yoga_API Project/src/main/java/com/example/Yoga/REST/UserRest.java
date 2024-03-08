
    package com.example.Yoga.REST;
    
    import com.example.Yoga.EntityYoga.Users;
    import com.example.Yoga.Service.BaseService;
    import com.example.Yoga.Service.UserService;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    
    @RestController
    @RequestMapping("/api")
    public class UserRest {
    
        private UserService userService ;
    
        public UserRest(  UserService userService) {
            this.userService = userService;
        }
    
        @PostMapping("/users")
        public List<Users> saveAll(@RequestBody List<Users> users) {

            return userService.saveAll(users);
        }

        @GetMapping("/users/{idUser}")
        public Users FindByID(@PathVariable int idUser ){
            return (Users) userService.findById(idUser);

        }

        @GetMapping("/users")
        public List<Users>FindAll(){
            return userService.findAll();
        }
    
    }
    


                            // format that used
    /*
    --> SaveAll

    [
  {
    "first_name": "Hazzem",
    "last_name": "Moh",
    "phone": "0102345634",
    "email": "Hazzem.e@example.com",
    "nationality": "US",
    "date_of_birth": "2000-01-15"
  }
  ,
  {

  }

]
     */