
    package com.example.Yoga.controller;
    
    import com.example.Yoga.Models.UserYoga;
    import com.example.Yoga.Service.UserService;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    
    @RestController
    @RequestMapping("/users")
    public class UserController {

        private UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/")
        public ResponseEntity<List<UserYoga>> saveAll(@RequestBody List<UserYoga> users){
            List<UserYoga> usersList = userService.saveAll(users) ;
            if(usersList != null || usersList.isEmpty() )
                return ResponseEntity.ok().body(usersList);
            else
                return ResponseEntity.badRequest().build();
        }
        @GetMapping("/{id_user}")
        public ResponseEntity FindByID(@PathVariable int id_user) {
            // return (Users) userService.findById(id_user);
            HttpHeaders headers = new HttpHeaders();

            UserYoga user = userService.findById(id_user);
            if (user != null) {
                headers.add("User_Header ", "User found successfully. User details for ID " + id_user);
                return ResponseEntity.ok().headers(headers).body(user);
            } else {
                headers.add("User_Header ", "User not found for ID " + id_user);
                return ResponseEntity.notFound().headers(headers).build();
            }

        }

        @GetMapping("/")
        public ResponseEntity<List<UserYoga>> FindAll() {
            List<UserYoga> users = userService.findAll();
            HttpHeaders headers = new HttpHeaders();

            if (!users.isEmpty()) {
                headers.add("UsersList_Header", "User Table is not empty");
                return ResponseEntity.ok().headers(headers).body(users);
            }

            else {
                headers.add("UsersList_Header", "No content available");
                return ResponseEntity.noContent().headers(headers).build();
            }

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