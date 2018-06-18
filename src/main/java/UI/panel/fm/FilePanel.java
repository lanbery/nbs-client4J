package UI.panel.fm;

import UI.common.NBSAbstractPanel;
import UI.common.ToolbarStatsPanel;
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
    public static final String PKUI_PANEL_FILE_LABEL = "nbs.ui.panel.file.label";


    public FilePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    @Override
    protected void addComponent() {
        ToolbarStatsPanel toolbarStatsPanel = new ToolbarStatsPanel(PKUI_PANEL_FILE_LABEL);
        this.add(toolbarStatsPanel,BorderLayout.NORTH);
    }

    @Override
    protected void addListener() {

    }

    @Override
    public void load() {

    }
}
