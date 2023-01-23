package io.ramoura.howtouse.springboot.openfign.client.dto;

import java.util.ArrayList;

public class QuoteSummaryResponse {

    public QuoteSummary quoteSummary;

    public static class QuoteSummary {
        public ArrayList<Result> result;
        public Object error;



    }

    public static class AverageDailyVolume10Day{
    }

    public static class AverageDailyVolume3Month{
    }

    public static class CirculatingSupply{
    }
    public static class MarketCap{
        public long raw;
        public String fmt;

        public String longFmt;
    }

    public static class OpenInterest{
    }

    public static class PostMarketChange{
    }

    public static class PostMarketPrice{
    }

    public static class PreMarketChange{
    }

    public static class PreMarketPrice{
    }

    public static class Price{
        public int maxAge;
        public PreMarketChange preMarketChange;
        public PreMarketPrice preMarketPrice;
        public PostMarketChange postMarketChange;
        public PostMarketPrice postMarketPrice;
        public RegularMarketChangePercent regularMarketChangePercent;
        public RegularMarketChange regularMarketChange;
        public int regularMarketTime;
        public PriceHint priceHint;
        public RegularMarketPrice regularMarketPrice;
        public RegularMarketDayHigh regularMarketDayHigh;
        public RegularMarketDayLow regularMarketDayLow;
        public RegularMarketVolume regularMarketVolume;
        public AverageDailyVolume10Day averageDailyVolume10Day;
        public AverageDailyVolume3Month averageDailyVolume3Month;
        public RegularMarketPreviousClose regularMarketPreviousClose;
        public String regularMarketSource;
        public RegularMarketOpen regularMarketOpen;
        public StrikePrice strikePrice;
        public OpenInterest openInterest;
        public String exchange;
        public String exchangeName;
        public int exchangeDataDelayedBy;
        public String marketState;
        public String quoteType;
        public String symbol;
        public Object underlyingSymbol;
        public String shortName;
        public String longName;
        public String currency;
        public String quoteSourceName;
        public String currencySymbol;
        public Object fromCurrency;
        public Object toCurrency;
        public Object lastMarket;
        public Volume24Hr volume24Hr;
        public VolumeAllCurrencies volumeAllCurrencies;
        public CirculatingSupply circulatingSupply;
        public MarketCap marketCap;
    }

    public static class PriceHint{
        public int raw;
        public String fmt;
        public String longFmt;
    }

    public static class RegularMarketChange{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketChangePercent{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketDayHigh{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketDayLow{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketOpen{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketPreviousClose{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketPrice{
        public double raw;
        public String fmt;
    }

    public static class RegularMarketVolume{
        public int raw;
        public Object fmt;
        public String longFmt;
    }

    public static class Result{
        public Price price;
    }

    public static class StrikePrice{
    }

    public static class Volume24Hr{
    }

    public static class VolumeAllCurrencies{
    }

}
