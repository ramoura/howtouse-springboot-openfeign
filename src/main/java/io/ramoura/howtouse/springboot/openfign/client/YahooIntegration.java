package io.ramoura.howtouse.springboot.openfign.client;

import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryParam;
import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryResponse;
import io.ramoura.howtouse.springboot.openfign.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "financeYahooIntegration",
    configuration = {FeignConfiguration.class})
public interface YahooIntegration {

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v10/finance/quoteSummary/{tickerName}"
    )
    QuoteSummaryResponse getQuoteSummary(@SpringQueryMap QuoteSummaryParam param, @PathVariable String tickerName);
}
