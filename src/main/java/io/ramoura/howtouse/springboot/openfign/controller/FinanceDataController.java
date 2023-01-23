package io.ramoura.howtouse.springboot.openfign.controller;

import io.ramoura.howtouse.springboot.openfign.client.YahooIntegration;
import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryParam;
import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryResponse;
import io.ramoura.howtouse.springboot.openfign.model.Asset;
import io.ramoura.howtouse.springboot.openfign.usecase.GetStockInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FinanceDataController {

    private final GetStockInformation getStockInformation;

    @GetMapping("/summary/{tickerName}")
    public Asset getSummary(@PathVariable String tickerName){
        return getStockInformation.getInfoFor(tickerName);
    }
}
