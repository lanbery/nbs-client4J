package UI.common;

import UI.ConstantsUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Package : UI.common
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/16-23:54
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public abstract class NBSAbstractPanel extends JPanel {

    public NBSAbstractPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        init();
        addComponent();
    }

    protected void init(){
        this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
    }
    protected abstract void addComponent();
    protected abstract void addListener();
    public abstract void load();

}
