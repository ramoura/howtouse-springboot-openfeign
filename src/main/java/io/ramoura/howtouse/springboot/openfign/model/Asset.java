package io.ramoura.howtouse.springboot.openfign.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class Asset {
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;



}
