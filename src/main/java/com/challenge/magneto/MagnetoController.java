package com.challenge.magneto;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MagnetoController {
 
  @RequestMapping("/magneto")
  public String hello() {
    StringBuilder message = new StringBuilder("Magneto Google App Engine!");
    try {
      InetAddress ip = InetAddress.getLocalHost();
      message.append(" From host: " + ip);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
      return message.toString();
    }
 
}