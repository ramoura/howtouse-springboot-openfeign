package io.ramoura.howtouse.springboot.openfign.usecase;

import io.ramoura.howtouse.springboot.openfign.client.YahooIntegration;
import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryParam;
import io.ramoura.howtouse.springboot.openfign.model.Asset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetStockInformation {

    private final YahooIntegration yahooIntegration;


    public Asset getInfoFor(String ticker){
        QuoteSummaryParam param = QuoteSummaryParam.builder()
            .module("price")
            .build();
        var response = yahooIntegration.getQuoteSummary(param, ticker);

        return Asset.builder()
            .ticker(response.quoteSummary.result.get(0).price.symbol)
            .shortName(response.quoteSummary.result.get(0).price.shortName)
            .longName(response.quoteSummary.result.get(0).price.longName)
            .currencyCode(response.quoteSummary.result.get(0).price.currency)
            .build();
    }


}
