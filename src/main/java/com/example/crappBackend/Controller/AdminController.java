package com.example.crappBackend.Controller;

import com.example.crappBackend.model.Admin;
import com.example.crappBackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id){
        Optional<Admin> admin = adminRepository.findById(id);
        //Posible exepcion
        return ResponseEntity.ok(admin);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    @DeleteMapping("{id}")
    public void deleteAdminById(@PathVariable Long id){
        adminRepository.deleteById(id);
    }
}
