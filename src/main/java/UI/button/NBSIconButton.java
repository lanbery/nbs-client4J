package UI.button;

import javax.swing.*;

/**
 * @Package : UI.button
 * @Description : <p></p>
 * @Author : lambor.c
 * @Date : 2018/6/14-17:38
 * Copyright (c) 2018, NBS , lambor.c<lanbery@gmail.com>.
 * All rights reserved.
 */
public class NBSIconButton extends JButton {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private ImageIcon iconEnabled;
    private ImageIcon iconDisabled;
    /**
     *
     */
    private String tip;

    public NBSIconButton(ImageIcon normalIcon,ImageIcon enabledIcon,ImageIcon disabledIcon,String tip){
        super(normalIcon);
        this.iconEnabled = enabledIcon;
        this.iconDisabled = disabledIcon;
        this.tip = tip;
    }


}
