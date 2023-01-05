package com.example.travellist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Repository repo;

    @RequestMapping("/addTravel")
    @ResponseBody
    public Optional<Travelentity> add(@RequestParam String id, String name, String description)
    {
        Travelentity obj = new Travelentity();
        obj.setId(id);
        obj.setName(name);
        obj.setDescription(description);
        repo.save(obj);
        System.out.println("Travel added successfully");
        return repo.findById(id);
    }

    @RequestMapping("/travel")
    @ResponseBody
    public List<Travelentity> all()
    {
        return repo.findAll();
    }

    @RequestMapping("/findtravel")
    @ResponseBody
    public Optional<Travelentity> find(@RequestParam String id)
    {
        return repo.findById(id);
    }

    @RequestMapping("/deltravel")
    @ResponseBody
    public Optional<Travelentity> del(@RequestParam String id)
    {
        repo.deleteById(id);
        return repo.findById(id);
    }

    // @RequestMapping("/getname")
    // @ResponseBody
    // public List<Travelentity> name(@RequestParam String name)
    // {
    //     //repo.deleteById(id);
    //     return repo.getByName(name);
    // }

}
