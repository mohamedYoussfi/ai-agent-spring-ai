package net.youssfi.myaiagentsapp.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("countryIdentityInfo")
@Description("""
        Get Identity Information about a given company including :
        - The Name of the company
        - The country of the company
        - The industry domain of the company
        - The founded year of the company
        """)
public class CountryIdentityInfo
        implements Function<CountryIdentityInfo.Request, CountryIdentityInfo.Response> {
    public record Request(String companyName){};
    public record Response(
            String companyName,
            String country,
            String industryDomain,
            int foundedYear
            ){};

    @Override
    public Response apply(Request request) {
        System.out.println("======== countryIdentityInfo ==== Company = "+request.companyName());
        return new Response(request.companyName(), "Morocco","Telecom",1911);
    }
}
