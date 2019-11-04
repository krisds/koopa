package koopa.app.debug;

import static javax.swing.text.StyleConstants.setBackground;
import static javax.swing.text.StyleConstants.setBold;
import static javax.swing.text.StyleConstants.setFontFamily;
import static javax.swing.text.StyleConstants.setFontSize;
import static javax.swing.text.StyleConstants.setForeground;
import static javax.swing.text.StyleConstants.setItalic;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.IslandTag;

public class CodeStyle {
	public static final Color BG_UNPARSED = new Color(233, 239, 242);
	private static final Color BG_REPLACED = new Color(248, 248, 236);
	private static final Color FG_COMMENT = new Color(50, 116, 44);
	private static final Color FG_WATER = new Color(6, 71, 128);

	public static AttributeSet forToken(Token token, StyledDocument document) {
		if (token.hasTag(AreaTag.COMMENT))
			return forComment(document, token.isReplacement());
		else if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA))
			return forNonProgramText(document, token.isReplacement());
		else if (token.hasTag(IslandTag.WATER))
			return forWater(document, token.isReplacement());
		else
			return forLand(document, token.isReplacement());
	}

	public static AttributeSet forUnparsed(StyledDocument document,
			boolean isReplacement) {
		Style style = getStyle(document, "unparsed", isReplacement);
		if (style == null) {
			style = addStyle(document, "unparsed", isReplacement);

			setItalic(style, false);
			setBold(style, false);
			setFontFamily(style, "Courier");
			setFontSize(style, 14);
			setBackground(style, isReplacement ? BG_REPLACED : BG_UNPARSED);
			setForeground(style, Color.GRAY);
		}

		return style;
	}

	public static AttributeSet forNonProgramText(StyledDocument document,
			boolean isReplacement) {
		Style style = getStyle(document, "non-program-text", isReplacement);
		if (style == null) {
			style = addStyle(document, "non-program-text", isReplacement);

			setItalic(style, false);
			setBold(style, false);
			setFontFamily(style, "Courier");
			setFontSize(style, 14);
			setBackground(style, isReplacement ? BG_REPLACED : Color.WHITE);
			setForeground(style, Color.GRAY);
		}

		return style;
	}

	public static AttributeSet forWater(StyledDocument document,
			boolean isReplacement) {
		Style style = getStyle(document, "water", isReplacement);
		if (style == null) {
			style = addStyle(document, "water", isReplacement);

			setItalic(style, false);
			setBold(style, true);
			setFontFamily(style, "Courier");
			setFontSize(style, 14);
			setBackground(style, isReplacement ? BG_REPLACED : Color.WHITE);
			setForeground(style, FG_WATER);
		}

		return style;
	}

	public static Style forLand(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "land", isReplacement);
		if (style == null) {
			style = addStyle(document, "land", isReplacement);

			setItalic(style, false);
			setBold(style, false);
			setFontFamily(style, "Courier");
			setFontSize(style, 14);
			setBackground(style, isReplacement ? BG_REPLACED : Color.WHITE);
			setForeground(style, Color.BLACK);
		}

		return style;
	}

	private static Style forComment(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "comment", isReplacement);
		if (style == null) {
			style = addStyle(document, "comment", isReplacement);

			setItalic(style, false);
			setBold(style, false);
			setFontFamily(style, "Courier");
			setFontSize(style, 14);
			setBackground(style, isReplacement ? BG_REPLACED : Color.WHITE);
			setForeground(style, FG_COMMENT);
		}

		return style;
	}

	private static Style getStyle(StyledDocument document, String name,
			boolean isReplacement) {

		if (isReplacement)
			return document.getStyle(name + "-in-copy");
		else
			return document.getStyle(name);
	}

	private static Style addStyle(StyledDocument document, String name,
			boolean isReplacement) {

		if (isReplacement)
			return document.addStyle(name + "-in-copy", null);
		else
			return document.addStyle(name, null);
	}
}
