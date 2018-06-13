package UI;

import com.nbs.tools.PropertyUtil;

import java.awt.*;

/**
 * @Package : UI
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/13-14:58
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class ConstantsUI {
    /**
     * 软件名称、版本
     */
    public final static String APP_NAME = "NBS Chain";
    public final static String APP_VERSION = "v0.1";
    /**
     * 窗口设置
     */
    public final static int MAIN_WINDOW_X = 240;
    public final static int MAIN_WINDOW_Y = 100;
    public final static int MAIN_WINDOW_WIDTH = 885;
    public final static int MAIN_WINDOW_HEIGHT = 636;
    /**
     * 系统当前路径
     */
    public final static String CURRENT_DIR = System.getProperty("user.dir");

    /**
     * 图标
     */
    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit()
            .getImage(AppMainWindow.class.getResource("/icon/nbs64.png"));
    /**
     *
     */
    public final static Color MAIN_BACK_COLOR = Color.WHITE;
    /**
     *
     */
    public final static Color TOOL_BAR_BACK_COLOR = new Color(37,174,96);

    /**
     * @Date    : 2018/6/13 15:19
     * @Author  : lanbery
     * @Decription :
     * <p>
     *     字体设置
     * </p>
     */
    public final static Font FONT_TITLE = new Font(PropertyUtil.getProperty("nbs.ui.font.family"),0,27);
    public final static Font FONT_NORMAL = new Font(PropertyUtil.getProperty("nbs.ui.font.family"),0,13);
    public final static Font FONT_RADIO = new Font(PropertyUtil.getProperty("nbs.ui.font.family"),0,15);




}
