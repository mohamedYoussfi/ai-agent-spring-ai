package net.youssfi.myaiagentsapp;

import net.youssfi.myaiagentsapp.agents.FinancialAnalysisAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAiAgentController {
    private FinancialAnalysisAgent financialAnalysisAgent;

    public MyAiAgentController(FinancialAnalysisAgent financialAnalysisAgent) {
        this.financialAnalysisAgent = financialAnalysisAgent;
    }

    @GetMapping(value = "/financialAnalysis", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String askAgent(String company){
        return financialAnalysisAgent.financialAnalysisReport(company);
    }
}
