package com.retoback.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retoback.model.User;
import com.retoback.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/usuarios")
public class UserController {
	
	@Autowired
	private UserService usuarioRepository;
	
	@GetMapping("/listarUsuarios")
	public User listarUsuarios(){
		return usuarioRepository.listarUsuarios();
	}

}