package com.scm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scm.services.ChatbotService;

@RestController
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(@RequestBody ChatMessage chatMessage) {
        String userMessage = chatMessage.getMessage();
        System.out.println("Received user message: " + userMessage); 

        String botResponse = chatbotService.generateResponse(userMessage);
        System.out.println("Generated bot response: " + botResponse); 

        Map<String, String> response = new HashMap<>();
        response.put("reply", botResponse);
        return ResponseEntity.ok(response);
    }

    public static class ChatMessage {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
