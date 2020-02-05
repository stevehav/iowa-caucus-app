package com.horcrux.svg;

import com.facebook.react.uimanager.ViewProps;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

class TextProperties {

    enum Direction {
        ltr,
        rtl
    }

    enum FontStyle {
        normal,
        italic,
        oblique
    }

    enum FontVariantLigatures {
        normal,
        none
    }

    enum TextAnchor {
        start,
        middle,
        end
    }

    enum TextLengthAdjust {
        spacing,
        spacingAndGlyphs
    }

    enum TextPathMethod {
        align,
        stretch
    }

    enum TextPathMidLine {
        sharp,
        smooth
    }

    enum TextPathSide {
        left,
        right
    }

    enum TextPathSpacing {
        auto,
        exact
    }

    TextProperties() {
    }

    enum AlignmentBaseline {
        baseline("baseline"),
        textBottom("text-bottom"),
        alphabetic("alphabetic"),
        ideographic("ideographic"),
        middle("middle"),
        central("central"),
        mathematical("mathematical"),
        textTop("text-top"),
        bottom(ViewProps.BOTTOM),
        center("center"),
        top(ViewProps.TOP),
        textBeforeEdge("text-before-edge"),
        textAfterEdge("text-after-edge"),
        beforeEdge("before-edge"),
        afterEdge("after-edge"),
        hanging("hanging");
        
        private static final Map<String, AlignmentBaseline> alignmentToEnum = null;
        private final String alignment;

        static {
            int i;
            alignmentToEnum = new HashMap();
            for (AlignmentBaseline alignmentBaseline : values()) {
                alignmentToEnum.put(alignmentBaseline.alignment, alignmentBaseline);
            }
        }

        private AlignmentBaseline(String str) {
            this.alignment = str;
        }

        static AlignmentBaseline getEnum(String str) {
            if (alignmentToEnum.containsKey(str)) {
                return alignmentToEnum.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }

        @Nonnull
        public String toString() {
            return this.alignment;
        }
    }

    enum FontWeight {
        Normal("normal"),
        Bold("bold"),
        w100("100"),
        w200("200"),
        w300("300"),
        w400("400"),
        w500("500"),
        w600("600"),
        w700("700"),
        w800("800"),
        w900("900"),
        Bolder("bolder"),
        Lighter("lighter");
        
        private static final Map<String, FontWeight> weightToEnum = null;
        private final String weight;

        static {
            int i;
            weightToEnum = new HashMap();
            for (FontWeight fontWeight : values()) {
                weightToEnum.put(fontWeight.weight, fontWeight);
            }
        }

        private FontWeight(String str) {
            this.weight = str;
        }

        static boolean hasEnum(String str) {
            return weightToEnum.containsKey(str);
        }

        static FontWeight get(String str) {
            return weightToEnum.get(str);
        }

        @Nonnull
        public String toString() {
            return this.weight;
        }
    }

    enum TextDecoration {
        None(ViewProps.NONE),
        Underline("underline"),
        Overline("overline"),
        LineThrough("line-through"),
        Blink("blink");
        
        private static final Map<String, TextDecoration> decorationToEnum = null;
        private final String decoration;

        static {
            int i;
            decorationToEnum = new HashMap();
            for (TextDecoration textDecoration : values()) {
                decorationToEnum.put(textDecoration.decoration, textDecoration);
            }
        }

        private TextDecoration(String str) {
            this.decoration = str;
        }

        static TextDecoration getEnum(String str) {
            if (decorationToEnum.containsKey(str)) {
                return decorationToEnum.get(str);
            }
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }

        @Nonnull
        public String toString() {
            return this.decoration;
        }
    }
}
