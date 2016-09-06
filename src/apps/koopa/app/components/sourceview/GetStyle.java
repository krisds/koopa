package koopa.app.components.sourceview;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.SyntacticTag.STRING;

import java.awt.Color;

import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import koopa.core.data.Token;

public class GetStyle {
	private static final Color BG_REPLACED = new Color(248, 248, 236);
	private static final Color FG_COMMENT = new Color(50, 116, 44);
	private static final Color FG_COMPILER_DIRECTIVE = new Color(255, 136, 0);
	private static final Color FG_STRING = new Color(98, 40, 110);
	private static final Color FG_WATER = new Color(6, 71, 128);

	public static AttributeSet forUnparsed(StyledDocument document) {
		Style style = getStyle(document, "unparsed", false);
		if (style == null) {
			style = addStyle(document, "unparsed", false);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.GRAY);
		}

		return style;
	}

	public static AttributeSet forTokenInDocument(Token token,
			StyledDocument document) {

		final boolean isReplacement = token.isReplacement();

		if (token.hasTag(COMPILER_DIRECTIVE))
			return getCompilerDirectiveStyle(document, isReplacement);
		else if (!token.hasTag(PROGRAM_TEXT_AREA))
			return getCommentStyle(document, isReplacement);
		else if (token.hasTag(COMMENT))
			return getCommentStyle(document, isReplacement);
		else if (token.hasTag(STRING))
			return getStringStyle(document, isReplacement);
		else if (token.hasTag(PROGRAM_TEXT_AREA) && token.hasTag(LAND))
			return getLandStyle(document, isReplacement);
		else
			return getWaterStyle(document, isReplacement);
	}

	private static Style getWaterStyle(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "water", isReplacement);
		if (style == null) {
			style = addStyle(document, "water", isReplacement);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, true);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, //
					isReplacement ? BG_REPLACED : Color.WHITE);
			StyleConstants.setForeground(style, FG_WATER);
		}

		return style;
	}

	private static Style getLandStyle(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "land", isReplacement);
		if (style == null) {
			style = addStyle(document, "land", isReplacement);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, //
					isReplacement ? BG_REPLACED : Color.WHITE);
			StyleConstants.setForeground(style, Color.BLACK);
		}

		return style;
	}

	private static Style getCommentStyle(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "comment", isReplacement);
		if (style == null) {
			style = addStyle(document, "comment", isReplacement);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, isReplacement ? BG_REPLACED
					: Color.WHITE);
			StyleConstants.setForeground(style, FG_COMMENT);
		}

		return style;
	}

	private static Style getCompilerDirectiveStyle(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "compilerDirective", isReplacement);
		if (style == null) {
			style = addStyle(document, "compilerDirective", isReplacement);

			StyleConstants.setItalic(style, true);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, isReplacement ? BG_REPLACED
					: Color.WHITE);
			StyleConstants.setForeground(style, FG_COMPILER_DIRECTIVE);
		}

		return style;
	}

	private static Style getStringStyle(StyledDocument document,
			boolean isReplacement) {

		Style style = getStyle(document, "string", isReplacement);
		if (style == null) {
			style = addStyle(document, "string", isReplacement);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, isReplacement ? BG_REPLACED
					: Color.WHITE);
			StyleConstants.setForeground(style, FG_STRING);
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
