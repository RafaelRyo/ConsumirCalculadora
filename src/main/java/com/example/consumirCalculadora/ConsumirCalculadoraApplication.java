package com.example.consumirCalculadora;

import com.example.consumirCalculadora.service.ConsumirCalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ConsumirCalculadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumirCalculadoraApplication.class, args);
	}

	@Autowired
	private ConsumirCalculadoraService consumirCalculadoraService;

	@RequestMapping("/consumirSuma")
	public int valor(@RequestParam("valor") Double valor){
		//http://localhost:8080/calculadora/consumirSuma?numero1=4&numero2=5
		Double iva = valor * 0.19;
		return consumirCalculadoraService.consumirSuma(iva, valor);
	}

}
