package spil.entity;

import java.awt.Color;

/*
 * FieldBoundary is a general class, that similar to TextBoundary, holds all the information
 * associated with the Field objects inside the GameBoard class. If any Field data is needed
 * to be changed, then this is where you want to be looking first.
 */
public class FieldInfo {

	private FieldInfo() {

	}

	public static final int FIELD_COUNT = 40;
	public static final int TAX_SPECIAL_POS = 18;

	public static final int DICE_MULTIPLIER = 100;
	public static final double TAX_MULTIPLIER = 0.1;

	public static final Color[][] fieldColors = { { Color.WHITE, Color.BLACK }, { Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE },
			{ Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE },
			{ Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE }, { Color.DARK_GRAY, Color.WHITE },
			{ Color.DARK_GRAY, Color.WHITE }, { Color.YELLOW, Color.BLACK }, { Color.YELLOW, Color.BLACK }, { Color.RED, Color.WHITE },
			{ Color.RED, Color.WHITE }, { Color.BLUE, Color.WHITE }, { Color.BLUE, Color.WHITE }, { Color.CYAN, Color.BLACK },
			{ Color.CYAN, Color.BLACK }, { Color.CYAN, Color.BLACK }, { Color.CYAN, Color.BLACK }, };

	public static final Color[][] carColors = { { new Color(0x03453F), new Color(0xFF0010) }, { new Color(0x0400FF), new Color(0xFF00E1) },
			{ new Color(0xAF4342), new Color(0xFF0910) }, { new Color(0xFA4039), new Color(0xF023E1) }, { new Color(0xABC423), new Color(0xAB0FA0) },
			{ new Color(0xA4FBC3), new Color(0xF234B0) }, };

}