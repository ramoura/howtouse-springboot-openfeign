package io.ramoura.howtouse.springboot.openfign.client.dto;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class QuoteSummaryParam {
    @Singular
    private List<String> modules;
}
