package UI;

import UI.panel.*;
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
     * 关于面板
     */
    public static AboutPanel aboutPanel;

    public static void main(String[] args){
        EventQueue.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        try{
                            AppMainWindow window = new AppMainWindow();
                            window.frame.setVisible(true);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
        );
    }


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

        //主要窗口
        mainPanel = new JPanel(true);
        mainPanel.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        mainPanel.setLayout(new BorderLayout());

        //工具栏
        ToolBarPanel toolbar = new ToolBarPanel();
        statusPanel = new StatusPanel();

        //初始化 面板
        aboutPanel = new AboutPanel();
        //TODO other panel init



        //设置左侧菜单栏位
        mainPanel.add(toolbar,BorderLayout.WEST);

        /**
         * 设置中部内容显示面板
         * 默认 status
         */
        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(statusPanel,BorderLayout.CENTER);

        mainPanel.add(mainPanelCenter,BorderLayout.CENTER);
        //
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logger.info("NBS initialized ...");
    }
}
