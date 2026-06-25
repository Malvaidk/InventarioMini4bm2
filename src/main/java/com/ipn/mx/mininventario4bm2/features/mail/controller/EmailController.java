package com.ipn.mx.mininventario4bm2.features.mail.controller;


import com.ipn.mx.mininventario4bm2.features.mail.service.EmailService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> enviarEmail(@RequestBody Map<String, String> request) throws IOException {
        try {
            String para = request.get("to");
            String asunto = request.get("subject");
            String mensaje = request.get("text");

            emailService.enviarCorreoElectronico(para, asunto, mensaje);
            return ResponseEntity.ok(Map.of("mensaje", "Correo enviado con éxito a " + para));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al procesar el envío: " + e.getMessage());}
        }

}
