package net.youssfi.myaiagentsapp.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("additionalFinancialInfos")
@Description("""
        Get additional financial information about the company in last years 
        """)
public class AdditionalFinancialInfos implements Function<AdditionalFinancialInfos.Request, AdditionalFinancialInfos.Response> {
    public record Request(String companyName){};
    public record Response(String additionalFinancialInfos){};

    @Override
    public Response apply(Request request) {
        System.out.println("AdditionalFinancialInfos Tool => Company "+request.companyName);
        return new Response("The number of subscribers is the very upward trend in the last years");
    }
}
