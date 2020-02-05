package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewProps;
import com.google.logging.type.LogSeverity;
import com.horcrux.svg.TextProperties;

class FontData {
    static final double DEFAULT_FONT_SIZE = 12.0d;
    private static final double DEFAULT_KERNING = 0.0d;
    private static final double DEFAULT_LETTER_SPACING = 0.0d;
    private static final double DEFAULT_WORD_SPACING = 0.0d;
    static final FontData Defaults = new FontData();
    private static final String FONT_DATA = "fontData";
    private static final String FONT_FEATURE_SETTINGS = "fontFeatureSettings";
    private static final String FONT_VARIANT_LIGATURES = "fontVariantLigatures";
    private static final String FONT_VARIATION_SETTINGS = "fontVariationSettings";
    private static final String KERNING = "kerning";
    private static final String LETTER_SPACING = "letterSpacing";
    private static final String TEXT_ANCHOR = "textAnchor";
    private static final String TEXT_DECORATION = "textDecoration";
    private static final String WORD_SPACING = "wordSpacing";
    int absoluteFontWeight;
    final ReadableMap fontData;
    final String fontFamily;
    final String fontFeatureSettings;
    final double fontSize;
    final TextProperties.FontStyle fontStyle;
    final TextProperties.FontVariantLigatures fontVariantLigatures;
    final String fontVariationSettings;
    TextProperties.FontWeight fontWeight;
    final double kerning;
    final double letterSpacing;
    final boolean manualKerning;
    final TextProperties.TextAnchor textAnchor;
    private final TextProperties.TextDecoration textDecoration;
    final double wordSpacing;

    static class AbsoluteFontWeight {
        private static final TextProperties.FontWeight[] WEIGHTS = {TextProperties.FontWeight.w100, TextProperties.FontWeight.w100, TextProperties.FontWeight.w200, TextProperties.FontWeight.w300, TextProperties.FontWeight.Normal, TextProperties.FontWeight.w500, TextProperties.FontWeight.w600, TextProperties.FontWeight.Bold, TextProperties.FontWeight.w800, TextProperties.FontWeight.w900, TextProperties.FontWeight.w900};
        private static final int[] absoluteFontWeights = {400, 700, 100, LogSeverity.INFO_VALUE, 300, 400, 500, LogSeverity.CRITICAL_VALUE, 700, 800, 900};
        static final int normal = 400;

        private static int bolder(int i) {
            if (i < 350) {
                return 400;
            }
            if (i < 550) {
                return 700;
            }
            if (i < 900) {
                return 900;
            }
            return i;
        }

        private static int lighter(int i) {
            if (i < 100) {
                return i;
            }
            if (i < 550) {
                return 100;
            }
            return i < 750 ? 400 : 700;
        }

        AbsoluteFontWeight() {
        }

        static TextProperties.FontWeight nearestFontWeight(int i) {
            return WEIGHTS[Math.round(((float) i) / 100.0f)];
        }

        static int from(TextProperties.FontWeight fontWeight, FontData fontData) {
            if (fontWeight == TextProperties.FontWeight.Bolder) {
                return bolder(fontData.absoluteFontWeight);
            }
            if (fontWeight == TextProperties.FontWeight.Lighter) {
                return lighter(fontData.absoluteFontWeight);
            }
            return absoluteFontWeights[fontWeight.ordinal()];
        }
    }

    private FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = TextProperties.FontStyle.normal;
        this.fontWeight = TextProperties.FontWeight.Normal;
        this.absoluteFontWeight = 400;
        this.fontFeatureSettings = "";
        this.fontVariationSettings = "";
        this.fontVariantLigatures = TextProperties.FontVariantLigatures.normal;
        this.textAnchor = TextProperties.TextAnchor.start;
        this.textDecoration = TextProperties.TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = DEFAULT_FONT_SIZE;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    private double toAbsolute(ReadableMap readableMap, String str, double d, double d2, double d3) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str);
        }
        return PropHelper.fromRelative(readableMap.getString(str), d3, d, d2);
    }

    private void setInheritedWeight(FontData fontData2) {
        this.absoluteFontWeight = fontData2.absoluteFontWeight;
        this.fontWeight = fontData2.fontWeight;
    }

    private void handleNumericWeight(FontData fontData2, double d) {
        long round = Math.round(d);
        if (round < 1 || round > 1000) {
            setInheritedWeight(fontData2);
            return;
        }
        this.absoluteFontWeight = (int) round;
        this.fontWeight = AbsoluteFontWeight.nearestFontWeight(this.absoluteFontWeight);
    }

    FontData(ReadableMap readableMap, FontData fontData2, double d) {
        double d2 = fontData2.fontSize;
        if (readableMap.hasKey(ViewProps.FONT_SIZE)) {
            this.fontSize = toAbsolute(readableMap, ViewProps.FONT_SIZE, 1.0d, d2, d2);
        } else {
            this.fontSize = d2;
        }
        if (!readableMap.hasKey(ViewProps.FONT_WEIGHT)) {
            setInheritedWeight(fontData2);
        } else if (readableMap.getType(ViewProps.FONT_WEIGHT) == ReadableType.Number) {
            handleNumericWeight(fontData2, readableMap.getDouble(ViewProps.FONT_WEIGHT));
        } else {
            String string = readableMap.getString(ViewProps.FONT_WEIGHT);
            if (TextProperties.FontWeight.hasEnum(string)) {
                this.absoluteFontWeight = AbsoluteFontWeight.from(TextProperties.FontWeight.get(string), fontData2);
                this.fontWeight = AbsoluteFontWeight.nearestFontWeight(this.absoluteFontWeight);
            } else if (string != null) {
                handleNumericWeight(fontData2, Double.parseDouble(string));
            } else {
                setInheritedWeight(fontData2);
            }
        }
        this.fontData = readableMap.hasKey(FONT_DATA) ? readableMap.getMap(FONT_DATA) : fontData2.fontData;
        this.fontFamily = readableMap.hasKey(ViewProps.FONT_FAMILY) ? readableMap.getString(ViewProps.FONT_FAMILY) : fontData2.fontFamily;
        this.fontStyle = readableMap.hasKey(ViewProps.FONT_STYLE) ? TextProperties.FontStyle.valueOf(readableMap.getString(ViewProps.FONT_STYLE)) : fontData2.fontStyle;
        this.fontFeatureSettings = readableMap.hasKey(FONT_FEATURE_SETTINGS) ? readableMap.getString(FONT_FEATURE_SETTINGS) : fontData2.fontFeatureSettings;
        this.fontVariationSettings = readableMap.hasKey(FONT_VARIATION_SETTINGS) ? readableMap.getString(FONT_VARIATION_SETTINGS) : fontData2.fontVariationSettings;
        this.fontVariantLigatures = readableMap.hasKey(FONT_VARIANT_LIGATURES) ? TextProperties.FontVariantLigatures.valueOf(readableMap.getString(FONT_VARIANT_LIGATURES)) : fontData2.fontVariantLigatures;
        this.textAnchor = readableMap.hasKey(TEXT_ANCHOR) ? TextProperties.TextAnchor.valueOf(readableMap.getString(TEXT_ANCHOR)) : fontData2.textAnchor;
        this.textDecoration = readableMap.hasKey(TEXT_DECORATION) ? TextProperties.TextDecoration.getEnum(readableMap.getString(TEXT_DECORATION)) : fontData2.textDecoration;
        boolean hasKey = readableMap.hasKey(KERNING);
        this.manualKerning = hasKey || fontData2.manualKerning;
        this.kerning = hasKey ? toAbsolute(readableMap, KERNING, d, this.fontSize, 0.0d) : fontData2.kerning;
        this.wordSpacing = readableMap.hasKey(WORD_SPACING) ? toAbsolute(readableMap, WORD_SPACING, d, this.fontSize, 0.0d) : fontData2.wordSpacing;
        this.letterSpacing = readableMap.hasKey("letterSpacing") ? toAbsolute(readableMap, "letterSpacing", d, this.fontSize, 0.0d) : fontData2.letterSpacing;
    }
}
