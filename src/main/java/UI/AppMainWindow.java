package UI;

import UI.panel.ConsolePanel;
import UI.panel.SettingPanel;
import UI.panel.StatusPanel;
import UI.panel.ToolBarPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * @Package : UI
 * @Description :
 * <p>
 *     NBS ipfs Client for Java.
 *     <h1>程序主入口</h1>
 * </p>
 * @Author : lambor.c
 * @Date : 2018/6/13-14:55
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class AppMainWindow {

    /**
     *
     */
    private static final Logger logger = LoggerFactory.getLogger(AppMainWindow.class);

    private JFrame frame;
    /**
     *
     */
    private static JPanel mainPanel;
    /**
     *
     */
    public static  JPanel mainPanelCenter;
    /**
     *
     */
    public static StatusPanel statusPanel;

    /**
     * 运行监控
     */
    public static ConsolePanel consolePanel;
    /**
     *
     */
    public static SettingPanel settingPanel;


    /**
     * @Date    : 2018/6/13 16:49
     * @Author  : lanbery
     * @Decription :
     * <p>构造NBS App</p>
     * @Param   :
     * @return
     * @throws
     */
    public AppMainWindow(){
        initialize();

    }
    /**
     * 初始化frame内容
     */
    private void initialize(){
        logger.info("NBS initializing start ...");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
                | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame = new JFrame();
        //set window Size
        frame.setBounds(ConstantsUI.MAIN_WINDOW_X,ConstantsUI.MAIN_WINDOW_Y
                ,ConstantsUI.MAIN_WINDOW_WIDTH,ConstantsUI.MAIN_WINDOW_HEIGHT);
        frame.setTitle(ConstantsUI.APP_NAME);
        frame.setIconImage(ConstantsUI.IMAGE_ICON);
        frame.setBackground(ConstantsUI.MAIN_BACK_COLOR);

        mainPanel = new JPanel(true);
        mainPanel.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        mainPanel.setLayout(new BorderLayout());

        //
        ToolBarPanel toolbar = new ToolBarPanel();
        statusPanel = new StatusPanel();

        mainPanel.add(toolbar,BorderLayout.WEST);

        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(statusPanel,BorderLayout.CENTER);

        mainPanel.add(mainPanelCenter,BorderLayout.CENTER);

        //
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        logger.info("NBS initialized ...");
    }
}
