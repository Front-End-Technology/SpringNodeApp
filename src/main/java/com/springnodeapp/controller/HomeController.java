package com.springnodeapp.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springnodeapp.model.Product;

@Controller
public class HomeController {

	@RequestMapping(value = "/welcome", produces = "application/json")
	// @RequestMapping(value = , method = RequestMethod.GET, )
	public @ResponseBody Product authenticate() {
		{
			Product product = null;
			Reader reader;
			try {
				reader = new FileReader("C:\\Users\\Sahil\\workspace_6_5\\SpringNodeApp\\src\\main\\resources\\product.json");
				ObjectMapper mapper = new ObjectMapper();
				product = mapper.readValue(reader, Product.class);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return product;
		}

	}
}
