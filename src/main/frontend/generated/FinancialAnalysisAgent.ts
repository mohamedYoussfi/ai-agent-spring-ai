import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
async function financialAnalysisReport_1(companyName: string, init?: EndpointRequestInit_1): Promise<string> { return client_1.call("FinancialAnalysisAgent", "financialAnalysisReport", { companyName }, init); }
export { financialAnalysisReport_1 as financialAnalysisReport };
