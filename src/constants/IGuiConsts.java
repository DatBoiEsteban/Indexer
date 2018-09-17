package constants;

import java.awt.Color;
import java.awt.Font;

public interface IGuiConsts {
	public final int TEXT_FONT_SIZE = 14;
	public final String TEXT_FONT_NAME = "Tahoma";
	public final int TEXT_FONT_STYLE = 0;
	public final Font TEXT_FONT = new Font(TEXT_FONT_NAME, TEXT_FONT_STYLE, TEXT_FONT_SIZE);
	public final int TEXT_COLOR_RED = 0;
	public final int TEXT_COLOR_GREEN = 153;
	public final int TEXT_COLOR_BLUE = 255;
	public final Color TEXT_COLOR = new Color(TEXT_COLOR_RED,TEXT_COLOR_GREEN,TEXT_COLOR_BLUE);
	
	public final int TITLE_FONT_SIZE = 36;
	public final String TITLE_FONT_NAME = "Verdana";
	public final int TITLE_FONT_STYLE = 1;
	public final Font TITLE_FONT = new Font(TITLE_FONT_NAME, TITLE_FONT_STYLE, TITLE_FONT_SIZE);
	public final String TITLE = "Log Pose";
	public final int TITLE_COLOR_RED = 51;
	public final int TITLE_COLOR_GREEN = 51;
	public final int TITLE_COLOR_BLUE = 255;
	public final Color TITLE_COLOR = new Color(TITLE_COLOR_RED,TITLE_COLOR_GREEN,TITLE_COLOR_BLUE);

	public final double HEIGHT_MODIF_SEARCH = 0.5;
	public final double HEIGHT_MODIF_TITLE = 0.15;
	public final int COMPONENT_SEPARATOR = 30;

	public final int WINDOW_HEIGHT = 720;
	public final int WINDOW_WIDTH = 1280;
	public final int BORDER = 100;

	public final int BUTTON_WIDTH = 100;
	public final int BUTTON_HEIGHT = 25;
	public final int BUTTON_X_LOCATION = WINDOW_WIDTH - BORDER - 50;
	public final int BUTTON_Y_LOCATION = (int) (WINDOW_HEIGHT * HEIGHT_MODIF_SEARCH);

	public final int SEARCHBAR_WIDTH = WINDOW_WIDTH - BORDER - COMPONENT_SEPARATOR - BUTTON_WIDTH-(BUTTON_WIDTH/2);
	public final int SEARCHBAR_HEIGHT = BUTTON_HEIGHT;
	public final int SEARCHBAR_X_LOCATION = BORDER;
	public final int SEARCHBAR_Y_LOCATION = (int) (WINDOW_HEIGHT * HEIGHT_MODIF_SEARCH);

	public final int TITLE_WIDTH = 220;
	public final int TITLE_HEIGHT = 50;
	public final int TITLE_X_LOCATION = WINDOW_WIDTH - (WINDOW_WIDTH / 2) - (TITLE_WIDTH / 2);
	public final int TITLE_Y_LOCATION = (int) (WINDOW_HEIGHT * HEIGHT_MODIF_TITLE);
}
