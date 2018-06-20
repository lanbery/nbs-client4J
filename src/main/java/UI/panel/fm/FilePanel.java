package UI.panel.fm;

import UI.ConstantsUI;
import UI.button.NBSIconButton;
import UI.common.NBSAbstractPanel;
import UI.common.ToolbarStatsPanel;
import UI.panel.ContentJLabel;
import UI.templete.WihteBackJPanel;
import com.nbs.tools.PropertyUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Package : UI.panel.fm
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/15-13:10
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class FilePanel extends NBSAbstractPanel {
    private static final String PKUI_PANEL_FILE_LABEL = "nbs.ui.panel.file.label";
    private static final String PKUI_LS_BUTTON_TIP = "nbs.ui.panel.file.button.query";
    private static final String PKUI_SHARE_BUTTON_TIP = "nbs.ui.panel.file.button.share";
    private static final String PKUI_UPLOAD_BUTTON_TIP = "nbs.ui.panel.file.button.upload";

    private static NBSIconButton lsBtn;
    private static NBSIconButton shareBtn;
    private static NBSIconButton uploadBtn;
    /**
     *
     */
    private static JTextField hashField = new JTextField(80);



    public FilePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    @Override
    protected void addComponent() {
        ToolbarStatsPanel toolbarStatsPanel = new ToolbarStatsPanel(PKUI_PANEL_FILE_LABEL);
        this.add(toolbarStatsPanel,BorderLayout.NORTH);

        this.add(buildCenterPanel(),BorderLayout.CENTER);

        this.add(biuldPanelBottom(),BorderLayout.SOUTH);
    }

    /**
     *
     */
    private JPanel buildCenterPanel(){
        WihteBackJPanel centerPanel = new WihteBackJPanel();
        centerPanel.setLayout(new BorderLayout());
        FileShowPanel showPanel = new FileShowPanel();

        FileHisPanel hisPanel = new FileHisPanel();


        centerPanel.add(showPanel,BorderLayout.CENTER);
        centerPanel.add(hisPanel,BorderLayout.EAST);

        return centerPanel;
    }

    /**
     *
     * @return
     */
    private JPanel biuldPanelBottom(){
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelBottom.setLayout(new BorderLayout());

        JPanel leftPanel = new WihteBackJPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT,8,10));
        JLabel hashLabel = new ContentJLabel(PropertyUtil.getProperty("nbs.ui.panel.file.label.hash"));
        hashLabel.setFont(ConstantsUI.FONT_LABEL);
        leftPanel.add(hashLabel);
        leftPanel.add(hashField);

        panelBottom.add(leftPanel,BorderLayout.WEST);


        JPanel rightPanel = new WihteBackJPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,4));
        lsBtn = new NBSIconButton(
                ConstantsUI.ICON_FILE_LS,ConstantsUI.ICON_FILE_LS_ENABLED,
                ConstantsUI.ICON_FILE_LS_DISABLED,PropertyUtil.getProperty(PKUI_LS_BUTTON_TIP));
        shareBtn = new NBSIconButton(
                ConstantsUI.ICON_FILE_SHARE,ConstantsUI.ICON_FILE_SHARE_ENABLED,
                ConstantsUI.ICON_FILE_SHARE_DISABLED,PropertyUtil.getProperty(PKUI_SHARE_BUTTON_TIP));
        uploadBtn =  new NBSIconButton(
                ConstantsUI.ICON_UPLOAD,ConstantsUI.ICON_UPLOAD_ENABLED,
                ConstantsUI.ICON_UPLOAD_DISABLED,PropertyUtil.getProperty(PKUI_UPLOAD_BUTTON_TIP));

        rightPanel.add(lsBtn);
        rightPanel.add(shareBtn);
        rightPanel.add(uploadBtn);

        panelBottom.add(rightPanel,BorderLayout.EAST);

        return panelBottom;
    }

    @Override
    protected void addListener() {

    }



    @Override
    public void load() {

    }
}
