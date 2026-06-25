package com.ipn.mx.mininventario4bm2.features.mail.service;

public interface EmailService {
    public void enviarCorreoElectronico(String to, String subject, String text);
}
