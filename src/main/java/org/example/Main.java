package org.example;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String API_KEY = System.getenv("OPENAI_API_KEY");

        OpenAiService service = new OpenAiService(API_KEY);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ask me anything: ");
        var prompt = scanner.nextLine();

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .maxTokens(1024)
                .build();

        String answer = service.createCompletion(request)
                .getChoices()
                .get(0)
                .getText();

        System.out.println(answer);
    }
}