package com.ecoalerta;

import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class EcoalertaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoalertaApplication.class, args);
	}


}
