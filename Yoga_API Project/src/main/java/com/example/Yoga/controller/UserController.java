
    package com.example.Yoga.controller;
    
    import com.example.Yoga.Models.Users;
    import com.example.Yoga.Service.UserService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    
    @RestController
    @RequestMapping("/users")
    public class UserController {
    
        private UserService userService ;
    
        public UserController(UserService userService) {
            this.userService = userService;
        }
    
        @PostMapping("/")
        public List<Users> saveAll(@RequestBody List<Users> users) {

            return userService.saveAll(users);
        }

        @GetMapping("/{id_user}")
        public ResponseEntity FindByID(@PathVariable int id_user ){
           // return (Users) userService.findById(id_user);
            Users user = userService.findById(id_user) ;
            if( user != null )
                return ResponseEntity.ok().body(user);
            else
                return ResponseEntity.notFound().build();

        }

        @GetMapping("/")
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