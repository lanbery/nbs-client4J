package UI.panel.fm;

import UI.ConstantsUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Package : UI.panel.fm
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/20-16:15
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class FileHisPanel extends JPanel {
    public FileHisPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        initialize();
    }

    public FileHisPanel(LayoutManager layout) {
        super(layout);
        initialize();
    }

    public FileHisPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        initialize();
    }

    public FileHisPanel() {
        initialize();
    }


    public void initialize(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT,4,0));
        this.setPreferredSize(new Dimension(ConstantsUI.MAIN_WINDOW_WIDTH*3/10,580));
        this.setBackground(ConstantsUI.COMMAND_BACK_COLOR);
        this.setFont(ConstantsUI.FONT_NORMAL);
        this.setForeground(Color.WHITE);
        LogFlowJText timeLabel ,hashLabel;

        timeLabel =  new LogFlowJText("> 2018-06-21 22:30:22 上传nbs.png,成功."+ConstantsUI.CRLF_PANEL);
        timeLabel.append("hash:.QmWqCZVQLZZM4B38N5NyAcSArbDe7WFntXQ842AbKDU9YB"+ConstantsUI.CRLF_PANEL);
        //timeLabel.widthWarp((ConstantsUI.MAIN_WINDOW_WIDTH*2/5-6),);
        this.add(timeLabel);
    }
}
