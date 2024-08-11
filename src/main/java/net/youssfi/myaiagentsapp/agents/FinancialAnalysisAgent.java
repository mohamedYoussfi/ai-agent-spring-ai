package net.youssfi.myaiagentsapp.agents;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import net.youssfi.myaiagentsapp.annotations.AiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
@BrowserCallable
@AnonymousAllowed
@AiAgent
public class FinancialAnalysisAgent {
    private ChatClient chatClient;

    String systemPrompt = """
            You will be asked to generate financial report about a given company using actual financial data
            Your report should include information about the company (name,country,domain, founded year)
            You report should include a concise conclusion about the financial analysis
            """;

    private String[] tools= new String[]{
            "countryIdentityInfo","financialDataTool","additionalFinancialInfos"
    };

    public FinancialAnalysisAgent(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem(systemPrompt)
                .defaultFunctions(tools)
                .build();
    }

    public String financialAnalysisReport(String companyName){
        return chatClient.prompt()
                .user("Company Name : "+companyName)
                .call().content();
    }
}
