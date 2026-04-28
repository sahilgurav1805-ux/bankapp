package com.sahil.bankapp.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String getResponse(String message) {

        message = message.toLowerCase();

        if (message.contains("hello")) {
            return "Hello 👋 I am your Banking AI Assistant!";
        }

        if (message.contains("balance")) {
            return "💰 Your balance will be fetched from database soon.";
        }

        if (message.contains("withdraw")) {
            return "🏦 You can withdraw money from dashboard.";
        }

        if (message.contains("loan")) {
            return "📊 We offer personal loans at low interest.";
        }

        return "🤖 Ask me about balance, account, withdraw, loan.";
    }
}