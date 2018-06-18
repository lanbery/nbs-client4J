package UI.panel;

import UI.ConstantsUI;
import UI.button.NBSIconButton;
import com.nbs.tools.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * @Package : UI.panel
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/13-16:43
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class StatusPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(StatusPanel.class);

    public static boolean isRunning = false;


    //Button Defined
    //public static NBSIconButton

    //Label
    public static JLabel labelStatus;

    public StatusPanel(){
        super(false);
        initialize();
        addComponent();

    }

    /**
     *
     */
    private void initialize(){
        this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
    }

    /**
     *
     */
    private void addComponent(){
        this.add(getUpPanel(),BorderLayout.NORTH);
        this.add(getDownPanel(),BorderLayout.SOUTH);
    }
    public void load(){

    }

    /**
     * 构造上部面板
     * @return
     */
    private JPanel getUpPanel(){
        JPanel panelUp = new JPanel();
        panelUp.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT,ConstantsUI.MAIN_H_GAP,5));

        JLabel labelTitle = new JLabel(PropertyUtil.getProperty("nbs.ui.panel.status.label"));
        labelTitle.setFont(ConstantsUI.FONT_TITLE);
        labelTitle.setForeground(ConstantsUI.PANEL_TITILE_COLOR);
        panelUp.add(labelTitle);
        return panelUp;
    }

    private JPanel getCenterPanel(){
        JPanel panel = new JPanel();

        return panel;
    }

    private JPanel getDownPanel(){
        JPanel panelDown = new JPanel();

        return panelDown;
    }
}
