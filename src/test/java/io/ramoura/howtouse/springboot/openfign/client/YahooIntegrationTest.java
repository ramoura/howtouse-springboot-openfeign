package io.ramoura.howtouse.springboot.openfign.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.ramoura.howtouse.springboot.openfign.client.dto.QuoteSummaryParam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

class YahooIntegrationTest {

    private WireMockServer wireMockServer;

    public void setupMockQuoteSummaryResponse(WireMockServer mockService, String testUrl) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlMatching(testUrl))
            .willReturn(WireMock.aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .withBody(
                    copyToString(
                        YahooIntegrationTest.class.getClassLoader().getResourceAsStream("payload/quoteSummary_OK.json"),
                        defaultCharset()))));
    }
    public void setupMockQuoteHistoryResponse(WireMockServer mockService, String testUrl) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlMatching(testUrl))
            .willReturn(WireMock.aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .withBody(
                    copyToString(
                        YahooIntegrationTest.class.getClassLoader().getResourceAsStream("payload/financeChart_OK.json"),
                        defaultCharset()))));
    }

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(wireMockConfig().port(9561));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void getQuoteSummary_success() throws IOException {
        YahooIntegration yahooIntegration = Feign.builder()
            .contract(new SpringMvcContract())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(YahooIntegration.class, "http://localhost:9561");

        QuoteSummaryParam param = QuoteSummaryParam.builder()
            .module("price")
            .build();

        String testUrl = "/v10/finance/quoteSummary/TICKER.NAME.*";

        setupMockQuoteSummaryResponse(wireMockServer, testUrl);

        var response = yahooIntegration.getQuoteSummary(param,"TICKER.NAME");

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.quoteSummary.result.get(0).price.symbol).isEqualTo("TICKER.NAME");
    }


}
