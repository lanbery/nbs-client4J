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
        this.setPreferredSize(new Dimension(ConstantsUI.MAIN_WINDOW_WIDTH*3/10,580));
        this.setBackground(new Color(25,25,25));
        this.setFont(ConstantsUI.FONT_NORMAL);
        this.setForeground(Color.WHITE);
        this.add(new Label("lskdfkflksakfkasflkdsa"));

    }
}
