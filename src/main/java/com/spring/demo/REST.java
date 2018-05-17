package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class REST {

    @Autowired
    MessageServiceImpl jsmClient;

    @Autowired
    JMSListener jmslisten;

    @RequestMapping(method = RequestMethod.POST, path = "/produce")
    public ResponseEntity<Void> produce(@RequestParam String body, @RequestHeader HttpHeaders header,
	    UriComponentsBuilder builder) {
	jsmClient.send(body);
	System.out.println(header.getContentLength());
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/produce/{id}").buildAndExpand("message sent").toUri());
	headers.setCacheControl("3600");
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/receive")
    public String receive() {
	return jmslisten.receive();
    }

}
