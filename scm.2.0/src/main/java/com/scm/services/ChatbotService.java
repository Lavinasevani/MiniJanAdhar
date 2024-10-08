package com.scm.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {

    private Map<String, String> responseMap;

    public ChatbotService(ResourceLoader resourceLoader) {
        responseMap = new HashMap<>();
        Resource resource = resourceLoader.getResource("classpath:chatbot_responses.csv");
        loadResponsesFromFile(resource);
    }

    private void loadResponsesFromFile(Resource resource) {
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String line;
            System.out.println("Loading chatbot responses from file...");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2); // Split into key and value
                if (parts.length == 2) {
                    responseMap.put(parts[0].trim().toLowerCase(), parts[1].trim());
                    System.out.println("Loaded response: " + parts[0] + " -> " + parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading chatbot responses: " + e.getMessage());
        }
    }

    public String generateResponse(String userMessage) {
        // Normalize the user input
        userMessage = normalizeInput(userMessage);

        // Check for an exact match in the response map
        String response = responseMap.getOrDefault(userMessage,
                "I'm not sure how to respond to that. Can you ask something else?");
        System.out.println("User message: " + userMessage + " | Bot response: " + response);
        return response;
    }

    private String normalizeInput(String input) {
        // Normalize input by removing excessive characters (e.g., "hiiiiii" -> "hi")
        input = input.toLowerCase(); // Convert to lowercase for consistent matching

        // Use specific replacements for common variations
        if (input.matches("h[i]+")) {
            input = "hi";
        } else if (input.matches("hello+")) {
            input = "hello";
        } else if (input.matches("he+y+")) {
            input = "hey";
        }

        return input.trim(); // Trim any extra spaces for clean input
    }
}
