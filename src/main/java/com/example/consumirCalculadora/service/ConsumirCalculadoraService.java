package com.example.consumirCalculadora.service;

import com.example.consumirCalculadora.interfaz.ConsumirCalculadoraInterfazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumirCalculadoraService implements ConsumirCalculadoraInterfazService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public int consumirSuma(Double iva, Double valor){
        String url = "http://localhost:8080/calculadora/suma?numero1={valor}&numero2={iva}";
        Map<String, Integer> params = new HashMap<>();
        params.put("valor", valor.intValue());
        params.put("iva", iva.intValue());

        int resultado = clientRest.getForObject(url, Integer.class, params);
        return resultado;
    }




    /*ResponseEntity<String> response = restTemplate.exchange(
            "https://api.example.com/users?name={name}&email={email}",
            HttpMethod.GET,
            null,
            String.class,
            "John Doe",
            "johndoe@example.com"
    );*/

}
