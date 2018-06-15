package UI.panel;

import UI.ConstantsUI;
import UI.button.NBSIconButton;
import com.nbs.tools.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @Package : UI.panel
 * @Description : <p>
 *     NBS 介绍
 * </p>
 * @Author : lambor.c
 * @Date : 2018/6/15-15:16
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class AboutPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(AboutPanel.class);
    protected static final String NBS_DOWNLOAD_SITE="https://github.com/W-B-S/nbs-server-test/releases";

    private static NBSIconButton checkUpdateBtn;

    /**
     *
     */
    public AboutPanel(){
        initialize();
        addComponent();
        addListener();
    }

    /**
     * 初始化
     */
    private void initialize(){
        this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
    }

    public void addComponent(){
        this.add(buildPanelTop(),BorderLayout.NORTH);
        this.add(buildPanelCenter(),BorderLayout.CENTER);
        this.add(biuldPanelBottom(),BorderLayout.SOUTH);
    }

    /**
     * @Date    : 2018/6/15 15:30
     * @Author  : lanbery
     * @Decription :
     * <p> 头部</p>
     * @Param   :
     * @return
     * @throws
     */
    public JPanel buildPanelTop(){
        JPanel panelTop = new JPanel();
        panelTop.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT,ConstantsUI.MAIN_H_GAP,5));

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty(PropertyUtil.PKUI_PANEL_ABOUT_LABEL));
        labelTitle.setFont(ConstantsUI.FONT_TITLE);
        labelTitle.setForeground(ConstantsUI.PANEL_TITILE_COLOR);

        panelTop.add(labelTitle);
        return panelTop;
    }

    /**
     *
     * @return
     */
    private JPanel buildPanelCenter(){
        JPanel panelCenter = new JPanel(true);
        panelCenter.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelCenter.setLayout(new BorderLayout());

        /**
         * About Short Title and logo Begin
         */
        // title and logo
        JPanel shortPanel = new JPanel(true);
        shortPanel.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        shortPanel.setLayout(new BorderLayout());

        JLabel shortTitle = new JLabel(" NBS IPFS the p2p data share!");
        shortTitle.setFont(ConstantsUI.FONT_SUB_TITLE);
        shortTitle.setForeground(ConstantsUI.NORMAL_FONT_COLOR);
        shortPanel.add(shortTitle,BorderLayout.CENTER);

        //logo
        JLabel logoLabel = new JLabel(ConstantsUI.NBS_ICON);
        shortPanel.add(logoLabel,BorderLayout.WEST);

        panelCenter.add(shortPanel,BorderLayout.NORTH);

        /**
         * contentPanel
         */
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT,ConstantsUI.MAIN_H_GAP,10));

        JLabel version = new ContentJLabel("v0.1.11");

        JLabel content = new ContentJLabel("asdfkjsafdhkjsadfjsafsadg dsafhdsakjdsafgdsalf " +
                "asdfsadfsahdfkhdsaf " +
                "dsafghsadgfjsagdff /n/r" +
                "sjdhfjds /n/r");
        contentPanel.add(version);
        contentPanel.add(content);

        panelCenter.add(contentPanel,BorderLayout.CENTER);
        return panelCenter;
    }

    /**
     * 加载信息
     */
    public void loadPanelInfo(){

    }

    /**
     * 底部
     * @return
     */
    private JPanel biuldPanelBottom(){
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(ConstantsUI.MAIN_BACK_COLOR);

        JLabel cyrt = new JLabel(PropertyUtil.getProperty("nbs.soft.copyright","Copyright by NBS 2018"));
        cyrt.setFont(ConstantsUI.FONT_CPR);
        cyrt.setForeground(ConstantsUI.NORMAL_FONT_COLOR);
        panelBottom.add(cyrt,BorderLayout.WEST);

        panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT,ConstantsUI.MAIN_H_GAP,15));
        checkUpdateBtn = new NBSIconButton(
                ConstantsUI.ICON_CHECK,ConstantsUI.ICON_CHECK_ENABLED,ConstantsUI.ICON_CHECK_DISABLED,"");
        panelBottom.add(checkUpdateBtn);


        return panelBottom;
    }

    /**
     * @Date    : 2018/6/15 15:55
     * @Author  : lanbery
     * @Decription :
     * <p>为控件添加事件</p>
     * @Param   :
     * @return
     * @throws
     */
    public void addListener(){
        /**
         *
         */
        checkUpdateBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String site = PropertyUtil.getProperty("nbs.soft.download.url",NBS_DOWNLOAD_SITE);
                try {
                    java.net.URI uri = java.net.URI.create(site);
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                    if(desktop.isSupported(Desktop.Action.BROWSE)){
                            desktop.browse(uri);
                    }else{
                        JOptionPane.showMessageDialog(null,PropertyUtil.getProperty("nbs.btn.checked.version.nosetBorowser",""));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,PropertyUtil.getProperty("nbs.global.error",""));
                }
            }
        });
    }
}
