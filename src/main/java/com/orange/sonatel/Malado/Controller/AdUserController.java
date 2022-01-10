package com.orange.sonatel.Malado.Controller;

import com.orange.sonatel.Malado.Models.AdUser;
import com.orange.sonatel.Malado.Repository.AdUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(path="/api")
public class AdUserController {

    @Autowired
    private AdUserRepository adUserRepository;

    @RequestMapping(value = "/users",method=RequestMethod.GET)
    public @ResponseBody Iterable<AdUser> getAllUsers(){
        return adUserRepository.findAll();
    }

    @RequestMapping(value = "/users",method=RequestMethod.POST)
    public AdUser  save (@RequestBody AdUser adUser){
        return adUserRepository.save(adUser);
    }

    //Une requete qui permet de verifier si le login saisi existe dans la base de donnees
    public AdUser ChekUser(String loginAD) {
        AdUser ad= adUserRepository.findOne(loginAD);
        if (ad==null) throw new RuntimeException("Login Incorrect");
        return ad;
    }
}

